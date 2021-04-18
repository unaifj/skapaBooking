package com.decode.main;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;

public class PrepareData {

	public static void main(String[] args) {
		DBManager dbm = new DBManager();
		try {
			dbm.preparedData();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
}
