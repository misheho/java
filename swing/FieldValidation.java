package swing;
import java.awt.*;
import javax.swing.*;

/*
 * Class for graphic components of the application
 * Definition of the graphic components and UI
 */
public class FieldValidation extends JFrame {
	private JTextField text= new JTextField(20);
	private JFrame frame= new JFrame("Field Validation");
	
	public FieldValidation() {
		setLayout();
	}
	
	private void setLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		panel.add(text);
		this.add(panel);
		this.pack();
	}
	
	public JTextField getTextField() {
		return text;
	}
	
}
