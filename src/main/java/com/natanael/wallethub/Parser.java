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

import org.springframework.stereotype.Service;

@Service
public class Parser {

	LocalDateTime time = LocalDateTime.now();
	int hour = time.getHour();
	int minutes = time.getMinute();
	int seconds = time.getSecond();

	private LineaArchivoRepository lr;

	// Inyeccion de dependecia
	public Parser(LineaArchivoRepository lr) {
		super();
		this.lr = lr;
	}

	// localizar el archivo
	public LineaArchivo convertirString(String cadena) {
		String[] arreglo = cadena.split("\\|");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		// DateTimeFormatter formato = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime fecha = LocalDateTime.parse(arreglo[0], formato);
		int estatus = Integer.parseInt(arreglo[3]);

		LineaArchivo lineaArchivo = new LineaArchivo(fecha, arreglo[1], arreglo[2], estatus, arreglo[4]);
		return lineaArchivo;
	}

	/**
	 * Toma un archivo de logs, lo procesa linea por linea y graba cada linea en la
	 * base de datos.
	 * 
	 * @param archivo el archivo a procesar
	 * @throws IOException si no encuentra el archivo, o hay un error leyendolo
	 */
	public void procesarArchivo(File archivo) throws IOException {

		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		System.out.println("La hora de inicio es" + hour + " : " + " : " + minutes + " : " + seconds);
		while ((linea = br.readLine()) != null) {

			LineaArchivo ln2 = convertirString(linea);
			lr.save(ln2);
			// saltar proxima linea
			linea = linea + 1;
		}
		br.close();
		System.out.println("La hora de finalizacion es " + hour + " : " + " : " + minutes + " : " + seconds);
	}

	public void procesarArchivo(File file, LocalDateTime startTime, String duration, int threshold) {
		//Java Stream API 
		//Diferencias entre un array list y un linked list
		//Generics
		//Estructura de datos
		
	}

	// Leer los datos del archivo, guardarlos en un string y imprimirlos
	// Leer Archivo log y imprimir las 5 primeras lineas.

	public void imprimirTextoArchivo(File file) throws IOException {
		// Impresion de las 5 primeras lineas

		// imprimiendo las primero 5 lineas
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		for (int x = 0; x < 5; x++) {

			linea = br.readLine();
			LineaArchivo ln = convertirString(linea);
			System.out.println(linea);
		}

		br.close();

	}

	/*
	 * public void leerLineaArchivo( ) throws IOException { File archivo = new
	 * File("nato.txt"); FileOutputStream fo = new FileOutputStream(archivo); String
	 * nombre ="JAVA"; fo.write(nombre.getBytes()); fo.close();
	 * 
	 * }
	 */

	// Hacer un metodo de parser, que lea un archivo y crea 5 objetos LineaArchivo
	// con las primeras 5 lineas del archivo.

	// leer el archivo

	// leer cada linea y guardarla en una base de datos

}
