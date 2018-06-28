package bean;



public class user {

	private String username;//’À∫≈
	private String password; //√‹¬Î
	private String nickname;//Í«≥∆
	private String identity; //…Ì∑›
	private String description;//”√ªß√Ë ˆ
	private String c_time;
		public user(){};
		public user(String username,String password,String nickname,String identity,String description,String c_time)
		{
			super();
			this.username=username;
			this.password=password;
			this.nickname=nickname;
			this.identity=identity;
			this.description=description;
			this.c_time=c_time;
		}
		    
			public String getUsername(){
				return username;
			}
			public void setUsername(String username) {
				this.username=username;
			}
			
			public String getPassword(){
				return password;
			}
			public void setPassword(String password) {
				this.password=password;
				
			}
			public String getNickname(){
				return nickname;
			}
			public void setNickname(String nickname) {
				this.nickname=nickname;
				
			}
			public String getIdentity(){
				return identity;
			}
			public void setIdentity(String identity) {
				this.identity=identity;
				
			}
			public String getDescription(){
				return description;
			}
			public void setDescription(String description) {
				this.description=description;
				
			}

			public String getC_time(){
				return c_time;
			}
			public void setC_time(String c_time){
				this.c_time=c_time;
				
			}
	
}
