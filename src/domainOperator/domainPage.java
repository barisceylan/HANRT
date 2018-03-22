package domainOperator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;

import handler.ButtonHandler;
import issue.Issue;
import main.WindowSelector;
import repository.Repository;
import repository.RepositoryItem;

public class domainPage extends JPanel {

	public static JFrame frame;
	static String pageName;
	public static String converter;
	static String text;
	public static Domain domain;
	Repository repository;
	RepositoryItem repositoryItem;

	JTable table;
	public static DefaultTableModel model;

	List<String> itemNames;
	
	ArrayList<RepositoryItem> items = new ArrayList<RepositoryItem>();
	public static ArrayList<Issue> issueItems = new ArrayList<Issue>();

	public domainPage(String text) {

		converter = text;

		initialize();
	}

	private void initialize() {

		domain = new Domain();
		domain.setId(converter);

		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Value");

		table.setRowHeight(35);
		Object[] newRow = new Object[3];
		newRow[0] = converter;
		newRow[1] = "OBJECTIVE";
		newRow[2] = "this==Objective";
		model.addRow(newRow);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(0, 0, 550, 380);
		add(scrollPane);

		setBounds(0, 0, 434, 261);

		setLayout(null);
		setBackground(Color.GRAY);

		JButton removeIssueBtn = new JButton("Remove Issue");
		removeIssueBtn.setBounds(203, 390, 150, 60);

		
		removeIssueBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int column=0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				
				
				try{
					File file = new File("./XML Files/" + converter + ".xml");
					JAXBContext jaxbContext = JAXBContext.newInstance(Domain.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					Domain domain = (Domain) jaxbUnmarshaller.unmarshal(file);
					ArrayList<Issue> list = domain.getIssueList();
					

				
					
					
					
					
					for (int k = 0; k < list.size(); k++) {
						Issue tempIssue = list.get(k);
					
						if(tempIssue.getId().equals(value)){
							
							
							System.out.println(value);
							
						}
					}
				}catch(Exception ex){
					
				}
				
				
				
				System.out.println(value);

			}
		});
		
		
		add(removeIssueBtn);

		JButton addIssueBtn = new JButton("Add Issue");
		ButtonHandler handler = new ButtonHandler();
		addIssueBtn.addActionListener(handler);
		addIssueBtn.setBounds(23, 390, 150, 60);
		add(addIssueBtn);

		JButton saveBtn = new JButton("Save Changes");
		saveBtn.setBounds(383, 390, 150, 60);
		add(saveBtn);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(text);

		lblNewLabel.setBounds(123, 11, 223, 33);
		add(lblNewLabel);

		saveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				File XMLDir = new File("./XML Files/");

				try {
					// DOMAIN XML PART

					File domainFile = new File("./XML Files/" + converter + ".xml");
					
					JAXBContext jaxbContext2 = JAXBContext.newInstance(Domain.class);
				
					

					
					Marshaller jaxbMarshaller2 = jaxbContext2.createMarshaller();
					jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
					jaxbMarshaller2.marshal(domain, domainFile);
					jaxbMarshaller2.marshal(domain, System.out);

					// REPOSITORY XML PART

					File[] domainList = XMLDir.listFiles();

					File repositoryFile = new File("REPOSITORY.xml");

					JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
					Marshaller marshaller = jaxbContext.createMarshaller();
					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

					repository = new Repository();

					for (File f : domainList) {
						repositoryItem = new RepositoryItem();
						repositoryItem.setPath(f.getAbsolutePath());
						items.add(repositoryItem);
					}

					repository.setRepository(items);

					marshaller.marshal(repository, repositoryFile);
					marshaller.marshal(repository, System.out);

				} catch (JAXBException e) {
					e.printStackTrace();
				}

			}
		});

	}
}