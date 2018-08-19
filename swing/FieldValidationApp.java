package swing;
import java.awt.*;
import javax.swing.*;

/*
 * Class with the application logic
 * Creates an instance of the UI FieldValidation
 * Adds action listener(s)
 * Contains methods needed to fulfill the purpose of the app
 */
public class FieldValidationApp {
	private FieldValidation ui;
	
	public FieldValidationApp() {
		ui = new FieldValidation();
		activate();
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setVisible(true);
	}
	
	//Application logic
	
	//Method to display text in a different color based on length validation
	void validateLength() {
		String t = ui.getTextField().getText();
		if (t.length() < 9) {
			ui.getTextField().setForeground(Color.RED);
		}
		else if (t.length() >= 9) {
			ui.getTextField().setForeground(Color.GREEN);
		}
	}
	
	/* In app activation action listeners need to be added to components
	*  to create the link between events and application logic
	*/
	private void activate() {
		ui.getTextField().addActionListener(new ValidationActionListener(this));
	}	
	
	public static void main(String[] args) {
		//FieldValidationApp fv = new FieldValidationApp();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FieldValidationApp();
			}
		});
	}
}
