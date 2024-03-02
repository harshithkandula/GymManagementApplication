package com.gym.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.gym.db.Db;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CancelBatch
 */
public class CancelBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBatch() {
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
		String batchName = request.getParameter("batchname");
		int result = d.deleteBatch(batchName);
		
		if(result > 0) {
			out.println("<h3>Cancelled Batch "+batchName+"</h3>");
			response.sendRedirect("BatchDetails.jsp");
		}
	}

}
