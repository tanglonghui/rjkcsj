package bean;

public class info {
	/*
	“查询用户登录情况”可查询某用户的所有登录情况：
	用户名、用户创建时间、登录时间、登录时长、当前状态（在线、下线）、ＩＰ地址。*/
	private String username;//用户名，账号
	private String y_time;//保存年日月
	
	private String l_time;//登录时间时分秒
	private String h_time; //登录时长
	private String now;//当前状态
	private String ip;//ip
	
		public info(){};
		public info(String username,String y_time,String l_time,String h_time,String now,String ip)
		{
			super();
			this.username=username;
			this.y_time=y_time;
			
			this.l_time=l_time;
			this.h_time=h_time;
			this.now=now;
			this.ip=ip;
		}
		    
			public String getUsername(){
				return username;
			}
			public void setUsername(String username) {
				this.username=username;
			}
			public String getY_time(){
				return y_time;
			}
			public void setY_time(String y_time){
				this.y_time=y_time;
				
			}
			
			
			public String getL_time(){
				return l_time;
			}
			public void setL_time(String l_time) {
				this.l_time=l_time;
				
			}
			public String getH_time(){
				return h_time;
			}
			public void setH_time(String h_time) {
				this.h_time=h_time;
				
			}
			public String getNow(){
				return now;
			}
			public void setNow(String now) {
				this.now=now;
				
			}
			public String getIp(){
				return ip;
			}
			public void setIp(String ip) {
				this.ip=ip;
				
			}

	

}
