<%-- 
    Document   : index
    Created on : 4/09/2017, 10:28:11 AM
    Author     : Labing I5
--%>

<%@page import="Dao.Crud_ventas"%>
<%@page import="java.util.Iterator"%>
<%@page import="dato.compras"%>
<%@page import="servicios.BD2"%>
<%@page import="dato.Venta"%>
<%@page import="servicios.BD"%>
<%@page import="controlador.Index"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

    <head>
        <title>PANADERIAS EL TRIUNFO</title>
        <meta name="description" content="website description" />
        <meta name="keywords" content="website keywords, website keywords" />
        <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
        <link rel="stylesheet" type="text/css" href="style/style.css" />
    </head>

    <body>
        <div id="main">
            <div id="header">
                <div id="logo">
                    <h1>PANADERIAS EL TRIUNFO</h1>
                    <BGSOUND SRC="Pharrell Williams - Happy.mp3" LOOP=INFINITE>
                        <div class="slogan">La mejor calidad al mejor precio</div>
                        <img src="canasta.png" border="4"  width="180" height="90"/>              
                        <p>&nbsp;</p>
                </div>
                <div id="menubar" style="background-color:#ff6666">
                    <ul id="menu">
                        <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
                         <li  ><a href="index.jsp">Sale</a></li>
                        <li><a href="compra.jsp">Buy</a></li>
                        <li><a href="listar.jsp">List</a></li>
                        <li><a href="caja.jsp">Caja</a></li>
                        <li class="current" ><a href="recetas.jsp">Recetas</a></li>
                        <li><a href="Listar_receta.jsp">ListRe</a></li>
                        <li><a href="generar_estados.jsp">Estado</a></li>
                        <li><a href="empleados.jsp">Emple</a></li>


                    </ul>
                </div>
            </div>
            <div id="site_content" style="background-color:#35BDF5">
                <div id="sidebar_container">
                    <!-- Inicio presentacion Noticias-->
                    <img class="paperclip" src="style/paperclip.png" alt="paperclip" />
                    <div class="sidebar">
                        <!-- insert your sidebar items here -->
                        <h3>&Uacute;ltimas Noticias</h3>
                        <h4>No tendremos atencion</h4>
                        <h5>31 Agosto 2018</h5>
                        <p>Estamos de vacaciones<br /><a href="#"></a></p>
                        <script language="JavaScript" src="http://www.pekegifs.com/calendarios2/cal005.js" type="text/JavaScript" ></script>


                        <%

                            out.println("<h1> " + "Top en ventas" + "</h1>");


                        %>

                        <h7>Producto menos vendido</h7>
                            <%                               
                                
                                 Crud_ventas s = new Crud_ventas();
                                 if(s.traernombres()==null){
                                     
                                 }else{
                                     
                                        Iterator it2 = s.traernombres().keySet().iterator();
                                int ko = 0;
                                while (it2.hasNext()) {
                                    Integer key = (Integer) it2.next();
                                    out.println("<h1> " + s.traernombres().get(key) + "</h1>");
                                    break;

                                }
                                     
                                 }
                             


                            %>

                        <h8>Producto mas vendido</h8>

                        <%       

                                   Crud_ventas s2 = new Crud_ventas();
                            int ju = s2.traernombres().size();
                            ju = ju + 1;
                            if (s2.traernombres().get(ju) == null) {
                                out.println("<h1> " + "Esperando mas reguistros" + "</h1>");
                            } else {
                                out.println("<h1> " + s2.traernombres().get(ju) + "</h1>");

                            }


                        %>
                    </div>
                    <!-- Final presentacion Noticias-->

                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>


                </div>
                <div id="content" style="background-color:#ffff33">
                    <!-- insert the page content here -->
                    <form action="recetas" method="post">
                        <div class="form_settings">

                            <p><span>Nombre Receta</span>
                                <input class="contact" type="text" name="Nombre_Receta" value="" /></p>
                            <p><span>Tiempo de preparacion</span>
                                <input class="contact" type="text" name="Tiempo_de_preparacion" value="" /></p>
                            <p><span>Receña</span>
                                <input class="contact" type="text" name="recetass" value="" /></p>
                            <p><span>Cantidad de personas</span>
                                <input class="contact" type="text" name="Cantidad_de_personas" value="" /></p>
                            <p><span>Ingredientes</span>
                                <input class="contact" type="text" name="Ingredientes" value="" /></p>
                            <p><span>Pasos</span>
                                <input class="contact" type="text" name="Pasos" value="" /></p>


                            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="Receta_registrada" value="Añadir Receta" /></p>

                        </div>
                    </form>

                </div>
                    
                    
                    <p>&nbsp;</p>
                       <center>
                      
                       <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3976.541702469006!2d-74.08319618569469!3d4.675470296603867!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f9b033fa56e79%3A0xd67cca4c935fae5f!2sCl.+74+%2363-10%2C+Bogot%C3%A1!5e0!3m2!1sen!2sco!4v1509418730390" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
                       </center>
                    
                    
            </div>
            <div id="footer">
                <p>Calle 74# 63-12 Bogota colombia  -  tel:(57) (1) 4381889  </p>
            </div>
        </div>
    </body>
</html>
