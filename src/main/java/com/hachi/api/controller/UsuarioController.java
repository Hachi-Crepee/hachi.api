package com.hachi.api.controller;

import com.hachi.api.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Classe Controller de Usuário
 *
 * @author Marley de S. Santos - <a href="https://github.com/MarleyS439">@MarleyS439</a>
 * @since 30-08-2026
 * @version 1.0.0
 * @see <a href="https://github.com/Hachi-Crepee/API">Hachi-Crepee/API</a>
 * */
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

    // Injeção de dependência
    public final JdbcTemplate jdbcTemplate;

    /**
     * Construtor
     *
     * @param jdbcTemplate JDBC Template
     * */
    public UsuarioController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        String sql = "SELECT * FROM usuario;";

        List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class));

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(200).body(usuarios);
        }

        return ResponseEntity.status(200).body(usuarios);
    }
}
