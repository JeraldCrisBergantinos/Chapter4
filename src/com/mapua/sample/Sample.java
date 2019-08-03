package com.mapua.sample;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class Sample
 */
@WebServlet(
		value="/Sample",
		initParams = {
				@WebInitParam(name = "foo", value = "Hello"),
				@WebInitParam(name = "bar", value = "World!"),
		}
)
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int n1 = Integer.parseInt( request.getParameter("number1") );
		int n2 = Integer.parseInt( request.getParameter("number2") );
		out.println("The result is " + (n1+n2));
		
		String foo = this.getInitParameter("foo");
		String bar = this.getInitParameter("bar");
		out.println("<br>");
		out.println(foo);
		out.println("<br>");
		out.println(bar);
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
