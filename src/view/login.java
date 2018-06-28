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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import bean.info;
import bean.user;
import dao.h_timeDao;
import dao.loginDao;
import dao.loginDataDao;



 public class login extends JFrame{
	 public void login(){
		 Frame f=new Frame("欢迎来到用户权限管理系统");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
			TextField tf1=new TextField();
			//TextField tf2=new TextField();
			JPasswordField tf2=new JPasswordField(); //使密码变为*
			Label la=new Label("请登录");
			Label la1=new Label("账号:");
			Label la2=new Label("密码:");
			Button btn1=new Button("登录");
			Button btn2=new Button("注册");
			 la.setFont(new Font("",1,30));//设置字体大小
			 la.setForeground(Color.red);//设置字体颜色
			la.setBounds(150, 50, 200, 50);
			la1.setBounds(50, 100, 80, 30);
			la2.setBounds(50, 150, 80, 30);
			tf1.setBounds(100, 100, 200, 30);
			tf2.setBounds(100, 150, 200, 30);
			btn1.setBounds(100, 200, 100, 30);
			btn2.setBounds(200, 200, 100, 30);//初始坐标，以及宽跟高
			f.add(btn1);//将按钮加载到界面上
			f.add(btn2);
			f.add(tf1);
			f.add(tf2);
			f.add(la);
			f.add(la1);
			f.add(la2);
			//获得文本框里的文本
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String username=tf1.getText();//获得文本信息
					String password=tf2.getText();
					  //验证
					loginDao lg=new loginDao();
					try {
						user rs=lg.longin(username, password);
						if(rs!=null){
							f.setVisible(false);
							//登录成功，保存登录时间，登录ip，修改在线情况
							try {
								InetAddress localAddress=InetAddress.getLocalHost();
								String ip=localAddress.getHostAddress();//获得ip
								 Calendar ca = Calendar.getInstance();
									Date time=ca.getTime();//获得系统时间
								    
								    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								    String y_time = sdf.format(time);//获得年月日
								    
								    Date today=new Date();
								    SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
								    String l_time=f.format(today);
								    String now="在线";
								    loginDataDao a=new loginDataDao();
								    a.loginDataDao(username, y_time, l_time, now, ip);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							menu m=new menu();
							m.menu(rs);
					
						
						}else{
							JOptionPane.showMessageDialog(null,"账号或密码错误！！！");
							tf1.setText(null);//清空文本框
							tf2.setText(null);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往注册
					registered r=new registered();
					try {
						r.registered();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					f.setVisible(false);//login窗口设置为隐藏
					
					
				}
			});
			
				}
	 class MyWindowListener extends WindowAdapter//重写
		{
			public void windowClosing(WindowEvent e){
				
				Window window=(Window) e.getComponent();
				window.dispose();
				System.exit(0);
			}
			}
	}

	
	 

