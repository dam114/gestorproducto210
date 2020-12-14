package org.jesuitasrioja.holamundo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

	@GetMapping("/productos")
	public List<Producto> allProducts() {
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(new Producto("1", "tomate", 1.30));
		listaProductos.add(new Producto("2", "patata", 0.50));
		listaProductos.add(new Producto("3", "aguacate", 3.0));
		
		return listaProductos;
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {
		return new Producto(id, "tomate", 1.30);
	}
	
	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam String id) {
		return new Producto(id, "tomate", 1.30);
	}
	
	@PostMapping("/producto")
	public String postProducto(@RequestBody Producto nuevoProducto) {
		return "Añadido"+nuevoProducto.toString();
	}
	
	@PutMapping("/producto/{id}")
	public Producto putProducto(@RequestBody Producto editadoProducto) {
		return null;
	}
	
	@DeleteMapping("/producto/{id}")
	public String deleteProducto() {
		return null; 
	}
	
	
	
	
//	@GetMapping("/saludos/{nombre}")
//	public String getSaludo(@PathVariable String nombre) {
//		return "Hola "+nombre;
//	}
//	
//	@GetMapping("/saludos")
//	public String getSaludo(@RequestParam String nombre) {
//		return "Hola "+nombre;
//	}
//	
//	@GetMapping("/alumno/{id}")
//	public String getSaludo2(@PathVariable String id) {
//		return "Hola "+id;
//	}
//	
//	@GetMapping("/saludo")
//	public String getSaludo2(@RequestParam String id) {
//		return "Hola "+id;
//	}
//	
//	@PostMapping("/saludos")
//	public String postSaludo() {
//		return "Hola Mundo con post";
//	}
//	
//	@PostMapping("/saludos")
//	public String postSaludo(@RequestBody String cuerpo) {
//		System.out.println("----Cuerpo----");
//		System.out.println(cuerpo);
//		return cuerpo;
//	}
//	
//	@DeleteMapping("/saludos")
//	public String deleteSaludo() {
//		return "Hola Mundo con delete";
//	}
//	
//	@PutMapping("/saludos")
//	public String putSaludo() {
//		return "Hola Mundo con put";
//	}

}
