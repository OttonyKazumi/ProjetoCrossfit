package com.pom.pcrossfit.projetocrossfit.dao;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;

public interface IUsuarioDAO {
    Usuario findByUserName(String nome);
    void save(Usuario usuario);
}
