package org.f1soft.graphclient.service;

import org.f1soft.graphclient.entity.Allotments;
import org.f1soft.graphclient.repository.AllotmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllotmentService {
    private final AllotmentRepository allotmentRepository;

    public AllotmentService(AllotmentRepository allotmentRepository) {
        this.allotmentRepository = allotmentRepository;
    }

    public Allotments saveAllotment(Allotments allotment) {
        return allotmentRepository.save(allotment);
    }

    public int getNoOfAllotments(String applicationId, String issueId) {
        return allotmentRepository.getNoOfAllotments(applicationId, issueId);
    }

    public boolean existsById(String applicationId) {
        return allotmentRepository.existsById(applicationId);
    }

    public Optional<Allotments> getAllotmentById(String applicationId) {
        Optional<Allotments> allotment = allotmentRepository.findById(applicationId);
        return allotment;
    }

}
