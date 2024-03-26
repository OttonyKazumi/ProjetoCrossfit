package com.pom.pcrossfit.projetocrossfit.entity;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="matricula")
    private int matricula;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobreNome;

    @Column(name="email")
    private String email;

    @Column(name="endereco")
    private String endereco;

    @Column(name="telefone")
    private String telefone;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Usuario() {
    }

    public Usuario(String nome, String sobreNome, String email, String endereco, String telefone, Collection<Role> role, Boolean enabled) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.roles = role;
        this.enabled = enabled;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> role) {
        this.roles = role;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
