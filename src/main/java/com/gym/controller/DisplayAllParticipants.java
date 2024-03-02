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
 * Servlet implementation class DisplayAllParticipants
 */
public class DisplayAllParticipants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllParticipants() {
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
		Db b = new Db();
		StringBuffer buffer = new StringBuffer();
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
		out.println("<h3>Participant Details</h3>");
		ArrayList<Participant> pd = b.displayAllParticipantDetails();
		if(pd.size()>0) {
			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<th>ID</th>");
			buffer.append("<th>NAME</th>");
			buffer.append("<th>DATE OF BIRTH</th>");
			buffer.append("<th>GENDER</th>");
			buffer.append("<th>BATCH NAME</th>");
			buffer.append("<th>PROFESSION</th>");
			buffer.append("<th>PHONE NUMBER</th>");
			buffer.append("<th>ADDRESS</th>");
			buffer.append("</tr>");
			for(Participant p: pd) {
				buffer.append("<tr>");
				buffer.append("<td>"+p.id+"</td>");
				buffer.append("<td>"+p.name+"</td>");
				buffer.append("<td>"+p.dob+"</td>");
				buffer.append("<td>"+p.gender+"</td>");
				buffer.append("<td>"+p.batchname+"</td>");
				buffer.append("<td>"+p.profession+"</td>");
				buffer.append("<td>"+p.phno+"</td>");
				buffer.append("<td>"+p.address+"</td>");
				buffer.append("</tr>");
			}
			buffer.append("</table>");
		}
		else {
			out.println("<h3>No Participants found</h3>");
		}
		
		out.println(buffer.toString());
		out.println("</html>");
		out.close();
	}

}
