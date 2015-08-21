

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
		double hwsum = 0;
		double qzsum = 0;
		double pjsum = 0;
		double ttsum = 0;
		double hwaverage = 0;
		double qzaverage = 0;
		double pjaverage = 0;
		double ttaverage = 0;
		double hw_weight = 0;
		double qz_weight = 0;
		double pj_weight = 0;
		double tt_weight = 0;
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

	  
		
	
		     //sql = "select * from students";
		     sql ="select * from students where  A_TYPE = 'Homework'";
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
					hwsum += result.getDouble("GRADE");
					counter++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hwaverage = hwsum/counter;
			
			System.out.println("hw-"+hwaverage);

		///finding the average of quizes
			
			 sql ="select * from students where  A_TYPE = 'Quiz'";
			    //creating PreparedStatement object to execute query
			
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
				
				counter = 0;
				try {
					while(result.next()){
					    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
						//System.out.printf("%s %s, %s\n",
						qzsum += result.getDouble("GRADE");
						counter++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				qzaverage = qzsum/counter;
			
				System.out.println("quiz-"+qzaverage);
				
			 sql ="select * from students where  A_TYPE = 'Project'";
			    //creating PreparedStatement object to execute query
			
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
				
				counter = 0;
				try {
					while(result.next()){
					    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
						//System.out.printf("%s %s, %s\n",
						pjsum += result.getDouble("GRADE");
						counter++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				pjaverage = pjsum/counter;
			
				System.out.println("project-"+pjaverage);
			
				
			 sql ="select * from students where  A_TYPE = 'Test'";
			    //creating PreparedStatement object to execute query
			
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
				
				counter = 0;
				try {
					while(result.next()){
					    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
						//System.out.printf("%s %s, %s\n",
						ttsum += result.getDouble("GRADE");
						counter++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ttaverage = ttsum/counter;		
				System.out.println("test-"+ttaverage);
			
			
			
				 sql ="select * from weights where  AS_TYPE = 'Homework'";
				    //creating PreparedStatement object to execute query
				
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
					
			
					try {
						while(result.next()){
						    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
							//System.out.printf("%s %s, %s\n",
							hw_weight= (result.getDouble("WEIGHT")/100);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					hwaverage = hwaverage*hw_weight;
					System.out.println("hw weight is -"+hw_weight);
					System.out.println("weighted hw-"+hwaverage);
			
			
					sql ="select * from weights where  AS_TYPE = 'Quiz'";
				    //creating PreparedStatement object to execute query
				
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
					
			
					try {
						while(result.next()){
						    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
							//System.out.printf("%s %s, %s\n",
							qz_weight= (result.getDouble("WEIGHT")/100);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					qzaverage = qzaverage*qz_weight;
					System.out.println("weighted quiz-"+qzaverage);
			
			
					sql ="select * from weights where  AS_TYPE = 'Project'";
				    //creating PreparedStatement object to execute query
				
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
					
			
					try {
						while(result.next()){
						    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
							//System.out.printf("%s %s, %s\n",
							pj_weight= (result.getDouble("WEIGHT")/100);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					pjaverage = pjaverage*pj_weight;
					System.out.println("weighted project-"+pjaverage);
			
		
					sql ="select * from weights where  AS_TYPE = 'Test'";
				    //creating PreparedStatement object to execute query
				
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
					
			
					try {
						while(result.next()){
						    //System.out.println("Current Date from Oracle : " +         result.getString("current_day"));
							//System.out.printf("%s %s, %s\n",
							tt_weight= (result.getDouble("WEIGHT")/100);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ttaverage = ttaverage*tt_weight;
					System.out.println("weighted test-"+ttaverage);
			
			
			
			
			
			average = hwaverage+qzaverage+pjaverage+ttaverage;
			System.out.println("weighted grade-"+average);
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
