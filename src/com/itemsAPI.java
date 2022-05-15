package com;
import model.Item;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customerAPI")
public class itemsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Item itemObj = new Item(); 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = itemObj.insertUser(
				request.getParameter("userName"), 
				request.getParameter("userNIC"), 
				request.getParameter("contactNumber"), 
				request.getParameter("userType"));
		     
				response.getWriter().write(output); 
	}

	// Convert request parameters to a Map
	private static Map<String, String> getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 

	 String[] p = param.split("="); 
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = itemObj.updateUser(paras.get("hidItemIDSave").toString(), 
		 paras.get("userName").toString(), 
		paras.get("userNIC").toString(), 
		paras.get("contactNumber").toString(), 
		paras.get("userType").toString());
		
		response.getWriter().write(output); 
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<?, ?> paras = getParasMap(request); 
		 String output = itemObj.deleteUser(paras.get("userID").toString()); 
		response.getWriter().write(output); 
	}

}
