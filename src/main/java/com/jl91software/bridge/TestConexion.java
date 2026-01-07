package com.jl91software.bridge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class TestConexion {

    @Value("${pub400.url}")
    private String url;
    @Value("${pub400.username}")
    private String user;
    @Value("${pub400.password}")
    private String password;

    public void conectarAS400() {

        try {
            // Cargar el driver que incluimos en el pom.xml
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("¡Conexión exitosa al servidor IBM i!");

            // Ejemplo de consulta SQL (usando lo que ya sabes de DB2)
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM QSYS2.SYSTEM_VALUE_INFO WHERE SYSTEM_VALUE_NAME = 'QDATE'");

            while (rs.next()) {
                System.out.println("Fecha del sistema en PUB400: " + rs.getString("SYSTEM_VALUE"));
            }

            con.close();
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}