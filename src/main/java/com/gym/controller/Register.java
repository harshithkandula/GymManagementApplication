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
import com.gym.model.Batch;
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
		String batchName = null;
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
				batchName = b;
			}
		}

		
		p.profession = request.getParameter("job");
		p.phno = request.getParameter("phno");
		p.address = request.getParameter("addr");
		
		
		
		int res = db.addParticipant(p);
		
		ArrayList<Batch> bd = db.fetchBatchDetails(batchName);
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		if(res > 0) {
			String htmlResponse = "Thank you "+p.name+" for joining "+p.batchname+" in our gym";
			out.println(htmlResponse);
			
			out.println("<h4>Batch Details</h4>");
			if(bd.size()>0) {
				for(Batch bat: bd) {
					out.println("<p>Batch ID: "+bat.batchId+"</p>");
					out.println("<p>Batch Name: "+bat.batchName+"</p>");
					out.println("<p>Timings: "+bat.timings+"</p>");
					out.println("<p>Strength: "+bat.strength+"</p>");
					out.println("<p>Start Date: "+bat.startdate+"</p>");
				}
			}
		}
		else {
			out.println("<h1>Participant not added. Please try Again</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
