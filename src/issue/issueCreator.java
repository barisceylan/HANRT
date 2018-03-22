package issue;

import java.awt.Color;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import handler.ButtonHandler;
import repository.RepositoryItem;

import javax.xml.bind.Unmarshaller;

import domainOperator.Domain;
import domainOperator.domainPage;

public class issueCreator {

	public JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField discreteTextField;

	private JTextField integerMinTextField;
	private JTextField integerMaxTextField;

	public static JPanel panel2;
	public JComboBox comboBox;
	public JLabel lblEditDiscreteValues;
	
	ArrayList<Value> discreteValueItems = new ArrayList<Value>();
	ArrayList<Value> integerValueItems = new ArrayList<Value>();

	public issueCreator() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 399);
		frame.setTitle("Add Issue");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 509, 145);
		frame.getContentPane().add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(10, 28, 149, 27);
		panel.add(lblName);

		textField = new JTextField();
		textField.setBounds(195, 24, 254, 31);
		panel.add(textField);
		textField.setColumns(10);

		issue_properties();

		createDiscretePanel();

		combo_box_listener();

	}

	private void combo_box_listener() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object selected = comboBox.getSelectedItem();
				if (selected.toString().equals("Integer")) {
					panel2.removeAll();
					panel2.repaint();
					createIntegerPanel();

				}
				if (selected.toString().equals("Discrete")) {
					panel2.removeAll();
					panel2.repaint();
					createDiscretePanel();
				}
			}

		});
	}

	private void issue_properties() {
		JLabel lblIssuProperties = new JLabel("Issue Properties :");
		lblIssuProperties.setBounds(10, 79, 149, 40);
		panel.add(lblIssuProperties);

		String[] issueProperties = { "Discrete", "Integer" };
		comboBox = new JComboBox(issueProperties);

		comboBox.setBounds(207, 79, 242, 40);
		panel.add(comboBox);
	}

	public void createIntegerPanel() {
		JLabel valueLabel = new JLabel("Min Value:");
		valueLabel.setBounds(20, 10, 60, 35);
		valueLabel.setForeground(Color.white);
		panel2.add(valueLabel);
		integerMinTextField = new JTextField();
		integerMinTextField.setBounds(90, 10, 100, 35);
		panel2.add(integerMinTextField);
		JLabel valueLabel2 = new JLabel("Evaluation of Min Value:");
		valueLabel2.setBounds(220, 10, 150, 35);
		valueLabel2.setForeground(Color.white);
		panel2.add(valueLabel2);
		JTextField field2 = new JTextField();
		field2.setBounds(370, 10, 100, 35);
		panel2.add(field2);

		JLabel valueLabel3 = new JLabel("Max Value:");
		valueLabel3.setBounds(20, 70, 60, 35);
		valueLabel3.setForeground(Color.white);
		panel2.add(valueLabel3);
		integerMaxTextField = new JTextField();
		integerMaxTextField.setBounds(90, 70, 100, 35);
		panel2.add(integerMaxTextField);
		JLabel valueLabel4 = new JLabel("Evaluation of Max Value:");
		valueLabel4.setBounds(220, 70, 150, 35);
		valueLabel4.setForeground(Color.white);
		panel2.add(valueLabel4);
		JTextField field4 = new JTextField();
		field4.setBounds(370, 70, 100, 35);
		panel2.add(field4);

		JButton createButton = create_btn_integer();

		panel2.add(createButton);

	}

	private JButton create_btn_integer() {
		JButton createButton = new JButton("Create Issue");
		createButton.setBounds(183, 170, 142, 35);
		ButtonHandler handler = new ButtonHandler();
		createButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				File domainFile = new File("./XML Files/" + domainPage.converter + ".xml");

				try {
					JAXBContext jaxbContext2 = JAXBContext.newInstance(Domain.class);

					Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();
					Domain domaintemp = (Domain) unmarshaller.unmarshal(domainFile);
					domainPage.issueItems = domaintemp.getIssueList();
					ArrayList<String> issueList = new ArrayList<String>();
					for (int k = 0; k < domainPage.issueItems.size(); k++) {
						issueList.add(domainPage.issueItems.get(k).getId());
					}

					if (issueList.contains(textField.getText())) {
						frame.setVisible(false);
						JOptionPane.showMessageDialog(frame, "You can't enter this issue, it already exists!");
					} else {
						Issue issue = new Issue();
						issue.setId(textField.getText());
                        
						Value minValue = new Value();
						Value maxValue = new Value();
						
						minValue.setId(integerMinTextField.getText());
						maxValue.setId(integerMaxTextField.getText());
						
						integerValueItems.add(minValue);
						integerValueItems.add(maxValue);
						
						issue.setValueList(integerValueItems);
						domainPage.issueItems.add(issue);

						domainPage.domain.setIssueList(domainPage.issueItems);
						issue.isDiscrete=false;
						Object[] issueRow = new Object[3];
						issueRow[0] = textField.getText();
						issueRow[1] = "INTEGER";
						issueRow[2] = "Min:" + integerMinTextField.getText() + "Max:" + integerMaxTextField.getText();

						domainPage.model.addRow(issueRow);
						frame.setVisible(false);
					}

				} catch (JAXBException e1) {

				}

			}
		});
		return createButton;
	}

	public void createDiscretePanel() {
		panel2 = new JPanel();
		panel2.setBounds(0, 144, 509, 216);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);

		lblEditDiscreteValues = new JLabel("Edit discrete values below : ");
		lblEditDiscreteValues.setBounds(25, 32, 328, 32);
		lblEditDiscreteValues.setForeground(Color.white);
		panel2.add(lblEditDiscreteValues);
		panel2.setBackground(Color.darkGray);
		discreteTextField = new JTextField();
		discreteTextField.setBounds(25, 75, 455, 84);
		panel2.add(discreteTextField);
		discreteTextField.setColumns(10);

		JButton createButton = create_btn_discrete();
		panel2.add(createButton);
	}

	private JButton create_btn_discrete() {
		JButton createButton = new JButton("Create Issue");
		createButton.setBounds(183, 170, 142, 35);
		//ButtonHandler handler = new ButtonHandler();
		createButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				File domainFile = new File("./XML Files/" + domainPage.converter + ".xml");

				try {
					JAXBContext jaxbContext2 = JAXBContext.newInstance(Domain.class);

					Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();
					Domain domaintemp = (Domain) unmarshaller.unmarshal(domainFile);
					//System.out.println(domaintemp.getIssueList().get(0).getId());
					domainPage.issueItems = domaintemp.getIssueList();
					ArrayList<String> issueList = new ArrayList<String>();
					
					
						for (int k = 0; k < domainPage.issueItems.size(); k++) {
							issueList.add(domainPage.issueItems.get(k).getId());
						}
					
					

					if (issueList.contains(textField.getText())) {
						frame.setVisible(false);
						JOptionPane.showMessageDialog(frame, "You can't enter this issue, it already exists!");
					} else {
					

					Issue issue = new Issue();
					issue.setId(textField.getText());
					String[] parts = discreteTextField.getText().split(",");
					
					for(int j=0;j<parts.length;j++){
						Value value = new Value();
						value.setId(parts[j]);
						discreteValueItems.add(value);
					}
					
					
					issue.setValueList(discreteValueItems);

					domainPage.issueItems.add(issue);

					domainPage.domain.setIssueList(domainPage.issueItems);
                    
					issue.isDiscrete=true;
					Object[] issueRow = new Object[3];
					issueRow[0] = textField.getText();
					issueRow[1] = "DISCRETE";
					issueRow[2] = discreteTextField.getText();

					domainPage.model.addRow(issueRow);
					frame.setVisible(false);

					}} catch (JAXBException e1) {

				}

			}
		});
		return createButton;
	}
}