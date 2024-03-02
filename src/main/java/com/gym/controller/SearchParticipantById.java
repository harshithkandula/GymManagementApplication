package com.gym.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.gym.db.Db;
import com.gym.model.Participant;

/**
 * Servlet implementation class SearchParticipantById
 */
public class SearchParticipantById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchParticipantById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String participantid = request.getParameter("pid");
		int p_id = Integer.parseInt(participantid);
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("table{");
		out.println("border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		Db d = new Db();
		ArrayList<Participant> pdbi = d.displayParticipantById(p_id);
		StringBuffer b = new StringBuffer();
		if(pdbi.size()>0) {
			b.append("<table>");
			b.append("<tr>");
			b.append("<th>ID</th>");
			b.append("<th>NAME</th>");
			b.append("<th>Date Of Birth</th>");
			b.append("<th>GENDER</th>");
			b.append("<th>Batch Name</th>");
			b.append("<th>Profession</th>");
			b.append("<th>Phone Number</th>");
			b.append("<th>Address</th>");			
			b.append("</tr>");
			for(Participant p: pdbi) {
				b.append("<tr>");
				b.append("<td>"+p.id+"</td>");
				b.append("<td>"+p.name+"</td>");
				b.append("<td>"+p.dob+"</td>");
				b.append("<td>"+p.gender+"</td>");
				b.append("<td>"+p.batchname+"</td>");
				b.append("<td>"+p.profession+"</td>");
				b.append("<td>"+p.phno+"</td>");
				b.append("<td>"+p.address+"</td>");
				b.append("</tr>");
			}
			b.append("</table>");
		}
		out.println(b.toString());
		out.println("</html>");
		out.close();
	}

}
