package sr.unasat.importadmin.jdbc.crud.repositories;

import sr.unasat.importadmin.jdbc.crud.constants.Credentials;
import sr.unasat.importadmin.jdbc.crud.entities.ProductOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderRepository {
	private Connection connection;

	public ProductOrderRepository() {
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

	public List<ProductOrder> findAllProdOrders() {
		List<ProductOrder> prodOrderList = new ArrayList<ProductOrder>();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String sql = "select pdr.product_order_id, pd.product_id, cs.customer_id , pdr.product_order_date, pd.product_name, cs.customer_name, cs.customer_address, cs.customer_telephone "
					+ "from product_order pdr " + "left join product pd " + "on pd.product_id = pdr.FK_product_id "
					+ "left join customer cs " + "on cs.customer_id = pdr.FK_customer_id ";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int product_order_id = rs.getInt("product_order_id");
				int product_id = rs.getInt("product_id");
				int customer_id = rs.getInt("customer_id");
				String product_order_date = rs.getString("product_order_date");
				String product_name = rs.getString("product_name");
				String customer_name = rs.getString("customer_name");
				String customer_address = rs.getString("customer_address");
				String customer_telephone = rs.getString("customer_telephone");

				System.out.println("product_order_id: " + product_order_id);
				System.out.println("product_id: " + product_id);
				System.out.println("customer_id: " + customer_id);
				System.out.println("product_order_date: " + product_order_date);
				System.out.println("product_name: " + product_name);
				System.out.println("customer_name: " + customer_name);
				System.out.println("customer_address: " + customer_address);
				System.out.println("customer_telephone: " + customer_telephone);

			}
			rs.close();
		} catch (SQLException e) {

		} finally {

		}
		return prodOrderList;
	}

	public int insertNewProductOrder(ProductOrder product_order) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "insert into product_order (product_order_date, FK_product_id, FK_customer_id)  values(?,?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product_order.getProduct_order_date());
			stmt.setInt(2, product_order.getFK_product_id());
			stmt.setInt(3, product_order.getFK_customer_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + product_order.getProduct_order_date() + ","
					+ product_order.getFK_product_id() + "," + product_order.getFK_customer_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int UpdateProductOrder(ProductOrder product_order) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "update product_order set product_order_date = ? , FK_product_id = ? , FK_customer_id = ? where product_order_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product_order.getProduct_order_date());
			stmt.setInt(2, product_order.getFK_customer_id());
			stmt.setInt(3, product_order.getFK_customer_id());
			stmt.setInt(4, product_order.getProduct_order_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + product_order.getProduct_order_date() + ","
					+ product_order.getFK_customer_id() + "," + product_order.getFK_customer_id() + " @ "
					+ "product_order_id = " + product_order.getProduct_order_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int DeleteOneProductOrder(ProductOrder product_order) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "delete from product_order where product_order_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, product_order.getProduct_order_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + " (" + " Product_order deleted where " + "product_order = "
					+ product_order.getProduct_order_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

}
