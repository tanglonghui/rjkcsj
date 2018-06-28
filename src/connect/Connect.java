package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
final static String url="jdbc:mysql://localhost:3306/qx";
final static String username = "root";
final static String password = "1234";
 public static Connection getConnection(){
	 	Connection conn=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,username,password);
		
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return conn;
		 }
 
 public static void main(String[] args) {
		
		try
		{
		   Connection conn = Connect.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("数据库连接正常！");
		   }
		   else
		   {
			   System.out.println("数据库连接异常！");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
