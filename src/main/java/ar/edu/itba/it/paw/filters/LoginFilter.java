package ar.edu.itba.it.paw.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = ((HttpServletRequest) request).getRequestURI();
		if (path.endsWith("HotelApp/login")) {
			//httpResponse.sendRedirect("./login");
			 request.getRequestDispatcher("/login").forward(request,
			 response);
		} else {
			HttpSession sess = httpRequest.getSession(false);
			System.out.println(sess);
			if (sess == null || sess.getAttribute("USER") == null) {
				System.out.println("no SESSION");
				httpResponse.sendRedirect("./login");
				return;
			}
			chain.doFilter(request, response);
		}

		return;
	}
}
