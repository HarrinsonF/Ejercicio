package com.flores.examen.entitys;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito {
@Id
@Column(name="iddistrito")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer codigo;
@Column(name="nomdistrito")
private String nombre;

@OneToMany(mappedBy = "distrito")
private List<Persona> listaDistrito;

public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public List<Persona> getListaDistrito() {
	return listaDistrito;
}

public void setListaDistrito(List<Persona> listaDistrito) {
	this.listaDistrito = listaDistrito;
}



}