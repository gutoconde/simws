package com.gutoconde.simws.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ipAddress = request.getHeader("X-Forward-For");
        if(ipAddress== null){
            ipAddress = request.getRemoteAddr();
        }
        logger.info("Client IP : " + ipAddress);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
