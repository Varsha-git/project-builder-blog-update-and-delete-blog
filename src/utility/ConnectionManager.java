package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class  ConnectionManager {

	 public static Properties loadPropertiesFile() throws Exception {Properties prop = new Properties();
	 InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	 prop.load(in);
	 in.close();
	 return prop; 
	 }
	 
	 public static Connection getConnection() throws Exception {
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//String userName = "system";
		//String password = "oracle";
		Connection con = null;
			Properties pro = loadPropertiesFile();
			final String driver=pro.getProperty("driver");
			final String url = pro.getProperty("url");
			final String  userName = pro.getProperty("username");
			final String  password = pro.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if(con!=null)
				System.out.println("Established");
				return con;
	}
}