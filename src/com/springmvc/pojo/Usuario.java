package com.springmvc.pojo;

import java.sql.Timestamp;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.springmvc.pojo.valid.PersistenceGroup;
import com.springmvc.pojo.valid.SpringFormGroup;

@SuppressWarnings("deprecation")
@Entity
@Table(name ="usuario")
public class Usuario {
	@Id //indicar que esta propiedad idUsr corresponde a mi Id en mi tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsr;
//	@Column(name="USUARIO") se tuviera que poner si mi columna tiviera un nombre distinto a la pro de mi pojo
	@NotEmpty(message = Constants.NOT_EMPTY, groups={PersistenceGroup.class, SpringFormGroup.class})
	private String usuario;
	@NotEmpty(message = Constants.NOT_EMPTY,groups={PersistenceGroup.class, SpringFormGroup.class})
	@Size(min=3 ,max=15,message=Constants.SIZE, groups={SpringFormGroup.class})
	private String clave;
	@NotEmpty(message = Constants.NOT_EMPTY, groups={PersistenceGroup.class, SpringFormGroup.class})
	private String permiso;
	private Timestamp fechaCreacion;
	
	
	public int getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsr=" + idUsr + ", usuario=" + usuario + ", clave=" + clave + ", permiso=" + permiso
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
}
