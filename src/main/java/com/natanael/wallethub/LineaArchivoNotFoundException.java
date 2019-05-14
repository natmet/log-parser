package com.natanael.wallethub;

public class LineaArchivoNotFoundException extends RuntimeException {
	
	LineaArchivoNotFoundException(Long id) {
	    super("Error al buscar linea del log " + id);
	  }
}
