package com.mapua.sample;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class OrderSlip
 */
@WebServlet("/OrderSlip")
public class OrderSlip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSlip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		out.println("Order Slip");
		out.println("<br>");
		
		String appetizer_item = request.getParameter("appetizer_item");
		String appetizer_item_count = request.getParameter("appetizer_item_count");
		String main_course_item = request.getParameter("main_course_item");
		String main_course_item_count = request.getParameter("main_course_item_count");
		String drink_item = request.getParameter("drink_item");
		String drink_item_count = request.getParameter("drink_item_count");
		String serve_with_dessert = request.getParameter("serve_with_dessert");
		String payment = request.getParameter("payment");
		String credit_card_number = request.getParameter("credit_card_number");
		String first_name = request.getParameter("first_name");		
		String middle_name = request.getParameter("middle_name");		
		String last_name = request.getParameter("last_name");
		
		if (serve_with_dessert == null || serve_with_dessert.isEmpty()) {
			serve_with_dessert = "NO";
		}
		else {
			serve_with_dessert = "YES";
		}
		
		if (payment.equalsIgnoreCase("Credit Card")) {
			String temp = "";
			if (credit_card_number.length()>4) {
				for (int i = 0; i < credit_card_number.length()-4; ++i) {
					temp += "X";
				}
				temp += credit_card_number.substring(credit_card_number.length()-4);
			}
			credit_card_number = temp; 
		}
		
		out.println(
				"Name: " + first_name + " " + middle_name + " " + last_name +
				"<table>" +
						"<tr>" +
							"<td>Category</td>" +
							"<td>Item<br>Count</td>" +
							"<td>Item<br>Name</td>" +
							"<td>Price</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td>Appetizer</td>" +
							"<td>" + appetizer_item_count + "</td>" +
							"<td>" + appetizer_item + "</td>" +
							"<td>P 1.00</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td>Main Course</td>" +
							"<td>" + main_course_item_count + "</td>" +
							"<td>" + main_course_item + "</td>" +
							"<td>P 1.00</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td>Drink</td>" +
							"<td>" + drink_item_count + "</td>" +
							"<td>" + drink_item + "</td>" +
							"<td>P 1.00</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td></td>" +
							"<td></td>" +
							"<td>Total Price</td>" +
							"<td>P 3.00</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td></td>" +
							"<td></td>" +
							"<td>Service Charge</td>" +
							"<td>P 0.36</td>" +
						"</tr>" +
							
						"<tr>" +
							"<td></td>" +
							"<td></td>" +
							"<td>Total amount to be paid</td>" +
							"<td>P 3.36</td>" +
						"</tr>" +

				"</table>" +
				
				"Remarks:<br>" +
				"Serve with dessert: " + serve_with_dessert + "<br>" +
				"Payment Option: " + payment + " " + credit_card_number
				);
		
		out.close();
	}
	
	void getParamsTest(PrintWriter out, HttpServletRequest request) {
		String appetizer_item = request.getParameter("appetizer_item");
		out.println(appetizer_item);
		out.println("<br>");
		
		String appetizer_item_count = request.getParameter("appetizer_item_count");
		out.println(appetizer_item_count);
		out.println("<br>");
		
		String main_course_item = request.getParameter("main_course_item");
		out.println(main_course_item);
		out.println("<br>");
		
		String main_course_item_count = request.getParameter("main_course_item_count");
		out.println(main_course_item_count);
		out.println("<br>");
		
		String drink_item = request.getParameter("drink_item");
		out.println(drink_item);
		out.println("<br>");
		
		String drink_item_count = request.getParameter("drink_item_count");
		out.println(drink_item_count);
		out.println("<br>");
		
		String serve_with_dessert = request.getParameter("serve_with_dessert");
		out.println(serve_with_dessert);
		out.println("<br>");
		
		String payment = request.getParameter("payment");
		out.println(payment);
		out.println("<br>");
		
		String first_name = request.getParameter("first_name");
		out.println(first_name);
		out.println("<br>");
		
		String middle_name = request.getParameter("middle_name");
		out.println(middle_name);
		out.println("<br>");
		
		String last_name = request.getParameter("last_name");
		out.println(last_name);
		out.println("<br>");
		
		out.println("<p>");
		
		for (String key: Collections.list(request.getParameterNames())) {
			out.println(key);
			out.println("<br>");
		}
	}
}
