package com.example.service;

import com.example.model.Role;
import com.example.model.RoleNameEnum;

public interface RoleService {

    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
