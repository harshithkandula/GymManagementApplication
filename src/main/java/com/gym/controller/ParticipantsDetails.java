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
 * Servlet implementation class ParticipantsDetails
 */
public class ParticipantsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantsDetails() {
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
		String pcntid = request.getParameter("id");
		int pid = Integer.parseInt(pcntid);
		Db d = new Db();
		ArrayList<Participant> pd = d.displayParticipantById(pid);
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		StringBuffer br = new StringBuffer();
		if(pd.size()>0) {
			br.append("<table>");
			br.append("<tr>");
			br.append("<th>ID</th>");
			br.append("<th>NAME</th>");
			br.append("<th>Date Of Birth</th>");
			br.append("<th>GENDER</th>");
			br.append("<th>Batch Name</th>");
			br.append("<th>Profession</th>");
			br.append("<th>Phone Number</th>");
			br.append("<th>Address</th>");			
			br.append("</tr>");
			for(Participant p: pd) {
				br.append("<tr>");
				br.append("<td>"+p.id+"</td>");
				br.append("<td>"+p.name+"</td>");
				br.append("<td>"+p.dob+"</td>");
				br.append("<td>"+p.gender+"</td>");
				br.append("<td>"+p.batchname+"</td>");
				br.append("<td>"+p.profession+"</td>");
				br.append("<td>"+p.phno+"</td>");
				br.append("<td>"+p.address+"</td>");
				br.append("</tr>");
			}
			br.append("</table>");
		}
		out.println(br.toString());
		out.println("</html>");
		out.close();
	}

}
