package com.flores.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flores.examen.entitys.Persona;
import com.flores.examen.repository.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository repo;
	
	public void registrar(Persona per) {
		repo.save(per);
	}
	
	public List<Persona> listarPersonas(){
		return repo.findAll();
	}
}
