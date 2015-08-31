

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.Weight;
import customTools.DBUtil;

/**
 * Servlet implementation class averagestd
 */
@WebServlet("/averagestd")
public class averagestd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public averagestd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("st_avg_id");
		
		int counter = 0;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Student bull = new model.Student();
		model.Weight weight = new model.Weight();
		String q = "select s from Student s where s.aType = '"+type+"'";
		TypedQuery<Student> bq = em.createQuery(q, Student.class);

		List<Student> list = bq.getResultList();

		double hwsum = 0;
		for (Student temp : list) {
			hwsum += temp.getGrade().doubleValue();
			counter++;
		}
		double hwaverage = hwsum / counter;
		System.out.println("hw-" + hwaverage);

		q = "select w from Weight w where w.asType = '"+type+"'";
		TypedQuery<Weight> wq = em.createQuery(q, Weight.class);
		List<Weight> weight1 =  wq.getResultList();
		double hw_weight = weight1.get(0).getWeight().doubleValue();
		hwaverage = hwaverage * (hw_weight/100);
		System.out.println("hw weight is -" + hw_weight);
		System.out.println("weighted hw-" + hwaverage);

		
/*		String sql = "";
		String message = "";
		ResultSet result = null;
		int sum = 0;
		double average = 0;
		//System.out.println(as_type);
		
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

	  
		
		sql ="select * from students where  a_type ='"+type+"'";
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
					sum += result.getDouble("GRADE");
					counter++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			average = (sum/counter); 
			message = "The average grade for "+type+"(s) is: "+average;*/
		String message = "The average grade for "+type+"(s) is: "+hwaverage;
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
		doGet(request, response);}
	

}


