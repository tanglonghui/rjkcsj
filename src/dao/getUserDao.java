package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.role;
import bean.user;
import connect.Connect;

public class getUserDao {

	
	public user getuser(String username) throws SQLException{
		Connection conn=Connect.getConnection();
		
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    user gg = null;
		String sql="select * from user where username=?";
		p=conn.prepareStatement(sql);
		p.setString(1,username);
		rs=p.executeQuery();
		if(rs.next()){
			gg=new user();
			gg.setUsername(rs.getString("username"));
			gg.setPassword(rs.getString("password"));
			gg.setIdentity(rs.getString("identity"));
			gg.setDescription(rs.getString("description"));
			gg.setNickname(rs.getString("nickname"));
			gg.setC_time(rs.getString("c_time"));
			
		}
		return gg;
		}

}
