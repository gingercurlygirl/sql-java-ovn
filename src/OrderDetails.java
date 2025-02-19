public class OrderDetails {
    int id;

    int order_id;

    int product_id;

    int quantity;

    public OrderDetails(int order_id, int product_id, int quantity, int id) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}
