package com.tkrity.nailsystem.branch.controller;

import com.tkrity.nailsystem.branch.model.BranchRequest;
import com.tkrity.nailsystem.branch.model.BranchResponse;
import com.tkrity.nailsystem.branch.service.BranchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branchs")
public class BranchController {

    @Resource
    private BranchService branchService;

    @GetMapping("/{id}")
    public BranchResponse getBranchById(@PathVariable Long id){
        return branchService.getBranchById(id);
    }

    @PostMapping
    public BranchResponse createBranch(@RequestBody BranchRequest request){
        return branchService.createBranch(request);
    }

}
