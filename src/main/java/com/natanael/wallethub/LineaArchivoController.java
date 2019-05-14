package com.natanael.wallethub;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineaArchivoController {

	private final LineaArchivoRepository lr;
	//un lineaarchivorepository es inyectado por el constructor en el lineaarchivocontroller
	LineaArchivoController(LineaArchivoRepository lr) {
		this.lr = lr;
	}

	// Agregar ruta
	@GetMapping("/LineaArchivo")
	List<LineaArchivo> all() {
		return (List<LineaArchivo>) lr.findAll();
	}

	@PostMapping("/LineaArchivo")
	LineaArchivo newLinea(@RequestBody LineaArchivo newLineaArchivo) {
		return lr.save(newLineaArchivo);
	}

	// Unico Item
	@GetMapping("/LineaArchivo/{id}")
	LineaArchivo one(@PathVariable Long id) {

		return lr.findById(id).orElseThrow(() -> new LineaArchivoNotFoundException(id));
	}
	
	//PutMapping

	
	//Delete Mapping
	@DeleteMapping("/LineaArchivo/{id}")
	void deleteLineaArchivo(@PathVariable Long id) {
		lr.deleteById(id);
	}

}
