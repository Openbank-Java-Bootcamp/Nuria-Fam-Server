package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.RoleToUserDTO;
import com.ironhack.finalprojectserver.service.interfaces.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleServiceInterface roleService;


    @PostMapping("/roles/addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleTOUser(@RequestBody @Valid RoleToUserDTO roleToUserDTO) {
        roleService.addRoleToUser(roleToUserDTO.getEmail(), roleToUserDTO.getRoleName());
    }
}
