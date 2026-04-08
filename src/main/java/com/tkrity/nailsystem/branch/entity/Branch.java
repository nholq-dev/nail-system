package com.tkrity.nailsystem.branch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String branchCode;

    @Column(nullable = false)
    private String branchName;

    @Column
    private String dataSource;

}
