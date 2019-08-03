package com.mapua.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseDAO {
	

		private Connection conn;
		private PreparedStatement ps;
		private Statement stmt;
		private ResultSet rs;

		public DatabaseDAO(Connection conn) {
			this.conn = conn;
		}

		
		public boolean validateAccess(AccessData credsData) {
			boolean result = false;
			
			String sql = "SELECT COUNT(*) COUNT FROM ACCESS_TABLE " +
				"WHERE USER_NAME='" + credsData.getUserID() +
				"' AND PASSWORD='" + credsData.getPassword() + "';";
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next() && rs.getInt("COUNT") > 0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DatabaseSource.closeStatement(stmt);
			}
			
			return result;
		}
}