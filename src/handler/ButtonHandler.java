package handler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domainOperator.domainCreator;
import domainOperator.domainNamer;
import issue.issueCreator;

public class ButtonHandler implements ActionListener {

	JTextField domainNameField;
	static String text;
	domainNamer namer;
	
	domainCreator domainTaker;
	issueCreator creator;
	public ButtonHandler(){
		
	}
	public ButtonHandler (String text){
		this.text=text;
	}
	public void actionPerformed(ActionEvent event) {
		
		if(((JButton)event.getSource()).getText().equals("New Domain")){
			System.out.println("domain de");
         namer =new domainNamer();
         namer.frame.setVisible(true);
        

		}else if (((JButton)event.getSource()).getText().equals("Create")){
			System.out.println(text);
			domainTaker.frame.setVisible(false);
			domainTaker = new domainCreator();	
			System.out.println("SILDI");
			
		}else if (((JButton)event.getSource()).getText().equals("Add Issue")){
		    issueCreator issueTable = new issueCreator();
		    issueTable.frame.setVisible(true);
		
		}

	}


}
