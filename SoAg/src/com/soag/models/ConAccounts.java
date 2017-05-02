package com.soag.models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.soag.beans.Account;
import com.soag.beans.Person;

public class ConAccounts {
	
	
	public static void main(String[] args) {

		addBankAccount("14","54545","CHECKINGS",1);
		
	}

	
	
	/*
	 * Création d'un compte bancaire dans la bdd, table sac_accounts
	 */
	public static void addBankAccount(String account_customer_id, String account_balance,String account_type,int account_is_default){
        
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Driver ok");
	         //connection
	         
	        Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root", "root");
	        System.out.println("Connexion ok");
	         	      	                
	        String query = "INSERT INTO sac_accounts (account_customer_id,account_balance,account_type,account_is_default) VALUES (?,?,?,?)";
	        PreparedStatement preparedStmt = (PreparedStatement) cnx.prepareStatement(query);
	        System.out.println("Statement ok"); 
	        
	        preparedStmt.setString(1, account_customer_id);		        
	        preparedStmt.setString(2, account_balance);
	        preparedStmt.setString(3, account_type);
	        preparedStmt.setInt(4, account_is_default);           
	        preparedStmt.executeUpdate();
            
	        preparedStmt.close();
            cnx.close();
            
        }catch(Exception e){
            System.out.println("erreur dans la création de compte bancaire");
        }
	}
	
	
	/*
	 * Cette fonction interroge la BDD et renvoie une liste de comptes bancaires (accounts) 
	 * qui appartiennent au client en question.
	 * a deplacer dans un truc genre "connexion comptes bancaires"
	 */
	public static List<Account> getMyAccounts(Person myClient){
		
		List<Account> accounts= new ArrayList<Account>(); 
		
		try{	
			 Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Driver ok");
	         //connection
	         
	        
	         Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test","root", "root");
	         System.out.println("Connexion ok");
	         
	         //statement
	         Statement stat = (Statement)cnx.createStatement();
	         System.out.println("Statement ok");       
	         
	         String query = "SELECT * From sac_accounts where account_customer_id =" + myClient.getId();
	         ResultSet resultat = stat.executeQuery(query);
	            
	         while(resultat.next()){
	        	 Account myAccount= new Account();
	        	 myAccount.setAccount_id(resultat.getInt(1));
	        	 myAccount.setAccount_customer_id(resultat.getString(2));
	        	 myAccount.setAccount_balance(resultat.getString(3));
	        	 myAccount.setAccount_type(resultat.getString(4));        	 
	        	     	        	 
	        	 accounts.add(myAccount);
	         	}
		         
	         resultat.close();
	         stat.close();
	         cnx.close();
	            
			}catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("erreur dans la connexion bdd");
			}
		return accounts; 
		
	}

}
