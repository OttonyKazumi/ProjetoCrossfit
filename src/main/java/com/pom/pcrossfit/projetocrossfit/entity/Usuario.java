package com.pom.pcrossfit.projetocrossfit.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="matricula")
    private int matricula;

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

    @Enumerated(EnumType.STRING)
    @Column(name="tipo")
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String sobreNome, String email, String endereco, String telefone, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
