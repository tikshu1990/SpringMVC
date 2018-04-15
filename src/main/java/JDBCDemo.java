import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        System.out.println("Loaded the driver ...");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "localuser",
            "passw0rd");
        System.out.println("Connected with DB ... ...");
        Statement stmt = con.createStatement();
        ResultSet results = stmt.executeQuery("select * from public.emp;");
        System.out.println("Executed the statement ...." + results.getMetaData().getColumnCount());
        while (results.next()) {
            System.out.print("RetrieveDemo.main()");
            System.out.print(" | ");
            System.out.print(results.getInt("e_id"));
            System.out.print(" | ");
            System.out.print(results.getString("first_name"));
            System.out.print(" | ");
            System.out.print(results.getString("last_name"));
            System.out.print(" | ");
            System.out.print(results.getString("email"));
            System.out.println("\n");
        }
    }
}
