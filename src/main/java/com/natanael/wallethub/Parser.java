package com.natanael.wallethub;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	// leer el archivo
	// leer cada linea y guardarla en una base de datos

}
