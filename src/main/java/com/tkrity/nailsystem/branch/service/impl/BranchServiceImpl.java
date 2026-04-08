package com.tkrity.nailsystem.branch.service.impl;

import com.tkrity.nailsystem.branch.Repository.BranchRepository;
import com.tkrity.nailsystem.branch.entity.Branch;
import com.tkrity.nailsystem.branch.model.BranchRequest;
import com.tkrity.nailsystem.branch.model.BranchResponse;
import com.tkrity.nailsystem.branch.service.BranchService;
import com.tkrity.nailsystem.exception.BadRequestException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Resource
    private BranchRepository branchRepository;

    @Override
    public BranchResponse getBranchById(Long id) {
        if(id == null){
            throw new BadRequestException("Không tìm thấy branch tương ứng");
        }else{
            Optional<Branch> optBranch = branchRepository.findById(id);
            if(optBranch.isPresent()){
                Branch dataBranch = optBranch.get();
                return new BranchResponse(
                        dataBranch.getId(),
                        dataBranch.getBranchCode(),
                        dataBranch.getBranchName()
                );
            }else{
                throw new BadRequestException("Branch không tồn tại");
            }
        }
    }

    @Override
    public BranchResponse getBranchByBranchCode(String branchCode) {
        return null;
    }

    @Override
    @Transactional
    public BranchResponse createBranch(BranchRequest request) {
        Branch branchCreate = new Branch();
        branchCreate.setBranchCode(request.getBranchCode());
        branchCreate.setBranchName(request.getBranchName());
        branchCreate.setDataSource(request.getDataSource());
        if(Objects.equals(request.getBranchCode(), "")){
            throw new BadRequestException("BranchCode: Không thể blank");
        }else{
            Optional<Branch> optionalBranch = branchRepository.findByBranchCode(branchCreate.getBranchCode());
            if(optionalBranch.isPresent()){
                throw new BadRequestException("Branch đã tồn tại");

            }else{
                branchRepository.save(branchCreate);
                return new BranchResponse(branchCreate.getId(),
                        branchCreate.getBranchCode(),
                        branchCreate.getBranchName()
                );
            }
        }
    }
}
