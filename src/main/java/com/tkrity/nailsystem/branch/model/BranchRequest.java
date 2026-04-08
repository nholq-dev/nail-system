package com.tkrity.nailsystem.branch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchRequest {
    private Long id;

    private String branchCode;

    private String branchName;

    private String dataSource;
}
