package com.jl91software.bridge.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProyectoController {

    @Value("${pub400.url}")
    private String url;
    @Value("${pub400.username}")
    private String user;
    @Value("${pub400.password}")
    private String password;

    @GetMapping("/proyectos")
    public List<Map<String, Object>> getProyectos() {
        List<Map<String, Object>> resultados = new ArrayList<>();

        // Consulta SQL
        String query = "SELECT ID_PROYECTO, NOMBRE_PROY, CATEGORIA, ESTADO FROM JIMLEE1.PROYECTOS";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                fila.put("id", rs.getInt("ID_PROYECTO"));
                fila.put("nombre", rs.getString("NOMBRE_PROY"));
                fila.put("categoria", rs.getString("CATEGORIA"));
                fila.put("estado", rs.getString("ESTADO"));
                resultados.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  resultados;
    }
}
