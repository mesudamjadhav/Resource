package com.yash.fielter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	public CORSFilter() {
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;

		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://10.8.100.121");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");

		HttpServletResponse resp = (HttpServletResponse) servletResponse;

		if (request.getMethod().equals("OPTIONS")) {
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}

		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}