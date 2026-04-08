package com.tkrity.nailsystem.branch.service;

import com.tkrity.nailsystem.branch.model.BranchRequest;
import com.tkrity.nailsystem.branch.model.BranchResponse;

public interface BranchService {
    BranchResponse getBranchById(Long id);

    BranchResponse getBranchByBranchCode(String branchCode);

    BranchResponse createBranch(BranchRequest branch);

}
