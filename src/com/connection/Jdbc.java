package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
public class Jdbc {
	Connection con;
	 public Jdbc() throws SQLException
	 {
		 this.con=getConnection();
	 }
      public  Connection getConnection() throws SQLException {
    			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    			String url="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
    			String userName="system";
    			String password="system";
    			 con=DriverManager.getConnection(url,userName,password);
    		   	  return con;
      }
	  public void createTable() {
//		  String q="CREATE TABLE STUDENT(Stu_Id varchar(5) primary key,Stu_name varchar(20) not null,"
//		  		+ "address varchar(20) not null , branch varchar(10) not null)";
	  }
	  public void insert(Student s) throws SQLException {
          PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
          ps.setString(1,s.getId()); 
          ps.setString(2,s.getName());
          ps.setString(3,s.getAddress());
          ps.setString(4,s.getBranch());
          ps.executeUpdate();
          ps.close();
	  }
		public void displaySorted() throws SQLException {
			ArrayList<Student> list=new ArrayList<Student>();
			ResultSet set=con.createStatement().executeQuery("select * from student");
			while(set.next()) {
				list.add(new Student(set.getString(1),set.getString(2),set.getString(3),set.getString(4)));
			}
			set.close();
		  Collections.sort(list,(l1,l2)->l1.getName().compareTo(l2.getName()));
		 for(int i=0;i<list.size();i++)
		 {
			 System.out.println(list.get(i).toString());
		 }
		}

}
