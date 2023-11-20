import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    static Connection con;

    public static  Connection getCon() {

        try{
            String url ="jdbc:postgresql://localhost:5432/employeeDB";
            String username = "postgres";
            String password = "root";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
