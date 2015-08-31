
import java.io.IOException;
import java.math.BigDecimal;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); } catch
		 * (ClassNotFoundException e3) { // TODO Auto-generated catch block
		 * e3.printStackTrace(); } //URL of Oracle database server String url =
		 * "jdbc:oracle:thin:testuser/password@localhost";
		 * 
		 * 
		 * //properties for creating connection to Oracle database Properties
		 * props = new Properties(); props.setProperty("user", "testdb");
		 * props.setProperty("password", "password");
		 * 
		 * //creating connection to Oracle database using JDBC Connection conn =
		 * null; try { conn = DriverManager.getConnection(url,props); } catch
		 * (SQLException e2) { // TODO Auto-generated catch block
		 * e2.printStackTrace(); }
		 * 
		 * 
		 * 
		 * 
		 * //sql = "select * from students"; sql
		 * ="select * from students where  A_TYPE = 'Homework'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * PreparedStatement preStatement = null; try { preStatement =
		 * conn.prepareStatement(sql); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } try { result =
		 * preStatement.executeQuery(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * int counter = 0; try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * hwsum += result.getDouble("GRADE"); counter++; } } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		int counter = 0;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Student bull = new model.Student();
		model.Weight weight = new model.Weight();
		String q = "select s from Student s where s.aType = 'Homework'";
		TypedQuery<Student> bq = em.createQuery(q, Student.class);

		List<Student> list = bq.getResultList();

		for (Student temp : list) {
			hwsum += temp.getGrade().doubleValue();
			counter++;
		}
		hwaverage = hwsum / counter;
		System.out.println("hw-" + hwaverage);

		q = "select w from Weight w where w.asType = 'Homework'";
		TypedQuery<Weight> wq = em.createQuery(q, Weight.class);
		List<Weight> weight1 =  wq.getResultList();
		hw_weight =weight1.get(0).getWeight().doubleValue();
		hwaverage = hwaverage * (hw_weight/100);
		System.out.println("hw weight is -" + hw_weight);
		System.out.println("weighted hw-" + hwaverage);

		
		//quiz average
		q = "select s from Student s where s.aType = 'Quiz'";
		bq = em.createQuery(q, Student.class);
		list = bq.getResultList();
		counter = 0;
		for (Student temp : list) {
			qzsum += temp.getGrade().doubleValue();
			counter++;
		}

		qzaverage = qzsum / counter;
		System.out.println("quiz-" + qzaverage);

		q = "select w from Weight w where w.asType = 'Quiz'";
		wq = em.createQuery(q, Weight.class);
		weight1 =  wq.getResultList();
		qz_weight =weight1.get(0).getWeight().doubleValue();
		qzaverage = qzaverage * (qz_weight/100);
		
		//project average
		q = "select s from Student s where s.aType = 'Project'";
		bq = em.createQuery(q, Student.class);
		list = bq.getResultList();
		counter = 0;
		for (Student temp : list) {
			pjsum += temp.getGrade().doubleValue();
			counter++;
		}
		pjaverage = pjsum / counter;
		System.out.println("project-" + pjaverage);
		q = "select w from Weight w where w.asType = 'Project'";
		wq = em.createQuery(q, Weight.class);
		weight1 =  wq.getResultList();
		pj_weight =weight1.get(0).getWeight().doubleValue();
		pjaverage = pjaverage * (pj_weight/100);
		
		System.out.println("project-" + pjaverage);

		//test average
		q = "select s from Student s where s.aType = 'Test'";
		bq = em.createQuery(q, Student.class);

		list = bq.getResultList();
		counter = 0;
		for (Student temp : list) {
			ttsum += temp.getGrade().doubleValue();
			counter++;
		}

		ttaverage = ttsum / counter;
		
		q = "select w from Weight w where w.asType = 'Quiz'";
		wq = em.createQuery(q, Weight.class);
		weight1 =  wq.getResultList();
		tt_weight =weight1.get(0).getWeight().doubleValue();
		ttaverage = ttaverage * (tt_weight/100);
		System.out.println("test-" + ttaverage);
		
		
		//overall average
		average = hwaverage + qzaverage + pjaverage + ttaverage;
		System.out.println("weighted grade-" + average);
		message = "The average grade is: " + average;

		System.out.println(message);
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/output.jsp").forward(
				request, response);

		/*
		 * request.setAttribute("message", message);
		 * getServletContext().getRequestDispatcher
		 * ("/output.jsp").forward(request, response);
		 */
		// /finding the average of quizes

		/*
		 * sql ="select * from students where  A_TYPE = 'Quiz'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * counter = 0; try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * qzsum += result.getDouble("GRADE"); counter++; } } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * sql ="select * from students where  A_TYPE = 'Project'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * counter = 0; try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * pjsum += result.getDouble("GRADE"); counter++; } } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * sql ="select * from students where  A_TYPE = 'Test'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// counter = 0;
		/*
		 * try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * ttsum += result.getDouble("GRADE"); counter++; } } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * sql ="select * from weights where  AS_TYPE = 'Homework'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * hw_weight= (result.getDouble("WEIGHT")/100); } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * sql ="select * from weights where  AS_TYPE = 'Quiz'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * qz_weight= (result.getDouble("WEIGHT")/100); } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		/*
		 * sql ="select * from weights where  AS_TYPE = 'Project'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * pj_weight= (result.getDouble("WEIGHT")/100); } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		

		/*
		 * sql ="select * from weights where  AS_TYPE = 'Test'"; //creating
		 * PreparedStatement object to execute query
		 * 
		 * try { preStatement = conn.prepareStatement(sql); } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try { result = preStatement.executeQuery(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { while(result.next()){
		 * //System.out.println("Current Date from Oracle : " +
		 * result.getString("current_day")); //System.out.printf("%s %s, %s\n",
		 * tt_weight= (result.getDouble("WEIGHT")/100); } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
