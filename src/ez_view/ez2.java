package ez_view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;
import view.menu;


public class ez2 {
	private String name;
	public void ez2(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("财务管理");
			String a=rs.getIdentity();
			 role ro=new role();
			 getInformationDao g=new getInformationDao();
			 ro=g.getInfo(a);//拉取登录的角色信息
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//
			Button btn1=new Button("查询财务记录");
			Button btn2=new Button("统计财务记录");
			Button btn3=new Button("修改财务记录");
			Button btn4=new Button("返回");
			
			
			btn1.setBounds(150, 30, 100, 30);
			btn2.setBounds(150, 70, 100, 30);//初始坐标，以及宽跟高
			btn3.setBounds(150, 110, 100, 30);
			btn4.setBounds(150, 150, 100, 30);
		
			f.add(btn1);//将按钮加载到界面上
			String lev=ro.getLevel();
			//char 换为Stirng
			String s1=String.valueOf(lev.charAt(0));
			if(s1.equals("2")){
				f.add(btn2);
				f.add(btn3);
				
			}
			f.add(btn4);
		
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					JOptionPane.showMessageDialog(null,"查询成功");
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					JOptionPane.showMessageDialog(null,"统计成功");
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					
					JOptionPane.showMessageDialog(null,"修改成功");
					
				}
			});
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					menu m=new menu();
					try {
						m.menu(rs);
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



