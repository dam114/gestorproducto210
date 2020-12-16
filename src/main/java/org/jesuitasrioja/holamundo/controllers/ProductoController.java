package org.jesuitasrioja.holamundo.controllers;

import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;
import org.jesuitasrioja.holamundo.repository.IProductosRepository;
import org.jesuitasrioja.holamundo.repository.ProductosRepository;
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
	
	private IProductosRepository pr = new ProductosRepository();

	@GetMapping("/productos")
	public List<Producto> allProducts() {
		return pr.getAll();
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProducto(@PathVariable String id) {
		return pr.getById(id);
	}
	
	@GetMapping("/producto")
	public Producto getProducto2(@RequestParam String id) {
		return pr.getById(id);
	}
	
	@PostMapping("/producto")
	public String postProducto(@RequestBody Producto nuevoProducto) {
		return String.valueOf(pr.aniadirProducto(nuevoProducto));
	}
	
	@PutMapping("/producto/{id}")
	public Producto putProducto(@RequestBody Producto editadoProducto) {
		return null;
	}
	
	@DeleteMapping("/producto/{id}")
	public String deleteProducto(@PathVariable String id) {
		return String.valueOf(pr.eliminarProducto(id)); 
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
