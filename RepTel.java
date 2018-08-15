package revisions;

import java.util.*;

public class RepTel {
	private  HashMap <String,Contact > rep;
	private String name;
	
	public  RepTel () {
		rep = new  HashMap <String ,Contact >();
	}
	
	public  RepTel (String name) {
		rep = new  HashMap <String ,Contact >();
		this.name = name;
	}
	
	/*	Ajoute  un  nouveau  contact  dans  le  r e p e r t o i r e*/
	public  void  nouveauContact(String nom , String  [] nums){
		Contact c = new  Contact(nom);
			for (String n: nums){
			c.ajoutNum(n);
		}
		String  key = nom.toLowerCase ();
		rep.put(key,c);
	}
	
	/*Adds new number to an existing contact
	 * Returns true if the number has not been added
	 * Returns false if the contact does not exist
	 */
	public  boolean  ajoutNum(String nom , String  num){
		nom = nom.toLowerCase();
		try {
			rep.get(nom).ajoutNum(num);
			return true;
		}
		catch (NullPointerException e) {return false;}		
	}
	
	/*Prints all details and phone numbers of a contact of the given name
	 */
	public  void  afficheContactDeNom(String  nom){
		nom = nom.toLowerCase();
		try {
			rep.get(nom).affiche();
		}
		catch (NullPointerException e) {System.out.println("Contact not found.");}
	}

	/*
	 * Prints the name of the directory and all contacts it contains
	 */
	public  void  affiche (){
		System.out.println("Contacts in " + name + ":");
	}

	/*
	 * Prints the first contact found of a given number
	 */
	public  void  afficheContactDeNum(String  num){
		ArrayList<Contact> l = new ArrayList<Contact>(rep.values());
		try {	
			for (Contact c : l) {
				boolean found = c.contientNumero(num);
				if (found) {
					c.affiche();
					break;
				}
				else {System.out.println("Phone number not found.");};
			}
		}
		catch (NullPointerException e) {System.out.println("The contact list is empty.");}
	}
	
	//Sorts and prints contacts in the directory in the alphabetical order
	public void orderABC() {
		if (rep.isEmpty()) {
			System.out.println("No contacts");
			return;
		}
		System.out.println("Directory" + name + " in alphabetical order:");
		ArrayList<Contact> contactList = new ArrayList<Contact>(rep.values());
		Collections.sort(contactList, new OrdreAlphaBethique());
		for (Contact c : contactList) {
			c.affiche();
		}
	}
}
