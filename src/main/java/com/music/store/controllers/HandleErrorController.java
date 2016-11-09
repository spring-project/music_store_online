package com.music.store.controllers;

import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleErrorController {
	@RequestMapping("/404")    
    public String handel404Error(final HttpServletRequest request, final Model model) {
		String errorMessage = getMessage(request);
        model.addAttribute("statusCode", getStatusCode(request));
        model.addAttribute("requestUri", getRequestUri(request));
        model.addAttribute("longMessage", "Page you looking for was not found");
        model.addAttribute("shortMessage", "Not Found");
        model.addAttribute("noticeMessage", errorMessage);    
        System.out.println(errorMessage);
        return "errors/page";
    }
	
	private String getStatusCode(HttpServletRequest request) {
		return "" + (int) request.getAttribute("javax.servlet.error.status_code");
	}
	
	private String getRequestUri(HttpServletRequest request) {
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		if (requestUri == null) {
        	requestUri = "Unknown";
        }
		
		return requestUri;
	}
	
	private String getMessage(HttpServletRequest request) {
		return (String) MessageFormat.format("{0} - {1}", getStatusCode(request), getRequestUri(request)); 
	}
}
