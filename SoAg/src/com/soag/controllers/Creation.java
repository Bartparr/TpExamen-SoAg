package com.soag.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soag.models.ConAccounts;
import com.soag.models.ConnexionBdd;

/**
 * Servlet implementation class TestCreationPerson
 * Test de la création de comptes clients et de comptes bancaires
 */
@WebServlet("/Creation")
public class Creation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONSEILLER_PATH= "/WEB-INF/profileConseiller/welcomeConseiller.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Creation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 if (request.getParameter("createClient") != null) {

			 	ConnexionBdd.CreatePerson(request.getParameter("external_Id"),request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("email") ,request.getParameter("password") , request.getParameter("dob"),request.getParameter("phone"));
			 	this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );
	        
		 } else if (request.getParameter("createAccount") != null) {

	        	ConAccounts.addBankAccount(request.getParameter("account_customer_id"),request.getParameter("account_balance"),request.getParameter("account_type"),Integer.parseInt("1"));
	        	this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );
	      
		 } else {

	        	this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );

	        }
		
		 this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );
		
	}

}
