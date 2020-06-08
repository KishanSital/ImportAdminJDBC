package sr.unasat.importadmin.jdbc.crud.repositories;

import sr.unasat.importadmin.jdbc.crud.constants.Credentials;
import sr.unasat.importadmin.jdbc.crud.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private Connection connection;

	public ProductRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("De driver is geregistreerd!");
			String URL = Credentials.URL;
			String USER = Credentials.USER;
			String PASS = Credentials.PASS;
			connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println(connection);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Product> findAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String sql = "select * from product";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				productList.add(new Product(product_id, product_name));
			}
			rs.close();

		} catch (SQLException e) {

		} finally {

		}
		return productList;
	}

	public int insertNewProduct(Product product) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "insert into product (product_name)  values(?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getProduct_name());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + product.getProduct_name() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int UpdateProduct(Product product) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "update product set product_name = ?  where product_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getProduct_name());
			stmt.setInt(2, product.getProduct_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + product.getProduct_name() + " @ " + "product_id = "
					+ product.getProduct_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int DeleteOneProduct(Product product) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "delete from product where product_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, product.getProduct_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + " (" + " Product deleted where " + "product_id = "
					+ product.getProduct_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

}
