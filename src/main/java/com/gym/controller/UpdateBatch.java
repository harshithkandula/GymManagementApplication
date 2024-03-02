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
 * Servlet implementation class UpdateBatch
 */
public class UpdateBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBatch() {
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
		Db d =new Db();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style");
		String id = request.getParameter("bid");
		String bthnm = request.getParameter("bname");
		String batchTime = request.getParameter("btiming");
		String batchSth = request.getParameter("strength");
		int bsth = Integer.parseInt(batchSth);
		String batchsd = request.getParameter("sdate");
		
		int result = d.updateBatch(id, bthnm, batchTime, bsth, batchsd);
		
		if(result > 0) {
			out.println("<h3>Batch Details of "+bthnm+" Updated Successfully</h3>");
		}
		else {
			out.println("<h3>Sorry, Batch Details not modified</h3>");
			out.println("<a href='BatchDetails.jsp'>Click Here to go to Batch Details</a>");
		}
		out.println("</html>");
		out.close();
	}

}
