/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.Crud_ventas;
import dato.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.BD;

/**
 *
 * @author Labing I5
 */
public class Index extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String producto = request.getParameter("producto");
            String valor_unitario = request.getParameter("valor_unitario");
            String cantidad = request.getParameter("cantidad");

            int y = 0;
            if (request.getParameter("valor_unitario") != null) {

                int valor_unitario2 = Integer.parseInt(valor_unitario);
                int cantidad2 = Integer.parseInt(cantidad);
                y = valor_unitario2 * cantidad2;

            }

            String total = String.valueOf(y);
            Venta j = new Venta(producto, valor_unitario, cantidad, total);
            BD d = new BD();
            d.addVenta(j);
            Crud_ventas s = new Crud_ventas(); 
            System.out.println("op");
            try {
                System.out.println(s.insert(d));
                request.setAttribute("total", total);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            

        }
    }
}
