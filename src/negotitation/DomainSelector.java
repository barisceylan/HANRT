package negotitation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domainOperator.Domain;

public class DomainSelector extends JFrame {

	private JPanel selectorPanel;
	private JPanel buttonPanel;
	private FlowLayout layout;
	private JLabel infoLabel;
	private JComboBox domainBox;
	private JButton startBtn;
	public static Domain choosenDomain;



	public DomainSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout());

		selectorPanel = new JPanel();
		buttonPanel = new JPanel();
		layout = new FlowLayout();
		selectorPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectorPanel.setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);

		buttonPanel.setLayout(new BorderLayout());

		infoLabel = new JLabel("Please Select a Domain");

		domainBox = new JComboBox();

		fillComboBox();

		domainBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				myBox(evt);
			}
		});

		startBtn = new JButton("Start Negotiation");

		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				File file = new File("./XML FILES/"+domainBox.getSelectedItem().toString()+".xml");
				try{
					JAXBContext jaxbContext = JAXBContext.newInstance(Domain.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					choosenDomain = (Domain) jaxbUnmarshaller.unmarshal(file);
				}catch(Exception ex){
					
				}
				
                System.out.println(choosenDomain.getId());
				NegotiationAvatar nego = new NegotiationAvatar(choosenDomain);
				nego.frame.setVisible(true);
				nego.frame.setSize(1100, 700);
				setVisible(false);

			}
		});

		buttonPanel.add(startBtn, BorderLayout.CENTER);

		selectorPanel.add(infoLabel);
		selectorPanel.add(domainBox);
		selectorPanel.setBackground(Color.decode("#bdcdf9"));

		add(selectorPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	protected void myBox(ActionEvent evt) {
		if (domainBox.getSelectedItem() != null) {
			System.out.println(domainBox.getSelectedItem().toString());
		}
	}

	private void fillComboBox() throws TransformerFactoryConfigurationError {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse("./REPOSITORY.xml");
			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/repository/repositoryNames";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			System.out.println(nodeList.getLength());

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node elem = nodeList.item(i);// Your Node
				StringWriter buf = new StringWriter();
				Transformer xform = TransformerFactory.newInstance().newTransformer();
				xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				xform.setOutputProperty(OutputKeys.INDENT, "yes");
				xform.transform(new DOMSource(elem), new StreamResult(buf));
				String domainPath = buf.toString().substring(23, buf.toString().length() - 5);
				System.out.println(domainPath);

				Document domainXmlDocument = builder.parse(domainPath);
				String domainExpression = "/domain/id";
				NodeList domainNodeList = (NodeList) xPath.compile(domainExpression).evaluate(domainXmlDocument,
						XPathConstants.NODESET);
				for (int j = 0; j < domainNodeList.getLength(); j++) {
					Node domainElem = domainNodeList.item(j);
					StringWriter buf2 = new StringWriter();
					Transformer xform2 = TransformerFactory.newInstance().newTransformer();
					xform2.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
					xform2.setOutputProperty(OutputKeys.INDENT, "yes");
					xform2.transform(new DOMSource(domainElem), new StreamResult(buf2));
					String domainID = buf2.toString().substring(4, buf2.toString().length() - 7);

					domainBox.addItem(domainID);

				}
			}

		} catch (Exception ex) {

		}
	}

}
