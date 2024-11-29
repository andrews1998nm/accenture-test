package com.springboot.accenture.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.accenture.app.models.Franquicia;
import com.springboot.accenture.app.models.Producto;
import com.springboot.accenture.app.models.Sucursal;
import com.springboot.accenture.app.repository.ProductoRepository;
import com.springboot.accenture.app.repository.SucursalRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private SucursalRepository sucursalRepo;
	
	public Producto agregarProductoASucursal(Long sucursalId,Producto productoRequest) {
		Sucursal sucursal = sucursalRepo.findById(sucursalId).orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
		
		productoRequest.setSucursal(sucursal);
		
		return productoRepo.save(productoRequest);
	}
	
	public Producto actualizarStockProducto(Long productoId, Integer stock) {
		Producto producto = productoRepo.findById(productoId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		
		producto.setStock(stock);
		
		return productoRepo.save(producto);
	}
	
	public Producto actualizarNombre(long productoId, String nuevoNombre) {
		Producto producto = productoRepo.findById(productoId)
				.orElseThrow(() -> new RuntimeException("Producto no encontradoencontrado"));
		
		producto.setNombre(nuevoNombre);
		
		return productoRepo.save(producto);
	}
	
	public void borrarProducto(Long productoId) {
		Producto producto = productoRepo.findById(productoId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		
		productoRepo.delete(producto);
	}

}
