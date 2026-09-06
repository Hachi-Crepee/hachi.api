package com.hachi.api.controller;

import com.hachi.api.model.Usuario;
import com.hachi.api.model.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Controller de Usuário
 *
 * @author Marley de S. Santos - <a href="https://github.com/MarleyS439">@MarleyS439</a>
 * @version 1.0.0
 * @see <a href="https://github.com/Hachi-Crepee/API">Hachi-Crepee/API</a>
 * @since 30-08-2026
 */
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Injeção de dependência
    public final JdbcTemplate jdbcTemplate;

    /**
     * Construtor
     *
     * @param jdbcTemplate JDBC Template
     */
    public UsuarioController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Lista todos os usuários
     *
     * @return Usuario
     * */
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        String sql = "SELECT idUsuario, nomeCompleto, email FROM usuario;";

        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class));

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(200).build();
        }

        List<UsuarioResponse> usuariosResponse = new ArrayList<>();

        usuarios.forEach(user -> {
            UsuarioResponse u = new UsuarioResponse();
            u.setIdUsuario(user.getIdUsuario());
            u.setNomeCompleto(user.getNomeCompleto());
            u.setEmail(user.getEmail());

            usuariosResponse.add(u);
        });

        return ResponseEntity.status(200).body(usuariosResponse);
    }

    /**
     * Obtém o usuário por ID
     *
     * @param idUsuario ID do usuário
     * @return Usuario
     * */
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Integer idUsuario) {

        // Valida id enviado
        if (idUsuario == null || idUsuario == 0) {
            return ResponseEntity.status(400).build();
        }

        String sql = "SELECT idUsuario, nomeCompleto, email FROM usuario WHERE idUsuario = ? LIMIT 1";

        List<Usuario> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Usuario.class), idUsuario);

        Usuario u = user.getFirst();

        // Valida se não é null a consulta
        if (user.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setIdUsuario(u.getIdUsuario());
        usuarioResponse.setEmail(u.getEmail());
        usuarioResponse.setNomeCompleto(u.getNomeCompleto());

        return ResponseEntity.status(200).body(usuarioResponse);
    }

    /**
     * Cria um novo usuário
     *
     * @param usuario Usuário a ser criado
     * @return Usuário criado
     */
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {

        // Validação dos campos
        if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Valida se o e-mail não é nulo ou vazio
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Valida se o formato do e-mail é válido
        if (!usuario.getEmail().matches("\\S+@\\S+\\.\\S+")) {
            return ResponseEntity.status(400).build();
        }

        // Valida se senha não é nula ou vazia
        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Valida o comprimento de senha
        if (usuario.getSenha().length() < 6) {
            return ResponseEntity.status(400).build();
        }

        // Valida se senha e confirmação de senha são iguais
        if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
            return ResponseEntity.status(400).build();
        }

        // Verifica se o e-mail já está cadastrado
        String sqlVerificar = "SELECT COUNT(*) FROM usuario WHERE email = ?";

        Integer quantidade = jdbcTemplate.queryForObject(sqlVerificar, Integer.class, usuario.getEmail());

        // Valida se há usuário cadastrado no retorno
        if (quantidade != null && quantidade > 0) {
            return ResponseEntity.status(409).build();
        }

        // Insere o usuário
        String sql = "INSERT INTO usuario (nomeCompleto, email, senha) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getNomeCompleto());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            return preparedStatement;
        }, keyHolder);

        Integer idGerado = keyHolder.getKeyAs(Integer.class);
        usuario.setIdUsuario(idGerado);

        return ResponseEntity.status(201).body(usuario);
    }

    /**
     * Autentica um usuário
     *
     * @param usuario Usuário contendo e-mail e senha
     * @return Usuário autenticado
     */
    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody Usuario usuario) {

        // Validação dos campos
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Valida o e-mail possui formato válido
        if (!usuario.getEmail().matches("\\S+@\\S+\\.\\S+")) {
            return ResponseEntity.status(400).build();
        }

        // Valida se a senha não é vazia
        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Busca o usuário pelo e-mail e senha
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ? LIMIT 1";

        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class), usuario.getEmail(), usuario.getSenha());

        // Valida se achou usuário
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        UsuarioResponse u = new UsuarioResponse();
        Usuario response = usuarios.getFirst();

        u.setIdUsuario(response.getIdUsuario());
        u.setNomeCompleto(response.getNomeCompleto());
        u.setEmail(response.getEmail());

        return ResponseEntity.status(200).body(u);
    }
}
