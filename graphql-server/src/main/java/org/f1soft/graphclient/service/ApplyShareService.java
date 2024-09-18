package org.f1soft.graphclient.service;

import org.f1soft.graphclient.entity.ShareApply;
import org.f1soft.graphclient.repository.ShareApplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyShareService {

    private ShareApplyRepository shareApplyRepository;

    public ApplyShareService(ShareApplyRepository shareApplyRepository) {
        this.shareApplyRepository = shareApplyRepository;
    }

    public ShareApply save(ShareApply shareApply) {
        return shareApplyRepository.save(shareApply);
    }

    public List<ShareApply> getAppliedShareById(String userId) {
        return shareApplyRepository.findByUserId(userId);
    }

    public List<String> getApplicationId(String userId) {
        return shareApplyRepository.findApplicationIdById(userId);
    }
}
