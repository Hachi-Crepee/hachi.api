package com.hachi.api.model;

/**

 * Classe Model de Resposta do Usuário
 *
 * @author Marley de S. Santos - <a href="https://github.com/MarleyS439">@MarleyS439</a>
 * @since 02-09-2026
 * @version 1.0.0
 * @see <a href="https://github.com/Hachi-Crepee/API">Hachi-Crepee/API</a>
 * */
public class UsuarioResponse {

    // ID
    private Integer idUsuario;

    // Nome completo
    private String nomeCompleto;

    // E-mail
    private String email;

    /**
     * Construtor vazio
     * */
    public UsuarioResponse() {
    }

    /**
     * Construtor completo
     *
     * @param idUsuario ID
     * @param nomeCompleto Nome completo
     * @param email E-mail
     * */
    public UsuarioResponse(Integer idUsuario, String nomeCompleto, String email) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
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
     * @param idUsuario ID do usuário
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
     * @param nomeCompleto Nome completo do usuário
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
     * @param email E-mail
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o objeto como String
     *
     * @return Objeto como String
     * */
    @Override
    public String toString() {
        return "UsuarioResponse{" +
                "idUsuario=" + idUsuario +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
