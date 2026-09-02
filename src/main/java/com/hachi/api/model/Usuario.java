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

    // Nome completo
    private String nomeCompleto;

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
     * @param nomeCompleto Nome completo
     * @param email E-mail
     * @param senha Senha
     * */
    public Usuario(String nomeCompleto, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor
     *
     * @param id ID
     * @param nomeCompleto Nome completo
     * @param email E-mail
     * @param senha Senha
     * */
    public Usuario(Integer id, String nomeCompleto, String email, String senha) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
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
     * Obtém o nome completo do usuário
     * */
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    /**
     * Define o nome completo do usuário
     *
     * @param nomeCompleto Nome completo do usuário a ser definido
     * */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
