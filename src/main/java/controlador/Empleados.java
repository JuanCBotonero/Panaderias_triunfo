/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



import Dao.Crud_Empleados;
import Dao.Crud_Recetas;
import dato.Empleado;
import dato.Venta;
import dato.receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.BD;
import servicios.BD3;
import servicios.BD4;

/**
 *
 * @author JCBOT
 */
public class Empleados extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

           
            
            
            String Nombre_empleado = request.getParameter("Nombre_empleado");
            String apellidos_empleado = request.getParameter("apellidos_empleado");
            String cedula = request.getParameter("cedula");
            String edad = request.getParameter("edad");
            String estado_civil = request.getParameter("estado_civil");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String eps=request.getParameter("eps");
            if(Nombre_empleado==null){
                request.getRequestDispatcher("empleados.jsp").forward(request, response);
            }else{
                
            Empleado r=new Empleado(Nombre_empleado,apellidos_empleado,cedula,edad,estado_civil,direccion,telefono,eps,"esperando");
            BD4 d = new BD4();
            d.addEmpleado(r);
            Crud_Empleados s2 = new Crud_Empleados();
            
                try {
                    System.out.println(s2.insert(d));
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
                
            }

          
            
        }
    }

}
