package com.flores.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flores.examen.entitys.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
