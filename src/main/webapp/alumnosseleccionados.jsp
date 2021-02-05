<%-- 
    Document   : mensajesalumnos
    Created on : 05-feb-2021, 12:53:17
    Author     : Juanjo Cortés
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) request.getAttribute("alumnos");
        %>
        <div class="container" style="padding-top:15px ">
            <% for(Alumno al: listaAlumnos){ %>
                <div style="background-color: gainsboro; border-radius: 15px;width: 300px; padding:3px; 
                     text-align: center; float:left; margin-right: 5px"><%=al.getEmail()%>  </div>          
            <% } %>        
        </div>
        <br>
        <br>
        <div class="container">
            <form>
                <textarea placeholder="Mensaje..." style="width: 100%; height: 300px"></textarea>
                <input type="submit" class="btn btn-primary btn-block" value="ENVIAR">
            </form>
        </div>
        
        
    </body>
</html>
