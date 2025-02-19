import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String url = "jdbc:mysql://localhost:3306/shop_db";

    private static final String user = "root";

    private static final String password = "password";

    public static Connection getConnection()  {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
}
