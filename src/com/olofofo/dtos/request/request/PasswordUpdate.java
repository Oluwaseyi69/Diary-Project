package com.olofofo.dtos.request.request;

import lombok.Data;

@Data
public class PasswordUpdate {
    String username;
    String oldPassword;
    String newPassword;
}
