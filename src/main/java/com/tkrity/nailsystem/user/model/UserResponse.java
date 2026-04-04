package com.tkrity.nailsystem.user.model;

public record UserResponse(
        Long id,
        String userCode,
        String address,
        String fullName
) {
}
