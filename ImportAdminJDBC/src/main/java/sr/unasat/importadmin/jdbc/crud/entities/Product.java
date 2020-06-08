package sr.unasat.importadmin.jdbc.crud.entities;

public class Product {

    private int product_id;
    private String product_name;

    //select
    public Product(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    // insert
    public Product(/*int product_id,*/ String product_name) {
       // this.product_id = product_id;
        this.product_name = product_name;
    }
    //update
    public Product(String product_name, int product_id) {
        this.product_name = product_name;
        this.product_id = product_id;
    }
    //delete
    public Product(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
