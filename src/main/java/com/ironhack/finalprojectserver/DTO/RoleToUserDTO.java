package com.ironhack.finalprojectserver.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleToUserDTO {
    @NotEmpty(message = "You must have an email")
    private String email;
    @NotEmpty(message = "You must have a role name")
    private String roleName;
}
