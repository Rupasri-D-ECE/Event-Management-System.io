


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


public class venuecontroller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	public  TextField vname;
	public TextField cap;
	public TextField loc;
	public TextField avai;
	
	

	public static String DATABASE_URL;
	    public static String DATABASE_USERNAME;
	    public static String DATABASE_PASSWORD ;
	    public static String SELECT_QUERY;
    
	public void submit(ActionEvent event) throws IOException, ClassNotFoundException {

		
		    String fn = vname.getText();
	        String ln = cap.getText();
	        String pn = loc.getText();
	        String em = avai.getText();
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/event_management", "root", "sanjeevi");
	      PreparedStatement preparedStatement = connection.prepareStatement("insert into venue (Venue_Name,Capacity,Location,Availability) values(?,?,?,?)")) {
	        	
	            preparedStatement.setString(1, fn);
	            preparedStatement.setString(2, ln);
	            preparedStatement.setString(3, pn);
	            preparedStatement.setString(4, em);

	            System.out.println("it runs");
	            // Empty field validation
	            if (fn.isEmpty() || ln.isEmpty() || pn.isEmpty() || em.isEmpty()) {
	                // Display an alert or perform some action to notify the user about the empty fields
	                System.out.println("Please fill in all fields.");
	                root = FXMLLoader.load(getClass().getResource("Error5.fxml"));
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
	        root = FXMLLoader.load(getClass().getResource("EventManager.fxml"));
	   		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	   		scene=new Scene(root);
	   		stage.setScene(scene);
	   		stage.show();
	}
	    public void previous(ActionEvent event) throws IOException {
	        	
	   		 root = FXMLLoader.load(getClass().getResource("Sponsors_Details.fxml"));
	   		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	   		scene=new Scene(root);
	   		stage.setScene(scene);
	   		stage.show();
	   		
	   	}
	  

	

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
}


