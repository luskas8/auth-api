package com.luskas8.auth_api.controller.dto;

public record LoginRequestRecord(
    String username,
    String password
) {

}
