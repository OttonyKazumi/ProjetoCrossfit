package com.pom.pcrossfit.projetocrossfit.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;
import com.pom.pcrossfit.projetocrossfit.entity.WebUser;

public interface IUsuarioServico extends UserDetailsService {

    public Usuario findByUserName(String userName);

	void save(WebUser webUser);
}
