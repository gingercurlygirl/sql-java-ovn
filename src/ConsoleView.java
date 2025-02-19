import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private CustomerDAO customerDAO = new CustomerDAO();

    private OrderDAO orderDAO = new OrderDAO();

    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){

        while(true){
            System.out.println("---Menu---");
            System.out.println("1. Add Customer");
            System.out.println("2. view Customers");
            System.out.println("0. Exit");

            String choice = scanner.next();

            switch(choice){
                case "1": addCustomer();
                    break;
                case "2": getAllCustomers();
                    break;
                case "3": createOrder();
                    break;
                case "0":
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createOrder() {
        System.out.println("Enter total products:");
        int quantity = scanner.nextInt();

        List<OrderDetails> odList = new ArrayList<OrderDetails>();
        for(int i = 0; i < quantity; i++){
            System.out.println("Enter product ID:");
            int productID = scanner.nextInt();
            System.out.println("Enter quantity:");
            int quantity1 = scanner.nextInt();

            OrderDetails od = new OrderDetails(0,0,productID,quantity1);
            odList.add(od);
        }

        System.out.println("Enter your customer number:");
        int customerNumber = scanner.nextInt();

        orderDAO.createOrder(customerNumber, odList);

    }

    private void getAllCustomers() {

        List<Customer> allCustomers = customerDAO.getAllCustomers();
        System.out.println("customers: ");
        allCustomers.forEach(s-> System.out.println(s));
    }

    public void addCustomer(){
       System.out.println("Enter name: ");
       String name = scanner.next();
       System.out.println("Enter email: ");
       String email = scanner.next();

       customerDAO.addCustomer(name, email);
   }
}
