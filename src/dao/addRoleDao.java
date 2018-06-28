package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.role;
import bean.user;
import connect.Connect;

public class addRoleDao {

	public role addRoleDao(role pu) throws SQLException{
		Connection conn=Connect.getConnection();
		String sql="insert into role(identity,rolename,ms,level)values(?,?,?,?)";
	
		String sql1="select *from role where identity=? ";
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    p=conn.prepareStatement(sql1);
	    p.setString(1, pu.getIdentity());
	    rs=p.executeQuery();
	    if(rs.next()){
	    	pu=null;
	    	return pu;
	    }else{
	    	
	    	p=conn.prepareStatement(sql);
			p.setString(1, pu.getIdentity());
			p.setString(2, pu.getRolename());
			p.setString(3, pu.getMs());
			p.setString(4, pu.getLevel());
			p.executeUpdate();
			return pu;
	    }
		
    	
    	
}

}
