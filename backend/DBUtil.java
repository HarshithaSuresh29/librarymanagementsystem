import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection() {
        try {
            // Railway automatically provides these
            String host = System.getenv("mysql.railway.internal");        // mysql.railway.internal
            String port = System.getenv("3306");        // 3306
            String db   = System.getenv("railway");    // railway
            String user = System.getenv("root");        // root
            String pass = System.getenv("root");    // your password (from Railway)

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
