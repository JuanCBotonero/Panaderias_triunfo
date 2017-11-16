/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.Crud_Compras;
import dato.compras;
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
import servicios.BD2;

/**
 *
 * @author Labing I5
 */
public class compra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String producto = request.getParameter("producto");
            String proveedor = request.getParameter("proveedor");
            String valor_unitario = request.getParameter("valor_unitario");
            String cantidad = request.getParameter("cantidad");

            int y = 0;
            if (request.getParameter("valor_unitario") != null) {

                int valor_unitario2 = Integer.parseInt(valor_unitario);
                int cantidad2 = Integer.parseInt(cantidad);
                y = valor_unitario2 * cantidad2;

            }

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title> Crear</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> El valor a pagar por: " + cantidad + " " + producto + "  " + "del proveedor " + proveedor + " " + "es " + " " + y + "</h1>");
//            out.println("</h1>");

            String total = String.valueOf(y);
            compras co = new compras(producto, proveedor, valor_unitario, cantidad, total);
            BD2 d2 = new BD2();
            d2.addCompra(co);
            Crud_Compras s = new Crud_Compras();
         
            try {
                System.out.println(s.insert(d2));
                request.setAttribute("total", total);
                request.getRequestDispatcher("compra.jsp").forward(request, response);
           
            } catch (SQLException ex) {
                Logger.getLogger(compra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(compra.class.getName()).log(Level.SEVERE, null, ex);
            }
                 

        }
    }
}
