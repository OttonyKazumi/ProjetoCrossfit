package com.pom.pcrossfit.projetocrossfit.service;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;
import com.pom.pcrossfit.projetocrossfit.entity.WebUser;

public interface IUsuarioServico {

    public Usuario findByUserName(String userName);

	void save(WebUser webUser);
}
