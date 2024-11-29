package com.springboot.accenture.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.accenture.app.models.Franquicia;
import com.springboot.accenture.app.models.Producto;
import com.springboot.accenture.app.services.FranquiciaService;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {
	
	@Autowired
	private FranquiciaService franquiciaService;
	
	@PostMapping("/crear-franquicia")
	public ResponseEntity<Franquicia> crearFranquicia(@RequestBody Franquicia franquicia) {
		Franquicia Franquicia = franquiciaService.crearFranquicia(franquicia);
		
		return new ResponseEntity<>(Franquicia, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizarNombre/{franquiciaId}")
	public ResponseEntity<Franquicia> actualizarNombreFranquicia(
			@PathVariable Long franquiciaId,
			@RequestParam String nombreFranquicia) {
		Franquicia Franquicia = franquiciaService.actualizarNombre(franquiciaId, nombreFranquicia);
		
		return new ResponseEntity<>(Franquicia, HttpStatus.OK);
	}
	
	@GetMapping("/{franquiciaId}/mayorStock")
	public ResponseEntity<List<Producto>> mayorStockPorFranquicia(@PathVariable Long franquiciaId) {
		List<Producto> mayorStock = franquiciaService.obtenerMayorStockProductos(franquiciaId);
		
		return new ResponseEntity<>(mayorStock, HttpStatus.OK);
	}
	
}
