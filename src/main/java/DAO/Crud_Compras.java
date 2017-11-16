/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

;
import dato.Venta;
import dato.compras;
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
import servicios.BD2;import dato.Venta;
import dato.compras;
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
import servicios.BD2;

/**
 *
 * @author JCBOT
 */


public class Crud_Compras {

    public List<compras> findAll() throws SQLException, URISyntaxException {
        List<compras> departamentos = null;
        String query = "SELECT * FROM Compras";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String producto = null;
            String proveedor = null;
            int valorunitario = 0;
            int cantidad = 0;
            int valortotal = 0;
            String fecha = null;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<compras>();
                }

                compras registro = new compras();

                id = rs.getInt("IdCompras");
                registro.setId(id);

                producto = rs.getString("Producto");
                registro.setProducto(producto);

                proveedor = rs.getString("Proveedor");
                registro.setProveedor(proveedor);

                valorunitario = rs.getInt("Valor_Unitario");
                registro.setValor_unitario(String.valueOf(valorunitario));

                cantidad = rs.getInt("Cantidad");
                registro.setCantidad(String.valueOf(cantidad));

                valortotal = rs.getInt("Valor_total");
                registro.setValor_total(String.valueOf(valortotal));

                fecha = rs.getString("Fecha");
                registro.setFecha(fecha);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(BD2 t) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Compras (IdCompras,Producto,Proveedor,Valor_Unitario,Cantidad,Valor_total,Fecha) " + "values (?,?,?,?,?,?,?)";

         Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Hora y fecha: " + hourdateFormat.format(date));
        String fecha_y_hora=hourdateFormat.format(date);
        

        PreparedStatement preparedStmt = null;
        try {

            preparedStmt = connection.prepareStatement(query);
            for (int i = 0; i < t.getActivos().size(); i++) {

                int id = 0;
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, t.getActivos().get(i).getProducto());
                preparedStmt.setString(3, t.getActivos().get(i).getProveedor());
                preparedStmt.setInt(4, Integer.parseInt(t.getActivos().get(i).getValor_unitario()));
                preparedStmt.setInt(5, Integer.parseInt(t.getActivos().get(i).getCantidad()));
                preparedStmt.setInt(6, Integer.parseInt(t.getActivos().get(i).getValor_total()));
                preparedStmt.setString(7, fecha_y_hora);

            }

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
