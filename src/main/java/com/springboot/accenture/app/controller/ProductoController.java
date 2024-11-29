package com.springboot.accenture.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.accenture.app.models.Producto;
import com.springboot.accenture.app.models.Sucursal;
import com.springboot.accenture.app.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/{sucursalId}")
	public ResponseEntity<Producto> agregarProductoASucursal(
			@PathVariable Long sucursalId,
			@RequestBody Producto productoRequest) {
		
		Producto producto = productoService.agregarProductoASucursal(sucursalId, productoRequest);
		
		return new ResponseEntity<>(producto, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizarNombre/{productoId}")
	public ResponseEntity<Producto> actualizarNombreSucursal(
			@PathVariable Long productoId,
			@RequestParam String nombre) {
		Producto producto = productoService.actualizarNombre(productoId, nombre);
		
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@PutMapping("/{productoId}/stock")
	public ResponseEntity<Producto> actualizarStock(
			@PathVariable Long productoId,
			@RequestParam Integer stock) {
		Producto producto = productoService.actualizarStockProducto(productoId, stock);
		
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{productoId}")
	public ResponseEntity<Void> borrarProducto(@PathVariable Long productoId){
		productoService.borrarProducto(productoId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
