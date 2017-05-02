package com.soag.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.soag.beans.Account;
import com.soag.beans.Person;

/*
 * Gestion de la connexion à la bdd en général
 */
public class ConnexionBdd {
	
	public static void main(String[] args) {
		
		List<Person> myTest = new ArrayList<Person>();
		displayTablePerson();
		/*
		myTest = getPersonFromBdd();
		for(Person myPerson: myTest){
			System.out.println(myPerson + " email :  " + myPerson.getEmail() + myPerson.getFirstName() + myPerson.getPassword());
		}
		*/
		Person myClient = new Person();
		myClient.setId(3);
		List<Account> accounts = new ArrayList<Account>();
		accounts = ConAccounts.getMyAccounts(myClient);
		
		
		for (Account myAccount: accounts ){
			System.out.println("account id : " + myAccount.getAccount_customer_id() +" account balance : " + myAccount.getAccount_balance());
		}
		
		
	}

	
	/*
	 * Se connecte à la bdd et afficher ce qu'il y a à l'intérieur de la table sac_person
	 */
public static void displayTablePerson(){
		
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
	         
	         
	            
	         stat.executeQuery("SELECT * From sac_person");
	         ResultSet resultat = stat.executeQuery("SELECT * From sac_person");
	            
	         while(resultat.next()){
	                System.out.print(resultat.getObject(1)+" ");
	                System.out.print(resultat.getObject(2)+" ");
	                System.out.print(resultat.getObject(3)+" ");
	                System.out.print(resultat.getObject(4)+" ");
	                System.out.print(resultat.getObject(5)+" ");
	                System.out.print(resultat.getObject(6)+" ");
	                System.out.print(resultat.getObject(7)+" ");
	                System.out.print(resultat.getObject(8)+" ");
	                System.out.print(resultat.getObject(9)+" ");
	                System.out.print(resultat.getObject(10)+" ");
	                System.out.print(resultat.getObject(11)+" ");
	                System.out.print(resultat.getObject(12)+" ");
	                System.out.print(resultat.getObject(13)+" ");
	                System.out.println();
	         	}
		         
	         resultat.close();
	         stat.close();
	         cnx.close();
	            
			}catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("erreur dans la connexion bdd");
			} 
		
	}


	/*
	*cette fonction interroge la bdd et retourne la liste de "Persons" qui correspondent aux lignes de la BDD
	*
	*/

	public static List <Person> getPersonsFromBdd(){
		List<Person> persons= new ArrayList<Person>(); 
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Driver ok");
	        
	        Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root", "root");
	        System.out.println("Connexion ok");
	        
	        Statement stat = (Statement)cnx.createStatement();
	        System.out.println("Statement ok");
	       
	         stat.executeQuery("SELECT * From sac_person");
	         ResultSet resultat = stat.executeQuery("SELECT * From sac_person");
	            
	         while(resultat.next()){
	        	 //créer une instance de Person et l'ajouter dans la liste "persons"
	        	 
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
	        	 
	        	 persons.add(myPerson);
	        	 
	                System.out.print(resultat.getObject(1)+" ");
	                System.out.print(resultat.getObject(2)+" ");
	                System.out.print(resultat.getObject(3)+" ");
	                System.out.print(resultat.getObject(4)+" ");
	                System.out.print(resultat.getObject(5)+" ");
	                System.out.print(resultat.getObject(6)+" ");
	                System.out.print(resultat.getObject(7)+" ");
	                System.out.print(resultat.getObject(8)+" ");
	                System.out.print(resultat.getObject(9)+" ");
	                System.out.print(resultat.getObject(10)+" ");
	                System.out.print(resultat.getObject(11)+" ");
	                System.out.print(resultat.getObject(12)+" ");
	                System.out.print(resultat.getObject(13)+" ");
	                System.out.println();
	         	}
		         
	         resultat.close();
	         stat.close();
	         cnx.close();
	
	        
		}catch(Exception e){
			System.out.println("erreur dans getEmail");
		}
		
		return persons;
		
}
	
	/*
	 * fonction de création d'une personne dans la bdd, table sc_person
	 * 
	 */
	
	public static void CreatePerson(String External_ID,String firstname,String lastname,String email,String password,String dob,String phone){
		try{	
			 Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Driver ok");
	         //connection
	         
	         //Connection cnx = (Connection) DriverManager.getConnection("url"," user", "passwrd");
	         Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root", "root");
	         System.out.println("Connexion ok");
	         
	         //statement
	    //     Statement stat = (Statement)cnx.createStatement();
	         
	
	         String query = "INSERT INTO sac_person (person_external_id,person_firstName,person_lastName,person_email,person_password,person_dob,person_phone_number) VALUES (?,?,?,?,?,?,?)";
	         PreparedStatement preparedStmt = (PreparedStatement) cnx.prepareStatement(query);
	         System.out.println("Statement ok"); 
	         
	        // preparedStmt.setString(1, ExternalID);
	         preparedStmt.setString(1, External_ID);
	         preparedStmt.setString(2, firstname);
	         preparedStmt.setString(3, lastname);
	         preparedStmt.setString(4, email);
	         preparedStmt.setString(5, password);
	         preparedStmt.setString(6, dob);
	         preparedStmt.setString(7, phone);
	         
	           
	     ///   int retour =  preparedStmt.executeUpdate();
	            
	        System.out.println("Retour cnx" + preparedStmt.executeUpdate());
	     //    ResultSet resultat = stat.executeQuery("person_externalId,person_firstName,person_lastName,person_email,person_password,person_dob,person_phoneNumber");
	          
	            
	       //  resultat.close();
	        // stat.close();
	         cnx.close();
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
		}



}
