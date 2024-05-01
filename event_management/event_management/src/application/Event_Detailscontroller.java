package application;
import java.io.IOException;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.scene.input.*;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Event_Detailscontroller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	public  TextField eventname;
	public TextField eventdescription;
	public TextField eventdate;
	public TextField eventtime;
	

	public static String DATABASE_URL;
	    public static String DATABASE_USERNAME;
	    public static String DATABASE_PASSWORD ;
	    public static String SELECT_QUERY;
    
	public void next(MouseEvent event) throws IOException, ClassNotFoundException {

		
		    String en = eventname.getText();
	        String ed = eventdescription.getText();
	        String edt = eventdate.getText();
	        String et = eventtime.getText();
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/event_management", "root", "sanjeevi");
	             	             PreparedStatement preparedStatement = connection.prepareStatement("insert into event (Event_Name,Description,Date,Time) values(?,?,?,?)")) {

	            preparedStatement.setString(1, en);
	            preparedStatement.setString(2, ed);
	            preparedStatement.setString(3, edt);
	            preparedStatement.setString(4, et);

	            System.out.println("it runs");
	            // Empty field validation
	            if (en.isEmpty() || ed.isEmpty() || edt.isEmpty() || et.isEmpty()) {
	                // Display an alert or perform some action to notify the user about the empty fields
	                System.out.println("Please fill in all fields.");
	                root = FXMLLoader.load(getClass().getResource("Error1.fxml"));
	        		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	        		scene=new Scene(root);
	        		stage.setScene(scene);
	        		stage.show();
	                return; // Exit the method without proceeding further
	            }

	            preparedStatement.executeUpdate();
	    

	        } catch (SQLException e) {
	            // print SQL exception information
	        	System.out.println("failed");
	            printSQLException(e);
	        } 
		root = FXMLLoader.load(getClass().getResource("Organizer_Details.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
}
