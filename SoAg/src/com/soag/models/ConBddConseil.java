package com.soag.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.soag.beans.Person;

/*
 * Cette classe gère les connexions à la bdd que fera le conseiller (pour gérer ses clients)
 */
public class ConBddConseil {
	
	public static void main(String[] args) {
		Person myConseiller = new Person();
		myConseiller.setAdvisorId(6);
		
		List<Person> clients = new ArrayList<Person>();
		clients = getMyClients(myConseiller);
		
		for(Person myPerson: clients){
			System.out.println(myPerson + " email :  " + myPerson.getEmail() + myPerson.getFirstName() + myPerson.getPassword());
		}
		
	}

	
	/*
	 * Va chercher la liste de clients correspondants au conseiller et renvoie une liste de Person (clients)
	 */
public static List<Person> getMyClients(Person myConseiller){
	
		List<Person> clients= new ArrayList<Person>(); 
		
		try{	
			 Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Driver ok");
	         //connection
	         
	         //Connection cnx = (Connection) DriverManager.getConnection("url"," user", "passwrd");
	         Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root", "root");
	         System.out.println("Connexion ok");
	         
	         //statement
	         Statement stat = (Statement)cnx.createStatement();
	         System.out.println("Statement ok");       
	         
	         String query = "SELECT * From sac_person where person_advisor_id = " + myConseiller.getAdvisorId();
	         ResultSet resultat = stat.executeQuery(query);
	            
	         while(resultat.next()){
	        	 Person myPerson = new Person();
	        	 myPerson.setId(resultat.getInt(1));
	        	 myPerson.setExternalId(resultat.getInt(2));
	        	 myPerson.setFirstName(resultat.getString(3));
	        	 myPerson.setLastName(resultat.getString(4));
	        	 myPerson.setEmail(resultat.getString(5));
	        	 myPerson.setPassword(resultat.getString(6));
	        	 myPerson.setDob(resultat.getString(7));
	        	 myPerson.setToken(resultat.getString(8));
	        	 myPerson.setPhoneNumber(resultat.getString(9));
	        	 myPerson.setCreatedAt((Date)resultat.getObject(10));
	        	 myPerson.setUpdatedAt((Date) resultat.getObject(11));
	        	 myPerson.setAdvisorId(resultat.getInt(12));
	        	 myPerson.setIsAdvisor((int)resultat.getInt(13) );
	        	 
	        	 clients.add(myPerson);
	         	}
		         
	         resultat.close();
	         stat.close();
	         cnx.close();
	            
			}catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("erreur dans la connexion bdd");
			}
		return clients; 
		
	}

}
