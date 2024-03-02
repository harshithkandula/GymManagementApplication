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
 * Servlet implementation class DeleteParticipant
 */
public class DeleteParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteParticipant() {
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
		String p_id = request.getParameter("id");
		int pid = Integer.parseInt(p_id);
		Db d = new Db();
		
		int r = d.deleteParticipant(pid);
		
		if(r>0) {
			out.println("<h3>Delete "+r+" participant with ID: "+pid+"</h3>");
			out.println("<a href='ParticipantDetails.jsp'>Click here for participant details</a>");
		}
	}

}
