package main;



// MERAbaaaaa
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domainOperator.domainCreator;
import domainOperator.domainNamer;
import handler.ButtonHandler;
import negotitation.DomainSelector;
import negotitation.NegotiationAvatar;

public class WindowSelector{
	public static JFrame frame;
	static JPanel mainPanel;
	static String domain_name;
	static int counter = 0;
	domainNamer namer;
	static NegotiationAvatar avatars;
	static domainCreator creator;
	static int i = 0;

	public int domainCounter = 0;
	static JPanel treePanel;

	
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowSelector selector= new WindowSelector();
					selector.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	
	public WindowSelector(){
		selector();
	}
	

	public static void selector() {
		frame = new JFrame();
		frame.setSize(250, 200);
		frame.setBounds(200, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Welcome Page");
		frame.setLayout(new BorderLayout());
		JPanel mainPanel = new JPanel();
	

		
		mainPanel.setLayout(null);
		mainPanel.setMaximumSize(mainPanel.getPreferredSize());
		mainPanel.setMinimumSize(mainPanel.getPreferredSize());
		mainPanel.setBackground(Color.decode("#bbd2f7"));
		
		JLabel over_text = new 	JLabel(" Please Choose an Option");
		over_text.setBounds(20, 30, 400, 100);
		over_text.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		
		JButton avatar_btn = new JButton("Negotiation Session");
		JButton negotiation_btn = new JButton("Domain Operator");
		
		avatar_btn.setBounds(40, 140, 150, 90);
		negotiation_btn.setBounds(200, 140, 150, 90);
		
		mainPanel.add(over_text);
		mainPanel.add(avatar_btn);
		mainPanel.add(negotiation_btn);
		frame.getContentPane().add(mainPanel,BorderLayout.CENTER);
		
		
		JLabel name_text = new 	JLabel("Human Agent Negotiation Research Tool");
		name_text.setBounds(80,280, 400, 100);
		//name_text.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		mainPanel.add(name_text);
		
		avatar_btn.addActionListener(new ActionListener(){
    		
			public void actionPerformed(ActionEvent e) {
				DomainSelector domainSelector = new DomainSelector();
				domainSelector.setVisible(true);
				domainSelector.setBounds(100, 100, 450, 300);
				frame.setVisible(false);
				
			}
			});
		
		negotiation_btn.addActionListener(new ActionListener(){
    		
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				creator = new domainCreator();
				creator.frame.setVisible(true);
						
			}
			});
		
		
	}


	
}
