package com.hachi.api.model;

/**
 * Classe Model de Usuário
 *
 * @author Marley de S. Santos - <a href="https://github.com/MarleyS439">@MarleyS439</a>
 * @since 30-08-2026
 * @version 1.0.0
 * @see <a href="https://github.com/Hachi-Crepee/API">Hachi-Crepee/API</a>
 * */
public class Usuario {

    // ID
    private Integer id;

    // Nome
    private String nome;

    // Sobrenome
    private String sobrenome;

    // E-mail
    private String email;

    // Senha
    private String senha;

    /**
     * Construtor
     * */
    public Usuario() {}

    /**
     * Construtor
     *
     * @param nome Nome
     * @param sobrenome Sobrenome
     * @param email E-mail
     * @param senha Senha
     * */
    public Usuario(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor
     *
     * @param id ID
     * @param nome Nome
     * @param sobrenome Sobrenome
     * @param email E-mail
     * @param senha Senha
     * */
    public Usuario(Integer id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Obtém o ID do usuário
     * */
    public Integer getId() {
        return this.id;
    }

    /**
     * Define o ID do usuário
     *
     * @param id ID a ser definido
     * */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário
     * */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o nome do usuário
     *
     * @param nome Nome do usuário a ser definido
     * */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o sobrenome
     * */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o sobrenome
     *
     * @param sobrenome Sobrenome
     * */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Obtém o e-mail do usuário
     * */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define o e-mail do usuário
     *
     * @param email E-mail a ser definido
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário
     * */
    public String getSenha() {
        return this.senha;
    }

    /**
     * Define a senha do usuário
     *
     * @param senha Senha a ser definida
     * */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o objeto como String
     *
     * @return Objeto como String
     * */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
