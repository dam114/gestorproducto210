package org.jesuitasrioja.holamundo.repository;

import java.util.ArrayList;
import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;

public class ProductosRepository implements IProductosRepository {

	List<Producto> productos;

	public ProductosRepository() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("1", "lechuga", 0.20));
		productos.add(new Producto("2", "patata", 0.5));
	}
	
	@Override
	public Producto getById(String id) {
		for (Producto producto : productos) {
			if (producto.getId().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	
	@Override
	public List<Producto> getAll() {
		return this.productos;
	}
	
	@Override
	public boolean aniadirProducto(Producto producto) {
		Boolean isAniadido = productos.add(producto);
		return isAniadido;
	}
	
	@Override
	public boolean eliminarProducto(String id) {
		boolean isEliminado = false;
		for (int i = 0; !isEliminado && i < productos.size(); i++) {
			if (productos.get(i).getId().equals(id)) {
				productos.remove(i);
				isEliminado=true;
			}
		}
		return isEliminado;
	}

}
