package com.soag.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soag.beans.Person;
import com.soag.models.ConBddConseil;

/**
 * Servlet implementation class TestConseiller
 * Ce servlet simule la connexion d'un conseiller, le conseiller numéro 7,
 * et afficher la JSP qui permet au conseiller d'afficher les différents clients qu'il gère
 *
 */
@WebServlet("/ServletConseiller")
public class ServletConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONSEILLER_PATH= "/WEB-INF/profileConseiller/welcomeConseiller.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConseiller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Person myAdvisor = new Person();
		myAdvisor = (Person) session.getAttribute("connectedAdvisor");
		System.out.println("On essaye de récupérer un attribut de la sesison : "+ myAdvisor);
		this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Person myAdvisor = new Person();
		myAdvisor = (Person) session.getAttribute("connectedAdvisor");
		System.out.println( "On essaye de récupérer un attribut de la sesison : "+ myAdvisor);
		
		List<Person> clients = new ArrayList<Person>();
		
		clients = ConBddConseil.getMyClients(myAdvisor);
		
		request.setAttribute("myConseiller", myAdvisor);
		request.setAttribute("clients", clients);
		
		this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward(request, response);
		
	}

}
