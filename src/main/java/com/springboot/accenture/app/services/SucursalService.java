package com.springboot.accenture.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.accenture.app.models.Franquicia;
import com.springboot.accenture.app.models.Sucursal;
import com.springboot.accenture.app.repository.FranquiciaRepository;
import com.springboot.accenture.app.repository.SucursalRepository;

@Service
public class SucursalService {
	
	@Autowired
	private FranquiciaRepository franquiciaRepo;
	
	@Autowired
	private SucursalRepository sucursalRepo;
	
	public Sucursal agregarSucursalAFranquicia(Long franquiciaId, Sucursal sucursalRequest) {
		
		Franquicia franquicia = franquiciaRepo.findById(franquiciaId)
				.orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
		
		sucursalRequest.setFranquicia(franquicia);
		
		return sucursalRepo.save(sucursalRequest);
	}
	
	public Sucursal actualizarNombre(long sucursalId, String nuevoNombre) {
		Sucursal surcursal = sucursalRepo.findById(sucursalId)
				.orElseThrow(() -> new RuntimeException("surcursal no encontrada"));
		
		surcursal.setNombreSucursal(nuevoNombre);
		
		return sucursalRepo.save(surcursal);
	}
	
	public List<Sucursal> obtenerSucursalesPorFranquicia(Long franquiciaId) {
		
		return sucursalRepo.findAll().stream()
		.filter(sucursal -> sucursal.getFranquicia().getId().equals(franquiciaId))
		.collect(Collectors.toList());
	}

}
