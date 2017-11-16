/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

;
import dato.Venta;
import dato.receta;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import servicios.BD;
import servicios.BD3;import dato.Venta;
import dato.receta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import servicios.BD;
import servicios.BD3;

/**
 *
 * @author JCBOT
 */


public class Crud_Recetas {

    public List<receta> findAll() throws SQLException, URISyntaxException {
        List<receta> departamentos = null;
        String query = "SELECT * FROM Recetas";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String Nombre_Receta = null;
            String Tiempo_De_Prepararion = null;
            String Receta = null;
            String Cantidad_De_Personas = null;
            String Ingredientes = null;
            String Pasos = null;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<receta>();
                }

                receta registro = new receta();

                id = rs.getInt("IdRecetas");
                registro.setId(id);

                Nombre_Receta = rs.getString("Nombre_Receta");
                registro.setNombre_Receta(Nombre_Receta);

                Tiempo_De_Prepararion = rs.getString("Tiempo_De_Prepararion");
                registro.setTiempo_de_preparacion(Tiempo_De_Prepararion);

                Receta = rs.getString("Receta");
                registro.setReceta(Receta);

                Cantidad_De_Personas = rs.getString("Cantidad_De_Personas");
                registro.setCantidad_de_personas(Cantidad_De_Personas);

                Ingredientes = rs.getString("Ingredientes");
                registro.setIngredientes(Ingredientes);

                Pasos = rs.getString("Pasos");
                registro.setPasos(Pasos);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(BD3 t) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Recetas (IdRecetas,Nombre_Receta,Tiempo_De_Prepararion,Receña,Cantidad_De_Personas,Ingredientes,Pasos) " + "values (?,?,?,?,?,?,?)";
  
        PreparedStatement preparedStmt = null;
        try {

            preparedStmt = connection.prepareStatement(query);
            for (int i = 0; i < t.getRecetas().size(); i++) {

                int id = 0;
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, t.getRecetas().get(i).getNombre_Receta());
                preparedStmt.setString(3, t.getRecetas().get(i).getTiempo_de_preparacion());
                preparedStmt.setString(4, t.getRecetas().get(i).getReceta());
                preparedStmt.setString(5, t.getRecetas().get(i).getCantidad_de_personas());
                preparedStmt.setString(6, t.getRecetas().get(i).getIngredientes());
                preparedStmt.setString(7, t.getRecetas().get(i).getPasos());

            }

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
