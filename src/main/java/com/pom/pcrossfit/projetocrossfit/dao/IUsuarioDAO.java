package com.pom.pcrossfit.projetocrossfit.dao;

import java.util.List;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;

public interface IUsuarioDAO {
    void cadastrar(Usuario usuario);
    void modificarUsuario(Usuario usuario);
    List<Usuario> listUsuarios();
    void removerUsuario(Integer matricula);
    Usuario buscaMatricula(Integer matricula);
    List<Usuario> buscaNome(String nome);
}
