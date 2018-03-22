package negotitation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.WindowSelector;
import negotitation.NegotiationAvatar;

public class ResultPage extends JFrame {

	static String result;

	public ResultPage(String result) {
		this.result = result;
		
		setVisible(true);
		//setSize(1100, 700);
		setBounds(400,150,400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RESULTS");
		
		guiCreator();
		
		
	}
	
	public void guiCreator(){
		JPanel resultPanel = new JPanel();
	
	
		
		
		JLabel enterLabel = new JLabel();
		enterLabel.setText("You have finished the negotiation session. The result is: ");
		
	
		resultPanel.setBounds(0,0,400,400);
		JLabel resultLabel = new JLabel();
		resultLabel.setText(result);
		
		enterLabel.setBounds(50, 20, 250, 60);
		resultLabel.setBounds(50, 80, 250, 60);
		
		JButton finishBtn = new JButton("FINISH");
		finishBtn.setBounds(200,120,60,30);
		
		finishBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "You have terminated the negotiation session!");
				
				setVisible(false);
				
				WindowSelector windowSelector = new WindowSelector();
				windowSelector.frame.setVisible(true);

			}
		});
		
		
		
		resultPanel.add(finishBtn);
		resultPanel.add(enterLabel);
		resultPanel.add(resultLabel);
		
		add(resultPanel);
	}

}
