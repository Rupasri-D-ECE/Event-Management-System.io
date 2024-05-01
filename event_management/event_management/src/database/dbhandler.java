//package database;
//import java.sql.Connection;
//public class dbhandler extends configs {
//	Connection dbconnection;
//	public  Connection getConnection(){
//		String connectionString="jdbc:mysql://"+configs.dbhost+":"+configs.dbport+"/"+configs.dbname;
//	try {
//		Class.forName("jdbc.mysql.Driver");
//	}catch(ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//	try {
//		dbconnection= DriverManager.getConnection(connectionString,configs.dbuser,configs.dbpass);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		return dbconnection;
//	}
//}
