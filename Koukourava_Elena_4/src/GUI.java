import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
	
	private JPanel panel;
	private JTextField inputField;
	private JButton Button;
	private JButton Mpouton;
	private Registry r;

	public GUI(Registry r) {
		this.r = r;
		panel = new JPanel();
		inputField = new JTextField(10);
		Button = new JButton("Find");
		Mpouton = new JButton("Visualize Network");
	
		panel.add(inputField);
		panel.add(Button);
		panel.add(Mpouton);
	
		ButtonListener listener = new ButtonListener();
		Button.addActionListener(listener);
		Mpouton.addActionListener(listener);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Find Suspect");
	
	}

	class ButtonListener implements ActionListener{
		int count = 0;
		Suspect helpingVal;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource().equals(Button)) {
				for(Suspect s : r.getSuspects()) {
					if(s.getName().equals(inputField.getText())) {
						count = 1;
						helpingVal = s;
					}
				}
				if(count == 1 ) {
					new SuspectPage(helpingVal, r);
					inputField.setText("");
				}else {
					JOptionPane.showMessageDialog(panel, "Suspect "+ inputField.getText() + " Not Found");
					inputField.setText("");
				}
			}
			if(arg0.getSource().equals(Mpouton)) {
				new JungGUI(r);
				setVisible(false);
			}
		}
	
	}
}
