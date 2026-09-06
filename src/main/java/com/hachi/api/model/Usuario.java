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
    private Integer idUsuario;

    // Nome completo
    private String nomeCompleto;

    // E-mail
    private String email;

    // Senha
    private String senha;

    // Confirmação de senha
    private String confirmarSenha;

    // Telefone
    private String telefone;

    // Pontos
    private Integer pontos;

    /**
     * Construtor vazio
     * */
    public Usuario() {}

    /**
     * Construtor sem `id` e com `confirmarSenha`
     *
     * @param nomeCompleto Nome completo
     * @param email E-mail
     * @param senha Senha
     * @param confirmarSenha Confirmação de senha
     * */
    public Usuario(String nomeCompleto, String email, String senha, String confirmarSenha, String telefone, Integer pontos) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
        this.telefone = telefone;
        this.pontos = pontos;
    }

    /**
     * Construtor sem `confirmarSenha`
     *
     * @param idUsuario ID
     * @param nomeCompleto Nome completo
     * @param email E-mail
     * @param senha Senha
     * */
    public Usuario(Integer idUsuario, String nomeCompleto, String email, String senha, String telefone, Integer pontos) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.pontos = pontos;
    }

    /**
     * Obtém o ID do usuário
     * */
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    /**
     * Define o ID do usuário
     *
     * @param idUsuario ID a ser definido
     * */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
     * Obtém a confirmação de senha do usuário
     * */
    public String getConfirmarSenha() {
        return this.confirmarSenha;
    }

    /**
     * Define a confirmação de senha do usuário
     *
     * @param confirmarSenha Confirmação de senha
     * */
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    /**
     * Obtém o telefone do usuário
     * */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Define o telefone do usuário
     *
     * @param telefone Telefone a ser definido
     * */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém os pontos do usuário
     * */
    public Integer getPontos() {
        return this.pontos;
    }

    /**
     * Define os pontos do usuário
     *
     * @param pontos Pontos
     * */
    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    /**
     * Retorna o objeto como String
     *
     * @return Objeto como String
     * */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + idUsuario +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", confirmarSenha='" + confirmarSenha + '\'' +
                '}';
    }
}
