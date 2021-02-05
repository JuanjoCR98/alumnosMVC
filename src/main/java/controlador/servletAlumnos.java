/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Utilidades;

/**
 *
 * @author Juanjo Cortés
 */
public class servletAlumnos extends HttpServlet {
    
      private ArrayList<String> gruposDAW;
      private String rutaFicherosA;
      private String rutaFicherosB;
      
    @Override
    public void init(ServletConfig config) throws ServletException {
        gruposDAW = new ArrayList<String>();
        gruposDAW.add("2DAW_A");
        gruposDAW.add("2DAW_B");
        rutaFicherosA = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros")
                .concat(File.separator).concat("2daw_a.txt");
        rutaFicherosB = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros")
                .concat(File.separator).concat("2daw_b.txt");
           
    }
      

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grupoSeleccionado = "2DAW_A";
        ArrayList<Alumno> gruposAB;
        if (request.getParameter("grupo") != null) {
            grupoSeleccionado = request.getParameter("grupo");
        }
        request.setAttribute("grupos", gruposDAW);
                request.setAttribute("grupo", grupoSeleccionado);
        if(grupoSeleccionado.equals("2DAW_A")){
             gruposAB= Utilidades.getAlumnos(rutaFicherosA);
        }else{
            gruposAB= Utilidades.getAlumnos(rutaFicherosB);
        }
        request.setAttribute("grupoSeleccionado", gruposAB);
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alumnosSeleccionados[] = request.getParameterValues("alumno");
        ArrayList<Alumno> arrayalumSelec =  new ArrayList<Alumno>();
        for(int i = 0;i<alumnosSeleccionados.length;i++){
            String[] al = alumnosSeleccionados[i].split(",");
            Alumno alumno = new Alumno(Integer.parseInt(al[0]),al[1],al[2],al[3]);
            arrayalumSelec.add(alumno);
        }
        request.setAttribute("alumnos",arrayalumSelec);
        request.getRequestDispatcher("alumnosseleccionados.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
