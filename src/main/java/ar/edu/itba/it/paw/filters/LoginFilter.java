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
	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * if (filterConfig == null) return;
		 */
		/*String path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/login")) {
			request.getRequestDispatcher(path).forward(request, response);
		}else{*/
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession sess = httpRequest.getSession(false);
			if (sess == null) {
				httpResponse.sendRedirect("./login");
			}
			chain.doFilter(request, response);
		//}
		
		return;
	}
}
