package com.gym.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gym.db.Db;

/**
 * Servlet implementation class UpdateParticipant
 */
public class UpdateParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateParticipant() {
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
		int id = Integer.parseInt(p_id);
		String  name = request.getParameter("pname");
		String pdob = request.getParameter("dob");
		String pgend = request.getParameter("gender");
		String batch = request.getParameter("bname");
		String prof = request.getParameter("job");
		String ph = request.getParameter("phno");
		String ad = request.getParameter("addr");
		
		int result = d.updateParticipant(id, name, pdob, pgend, batch, prof, ph, ad);
		
		if(result > 0) {
			out.println("<h3>Participant Details Updated Successfully</h3>");
			out.println("<a href='ParticipantDetails.jsp'>Click Here to naviage to Participant Details</a>");
		}
		else {
			out.println("<h3>Update unsuccessful</h3>");
			out.println("<a href='ParticipantDetails.jsp'>Click Here to naviage to Participant Details</a>");
		}
		
		out.println("<html>");
		out.close();
	}

}
