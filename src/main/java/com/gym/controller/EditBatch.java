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
import com.gym.model.Batch;

/**
 * Servlet implementation class EditBatch
 */
public class EditBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBatch() {
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
		String batchName = request.getParameter("batchname");
		
		
		ArrayList<Batch> bd = d.fetchBatchDetails(batchName);
		
		out.println("<h3>Edit Participant</h3>");
		for(Batch i: bd) {
			out.println("<form action='updatebatch' method='post'>");
			out.println("<label>Batch ID</label>");
			out.println("<input type='text' name='bid' value='"+i.batchId+"'>");
			out.println("<label>Batch Name</label>");
			out.println("<input type='text' name='bname' value='"+i.batchName+"'>");
			out.println("<label>Timings</label>");
			out.println("<input type='time' name='btiming' value='"+i.timings+"'>");
			out.println("<label>Batch Strength</label>");
			out.println("<input type='number' name='strength' value='"+i.strength+"'>");
			out.println("<label>Start Date</label>");
			out.println("<input type='date' name='sdate' value='"+i.startdate+"'>");
			out.println("<input type='submit' value='modify'>");
			out.println("</form>");
		}
		
		/*String id = request.getParameter("bid");
		String batchTime = request.getParameter("btiming");
		String batchSth = request.getParameter("strength");
		int bsth = Integer.parseInt(batchSth);
		String batchsd = request.getParameter("sdate");
		
		int result = d.updateBatch(id, batchName, batchTime, bsth, batchsd);
		
		if(result > 0) {
			out.println("<h3>Batch Details of "+batchName+" Updated Successfully</h3>");
		}
		else {
			out.println("<h3>Sorry, Batch Details not modified</h3>");
		}*/
		out.println("</html>");
		out.close();
	}

}
