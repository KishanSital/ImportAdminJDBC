package sr.unasat.importadmin.jdbc.crud.entities;

public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_telephone;

    //select
    public Customer(int customer_id, String customer_name, String customer_address, String customer_telephone) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_telephone = customer_telephone;
    }

    //insert
    public Customer(/*int customer_id,*/ String customer_name, String customer_address, String customer_telephone) {
      //  this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_telephone = customer_telephone;
    }
    //update
    public Customer( String customer_name, String customer_address, String customer_telephone , int customer_id) {
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_telephone = customer_telephone;
        this.customer_id = customer_id;

    }

    //delete
    public Customer(  int customer_id) {
        this.customer_id = customer_id;

    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_telephone() {
        return customer_telephone;
    }

    public void setCustomer_telephone(String customer_telephone) {
        this.customer_telephone = customer_telephone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_telephone='" + customer_telephone + '\'' +
                '}';
    }
}
