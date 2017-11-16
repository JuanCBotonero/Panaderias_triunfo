/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

;
import dato.Venta;
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
import servicios.BD;import dato.Venta;
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

/**
 *
 * @author JCBOT
 */


public class Crud_ventas {

    public List<Venta> findAll() throws SQLException, URISyntaxException {
        List<Venta> departamentos = null;
        String query = "SELECT * FROM Ventas";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String producto = null;
            int valorunitario = 0;
            int cantidad = 0;
            int valortotal = 0;
            String fecha = null;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Venta>();
                }

                Venta registro = new Venta();

                id = rs.getInt("IdVenta");
                registro.setId(id);

                producto = rs.getString("Producto");
                registro.setProducto(producto);

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

    public boolean insert(BD t) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Ventas (IdVenta,Producto,Valor_Unitario,Cantidad,Valor_total,Fecha) " + "values (?,?,?,?,?,?)";

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Hora y fecha: " + hourdateFormat.format(date));
        String fecha_y_hora = hourdateFormat.format(date);

        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            for (int i = 0; i < t.getActivos().size(); i++) {
                int id = 0;
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, t.getActivos().get(i).getProducto());
                preparedStmt.setInt(3, Integer.parseInt(t.getActivos().get(i).getValor_unitario()));
                preparedStmt.setInt(4, Integer.parseInt(t.getActivos().get(i).getCantidad()));
                preparedStmt.setInt(5, Integer.parseInt(t.getActivos().get(i).getValor_total()));
                preparedStmt.setString(6, fecha_y_hora);

            }

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<Integer, String> traernombres() throws IOException, ClassNotFoundException, SQLException, URISyntaxException {

        ArrayList<Venta> activos = null;
        activos = (ArrayList<Venta>) findAll();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<Integer, String> map2 = new HashMap<Integer, String>();

        if (activos == null) {

        } else {

            for (int i = 0; i < activos.size(); i++) {
                map.put(activos.get(i).getProducto(), i);
            }

            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
//            System.out.println("Clave: " + key );
                int temp = 0;
                for (int i = 0; i < activos.size(); i++) {
                    if (key.equals(activos.get(i).getProducto())) {
                        temp++;
                    }
                }

                map2.put(temp, key);
            }

            Iterator it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                Integer key = (Integer) it2.next();
                System.out.println("Clave: " + key + " -> Valor: " + map2.get(key));
            }

            return map2;

        }

        return map2;
    }

    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

}
