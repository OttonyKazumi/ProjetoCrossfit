package com.pom.pcrossfit.projetocrossfit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pom.pcrossfit.projetocrossfit.dao.RoleDAO;
import com.pom.pcrossfit.projetocrossfit.dao.UsuarioDAO;
import com.pom.pcrossfit.projetocrossfit.entity.Role;
import com.pom.pcrossfit.projetocrossfit.entity.Usuario;
import com.pom.pcrossfit.projetocrossfit.entity.WebUser;

@Service
public class UsuarioServico implements IUsuarioServico{

    private UsuarioDAO usuarioDAO;

	private RoleDAO roleDAO;

	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UsuarioServico(UsuarioDAO usuarioDAO, RoleDAO roleDAO, BCryptPasswordEncoder passwordEncoder) {
		this.usuarioDAO = usuarioDAO;
		this.roleDAO = roleDAO;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Usuario findByUserName(String userName) {
		// check the database if the user already exists
		return usuarioDAO.findByUserName(userName);
	}

	@Override
	public void save(WebUser webUser) {
		Usuario usuario = new Usuario();

		// assign user details to the user object
		usuario.setUserName(webUser.getUserName());
		usuario.setPassword(passwordEncoder.encode(webUser.getPassword()));
		usuario.setNome(webUser.getFirstName());
		usuario.setSobreNome(webUser.getLastName());
		usuario.setEmail(webUser.getEmail());
		usuario.setEnabled(true);

		// give user default role of "employee"
		usuario.setRoles(Arrays.asList(roleDAO.findRoleByName("ROLE_EMPLOYEE")));

		// save user in the database
		usuarioDAO.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUserName(userName);

		if (usuario == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(usuario.getRoles());

		return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(),
				authorities);
	}

	private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role tempRole : roles) {
			SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
			authorities.add(tempAuthority);
		}

		return authorities;
	}

}
