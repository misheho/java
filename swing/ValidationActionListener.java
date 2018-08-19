package swing;
import java.awt.event.*;

/*
 * ActionListener class
 * Links actions to be performed in cases of events to components
 */
public class ValidationActionListener implements ActionListener {
	private final FieldValidationApp fVa;
	
	ValidationActionListener(FieldValidationApp app) {
		this.fVa = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fVa.validateLength();
	}

}
