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
 * Servlet implementation class DisplayParticipantByBatch
 */
public class DisplayParticipantByBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayParticipantByBatch() {
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
		String bid = request.getParameter("b_name");
		Db d = new Db();
		ArrayList<String> bn = d.getBatchName(bid);
		ArrayList<Participant> pdb = null;
		
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
		if(bn.size() > 0) {
			for(String b:bn) {
				pdb = d.displayParticipantByBatch(b);
			}
		}
		
		
		StringBuffer buff = new StringBuffer();
		if(pdb.size()>0) {
			buff.append("<table>");
			buff.append("<tr>");
			buff.append("<th>ID</th>");
			buff.append("<th>NAME</th>");
			buff.append("<th>DATE OF BIRTH</th>");
			buff.append("<th>GENDER</th>");
			buff.append("<th>BATCH NAME</th>");
			buff.append("<th>PROFESSION</th>");
			buff.append("<th>PHONE NUMBER</th>");
			buff.append("<th>ADDRESS</th>");
			buff.append("</tr>");
			for(Participant p:pdb) {
				buff.append("<tr>");
				buff.append("<td>"+p.id+"</td>");
				buff.append("<td>"+p.name+"</td>");
				buff.append("<td>"+p.dob+"</td>");
				buff.append("<td>"+p.gender+"</td>");
				buff.append("<td>"+p.batchname+"</td>");
				buff.append("<td>"+p.profession+"</td>");
				buff.append("<td>"+p.phno+"</td>");
				buff.append("<td>"+p.address+"</td>");
				buff.append("</tr>");
			}
			buff.append("</table>");
		}
		else {
			out.println("<h3>No Participants registered in "+bn+"</h3>");
		}
		out.println(buff.toString());
		out.println("</html>");
		out.close();
	}

}
