// package org.f1soft.shareapply.services;
//
// import org.f1soft.shareapply.model.ApiResponse;
// import org.f1soft.shareapply.model.ApplyShare;
// import org.f1soft.shareapply.model.ResponseData;
// import org.f1soft.shareapply.model.Status;
// import org.f1soft.shareapply.repository.ApplyShareRepository;
// import org.f1soft.shareapply.service.ApplyShareService;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.random.RandomGenerator;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
//
// @ExtendWith(MockitoExtension.class)
// public class ApplyShareServiceTest {
// @Mock
// private ApplyShareRepository applyShareRepository;
//
//
// @Mock
// private RandomGenerator randomGenerator;
//
//// @Mock
// private ApiResponse apiResponse;
//
// private ApplyShareService cut;
//
// @Mock
// private List<String> issues ;
//
// private ResponseData data;
//
// private ApplyShare applyShare;
//
// @BeforeEach
// public void setup(){
// data = new ResponseData();
// applyShare = new ApplyShare();
// apiResponse = new ApiResponse();
// applyShare.setAppliedQuantity(20);
// applyShare.setCrn("456");
// applyShare.setId(1L);
// applyShare.setAccountNumber("A1234");
// applyShare.setUserId("123");
// applyShare.setIssueId("123");
// data.setUserId("123");
// data.setIssueId("123");
// data.setApplicationId("123-123-1");
// data.setStatus(Status.valueOf("VERIFIED"));
// cut = new ApplyShareService(applyShareRepository, apiResponse,data);
// }
//
// @Test
// public void testApplyShare() {
// when(applyShareRepository.save(any(ApplyShare.class))).thenReturn(applyShare);
// apiResponse = cut.applyShare(applyShare);
// Assertions.assertNotNull(apiResponse);
// Assertions.assertEquals("IPO has been applied successfully",
// apiResponse.getMessage());
//
// Assertions.assertNotNull(apiResponse.getData());
// verify(applyShareRepository).save(any(ApplyShare.class));
// }
// }
