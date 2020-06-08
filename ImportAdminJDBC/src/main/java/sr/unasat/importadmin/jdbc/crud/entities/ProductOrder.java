package sr.unasat.importadmin.jdbc.crud.entities;


import java.time.LocalDateTime;

public class ProductOrder {
    private int product_order_id;
    private String product_order_date;
    private int FK_product_id;
    private int FK_customer_id;

    //select
    public ProductOrder(int product_order_id, String product_order_date, int FK_product_id, int FK_customer_id) {
        this.product_order_id = product_order_id;
        this.product_order_date = product_order_date;
        this.FK_product_id = FK_product_id;
        this.FK_customer_id = FK_customer_id;
    }

    //insert
    public ProductOrder(/*int product_order_id,*/ String product_order_date, int FK_product_id, int FK_customer_id) {
/*
        this.product_order_id = product_order_id;
*/
        this.product_order_date = product_order_date;
        this.FK_product_id = FK_product_id;
        this.FK_customer_id = FK_customer_id;
    }

    //update
    public ProductOrder(String product_order_date, int FK_product_id, int FK_customer_id, int product_order_id) {
        this.product_order_id = product_order_id;
        this.product_order_date = product_order_date;
        this.FK_product_id = FK_product_id;
        this.FK_customer_id = FK_customer_id;
    }

    //delete
    public ProductOrder(int product_order_id) {
        this.product_order_id = product_order_id;

    }

    public int getProduct_order_id() {
        return product_order_id;
    }

    public void setProduct_order_id(int product_order_id) {
        this.product_order_id = product_order_id;
    }

    public String getProduct_order_date() {
        return product_order_date;
    }

    public void setProduct_order_date(String product_order_date) {
        this.product_order_date = product_order_date;
    }

    public int getFK_product_id() {
        return FK_product_id;
    }

    public void setFK_product_id(int FK_product_id) {
        this.FK_product_id = FK_product_id;
    }

    public int getFK_customer_id() {
        return FK_customer_id;
    }

    public void setFK_customer_id(int FK_customer_id) {
        this.FK_customer_id = FK_customer_id;
    }
}
