package com.jl91software.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {
    public void conectarAS400() {
        // Sustituye con tus credenciales de PUB400
        String url = "jdbc:as400://pub400.com";
        String usuario = "JIMLEE";
        String password = "jl4005357d";

        try {
            // Cargar el driver que incluimos en el pom.xml
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
            Connection con = DriverManager.getConnection(url, usuario, password);

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