package test_exex_swing;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class UserCreation extends JFrame {
	private JTextField identifiant = new JTextField(10);
	private JLabel name = new JLabel("Username");
	private JLabel pwd1 = new JLabel("Password");
	private JLabel pwd2 = new JLabel("Confirm Password");
	private JTextField MDP1 = new JTextField(10);
	private JTextField MDP2 = new JTextField(10);
	private JButton bouton = new JButton("Save");
	private JPanel panel;
	
	private class MyDocListener implements DocumentListener {
		public void changedUpdate (DocumentEvent e) {};
		public void insertUpdate (DocumentEvent e) {verifyButton();};
		public void removeUpdate (DocumentEvent e) {verifyButton();};
		
	}
	
	private MyDocListener docListener = new MyDocListener();
	
	public UserCreation() {
		panel = new JPanel();
		//bouton.setEnabled(false);
		defineLayout();
		activate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void defineLayout() {
			// Bon, on va essayer de faire plus beau que d'habitude.
			panel.setLayout(new GridLayout(4,1));
			panel.add(name);
			panel.add(identifiant);
			panel.add(pwd1);
			panel.add(MDP1);
			panel.add(pwd2);
			panel.add(MDP2);
			panel.add(new JLabel(""));
			panel.add(bouton);
			this.add(panel);
			this.pack();
	}
	
	private void verifyButton() {
		boolean ok = !identifiant.getText().isEmpty() && !MDP1.getText().isEmpty() && !MDP2.getText().isEmpty()
				&& MDP1.getText().equals(MDP2.getText());
		bouton.setEnabled(ok);
	}
	
	private void activate() {
		
		/*MDP2.addTextListener(new TextListener() {
			public void textValueChanged (TextEvent e) {
				setBoutonActive();
			}
		});
		MDP1.addTextListener(new TextListener() {
			public void textValueChanged (TextEvent e) {
				setBoutonActive();
			}
		});*/
		
		MDP1.getDocument().addDocumentListener(docListener);
		MDP2.getDocument().addDocumentListener(docListener);
		identifiant.getDocument().addDocumentListener(docListener);
		bouton.addActionListener(e -> sauverUtilisateur());
		verifyButton();
	}
	
	public void setBoutonActive () {
		if (sameMDP(MDP1.getText(), MDP2.getText())) {
			bouton.setEnabled(true);
		}
	}
	
	public boolean sameMDP (String mdp1, String mdp2) {
		if (mdp1.equals(mdp2)) {
			return true;
		}
		else return false;
	}
	
	public void sauverUtilisateur() {
		
	}
	
	public static void main(String[] args) {
		 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new UserCreation();
			}
		});
	}
	
	
	
}
