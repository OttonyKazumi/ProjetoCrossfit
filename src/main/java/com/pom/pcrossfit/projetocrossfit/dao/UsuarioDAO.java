package com.pom.pcrossfit.projetocrossfit.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UsuarioDAO implements IUsuarioDAO {
    
    private EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void cadastrar(Usuario usuario) {
        entityManager.persist(usuario);;
    }

    @Override
    @Transactional
    public void modificarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public List<Usuario> listUsuarios() {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario", Usuario.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void removerUsuario(Integer matricula) {
        // retrieve the student
        Usuario usuario = entityManager.find(Usuario.class, matricula);

        // delete the student
        entityManager.remove(usuario);
    }

    @Override
    public Usuario buscaMatricula(Integer matricula) {
        return entityManager.find(Usuario.class, matricula);
    }

    @Override
    public List<Usuario> buscaNome(String nome) {
        TypedQuery<Usuario> theQuery = entityManager.createQuery("FROM Usuario WHERE nome=:theData", Usuario.class);

        // set query parameters
        theQuery.setParameter("theData", nome);

        // return query resutls
        return theQuery.getResultList();
    }

}
