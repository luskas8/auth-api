package com.luskas8.auth_api.controller.dto;

public record LoginResponseRecord(
    String accessToken,
    Long expiresIn
) {
}
