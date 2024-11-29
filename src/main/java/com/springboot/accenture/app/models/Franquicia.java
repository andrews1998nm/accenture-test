package com.springboot.accenture.app.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "franquicia")
public class Franquicia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_franquicia")
	private String nombreFranquicia;
	
	@OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
	private List<Sucursal> listaSucursales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreFranquicia() {
		return nombreFranquicia;
	}

	public void setNombreFranquicia(String nombreFranquicia) {
		this.nombreFranquicia = nombreFranquicia;
	}

	public List<Sucursal> getListaSucursales() {
		return listaSucursales;
	}

	public void setListaSucursales(List<Sucursal> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}
	
	

}
