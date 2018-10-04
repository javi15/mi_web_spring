package com.springmvc.pojo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="admin")
public class Admin {
	//Le indico de el atributo idAd sera el id y al mismo tiempo que es
	//de tipo identity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAd;
	
	private String nombre;
	
	private String cargo;
	
	private Timestamp fechaCreacion;
	
	@OneToMany(mappedBy="admin")
	private Set<Direccion> direcciones;
	
	
/*
 * Este es un constructor vacio como parte del y un estandar de la clase POJO*/
	public Admin() {
	}
	
	// constructor con todos los atributos de la clase 
	public Admin(String nombre, String cargo, Timestamp fechaCreacion) {
		
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}
	
	//Los metodos GET y SET para cada atrubuto que hemos declarado
	public int getIdAd() {
		return idAd;
	}
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	//Metodo toString()
	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion="
				+ fechaCreacion + "]";
	}
	
	
}
