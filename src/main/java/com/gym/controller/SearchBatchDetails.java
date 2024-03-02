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
 * Servlet implementation class SearchBatchDetails
 */
public class SearchBatchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBatchDetails() {
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
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("*{");
		out.println("background-color:burlywood;");
		out.println("}");
		out.println("</style>");
		Db d = new Db();
		String bid = request.getParameter("bname");
		ArrayList<String> bn = d.getBatchName(bid);
		ArrayList<Batch> bno = new ArrayList<Batch>();
		
		if(bn.size()>0) {
			for(String b:bn) {
				bno = d.fetchBatchDetails(b);
			}
		}
		
		out.println("<h4>Batch Details</h4>");
		if(bno.size()>0) {
			for(Batch bat: bno) {
				out.println("<p>Batch ID: "+bat.batchId+"</p>");
				out.println("<p>Batch Name: "+bat.batchName+"</p>");
				out.println("<p>Timings: "+bat.timings+"</p>");
				out.println("<p>Strength: "+bat.strength+"</p>");
				out.println("<p>Start Date: "+bat.startdate+"</p>");
			}
		}
		else {
			out.println("<h4>Batch Details Not Found</h4>");
		}
		
		out.println("</html>");
		out.close();

	}

}
