package ar.edu.unlam.tallerweb1.domain.menu;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.domain.usuarios.Ingredientes;



public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private List <Ingredientes> ingredientes;
	
	
	
}
