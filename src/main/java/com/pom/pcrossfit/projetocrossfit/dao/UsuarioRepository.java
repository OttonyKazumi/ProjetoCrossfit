package com.pom.pcrossfit.projetocrossfit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
