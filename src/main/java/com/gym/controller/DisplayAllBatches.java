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
 * Servlet implementation class DisplayAllBatches
 */
public class DisplayAllBatches extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllBatches() {
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
		 Db d2 = new Db();
	       ArrayList<Batch> bds = d2.fetchAllBatchesDetails();
	       StringBuffer buff = new StringBuffer();
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
	       out.println("<h3>Batches<h3>");
	       if(bds.size()>0){
	    	   buff.append("<table>");
			   buff.append("<tr>");
			   buff.append("<th>ID</th>");
			   buff.append("<th>NAME</th>");
			   buff.append("<th>START DATE</th>");
			   buff.append("<th>TIMINGS</th>");
			   buff.append("<th>STRENGTH</th>");
			   buff.append("<tr>");
	    	   for(Batch b: bds){
	    		 buff.append("<tr>");
	    		 buff.append("<td>"+b.batchId+"</td>");
	    		 buff.append("<td>"+b.batchName+"</td>");
	    		 buff.append("<td>"+b.startdate+"</td>");
	    		 buff.append("<td>"+b.timings+"</td>");
	    		 buff.append("<td>"+b.strength+"</td>");
	    		 buff.append("</tr>");
	    		   
	    	   }
	    	   buff.append("</table>");
	       }
	       else {
	    	   out.println("No Batches Found");
	       }
	       
	       out.println(buff.toString());
	       out.println("</html>");
	       out.close();
	}

}
