import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer (String name, String email) {
        String sql = "insert into customers(name, email) values(?,?)";

        try{
            Connection conn = Database.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);

            ps.executeUpdate();
            System.out.println("Customer added successfully");

        }catch(SQLException e){
            System.out.println("failed to add customer");
            e.printStackTrace();
        }
    }


    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();

        String sql = "select * from customers";

        try{
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                customers.add(new Customer(rs.getInt("id"), rs.getString("email"), rs.getString("name")));
            }

        }catch (SQLException e){
            System.out.println("failed to get all customers");
            e.printStackTrace();

        }

        return customers;

    }

    public void updateCustomer() {

        try{
            Connection conn = Database.getConnection();
            conn.setAutoCommit(false);


        }catch (SQLException e){

        }
    }

}
