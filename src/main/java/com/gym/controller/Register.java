package com.gym.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gym.db.Db;
import com.gym.model.Participant;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement ps;
		
		ServletConfig config = getServletConfig();
		String uname = config.getInitParameter("username");
		String pwd = config.getInitParameter("password");
		String url = config.getInitParameter("driverlink");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Db db = new Db();
		Participant p = new Participant();
		
		p.name = request.getParameter("pname");
		p.dob = request.getParameter("dob");
		p.gender = request.getParameter("gender");
		String bid = request.getParameter("bname");
		ArrayList<String> batchnm = db.getBatchName(bid);
		if(batchnm.size()>0) {
			for(String b: batchnm) {
				p.batchname = b;
			}
		}

		//p.batchname = request.getParameter("bname");
		
		/*String batch_name = request.getParameter("bname");
		if(batch_name == "morning") {
			String sql = "select name from batch where where id ='ZBM'";
		    try {
				connection = DriverManager.getConnection(url, uname, pwd);
				ps = connection.prepareStatement(sql);
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					p.batchname = res.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		p.profession = request.getParameter("job");
		p.phno = request.getParameter("phno");
		p.address = request.getParameter("addr");
		
		
		
		int res = db.addParticipant(p);
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		if(res > 0) {
			String htmlResponse = "Thank you "+p.name+" for joining "+p.batchname+" in our gym";
			out.println(htmlResponse);
		}
		else {
			out.println("<h1>Participant not added. Please try Again</h1>");
		}
		
		out.println("</html");
		out.close();
	}

}
