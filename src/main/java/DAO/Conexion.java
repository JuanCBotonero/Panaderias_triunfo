package Dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {

    private static Connection CONEXION = null;

//    public static Connection getConnection() throws SQLException {
//        if (CONEXION == null) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                //Integracion Log4J
//            } catch (ClassNotFoundException e) {
//                throw new SQLException(e);
//            } catch (InstantiationException e) {
//                //Integracion Log4J
//                throw new SQLException(e);
//            } catch (IllegalAccessException e) {
//                //Integracion Log4J
//                throw new SQLException(e);
//            }
//
//            try {
//                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectobases", "root", "root");
//                System.out.println("voy");
//            } catch (SQLException e) {
//                throw new SQLException(e);
//            }
//
//        }
//
//        return CONEXION;
//    }

    public static Connection getConnection() throws URISyntaxException {
        if (CONEXION != null) {
            return CONEXION;
        } else {
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            if (CONEXION == null) {
                try {
                    CONEXION = DriverManager.getConnection(dbUrl, username, password);
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                }

            }
            return CONEXION;

        }

    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }

        } catch (SQLException e) {
            //Integracion Log4J
            throw new SQLException(e);
        }

    }

}
