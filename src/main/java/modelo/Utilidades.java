/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author DAW-B
 */
public class Utilidades {
	public static ArrayList<Alumno> getAlumnos(String fichero){
		ArrayList<Alumno> productos = new ArrayList<Alumno>();
		try {		
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero), "utf-8"));
			String linea;			
			try {			
				while((linea = buffer.readLine())!=null) {
                                    String [] atributoAlumno = linea.split(";");
                                    Alumno prod = new Alumno(Integer.parseInt(atributoAlumno[0]),
                                            atributoAlumno[1],
                                            atributoAlumno[2],
                                            atributoAlumno[3]);      
					productos.add(prod);					
				 }				
				buffer.close();
			} catch (IOException e) {			
			}		
		} catch (FileNotFoundException | UnsupportedEncodingException e) {			
		}
		return productos;		
	}
}