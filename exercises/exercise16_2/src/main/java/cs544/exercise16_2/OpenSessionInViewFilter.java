package cs544.exercise16_2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		
		
		// pass the request along the filter chain
		System.out.println("receiving request");
		chain.doFilter(request, response);
		System.out.println("sending response");
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
