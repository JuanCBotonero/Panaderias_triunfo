<%-- 
    Document   : index
    Created on : 4/09/2017, 10:28:11 AM
    Author     : Labing I5
--%>

<%@page import="java.util.List"%>
<%@page import="Dao.Crud_Recetas"%>
<%@page import="Dao.Crud_ventas"%>
<%@page import="java.util.Iterator"%>
<%@page import="dato.receta"%>
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
                        <img src="canasta.png" border="4"  width="160" height="90"/>              
                        <p>&nbsp;</p>
                </div>
                <div id="menubar" style="background-color:#ff6666" >
                    <ul id="menu">
                        <!-- put class="current" in the li tag for the selected page - to highlight which page you're on -->
                            <li><a href="index.jsp">Sale</a></li>
                        <li><a href="compra.jsp">Buy</a></li>
                        <li><a href="listar.jsp">List</a></li>
                        <li><a href="caja.jsp">Caja</a></li>
                        <li><a href="recetas.jsp">Recetas</a></li>
                        <li class="current"  ><a href="Listar_receta.jsp">ListRe</a></li>
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
                    <form action="Listar_receta" method="post">
                        <div class="form_settings">

                            <%                                System.out.println("lectura");

                                Crud_Recetas s3 = new Crud_Recetas();
                                if(s3.findAll()==null){
                                    
                                }else{
                                    
                                    List<receta> activos=s3.findAll();

                                for (int i = 0; i < activos.size(); i++) {
                                   
                                    out.println("<h1>" + "-----------------------------------------------" + "</h1>");
                                    out.println("<h1>" + "Receta N° " + activos.get(i).getId() + " - " + activos.get(i).getNombre_Receta() + "</h1>");
                                    out.println("<h1>" + "Tiempo de preparación" + " " + activos.get(i).getTiempo_de_preparacion() + "</h1>");
                                    out.println("<h1>" + "DESCRIPCION" + "</h1>");
                                    out.println("<h1> El " + activos.get(i).getReceña() + "</h1>");
                                    out.println("<h1> Para " + activos.get(i).getCantidad_de_personas() + " - " + "Personas" + "</h1>");
                                    out.println("<h1>" + "INGREDIENTES" + "</h1>");

                                    String temp = activos.get(i).getIngredientes();
                                    String diaArray[] = temp.split(",");

                                    for (int i2 = 0; i2 < diaArray.length; i2++) {
                                        int y2 = i2;
                                        y2 = y2 + 1;
                                        out.println("<h1>" + y2 + " - " + diaArray[i2] + "</h1>");
                                    }
                                    out.println("<h1>" + "PASOS PARA PREPARAR" + "</h1>");

                                    String temp2 = activos.get(i).getPasos();
                                    String diaArray2[] = temp2.split(",");

                                    for (int i3 = 0; i3 < diaArray2.length; i3++) {
                                        int y3 = i3;
                                        y3 = y3 + 1;
                                        out.println("<h1>" + y3 + " - " + diaArray2[i3] + "</h1>");
                                    }

                                    out.println("<h1>" + "-----------------------------------------------" + "</h1>");

                                }


                                    
                                }
                                
                            %>





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
