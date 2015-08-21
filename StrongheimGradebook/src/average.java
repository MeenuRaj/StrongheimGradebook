

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class average
 */
@WebServlet("/average")
public class average extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public average() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql = "";
		double sum = 0;
		double average = 0;
		String message = "";
		
		ResultSet result = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    //URL of Oracle database server
	    String url = "jdbc:oracle:thin:testuser/password@localhost"; 

	    
	    //properties for creating connection to Oracle database
	    Properties props = new Properties();
	    props.setProperty("user", "testdb");
	    props.setProperty("password", "password");
	  
	    //creating connection to Oracle database using JDBC
	    Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,props);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	  
		
	
		     sql = "select * from students";
		    //creating PreparedStatement object to execute query
		
		    PreparedStatement preStatement = null;
			try {
				preStatement = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				result = preStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			
			int counter = 0;
			try {
				while(result.next()){
				    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
					//System.out.printf("%s %s, %s\n",
					sum += result.getDouble("GRADE");
					counter++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			average = (sum/counter); 
			message = "The average grade is: "+average;
			

	    System.out.println(message);
	      request.setAttribute("message", message);
	      getServletContext()
	      .getRequestDispatcher("/output.jsp")
	      .forward(request,  response);
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
