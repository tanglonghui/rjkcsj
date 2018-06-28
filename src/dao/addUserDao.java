package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.user;
import connect.Connect;

public class addUserDao {

	public user addUserDao(user pu) throws SQLException{
		Connection conn=Connect.getConnection();
		String sql="insert into user(username,password,nickname,identity,description,c_time)values(?,?,?,?,?,?)";
		String sql1="select *from user where username=? ";
	    PreparedStatement p=null;
	    ResultSet rs=null;
	    p=conn.prepareStatement(sql1);
	    p.setString(1, pu.getUsername());
	    rs=p.executeQuery();
	    if(rs.next()){
	    	pu=null;
	    	return pu;
	    }else{
	    	
	    	p=conn.prepareStatement(sql);
			p.setString(1, pu.getUsername());
			p.setString(2, pu.getPassword());
			p.setString(3, pu.getNickname());
			p.setString(4, pu.getIdentity());
			p.setString(5, pu.getDescription());
			p.setString(6, pu.getC_time());
			p.executeUpdate();//获得数据集
			return pu;
	    }
		
    	
    	
}

}
