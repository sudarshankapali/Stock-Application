package org.f1soft.currentissue.controllers;

import org.f1soft.currentissue.dto.ServerResponse;
import org.f1soft.currentissue.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/current-issues")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("")
    public ResponseEntity<ServerResponse> getCurrentIssues() {
        ServerResponse serverResponse = issueService.getAllIssues();
        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/opened")
    public ResponseEntity<ServerResponse> getCurrentIssuesOpened(@PathVariable String id) {
        ServerResponse serverResponse = issueService.getIssueById(id,"opened");
        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServerResponse> getSpecificIssueById(@PathVariable String id) {
        ServerResponse serverResponse = issueService.getIssueById(id,"specific");
        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }

    @GetMapping("/getIssueId")
    public List<String> getAllIssueId(){
        return issueService.getAllIssuesId();
    }
}