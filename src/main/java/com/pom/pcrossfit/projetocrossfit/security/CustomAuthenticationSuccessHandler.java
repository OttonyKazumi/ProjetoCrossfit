package com.pom.pcrossfit.projetocrossfit.security;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.pom.pcrossfit.projetocrossfit.entity.Usuario;
import com.pom.pcrossfit.projetocrossfit.service.UsuarioServico;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UsuarioServico usuarioServico;

    public CustomAuthenticationSuccessHandler(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {
        System.out.println("In customAuthenticationSuccessHandler");

        String userName = authentication.getName();

        System.out.println("userName=" + userName);

        Usuario theUser = usuarioServico.findByUserName(userName);

        // now place in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", theUser);

        // forward to home page
        response.sendRedirect(request.getContextPath() + "/");
    }

}
