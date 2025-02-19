import java.sql.*;
import java.util.List;

public class OrderDAO {


    public void createOrder(int customerId, List<OrderDetails> orderDetailsList) {
        Connection conn = Database.getConnection();

        try {

            conn.setAutoCommit(false);

            String insertOrderQuery = "insert into orders (customer_id) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, customerId);

            stmt.executeUpdate();


            ResultSet keySet = stmt.getGeneratedKeys();

            int orderId = 0;
            if (keySet.next()) {
                orderId = keySet.getInt(1);
            }

            String orderDetailQuery = "INSERT INTO order_details (order_id,product_id, quantity) VALUES (?,?,?)";

            for (OrderDetails od : orderDetailsList) {
                PreparedStatement detailStatement = conn.prepareStatement(orderDetailQuery);
                detailStatement.setInt(1, orderId);
                detailStatement.setInt(2, od.getProduct_id());
                detailStatement.setInt(3, od.getQuantity());
                detailStatement.executeUpdate();

            }
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

