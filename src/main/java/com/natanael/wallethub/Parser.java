package com.natanael.wallethub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Parser {

	
	
	
	// localizar el archivo
	public LineaArchivo convertirString(String cadena) {
		String[] arreglo = cadena.split("\\|");
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:MM:ss.SSS");
		// DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime fecha = LocalDateTime.parse(arreglo[0], formato);
		int estatus = Integer.parseInt(arreglo[3]);

		LineaArchivo lineaArchivo = new LineaArchivo(fecha, arreglo[1], arreglo[2], estatus, arreglo[4]);
		return lineaArchivo;
	}

	public static void main(String[] args) {
		
		Parser ps = new Parser();
		try {
			ps.leerLineaArchivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Leer los datos del archivo, guardarlos en un string y imprimirlos
		File archivo = new File("nato.txt");
		
		try {
			ps.imprimirTextoArchivo(archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Leer Archivo log y imprimir las 5 primeras lineas.
	public void imprimirTextoArchivo(File file) throws IOException {
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String nombre = br.readLine();
		System.out.println(nombre);
		br.close();
	}
	
	public void leerLineaArchivo( ) throws IOException {
		File archivo = new File("nato.txt");
		
		FileOutputStream fo = new FileOutputStream(archivo);
		String nombre ="natanael";
		fo.write(nombre.getBytes());
		fo.close();
		
	}
	
		
	//Hacer un metodo de parser, que lea un archivo y crea 5 objetos LineaArchivo con las primeras 5 lineas del archivo.
	
	
	
	
	
	// leer el archivo
	
	
	
	// leer cada linea y guardarla en una base de datos

}
