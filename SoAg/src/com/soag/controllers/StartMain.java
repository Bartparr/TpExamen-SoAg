package com.soag.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soag.beans.Person;
import com.soag.models.ConnexionBdd;

/**
 * Servlet implementation class StartConseiller
 * Cette servlet est la servlet de départ de notre projet. Elle permet aux utilisateurs de se connecter, et après 
 * avoir interrogé la base de données,et en fonction de si ils sont conseillers
 * ou clients on les envoie sur la JSP correspodnantes
 * Des messages d'erreurs sont renvoyés en fonction de ce qu'a entré l'utilisateur (email erronés ...)
 */
@WebServlet("/StartMain")
public class StartMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONNEXION_PATH= "/WEB-INF/connexionConseiller.jsp";
	public static final String CONSEILLER_PATH= "/WEB-INF/profileConseiller/welcomeConseiller.jsp";
	public static final String CLIENT_PATH= "/WEB-INF/profileClient/welcomeClient.jsp";	
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_PASS = "password";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(CONNEXION_PATH).forward( request, response );
		//this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward( request, response );
		//this.getServletContext().getRequestDispatcher(CLIENT_PATH).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 boolean found = false;
	        
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();    
	        String email = request.getParameter( FIELD_EMAIL ); //email rentré
	        String password = request.getParameter( FIELD_PASS); //mdp rentré par l'utilisateur
	        
	        List<Person> persons = new ArrayList<Person>();
	        persons = ConnexionBdd.getPersonsFromBdd();        
	        
	        System.out.println(" En entrée Email :"+email+" mdp : "+password);
	        
	       	for (Person myPerson: persons) {       
	               
	           System.out.println("Email :"+myPerson.getEmail()+" mdp : "+myPerson.getPassword());
	              
	            if((myPerson.getEmail().equals(email)) && (myPerson.getPassword().equals(password)) ){
	                
	                 if (myPerson.getIsAdvisor() == 1){
	                	 Person myAdvisor = new Person();
	                	 myAdvisor = myPerson;
	                	 session.setAttribute("connectedAdvisor", myAdvisor);
	                	 System.out.println(" on teste si on a bien stocké qqch dans myAdvisor : "+ myAdvisor);
	                     this.getServletContext().getRequestDispatcher(CONSEILLER_PATH).forward(request, response);
	                 }else{
	                	 Person myClient = new Person();
	                	 myClient = myPerson;
	                	 session.setAttribute("connectedClient", myClient);
	                     this.getServletContext().getRequestDispatcher(CLIENT_PATH).forward(request, response);
	                 }            
	                return;
	                
	            }else if(myPerson.getEmail().equals(email) && (!(myPerson.getPassword().equals(password)))){
	                request.setAttribute("msg", "le mot de passe est erroné !!!");   
	                found = true;
	              
	                
	            }else if(!(myPerson.getEmail().equals(email)) && (myPerson.getPassword().equals(password))){
	                request.setAttribute("msg", "le login est erroné !!!");     
	                found = true;
	             
	                
	            }else{
	             //   request.setAttribute("msg", "le login et le mDP sont erronés !!!");
	                
	            }
	            
	           
	        }
	       
	       if(!found)
	       request.setAttribute("msg", "le login et le mDP sont erronés !!!");
	       
	        this.getServletContext().getRequestDispatcher(CONNEXION_PATH).forward(request, response);
	        System.out.println("ici");
	        return;
    	}
	

	
}

