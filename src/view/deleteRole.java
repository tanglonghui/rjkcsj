package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import bean.user;
import connect.Connect;
import dao.addUserDao;
import dao.deleteRoleDao;
import dao.deleteUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class deleteRole {
	private String name;
	public void deleteRole(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("删除一个角色");
		 	JComboBox a;
			JPanel b=new JPanel();
			a =new JComboBox();
			//拉取数据
		    Connection conn=Connect.getConnection();
		 	String sql1="select * from role where identity is not null ";
		    PreparedStatement p=null;
		    ResultSet rs1=null;
		    p=conn.prepareStatement(sql1);
		    rs1=p.executeQuery();
		    while(rs1.next())
		    {
		    	a.addItem(""+rs1.getString("identity"));
		    }
		    
		    
			
			
			
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//增加一个用户、删除一个用户、修改用户信息、查询用户登录情况、更新个人情况。
			
			Label la1=new Label("请选择你想要删除的角色");
			
			Button btn6=new Button("确定");
			Button btn7=new Button("返回");
			
			
			
			la1.setBounds(100, 110, 200, 30);//初始坐标，以及宽跟高
			a.setBounds(100, 150, 200, 30);
			
			
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
		
			
			f.add(btn6);
			f.add(btn7);
			f.add(la1);
			f.add(a);
			
		
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					//本窗口设置为隐藏
					deleteRoleDao de=new deleteRoleDao();
					String it=(String) a.getSelectedItem();
					try {
						de.deleteRoleDao(it);
						JOptionPane.showMessageDialog(null,"你选择的角色已经删除");
						f.setVisible(false);
						role_m_menu m=new role_m_menu();
						m.role_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					role_m_menu m=new role_m_menu();
					m.role_m_menu(rs);;
					
					
				}
			});
			

}
	 class MyWindowListener extends WindowAdapter//重写
		{
			public void windowClosing(WindowEvent e){
				h_timeDao a=new h_timeDao();
			    try {
					a.h_time(name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Window window=(Window) e.getComponent();
				window.dispose();
				System.exit(0);
			}
			}
	
	 }

