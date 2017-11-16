/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import Dao.Crud_Recetas;
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

/**
 *
 * @author JCBOT
 */
public class recetas extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String Nombre_Receta = request.getParameter("Nombre_Receta");
            String Tiempo_de_preparacion = request.getParameter("Tiempo_de_preparacion");
            String Receta = request.getParameter("recetass");
            String Cantidad_de_personas = request.getParameter("Cantidad_de_personas");
            String Ingredientes = request.getParameter("Ingredientes");
            String Pasos = request.getParameter("Pasos");
            
            
//             out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title> Crear</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> El valor a pagar por: " + Nombre_Receta + " " + Tiempo_de_preparacion + " " + Receña + " " + Cantidad_de_personas +Ingredientes+Pasos+ "</h1>");
//            out.println("</h1>");

       

            receta r=new receta(Nombre_Receta,Tiempo_de_preparacion,Receta,Cantidad_de_personas,Ingredientes,Pasos);
            BD3 d = new BD3();
            d.addReceta(r);
            Crud_Recetas s = new Crud_Recetas();
            
            try {
                System.out.println(s.insert(d));
                request.getRequestDispatcher("recetas.jsp").forward(request, response);
            
            } catch (SQLException ex) {
                Logger.getLogger(recetas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(recetas.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
            
        }
    }

}
