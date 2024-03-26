package com.pom.pcrossfit.projetocrossfit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
    
    private EntityManager entityManager;

	@Autowired
	public UsuarioDAO(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public Usuario findByUserName(String nome) {

		// retrieve/read from database using username
		TypedQuery<Usuario> theQuery = entityManager.createQuery("from User where userName=:uName and enabled=true", Usuario.class);
		theQuery.setParameter("uName", nome);

		Usuario theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {

		// create the user ... finally LOL
		entityManager.merge(usuario);
	}

}
