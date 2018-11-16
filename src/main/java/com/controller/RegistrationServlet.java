package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Jdbc;

import com.model.Login;
import com.model.Registration;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		long contact_no = Long.parseLong(request.getParameter("contact_no"));
		
		Login r1= new Login();
		Registration r = new Registration(r1);
		
		r.setEmail(email);
		r.setFirstname(firstname);
		r.setLastname(lastname);
		r.setPassword(password);
		r.setContact_no(contact_no);

		List<Registration> lst = new ArrayList<Registration>();
		lst.add(r);
		
		Jdbc rj = new Jdbc();
		int i = rj.saveData(lst);
		if(i>0) {
		System.out.println("ok");	
			out.println("<script language='javascript'>window.alert('You have successfully registered yourself -- Login to continue');</script>");
			out.println("Welcome");
			
		

	}
		else
		{
			System.out.println("error.....");
			
		}



	}

}
