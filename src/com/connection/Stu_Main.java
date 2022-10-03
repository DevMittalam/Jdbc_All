package com.connection;

import java.sql.SQLException;

public class Stu_Main {

	public static void main(String[] args) throws SQLException {
		 Jdbc j=new Jdbc();
		 //j.insert(new Student("1001","Ram","Delhi","IT"));
		 //j.insert(new Student("1002","ABC","Mds","IT"));
		 j.displaySorted();
	}

}
