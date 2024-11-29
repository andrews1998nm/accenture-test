package com.springboot.accenture.app.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.accenture.app.models.Franquicia;
import com.springboot.accenture.app.models.Producto;
import com.springboot.accenture.app.models.Sucursal;
import com.springboot.accenture.app.repository.FranquiciaRepository;

@Service
public class FranquiciaService {
	
	@Autowired
	private FranquiciaRepository franquiciaRepo;
	
	@Autowired
	private SucursalService sucursalService;
	
	public Franquicia crearFranquicia(Franquicia franquicia) {
		
		return franquiciaRepo.save(franquicia);
	}
	
	public Franquicia actualizarNombre(long franquiciaId, String nuevoNombre) {
		Franquicia franquicia = franquiciaRepo.findById(franquiciaId)
				.orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
		
		franquicia.setNombreFranquicia(nuevoNombre);
		
		return franquiciaRepo.save(franquicia);
	}
	
	public List<Producto> obtenerMayorStockProductos(long franquiciaId){
		List<Sucursal> sucursales = sucursalService.obtenerSucursalesPorFranquicia(franquiciaId);
		
		List<Producto> MayorStockProductos = new ArrayList<>();
		
		for (Sucursal sucursal: sucursales) {
			Producto productoMayorStock = sucursal.getListaProductos().stream()
					.max(Comparator.comparingInt(Producto::getStock))
					.orElse(null);
			if(productoMayorStock != null) {
				productoMayorStock.setSucursal(sucursal);
				MayorStockProductos.add(productoMayorStock);
			}
		}
		return MayorStockProductos;
	}

}
