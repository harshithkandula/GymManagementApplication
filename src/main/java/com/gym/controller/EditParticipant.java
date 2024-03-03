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
 * Servlet implementation class EditParticipant
 */
public class EditParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditParticipant() {
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
		Db d = new Db();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style>");
		String p_id = request.getParameter("id");
		int pid = Integer.parseInt(p_id);
		
		ArrayList<Participant> p = d.displayParticipantById(pid);
		ArrayList<String> b = d.fetchAllBatches();
		
		out.println("<h3>Edit Participant</h3>");
		for(Participant i: p) {
			out.println("<form action='updateparticipant' method='post'>");
			out.println("<input type='hidden' name='id' value='"+pid+"'>");
			out.println("<label>Participant Name</label>");
			out.println("<input name='pname' value='"+i.name+"'><br>");
			out.println("<label>Date Of Birth</label>");
			out.println("<input name='dob' value='"+i.dob+"'><br>");
			out.println("<label>Gender</label>");
			out.println("Male<input type='radio' name='gender' value='male'>");
			out.println("Female<input type='radio' name='gender' value='female'>");
			out.println("<label>Batch Name</label>");
			out.println("<select name='bname' value='"+i.batchname+"'>");
			for(String j: b) {
				out.println("<option value='"+j+"'>"+j+"</option>");
			}
			out.println("</select>");
			out.println("<label>Profession</label>");
			out.println("<input name='job' value='"+i.profession+"'><br>");
			out.println("<label>Phone Number</label>");
			out.println("<input name='phno' value='"+i.phno+"'><br>");
			out.println("<label>Address</label>");
			out.println("<textarea name='addr' value='"+i.address+"'></textarea>");
			
			out.println("<input type='submit' value='update'>");
			
			out.println("</form>");
		}
		
		
		
		
		out.println("</html>");
		out.close();
		
	}

}
