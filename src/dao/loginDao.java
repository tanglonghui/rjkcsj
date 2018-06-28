package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.role;
import bean.user;
import connect.Connect;




public class loginDao {

	
	public user longin(String username,String password) throws SQLException{
		Connection conn=Connect.getConnection();
		String sql="select * from user where username=? and password=?";
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    user pu = null;
	    p=conn.prepareStatement(sql);
		p.setString(1, username);
		p.setString(2, password);
		rs=p.executeQuery();//获得数据集
		if(rs.next())
		{
			pu=new user();
			pu.setUsername(rs.getString("username"));
			pu.setPassword(rs.getString("password"));
			pu.setNickname(rs.getString("nickname"));
			pu.setIdentity(rs.getString("identity"));
			pu.setDescription(rs.getString("description"));
			
			
		}
		
		
    	return pu;
    	
}
}
