package br.ifpr.edu.receitas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class FabricaDeConexoes {
    private static Dotenv dotenv = Dotenv.load();

    private static String URL_DB = dotenv.get("URL_DB");
    private static String DB_NAME = dotenv.get("DB_NAME");
    private static String USERNAME = dotenv.get("USERNAME");
    private static String PASSWORD = dotenv.get("PASSWORD");

    private static String DB_URL = "jdbc:mysql://" + URL_DB + "/" + DB_NAME;

    public static Connection getConnection() throws RuntimeException {
        try {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Falha em conectar com o banco", e);
        }
    }
}