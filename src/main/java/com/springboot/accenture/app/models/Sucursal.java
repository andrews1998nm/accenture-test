package com.springboot.accenture.app.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_sucursal")
	private String nombreSucursal;
	
	@ManyToOne
	@JoinColumn(name = "franquicia_id")
	private Franquicia franquicia;
	
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
	private List<Producto> ListaProductos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public Franquicia getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}

	public List<Producto> getListaProductos() {
		return ListaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		ListaProductos = listaProductos;
	}
	
	
	
}
