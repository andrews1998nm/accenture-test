package com.springboot.accenture.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.accenture.app.models.Franquicia;
import com.springboot.accenture.app.models.Sucursal;
import com.springboot.accenture.app.services.SucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	@PostMapping("/{franquiciaId}")
	public ResponseEntity<Sucursal> agregarSucursalAFranquicia(
			@PathVariable Long franquiciaId,
			@RequestBody Sucursal sucursalRequest) {
		Sucursal sucursal = sucursalService.agregarSucursalAFranquicia(franquiciaId, sucursalRequest);
		
		return new ResponseEntity<>(sucursal, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizarNombre/{sucursalId}")
	public ResponseEntity<Sucursal> actualizarNombreSucursal(
			@PathVariable Long sucursalId,
			@RequestParam String nombreSucursal) {
		Sucursal sucursal = sucursalService.actualizarNombre(sucursalId, nombreSucursal);
		
		return new ResponseEntity<>(sucursal, HttpStatus.OK);
	}
}
