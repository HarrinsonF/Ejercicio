package com.flores.examen.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flores.examen.entitys.Categoria;
import com.flores.examen.entitys.Distrito;
import com.flores.examen.entitys.Persona;
import com.flores.examen.service.CategoriaService;
import com.flores.examen.service.DistritoService;
import com.flores.examen.service.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private CategoriaService servicioCate;
	@Autowired
	private DistritoService servicioDistrito;
	@Autowired
	private PersonaService servicioPersona;
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("categoria", servicioCate.listarCategorias());
		model.addAttribute("distrito", servicioDistrito.listarTodos());
		model.addAttribute("persona", servicioPersona.listarPersonas());
		return "persona";
	}
	
	@RequestMapping("/grabar")
	public String 	grabar(@RequestParam("codigo") Integer cod,
							@RequestParam("nombre") String nom,
							@RequestParam("paterno") String pat,
							@RequestParam("materno") String mat,
							@RequestParam("dni") String dni,
							@RequestParam("sueldo") double sue,
							@RequestParam("nacimiento") String nac,
							@RequestParam("distrito") int codDis,
							@RequestParam("categoria") int codCate,
							RedirectAttributes redirect) {
		try {
			Persona per = new Persona();
			
			per.setNombre(nom);
			per.setPaterno(pat);
			per.setMaterno(mat);
			per.setDni(dni);
			per.setSueldo(sue);
			per.setNacimiento(LocalDate.parse(nac));
			
			Distrito dis = new Distrito();
			Categoria cat = new Categoria();
			
			dis.setCodigo(codDis);
			cat.setCodigo(codCate);
			
			per.setDistrito(dis);
			per.setCategoria(cat);
			
			if(cod==0) {
				servicioPersona.registrar(per);
				redirect.addFlashAttribute("MENSAJE", "PERSONA REGISTRADA");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/persona/lista";
	}

}
