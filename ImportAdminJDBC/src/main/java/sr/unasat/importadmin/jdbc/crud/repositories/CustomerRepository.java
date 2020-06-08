package sr.unasat.importadmin.jdbc.crud.repositories;

import sr.unasat.importadmin.jdbc.crud.constants.Credentials;
import sr.unasat.importadmin.jdbc.crud.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
	private Connection connection;

	public CustomerRepository() {
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

	public List<Customer> findAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String sql = "select * from customer";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int customer_id = rs.getInt("customer_id");
				String customer_name = rs.getString("customer_name");
				String customer_address = rs.getString("customer_address");
				String customer_telephone = rs.getString("customer_telephone");

				customerList.add(new Customer(customer_id, customer_name, customer_address, customer_telephone));
			}
			rs.close();

		} catch (SQLException e) {

		} finally {

		}
		return customerList;
	}

	public int insertNewCustomer(Customer customer) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "insert into customer (customer_name, customer_address, customer_telephone)  values(?,?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getCustomer_name());
			stmt.setString(2, customer.getCustomer_address());
			stmt.setString(3, customer.getCustomer_telephone());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + customer.getCustomer_name() + ","
					+ customer.getCustomer_address() + "," + customer.getCustomer_telephone() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int UpdateCustomer(Customer customer) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "update customer set customer_name = ? , customer_address = ? , customer_telephone = ? where customer_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getCustomer_name());
			stmt.setString(2, customer.getCustomer_address());
			stmt.setString(3, customer.getCustomer_telephone());
			stmt.setInt(4, customer.getCustomer_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + "(" + customer.getCustomer_name() + ","
					+ customer.getCustomer_address() + "," + customer.getCustomer_telephone() + " @ " + "customer_id = "
					+ customer.getCustomer_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

	public int DeleteOneCustomer(Customer customer) {
		PreparedStatement stmt = null;
		int result = 0;
		try {
			String sql = "delete from customer where customer_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, customer.getCustomer_id());
			result = stmt.executeUpdate();
			System.out.println("resultset: " + result + " (" + " Customer deleted where " + "customer_id = "
					+ customer.getCustomer_id() + ")");
		} catch (SQLException e) {

		} finally {

		}
		return result;
	}

}
