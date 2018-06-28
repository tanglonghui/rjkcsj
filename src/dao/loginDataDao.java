package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.role;
import connect.Connect;

public class loginDataDao {
	

		public String loginDataDao(String username,String y_time,String l_time,String now,String ip) throws SQLException{
			Connection conn=Connect.getConnection();
			String sql="insert into info(username,y_time,l_time,now,ip)values(?,?,?,?,?)";
		
			
		    PreparedStatement p=null;
		    ResultSet rs=null;
		    p=conn.prepareStatement(sql);
		    p.setString(1, username);
		    p.setString(2, y_time);
		    p.setString(3, l_time);
		    p.setString(4, now);
		    p.setString(5, ip);
		    p.executeUpdate();
		    
			return null;
	    	
	    	
		}}



