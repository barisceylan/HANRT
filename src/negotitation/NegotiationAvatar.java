package negotitation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import domainOperator.Domain;
import issue.Issue;
import main.WindowSelector;

public class NegotiationAvatar  {
	static int counter = 80;
	static int checker = 0;
	static int choice = 1;
	static Domain negoDomain = new Domain();
	JButton button1, button2, button3;
	static ImageIcon icon;
	static JFrame frame;
	JButton offerBtn;
	JLabel label2, label3;
	static JPanel panel1, panel2, panel3, panel4;
	JLabel count_down = new JLabel();
	static JTextPane textPane = new JTextPane();
	ArrayList<String> valueOfferList = new ArrayList<String>();
	ArrayList<Double> doubleOfferList = new ArrayList<Double>();

	ArrayList<String> preferenceValues = new ArrayList<String>();
	ArrayList<Double> preferenceDoubles = new ArrayList<Double>();

	JComboBox<String> issueBox;

	ArrayList<JComboBox> comboList = new ArrayList<JComboBox>();
	static StyledDocument doc;
	SimpleAttributeSet left;
	static SimpleAttributeSet right;

	public static JLabel images = new JLabel();

	static int offerCounter = 0;

	public NegotiationAvatar(Domain domain) {
		frame = new JFrame();
		frame.setLayout(new GridLayout(2, 2));
		this.negoDomain = domain;
		guiCreator();

		frame.setVisible(true);
		frame.setSize(1100, 700);
		//frame.setBounds(230, 0, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Negotiation");

	}

	private void guiCreator() {
		createPreferenceLists();

		offerPanel_design();

		negotiationWindow_design();

		offerManagement_design();

		avatarPanel_design();

	}

	private static void women_avatar() {
		if (checker == 4) {
			ImageIcon emoji1 = new ImageIcon("images/WEkran1.PNG");
			images.setIcon(emoji1);

			
			frame.add(images);
			panel1.validate();
			panel1.repaint();

			checker = checker - 4;
		} else {
			if (checker == 5) {
				ImageIcon emoji1 = new ImageIcon("images/WEkran2.PNG");
				images.setIcon(emoji1);

				frame.add(images);
				panel1.validate();
				panel1.repaint();

				checker = checker - 5;
			}
		}
	}

	private void negotiationWindow_design() {
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		JLabel window_name = new JLabel("Negotiation Window");
		window_name.setFont(new Font("Tahoma", Font.BOLD, 17));

	
		textPane.setPreferredSize(new Dimension(400, 600));
	
		doc = textPane.getStyledDocument();

		left = new SimpleAttributeSet();
		StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(left, Color.red);

		right = new SimpleAttributeSet();
		StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setForeground(right, Color.BLUE);

		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setSize(400, 600);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel2.add(window_name, BorderLayout.NORTH);
		panel2.add(textPane, BorderLayout.CENTER);
		panel2.add(scrollPane, BorderLayout.EAST);
		frame.add(panel2);

	}

	private void offerPanel_design() {
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.lightGray);

		offer_text();

		JPanel humanPreferencePanel = new JPanel();
		humanPreferencePanel.setBackground(Color.WHITE);
		panel3.add(humanPreferencePanel);
		humanPreferencePanel.setBounds(235, 235, 280, 90);

		JLabel prefLabel1 = new JLabel("hotels: grand:0.7 , medium:0.4, low: 0.1");
		JLabel prefLabel2 = new JLabel("month: january:0.2 , june:0.7, september: 0.8");
		JLabel prefLabel3 = new JLabel("place: barcelona:0.8 , paris:0.9, antalya: 0.6");
		JLabel header = new JLabel("Human Preferences");
		header.setFont(new Font("Apple Casual", Font.CENTER_BASELINE, 15));
		header.setBounds(0, 0, 260, 20);
		prefLabel1.setBounds(0, 25, 260, 20);
		prefLabel2.setBounds(0, 50, 260, 20);
		prefLabel3.setBounds(0, 75, 260, 20);
		humanPreferencePanel.add(header);
		humanPreferencePanel.add(prefLabel1);
		humanPreferencePanel.add(prefLabel2);
		humanPreferencePanel.add(prefLabel3);
		humanPreferencePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel crazy = new JPanel();
		crazy.setBackground(Color.lightGray);
		crazy.setLayout(new BoxLayout(crazy, BoxLayout.Y_AXIS));
		panel3.add(crazy);

