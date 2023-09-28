package com.flores.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flores.examen.entitys.Distrito;
import com.flores.examen.repository.DistritoRepository;

@Service
public class DistritoService {
	@Autowired
	private DistritoRepository repo;
	
	
	public List<Distrito> listarTodos(){
		return repo.findAll();
	}
}
