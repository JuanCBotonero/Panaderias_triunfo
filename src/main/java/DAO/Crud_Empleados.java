/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

;
import dato.Empleado;
import dato.receta;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicios.BD4;import dato.Empleado;
import dato.receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicios.BD4;

/**
 *
 * @author JCBOT
 */


public class Crud_Empleados {

    public List<Empleado> findAll() throws SQLException, URISyntaxException {
        List<Empleado> departamentos = null;
        String query = "SELECT * FROM Empleados";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

    

            String Nombre_empleado;
            String apellidos_empleado;
            String cedula;
            String edad;
            String estado_civil;
            String direccion;
            String telefono;
            String eps;
            String fecha_de_contratacion;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Empleado>();
                }

                Empleado registro = new Empleado();

                Nombre_empleado = rs.getString("Nombre_empleado");
                registro.setNombre_empleado(Nombre_empleado);

                apellidos_empleado = rs.getString("apellidos_empleado");
                registro.setApellidos_empleado(apellidos_empleado);

                cedula = String.valueOf(rs.getInt("cedula"));
                registro.setCedula(cedula);

                edad = rs.getString("edad");
                registro.setEdad(edad);

                estado_civil = rs.getString("estado_civil");
                registro.setEstado_civil(estado_civil);

                direccion = rs.getString("direccion");
                registro.setDireccion(direccion);

                telefono = rs.getString("telefono");
                registro.setTelefono(telefono);
                
                eps = rs.getString("eps");
                registro.setEps(eps);
                
                fecha_de_contratacion = rs.getString("fecha_de_contratacion");
                registro.setFecha_de_contratacion(fecha_de_contratacion);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(BD4 t) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Empleados (Nombre_empleado,apellidos_empleado,cedula,edad,estado_civil,direccion,telefono,eps,fecha_de_contratacion) " + "values (?,?,?,?,?,?,?,?,?)";
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Hora y fecha: " + hourdateFormat.format(date));
        String fecha_y_hora = hourdateFormat.format(date);

        PreparedStatement preparedStmt = null;
        try {

            preparedStmt = connection.prepareStatement(query);
            for (int i = 0; i < t.getEmpleados().size(); i++) {

                int cedula = Integer.parseInt(t.getEmpleados().get(i).getCedula());
                preparedStmt.setString(1, t.getEmpleados().get(i).getNombre_empleado());
                preparedStmt.setString(2, t.getEmpleados().get(i).getApellidos_empleado());
                preparedStmt.setInt(3, cedula);
                preparedStmt.setString(4, t.getEmpleados().get(i).getEdad());
                preparedStmt.setString(5, t.getEmpleados().get(i).getEstado_civil());
                preparedStmt.setString(6, t.getEmpleados().get(i).getDireccion());
                preparedStmt.setString(7, t.getEmpleados().get(i).getTelefono());
                preparedStmt.setString(8, t.getEmpleados().get(i).getEps());
                preparedStmt.setString(9, fecha_y_hora);

            }

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
