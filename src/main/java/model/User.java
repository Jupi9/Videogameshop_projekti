package model;

public class User {
	
	private String username;
	private String name;
	private String password;
	private boolean enabled;
	private String rolename;
	
	
	
	public User(String username, String name, String password, boolean enabled, String rolename) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.rolename = rolename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
	
	
	
	

}
