package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.user;
import connect.Connect;

public class deleteRoleDao {

	public int deleteRoleDao(String choose) throws SQLException{
		Connection conn=Connect.getConnection();
		String sql="delete  from role where identity=?";
		PreparedStatement p=null;
	    ResultSet rs=null;
	    p=conn.prepareStatement(sql);
	    p.setString(1, choose);
	    p.executeUpdate();
		return 0;
	   
		
    	
    	
}

}
