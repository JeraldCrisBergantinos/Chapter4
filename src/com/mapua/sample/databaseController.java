package com.mapua.sample;

import java.sql.Connection;

public class databaseController {
	public boolean getAccess(Connection conn,AccessData credsData) {
		boolean result = false;
		DatabaseDAO dao = new DatabaseDAO(conn);
		result = dao.validateAccess(credsData);
		return result;
	}	
}