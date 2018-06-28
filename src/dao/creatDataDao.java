package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.Connect;

public class creatDataDao {
	public String createDataDao(String username,String c_time) throws SQLException{
		Connection conn=Connect.getConnection();
		String sql="insert into info(username,c_time)values(?,?)";
	
		
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    p=conn.prepareStatement(sql);
	    p.setString(1, username);
	    p.setString(2, c_time);
	   
	    p.executeUpdate();
	    
		return null;
    	
    	
	}
}
