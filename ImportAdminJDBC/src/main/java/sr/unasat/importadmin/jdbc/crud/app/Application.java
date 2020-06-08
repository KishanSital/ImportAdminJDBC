package sr.unasat.importadmin.jdbc.crud.app;

import sr.unasat.importadmin.jdbc.crud.entities.Customer;
import sr.unasat.importadmin.jdbc.crud.entities.Product;
import sr.unasat.importadmin.jdbc.crud.entities.ProductOrder;
import sr.unasat.importadmin.jdbc.crud.repositories.CustomerRepository;
import sr.unasat.importadmin.jdbc.crud.repositories.ProductOrderRepository;
import sr.unasat.importadmin.jdbc.crud.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Application {
	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(format);

		ProductOrderRepository prOrdRepo = new ProductOrderRepository();
		ProductRepository prdRepo = new ProductRepository();
		CustomerRepository custRepo = new CustomerRepository();

		System.out.println("-------------------Welcome to Shop Doewet------------------");

//		Select statements

//		List<Product> productList = prdRepo.findAllProducts();
//		for (Product product : productList) {
//			System.out.println(product);
//		}

		/*List<Customer> customerList = custRepo.findAllCustomers();
		for (Customer customer : customerList) {
			System.out.println(customer);
		}*/

	//	List<ProductOrder> productOrderList = prOrdRepo.findAllProdOrders();

//		 Insert statements

//		 prdRepo.insertNewProduct(new Product("Alcohol"));
//		 custRepo.insertNewCustomer(new Customer("lisa","kwatta3","12345678"));
//		 prOrdRepo.insertNewProductOrder(new Product_order(formatDateTime, 6, 5));
//		 prOrdRepo.insertNewProductOrder(new Product_order(formatDateTime, 2, 4));
//		 prOrdRepo.insertNewProductOrder(new Product_order(formatDateTime, 3, 4));
//		 prOrdRepo.insertNewProductOrder(new Product_order(formatDateTime, 4, 4));

//		 Update statements
//		 prdRepo.UpdateProduct(new Product("Vitamine C",5));
//		 custRepo.UpdateCustomer(new Customer("Vidhan Sital","Garnizoenspad
//		 5","005978825116",1));
//		 prOrdRepo.UpdateProductOrder(new ProductOrder(formatDateTime,3,3,1));

//		delete statements (If customers and products in a relation, delete the relation
//		 before deleting product or customer
//		prOrdRepo.DeleteOneProductOrder(new ProductOrder(5));
//		prdRepo.DeleteOneProduct(new Product(6));
//		custRepo.DeleteOneCustomer(new Customer(5));
	}

}
