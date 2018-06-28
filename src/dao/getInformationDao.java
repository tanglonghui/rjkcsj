package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.role;
import bean.user;
import connect.Connect;

public class getInformationDao {

	
	public role getInfo(String identity) throws SQLException{
		Connection conn=Connect.getConnection();
		
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    role ro = null;
		String sql="select * from role where identity=?";
		p=conn.prepareStatement(sql);
		p.setString(1,identity);
		rs=p.executeQuery();
		if(rs.next()){
			ro=new role();
			ro.setIdentity(rs.getString("identity"));
			ro.setRolename(rs.getString("rolename"));
			ro.setMs(rs.getString("ms"));
			ro.setLevel(rs.getString("level"));
		}
		return ro;
		}

}
