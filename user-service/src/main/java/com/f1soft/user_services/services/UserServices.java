package com.f1soft.user_services.services;

import com.f1soft.user_services.client.UserFeignClient;
import com.f1soft.user_services.dto.AccountDTO;
import com.f1soft.user_services.dto.BankDTO;
import com.f1soft.user_services.dto.BranchDTO;
import com.f1soft.user_services.entity.*;
import com.f1soft.user_services.exception.UserNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final GraphqlUserService graphqlUserService;

    private final UserFeignClient userFeignClient;

    private Logger logger = LoggerFactory.getLogger(UserServices.class);

    public final ResponseMessage responseMessage;

public UserServices(ResponseMessage responseMessage, UserFeignClient userFeignClient, GraphqlUserService graphqlUserService) {
        this.graphqlUserService = graphqlUserService;
        this.responseMessage = responseMessage;
        this.userFeignClient = userFeignClient;
    }

    public ResponseMessage getAllUser() {
        List<User> users = graphqlUserService.getAllUsers();
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(users);
        responseMessage.setMessage("Successfully retrieved all users");
        return responseMessage;
    }

    public ResponseMessage getUserDetails(String id) {

        User user = graphqlUserService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        List<ApplyShare> appliedShareOfUser = userFeignClient.getApplyShare(user.getUserId());
        logger.info("{}", appliedShareOfUser);
        user.setApplyShares(appliedShareOfUser);

        responseMessage.setMessage("User details successfully fetched");
        responseMessage.setData(user);

        return responseMessage;
    }

    public ResponseMessage getAccountDetails(String id) {
        Optional<User> user = graphqlUserService.getUserById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User doesn't exist");
        }

        List<Accounts> accounts = graphqlUserService.getAccountsByUserId(id);

        if (accounts.isEmpty()) {
            throw new UserNotFoundException("Bank account doesn't exists");
        }
        List<BankDTO> bankDTOS = new ArrayList<>();

        accounts.stream().collect(Collectors.groupingBy(account -> account.getBranch().getBank()))
                .forEach((bank, bankAccount) -> {
                    BankDTO bankDTO = new BankDTO();
                    bankDTO.setBankId(bank.getBankId());
                    bankDTO.setBankName(bank.getBankName());

                    List<BranchDTO> branchDTOS = new ArrayList<>();

                    bankAccount.stream().collect(Collectors.groupingBy(account -> account.getBranch()))
                            .forEach((branch, branchAccount) -> {
                                BranchDTO branchDTO = new BranchDTO();
                                branchDTO.setBranchId(branch.getBranchId());
                                branchDTO.setBranchName(branch.getBranchName());

                                List<AccountDTO> accountDTOS = branchAccount.stream().map(account -> {
                                    AccountDTO accountDTO = new AccountDTO();
                                    accountDTO.setAccountNumber(account.getAccountNumber());
                                    accountDTO.setAccountHoldersName(account.getAccountHolderName());

                                    return accountDTO;
                                }).toList();

                                branchDTO.setAccountList(accountDTOS);
                                branchDTOS.add(branchDTO);
                            });
                    bankDTO.setBranchList(branchDTOS);
                    bankDTOS.add(bankDTO);
                });

        responseMessage.setMessage("User account(s) details successfully fetched");
        responseMessage.setData(bankDTOS);
        return responseMessage;
    }

    public List<String> getAllUserId() {
        return graphqlUserService.getAllUserIds();
    }

    public List<String> getAllAccountIdOfUser(String userId) {
        Optional<User> user = graphqlUserService.getUserById(userId);
        System.out.println(user);
        if(user.isPresent()){
            List<Accounts> accounts = user.get().getAccounts();
            return accounts.stream().map(Accounts::getAccountNumber).toList();

        }
        return new ArrayList<>();
    }
}
