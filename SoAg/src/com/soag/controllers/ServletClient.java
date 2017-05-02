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

import com.soag.beans.Account;
import com.soag.beans.Person;
import com.soag.models.ConAccounts;
import com.soag.models.ConBddConseil;
import com.soag.models.ConnexionBdd;

/**
 * Servlet implementation class TestAffichageComptes
 * Ce servlet simule la connection d'un client, le client avec l'id 3 et appelle une JSP
 * qui permet de d'afficher les comptes bancaires de ce client
 */
@WebServlet("/ServletClient")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CLIENT_PATH= "/WEB-INF/profileClient/welcomeClient.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(CLIENT_PATH).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ici on simule si on qu'on est un certain client, le client à l'id 3, et on récupère ses comptes pour les affichers
		HttpSession session = request.getSession();
				
		Person myClient = new Person();
		myClient = (Person) session.getAttribute("connectedClient");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts = ConAccounts.getMyAccounts(myClient);
		request.setAttribute("accounts", accounts);
		
		this.getServletContext().getRequestDispatcher(CLIENT_PATH).forward(request, response);
	}

}
