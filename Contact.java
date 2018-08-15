package revisions;

import java.util.*;

public class Contact {
	private  String  nom;
	private Set <String> numTel;
	
	public  Contact(String n){
		nom = n;
		numTel = new HashSet<String>();
	}
	
	public  String  getNom () {return  nom;}
	
	//Prints out the contact name and phone numbers
	public  void  affiche (){
		System.out.println(getNom ());
		afficheNums ();
	}

	//Add a phone number (no duplicates allowed)
	public  void  ajoutNum(String  num) {
		numTel.add(num);
	}

	//Print numbers of the contact
	public  void  afficheNums (){
		for (String num : numTel) {
			System.out.println(num);
		}
	}
	/*Teste  s i  ce  contact  c o n t i e n t  un  numero  de  t é l é phone*/
	public  boolean  contientNumero(String  num) {
		for (String n : numTel) {
			if (n.equals(num)) {
				return true;
			}
		}
		return false;
	}

}
