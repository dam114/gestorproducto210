package org.jesuitasrioja.holamundo.repository;

import java.util.List;

import org.bson.Document;
import org.jesuitasrioja.holamundo.modelo.Producto;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ProductosRepositoryMongoDB implements IProductosRepository {

	private MongoCollection<Document> collection;

	public ProductosRepositoryMongoDB() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("productosDB");
		collection = database.getCollection("productos");
	}

	/**
	 * sfdbjh
	 * 
	 * @return El producto con el id pasado por parametro o null en caso de no
	 *         existir.
	 */
	@Override
	public Producto getById(String id) {
		Producto productoReturn = null;
		Document productoDocument = collection.find(Filters.eq("id", id)).first();

		if (productoDocument != null) {
			productoReturn = documentToProducto(productoDocument);
		}
		return productoReturn;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aniadirProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarProducto(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Producto documentToProducto(Document productoDocument) {
		Producto productoReturn;
		Gson gson = new Gson();
		String productoJSON = productoDocument.toJson();
		productoReturn = gson.fromJson(productoJSON, Producto.class);
		return productoReturn;
	}

}
