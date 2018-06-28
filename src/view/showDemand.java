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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import bean.info;
import bean.role;
import bean.user;
import connect.Connect;
import dao.getInformationDao;
import dao.getUserDao;
import dao.h_timeDao;
import ez_view.ez1;
import ez_view.ez2;
import ez_view.ez3;
import ez_view.ez4;

public class showDemand {
	private String name;
	
	 public void showDemand(String username ,String name,String c_time,String l_time) throws SQLException{
		
		 Frame f=new Frame("查询结果");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//用户管理、角色管理、人事管理、财务管理、销售管理、技术管理
		 this.name=name;
		 Connection conn=Connect.getConnection();
			
		    PreparedStatement p=null;
		    ResultSet rs=null;
		    info gg = null;
			String sql="select * from info where username=? and l_time=?";
			p=conn.prepareStatement(sql);
			p.setString(1,username);
			p.setString(2,l_time);
			rs=p.executeQuery();
			String[] L=new String[100];
			String[] H=new String[100];
			String[] I=new String[100];
			
			while(rs.next()){
				gg=new info();
				//gg.setUsername(rs.getString("username"));
				//gg.setY_time(rs.getString("y_time"));
				gg.setL_time(rs.getString("l_time"));
				gg.setH_time(rs.getString("h_time"));
				gg.setIp(rs.getString("ip"));
				int i1=0;
				L[i1]=gg.getL_time();
				H[i1]=gg.getH_time();
				I[i1]=gg.getIp();
				i1++;
			
			}
			String sql1="select * from info where username=? and now=?";
			p=conn.prepareStatement(sql1);
			p.setString(1,username);
			p.setString(2,"在线");
			rs=p.executeQuery();
			String now;
			if(rs.next()){
				now="在线";
			}else{
				now="离线";
			}
		    
		    Label la3=new Label();
			Label la4=new Label();
			Label la5=new Label();
		    la3.setText("登录时间:"+L[0]);
			la4.setText("注销时间:"+H[0]);
			la5.setText("登录ip :  "+I[0]);
			la3.setBounds(20, 130, 200, 30);
			la4.setBounds(20, 160, 200, 30);
			la5.setBounds(20, 190, 200, 30);
			f.add(la3);
			f.add(la4);
			f.add(la5);
			Label la=new Label();
			Label la1=new Label();
			Label la2=new Label();
			la.setText("账号:  "+username);
			la1.setText("当前状态:  "+now);
			la2.setText("创建时间:  "+c_time);
			Button btn7=new Button("返回");
			
			
			la.setBounds(20, 30, 100, 30);
			la1.setBounds(20, 60, 200, 30);
			la2.setBounds(20, 90, 200, 30);
			btn7.setBounds(250, 30, 100, 30);
			
		
			f.add(la);
			f.add(la1);
			f.add(la2);
			f.add(btn7);
			
			//下面的按钮进行权限控制
		
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					demandUser aa=new demandUser();
					getUserDao aaa=new getUserDao();
					user rs;
					try {
						rs = aaa.getuser(name);
						aa.demandUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
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
