package com.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ViewShoppingCart extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("within viewShoppingCart servlet");

		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.print("<HTML><HEAD><TITLE>Supply Categories</TITLE></HEAD>");
		out.print("<BODY><CENTER>");



		out.print("<table>");
		out.print("<tr><td><CENTER><b><h2>Dizzyworld Store Shopping Cart</h2></b></CENTER></td>");
		out.print("</tr>");
		out.print("</table>");

		out.print("<FONT SIZE='4' COLOR='navy'>");


		HttpSession session = request.getSession(true);

		Vector scitems = (Vector) session.getAttribute("cart");
		if (scitems == null)
		{

			out.print("Nothing in shopping cart<BR><BR>");
		} else {

			Enumeration<ShoppingCartItem> enum1 = scitems.elements();

			out.print("<BR><TABLE WIDTH='75%' BGCOLOR='wheat'>");
			out.print("<TR><TD>Item</TD><TD>Price</TD></TR>");
			System.out.println("Your shopping cart includes: ");

			while (enum1.hasMoreElements())
			{
				ShoppingCartItem item = (ShoppingCartItem) enum1.nextElement();

				out.print("<TR><TD>" + item.getName() + "</TD><TD>" + item.getPrice() + "</TD></TR>");
				System.out.println("\tItem: " + item.getName() + " price: " + item.getPrice());
			}

			out.print("</TABLE>");
		}



		out.print("</FONT>");
		out.print("<BR><A HREF='./shopping.jsp'>Back To The Shopping Page</A><BR>");
		out.print("<BR><A HREF='./welcome.jsp'>Back To Home Page</A><BR>");
		out.print("</BODY></HTML>");

	}


}