		JLabel domainName = new JLabel(negoDomain.getId().toUpperCase());
		domainName.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 25));

		crazy.add(domainName);

		for (int i = 0; i < negoDomain.getIssueList().size(); i++) {
			JLabel issueLabel = new JLabel(negoDomain.getIssueList().get(i).getId() + ":");
			issueLabel.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));

			crazy.add(issueLabel);
			issueBox = new JComboBox<String>();
			for (int j = 0; j < negoDomain.getIssueList().get(i).getValueList().size(); j++) {
				issueBox.addItem(negoDomain.getIssueList().get(i).getValueList().get(j).getId());
			}
			crazy.add(issueBox);
			comboList.add(issueBox);
		}

		JScrollPane scrollPane = new JScrollPane(crazy);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 30, 550, 200);
		panel3.add(scrollPane);

		offerBtn = new JButton("Make an offer");

		offerBtn.setBounds(25, 260, 200, 50);
		panel3.add(offerBtn);

		offerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				offerCounter++;
				try {
					doc.setParagraphAttributes(doc.getLength(), 1, left, false);
					doc.insertString(doc.getLength(), "USER: My Offer is; \n ", left);

					for (int i = 0; i < comboList.size(); i++) {

						doc.insertString(doc.getLength(), negoDomain.getIssueList().get(i).getId() + ":"
								+ comboList.get(i).getSelectedItem().toString().toUpperCase() + " ", left);
						doc.setParagraphAttributes(doc.getLength(), 1, left, false);

						for (int k = 0; k < preferenceValues.size(); k++) {

							if (preferenceValues.get(k).toString()
									.equals(comboList.get(i).getSelectedItem().toString())) {

								valueOfferList.add(comboList.get(i).getSelectedItem().toString());
								doubleOfferList.add(preferenceDoubles.get(k));
							}

						}

					}

					doc.insertString(doc.getLength(), "\n", left);
				
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int j = 0; j < valueOfferList.size(); j++) {
					//System.out.println(valueOfferList.get(j).toString() + " TIK");
					// System.out.println(doubleOfferList.get(j));

				}

				Offer humanOffer = new Offer(valueOfferList, doubleOfferList);

				Timer timer = new Timer();

				TimerTask myTask = new TimerTask() {
					int counterOfferDuration = 1;

					@Override
					public void run() {
						if (counterOfferDuration == 0) {
							timer.cancel();
							offerBtn.setEnabled(true);
							Agent agent = new Agent(humanOffer);
							Protocol protocol = new Protocol(humanOffer, agent);
							valueOfferList.clear();
							
						}else{
						counterOfferDuration--;
						//panel3.enable(false);
						offerBtn.setEnabled(false);
						
						}
					}

				};

				timer.schedule(myTask, 1000, 1000);

				// valueOfferList.clear();
				doubleOfferList.clear();

			}
		});

		frame.add(panel3);

	}

	public void offer_text() {
		JLabel offers = new JLabel("Please select your offer;");

		offers.setBounds(0, 0, 300, 25);

		offers.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));

		offers.setHorizontalAlignment(JLabel.CENTER);

		panel3.add(offers);

	}

	private void offerManagement_design() {

		JButton terminateBtn = new JButton("Terminate the negotiation");
		JButton acceptBtn = new JButton("Accept the offer");

		terminateBtn.setBounds(80, 70, 200, 40);
		acceptBtn.setBounds(300, 70, 200, 40);
		JPanel panel4 = new JPanel();

		panel4.setLayout(null);
		panel4.add(terminateBtn);
		panel4.add(acceptBtn);

		terminateBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have terminated the negotiation session!");
				frame.setVisible(false);
				WindowSelector windowSelector = new WindowSelector();
				windowSelector.frame.setVisible(true);

			}
		});

		acceptBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,
				//		"Negotiation Session Is Finished. The Result Is: \n" + Agent.agentResult);
				//setVisible(false);
				//WindowSelector windowSelector = new WindowSelector();
				//windowSelector.frame.setVisible(true);
				
				ResultPage resultPage = new ResultPage(Agent.agentResult);
				frame.setVisible(false);
				resultPage.setVisible(true);
			}
		});

		time_check(panel4);

		ImageIcon icon1 = new ImageIcon("images/1.png");
		ImageIcon icon2 = new ImageIcon("images/2.png");
		ImageIcon icon3 = new ImageIcon("images/3.png");

		button_checker(panel4, icon1);

		button_checker2(panel4, icon2);

		button_checker3(panel4, icon3);

		JLabel gender = new JLabel("Choose your avatar:");
		gender.setFont(new Font("Tahoma", Font.BOLD, 17));
		gender.setBounds(40, 10, 200, 40);
		panel4.add(gender);

		gender_selector(panel4);

		frame.add(panel4);

	}

	public static void avatarPanel_design() {
		panel1 = new JPanel();
		
		// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		if (checker == 0) {
			ImageIcon icon = new ImageIcon("images/Ekran1.PNG");
			System.out.println("1111");
			// setSize(new Dimension(panel1.getWidth(), panel1.getHeight()));
			images.setIcon(icon);

			frame.add(images);
		} else {
			if (checker == 1 && choice > 0) {

				ImageIcon emoji1 = new ImageIcon("images/Ekran3.PNG");
				images.setIcon(emoji1);

				frame.add(images);
				panel1.validate();
				panel1.repaint();

				checker--;

			} else {
				if (checker == 2 && choice > 0) {

					ImageIcon emoji1 = new ImageIcon("images/Ekran2.png");
					images.setIcon(emoji1);

					frame.add(images);
					panel1.validate();
					panel1.repaint();

					checker = checker - 2;

				} else {
					if (checker == 3 && choice > 0) {

						ImageIcon emoji1 = new ImageIcon("images/Ekran4.PNG");
						images.setIcon(emoji1);

						frame.add(images);
						panel1.validate();
						panel1.repaint();

						checker = checker - 3;

					} else if (choice == 0) {
						//System.out.println(choice);
						//System.out.println(checker);
						women_avatar();
					}
				}
			}
		}

		// add(new JLabel(new ImageIcon("images/avatar1.png")));

	}

	public void time_check(JPanel panel4) {
		Timer timer = new Timer();

		TimerTask myTask = new TimerTask() {
			int check = 80;

			@Override
			public void run() {
				if (check == 0 || counter == 0) {
					timer.cancel();
					terminate_message();

				}
				panel4.repaint();
				count_down.setText(String.valueOf(counter));
				count_down.setBounds(250, 280, 200, 40);
				count_down.setFont(new Font("Tahoma", Font.BOLD, 23));

				counter--;
				check--;

				panel4.repaint();
				panel4.add(count_down);

			}

			private void terminate_message() {

				JOptionPane.showMessageDialog(null, "The time is ended, negotiation session will be terminated!");
				frame.setVisible(false);
				WindowSelector windowSelector = new WindowSelector();
				windowSelector.frame.setVisible(true);
			}

		};

		timer.schedule(myTask, 1000, 1000);

		// }

	}

	private void gender_selector(JPanel panel4) {

		JButton button5 = new JButton("Man");
		button5.setBounds(230, 10, 130, 40);

		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checker = checker + 1;
				choice++;
				avatarPanel_design();

			}
		});

		panel4.add(button5);

		JButton button6 = new JButton("Woman");
		button6.setBounds(370, 10, 130, 40);

		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(checker);
				checker = checker + 4;
				//System.out.println(checker);
				choice--;
			
				avatarPanel_design();

			}
		});

		panel4.add(button6);
	}

	private void button_checker3(JPanel panel4, ImageIcon icon3) {
		JButton button4 = new JButton(icon3);
		button4.setBounds(75, 150, 100, 100);

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//	checker = checker + 3;
				textPane.insertIcon(new ImageIcon("images/sasýrma.PNG"));
				try {
					doc.insertString(doc.getLength(), " \n ", left);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//panel1_design();

			}
		});
		panel4.add(button4);
	}

	private void button_checker2(JPanel panel4, ImageIcon icon2) {
		JButton button3 = new JButton(icon2);
		button3.setBounds(365, 150, 100, 100);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			//	checker = checker + 2;
				textPane.insertIcon(new ImageIcon("images/yuzz.PNG"));
				try {
					doc.insertString(doc.getLength(), " \n ", left);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//	panel1_design();

			}
		});
		panel4.add(button3);
	}

	private void button_checker(JPanel panel4, ImageIcon icon1) {
		JButton button2 = new JButton(icon1);
		button2.setBounds(220, 150, 100, 100);

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPane.insertIcon(new ImageIcon("images/kýzgýn.PNG"));
				try {
					doc.insertString(doc.getLength(), " \n ", left);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//	checker++;
			//	panel1_design();

			}
		});
		panel4.add(button2);
	}

	public void createPreferenceLists() {
		preferenceValues.add("grand");
		preferenceValues.add("medium");
		preferenceValues.add("low");
		preferenceValues.add("january");
		preferenceValues.add("june");
		preferenceValues.add("september");
		preferenceValues.add("barcelona");
		preferenceValues.add("paris");
		preferenceValues.add("antalya");

		preferenceDoubles.add(0.7);
		preferenceDoubles.add(0.4);
		preferenceDoubles.add(0.1);
		preferenceDoubles.add(0.2);
		preferenceDoubles.add(0.7);
		preferenceDoubles.add(0.8);
		preferenceDoubles.add(0.8);
		preferenceDoubles.add(0.9);
		preferenceDoubles.add(0.6);

	}

	public static void changer(int checker) {
		
		// panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		if (checker == 0) {
			ImageIcon icon = new ImageIcon("images/Ekran1.PNG");
			// setSize(new Dimension(panel1.getWidth(), panel1.getHeight()));
			images.setIcon(icon);
			
			frame.add(images);
		} else {
			if (checker == 1) {

				ImageIcon emoji1 = new ImageIcon("images/Ekran3.PNG");
				images.setIcon(emoji1);

				frame.add(images);
				panel1.validate();
				panel1.repaint();

				checker--;

			} else {
				if (checker == 2) {

					ImageIcon emoji1 = new ImageIcon("images/Ekran2.png");
					images.setIcon(emoji1);

					frame.add(images);
					panel1.validate();
					panel1.repaint();

					checker = checker - 2;

				} else {
					if (checker == 3) {

						ImageIcon emoji1 = new ImageIcon("images/Ekran4.PNG");
						images.setIcon(emoji1);

						frame.add(images);
						panel1.validate();
						panel1.repaint();

						checker = checker - 3;

					} else if (choice == 0) {
						//System.out.println(choice);
						//System.out.println(checker);
						women_avatar();
					}
				}
			}
		}
	}
	

}