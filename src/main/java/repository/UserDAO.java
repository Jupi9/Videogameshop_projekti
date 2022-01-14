package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import model.User;

public class UserDAO {
	
	private DataSource ds;
	
	public UserDAO(DataSource ds) throws SQLException {
		this.ds = ds;
	}
	
	public User getUser(String username) throws SQLException{
		User user = null;
		String sql = "SELECT username, name, password, enabled, rolename FROM user WHERE username=?";
		try (Connection conn = ds.getConnection()){
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.setString(1, username);
                try(ResultSet rs = pstm.executeQuery()){
                    if (rs.next()) {
                        user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
                        		rs.getString(5));
                    }
                }
            }
        }
        return user;
    }
	
	public void insertUser(User user) throws SQLException{
		String sql = "INSERT INTO user(username, name, password, enabled, rolename) "
		        +"VALUES(?,?,?,?,?)";
		 try (Connection conn = ds.getConnection()){
	            try(PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
	                pstm.setString(1,  user.getUsername());
	                pstm.setString(2, user.getName());
	                pstm.setString(3, user.getPassword());
	                pstm.setBoolean(4, user.getEnabled());
	                pstm.setString(5, user.getRolename());
	                pstm.executeUpdate();				
	                					
	            }
	        }
	      
	}
	
}
	


