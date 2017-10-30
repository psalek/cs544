package edu.mum.cs.cs544.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello Example</title>");
		out.println("</p>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet</h1>");
		out.println("<p>Current date &amp; time on server:");
		Date now = new Date();
		if (now.after(new Date(0))) {
			out.println(now);
		}
		out.println("<br/>");
		out.println("<p><a href=\"index.html\">Home</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
