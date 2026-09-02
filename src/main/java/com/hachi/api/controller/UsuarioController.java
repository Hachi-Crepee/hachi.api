package com.hachi.api.controller;

import com.hachi.api.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        String sql = "SELECT * FROM usuario;";


        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class));

        return ResponseEntity.status(200).body(usuarios);

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

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        if (!usuario.getEmail().matches("\\S+@\\S+\\.\\S+")) {
            return ResponseEntity.status(400).build();
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        if (usuario.getSenha().length() < 6) {
            return ResponseEntity.status(400).build();
        }

        // Verifica se o e-mail já está cadastrado
        String sqlVerificar = "SELECT COUNT(*) FROM usuario WHERE email = ?";

        Integer quantidade = jdbcTemplate.queryForObject(sqlVerificar, Integer.class, usuario.getEmail());

        if (quantidade != null && quantidade > 0) {
            return ResponseEntity.status(409).build();
        }

        // Insere o usuário
        String sql = "INSERT INTO usuario (nome_completo, email, senha) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, usuario.getNomeCompleto(), usuario.getEmail(), usuario.getSenha());

        return ResponseEntity.status(201).body(usuario);
    }

    /**
     * Autentica um usuário
     *
     * @param usuario Usuário contendo e-mail e senha
     * @return Usuário autenticado
     */
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {

        // Validação dos campos
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        if (!usuario.getEmail().matches("\\S+@\\S+\\.\\S+")) {
            return ResponseEntity.status(400).build();
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            return ResponseEntity.status(400).build();
        }

        // Busca o usuário pelo e-mail e senha
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class), usuario.getEmail(), usuario.getSenha());

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.status(200).body(usuarios.get(0));
    }
}
