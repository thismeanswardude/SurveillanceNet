import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class SuspectPage extends JFrame {
	
	private JPanel panel;
	private JButton findSms;
	private JButton backToScreen;
	private JTextField inputField;
	
	private JScrollPane paneForS;
	private JScrollPane paneForCode;
	private JScrollPane paneForSms;
	private JScrollPane paneForParteners;
	private JScrollPane paneForTelephones;
	private JScrollPane paneForSuggPart;
	
	private JTextArea msgArea;
	private JTextArea nameArea;
	private JTextArea codeNameArea;
	private JTextArea telephoneArea;
	private JTextArea possibleSusarea;
	private JTextArea suggestedarea;
	
	private Registry r;
	private Suspect s;
	
	public SuspectPage(Suspect s, Registry r) {
		this.s = s;
		this.r = r;
		panel = new JPanel();
		findSms = new JButton("Find SMS");
		backToScreen = new JButton("back to search screen");
		inputField = new JTextField(30);
		msgArea = new JTextArea(10,10);
		nameArea = new JTextArea();
		codeNameArea = new JTextArea();
		telephoneArea = new JTextArea();
		possibleSusarea = new JTextArea();
		suggestedarea = new JTextArea();
		
		nameArea.append(s.getName()+" ");
		codeNameArea.append(s.getCodeName()+" ");
		for(String t : s.getTelephoneNum()) {
			telephoneArea.append(t+"\n");
		}
		
		s.sort(s.getPossibleSuspects());
		for(Suspect i: s.getPossibleSuspects()) {
			possibleSusarea.append(i.getName()+", "+i.getCodeName()+"\n");
		}
		
		s.addSuggestedParteners();
		for(Suspect i : s.getSuggestedParteners()) {
			suggestedarea.append(i.getName()+", "+i.getCodeName()+"\n");
		}
		
		paneForS = new JScrollPane(nameArea);
		paneForCode = new JScrollPane(codeNameArea);
		paneForTelephones = new JScrollPane(telephoneArea);
		paneForSms = new JScrollPane(msgArea);
		paneForParteners = new JScrollPane(possibleSusarea);
		paneForSuggPart = new JScrollPane(suggestedarea);
		
		ButtonListener listener = new ButtonListener();
		findSms.addActionListener(listener);
		backToScreen.addActionListener(listener);
		
		panel.add(paneForS);
		panel.add(paneForCode);
		panel.add(paneForTelephones);
		panel.add(inputField);
		panel.add(paneForSms);
		panel.add(findSms);
		panel.add(paneForParteners);
		panel.add(paneForSuggPart);
		panel.add(backToScreen);
		
		this.setContentPane(panel);

		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Suspect Page");
		
		
		
	}
	
	class ButtonListener implements ActionListener{
		
		ArrayList<SMS> helpingArray = new ArrayList<>();
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource().equals(findSms)) {
				for(String s : s.getTelephoneNum()) {
					System.out.println(s);
					helpingArray = (r.getMessagesBetween(s , inputField.getText()));
				}
				for(SMS msg : helpingArray) {
					msgArea.append(msg.getMessage()+"\n");
				}
			}else {
				dispose();
			}
			
		}
		
	}
	
	

}