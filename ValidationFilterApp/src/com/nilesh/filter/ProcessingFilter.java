package com.nilesh.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProcessingFilter implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		String msg_error_eid="", msg_error_ename="", msg_error_eage="", msg_error_mobile="", msg_error_email="";

		Boolean flag = false;
		
		PrintWriter out = response.getWriter();
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		if(eid==null || eid.equals("")) {
			flag = false;
			msg_error_eid = "eid filed can't be empty";
		}else {
			if(!eid.startsWith("iNeuron")){
				flag = false;
				msg_error_eid = "eid must start with iNeuron";
			}else {
				flag = true;
			}
		}
		
		if(ename==null || ename.equals("")) {
			msg_error_ename = "ename can't be empty";
			flag = false;
		}else {
			if(ename.length()<=3 || ename.length()>=20){
				flag = false;
				msg_error_ename = "ename length should be greater than 3 and less than 20";
			}else {
				flag = true;
			}
		}
		
		if(eage==null || eage.equals("")) {
			msg_error_eage = "eage can't be empty";
			flag = false;
		}else {
			if(Integer.parseInt(eage)<=20 || Integer.parseInt(eage)>=30){
				flag = false;
				msg_error_eage = "age must be between 20 to 30";
			}else {
				flag = true;
			}
		}
		
		if(mobile==null || mobile.equals("")) {
			msg_error_mobile = "mobile can't be empty";
			flag = false;
		}else {
			if(!mobile.startsWith("91")){
				flag = false;
				msg_error_mobile = "please attach country code 91";
			}else {
				flag = true;
			}
		}
		
		if(email==null || email.equals("")) {
			msg_error_email = "ename can't be empty";
			flag = false;
		}else {
			if(!email.endsWith("@ineuron.ai")){
				flag = false;
				msg_error_email = "email id must ends with @ineuron.ai";
			}else {
				flag = true;
			}
		}
		
		
		
		
		if(flag=false) {
		chain.doFilter(request, response);
		}else {
			out.println("<center>");
			out.println("<form action='reg' method='post'>");
			out.println("<table>");
			
			out.println("<tr>");
			out.println("<td>Eid</td> <td><input type='text' name='eid' value='"+eid+"'</td> <td>"+msg_error_eid+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Ename</td> <td><input type='text' name='ename' value='"+ename+"'</td> <td>"+msg_error_ename+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Eage</td> <td><input type='text' name='eage' value='"+eage+"'</td> <td>"+msg_error_eage+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Mobile</td> <td><input type='text' name='mobile' value='"+mobile+"'</td> <td>"+msg_error_mobile+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Email</td> <td><input type='text' name='email' value='"+email+"'</td> <td>"+msg_error_email+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td></td> <td><input type='submit' value='Submit'</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("</center>");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
}
