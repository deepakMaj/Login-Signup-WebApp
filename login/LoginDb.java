package org.deepak.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

public class LoginDb {
	
	private DataSource datasource;
	
	public LoginDb(DataSource dataSource) {
		datasource = dataSource;
	}
	
	public boolean getStudent(String username, String password) throws Exception{
		HashMap<String,String> hashmap = new HashMap<String,String>();
		Connection mycon = null;
		Statement sts = null;
		ResultSet rs = null;
		try {
			mycon = datasource.getConnection();
			String query = "select * from logindata";
			sts = mycon.createStatement();
			rs = sts.executeQuery(query);
			while(rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");
				hashmap.put(user, pass);
			}
			if(hashmap.containsKey(username) && hashmap.containsValue(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		finally {
			close(mycon, sts, rs);
		}
	}

	private void close(Connection mycon, Statement sts, ResultSet rs) throws SQLException {
		if(mycon != null)
			mycon.close();
		if(sts != null)
			sts.close();
		if(rs != null)
			rs.close();
	}
	
	public void setStudent(String username, String password , String email) throws Exception{
		Connection mycon = null;
		PreparedStatement sts = null;
		try {
			mycon = datasource.getConnection();
			String query = "insert into logindata (username, password, email)"+" values (?, ?, ?)";
			sts = mycon.prepareStatement(query);
			sts.setString(1, username);
			sts.setString(2, password);
			sts.setString(3, email);
			sts.execute();
		}
		finally {
			close(mycon, sts, null);
		}
}

	public boolean check(String username) throws SQLException {
		ArrayList<String> arr = new ArrayList<String>();
		Connection mycon = null;
		Statement sts = null;
		ResultSet rs = null;
		try {
			mycon = datasource.getConnection();
			sts = mycon.createStatement();
			String query = "select * from logindata";
			rs = sts.executeQuery(query);
			while(rs.next()) {
				arr.add(rs.getString("username"));
			}
			if(arr.contains(username)) {
				return true;
			}
			else {
				return false;
			}
			}
		finally {
			close(mycon,sts,rs);
		}
	}

	public void update(String pass1, String username) throws SQLException {
		Connection mycon = null;
		PreparedStatement sts = null;
		try {
			mycon = datasource.getConnection();
			String query = "update logindata set password = ? where username = ? ";
			sts = mycon.prepareStatement(query);
			sts.setString(1, pass1);
			sts.setString(2, username);
			sts.executeUpdate();
		}
		finally {
			close(mycon,sts,null);
		}
	}
	
}
