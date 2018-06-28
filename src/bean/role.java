package bean;

public class role {
	private String identity; //角色
	private String rolename;//角色昵称
	private String ms;//角色描述
	private String level; //权限
	

	public role(){};
	public role(String identity,String rolename,String ms,String level)
	{
		super();
		this.identity=identity;
		this.rolename=rolename;
		this.ms=ms;
		this.level=level;
		
	}
		public String getIdentity(){
			return identity;
		}
		public void setIdentity(String identity) {
			this.identity=identity;
			
		}
		    
		public String getRolename(){
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename=rolename;
		}
		
		public String getMs(){
			return ms;
		}
		public void setMs(String ms) {
			this.ms=ms;
			
		}
		public String getLevel(){
			return level;
		}
		public void setLevel(String level) {
			this.level=level;
			
		}
		
}
