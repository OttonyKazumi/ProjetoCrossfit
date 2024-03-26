package com.pom.pcrossfit.projetocrossfit.dao;

import com.pom.pcrossfit.projetocrossfit.entity.Role;

public interface IRoleDAO {
    public Role findRoleByName(String theRoleName);
}
