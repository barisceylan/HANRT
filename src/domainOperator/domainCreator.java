package domainOperator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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

//import com.sun.xml.bind.v2.model.core.Element;

import handler.ButtonHandler;
import issue.Issue;

public class domainCreator {

	public static JFrame frame;
	static JPanel mainPanel;
	static String domain_name;
	static int counter = 0;
	domainNamer namer;
	domainCreator creator;
	String treeNodeName;
	public static ArrayList<String> domainList = new ArrayList<String>();
	static int i = 0;
	String[] discreteValueCombineArray = new String[256];
	String[] integerValueCombineArray;
	public int domainCounter = 0;
	static JPanel treePanel;

	List<String> where = new ArrayList<String>();

	static DefaultMutableTreeNode root;

	static JTree tree;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { domainCreator window = new
	 * domainCreator(); window.frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */
	public domainCreator() {

		if (counter == 0) {
			initialize();
		} else if (counter > 1) {
			initialize();

		}
	}

	public domainCreator(String treeNodeName) {
		this.treeNodeName = treeNodeName;
		if (counter == 0) {
			initialize();
		} else if (counter > 1) {
			initialize();

		}
	}

	public void initialize() {

		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setBounds(200, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Domain Operator");
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(142, 0, 1602, 1478);

		mainPanel.setBackground(Color.CYAN);
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(600, 400));
		mainPanel.setMaximumSize(mainPanel.getPreferredSize());
		mainPanel.setMinimumSize(mainPanel.getPreferredSize());

		JLabel text_over_panel = new JLabel("HUMAN AGENT NEGOTIATION");
		JLabel text_over_panel2 = new JLabel("RESEARCH TOOL 1.0");
		JLabel names_over_panel = new JLabel("BY BARIS CEYLAN AND SAYIM ERK AYDOGAN");

		text_over_panel.setBounds(30, 130, 500, 100);
		text_over_panel.setFont(new Font("Tahoma", Font.BOLD, 31));
		text_over_panel2.setBounds(110, 170, 500, 100);
		text_over_panel2.setFont(new Font("Tahoma", Font.BOLD, 31));

		names_over_panel.setBounds(100, 220, 500, 100);
		names_over_panel.setFont(new Font("Tahoma", Font.BOLD, 15));

		mainPanel.add(text_over_panel);
		mainPanel.add(text_over_panel2);
		mainPanel.add(names_over_panel);

		frame.getContentPane().add(mainPanel);

		if (counter > 1) {
			//System.out.println("oldu bu iş" + namer.text);

		}

		treePanel = new JPanel();
		treePanel.setBounds(0, 0, 143, 1500);

		treePanel.setLayout(null);

		JLabel label = new JLabel();
		JButton jButton1 = new JButton();

		createTree(mainPanel);

		mainPanel.setBackground(Color.decode("#bbd2f7"));

		JButton btnNewDomain = new JButton("New Domain");
		// btnNewDomain.setFont(btnNewDomain.getFont().deriveFont(15.0f));
		btnNewDomain.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewDomain.setForeground(new Color(7, 14, 23));
		btnNewDomain.setContentAreaFilled(true);
		btnNewDomain.setBorder(new LineBorder(Color.GRAY));
		btnNewDomain.setBounds(20, 0, 110, 23);
		treePanel.add(btnNewDomain);

		ButtonHandler handler = new ButtonHandler();
		btnNewDomain.addActionListener(handler);

	}

	private void createTree(JPanel mainPanel) throws TransformerFactoryConfigurationError {
		tree = new JTree();
		
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
        
		root.setUserObject("Domains");
		
		
		root.add(new DefaultMutableTreeNode(treeNodeName));

		model.reload(root);

		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse("./REPOSITORY.xml");
			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/repository/repositoryNames";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		//	System.out.println(nodeList.getLength());

			for (i = 0; i < nodeList.getLength(); i++) {

				Node elem = nodeList.item(i);// Your Node
				StringWriter buf = new StringWriter();
				Transformer xform = TransformerFactory.newInstance().newTransformer();
				xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				xform.setOutputProperty(OutputKeys.INDENT, "yes");
				xform.transform(new DOMSource(elem), new StreamResult(buf));
				String domainPath = buf.toString().substring(23, buf.toString().length() - 5);
				//System.out.println(domainPath);

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
					domainList.add(domainID);
					root.add(new DefaultMutableTreeNode(domainID));
					model.reload(root);

				}
			}

		} catch (Exception ex) {

		}

		tree.setBounds(20, 32, 143, 439);
		JScrollPane scrollBar = new JScrollPane(tree);
		scrollBar.setSize(10, 480);

		treePanel.add(scrollBar, BorderLayout.EAST);
		treePanel.add(tree, BorderLayout.WEST);
		treePanel.setBackground(Color.white);

		frame.getContentPane().add(treePanel, BorderLayout.WEST);

		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String nodeName = selectedNode.getUserObject().toString();

				domainPage nodePanel = new domainPage(nodeName);

				try {

					File file = new File("./XML Files/" + nodeName + ".xml");
					JAXBContext jaxbContext = JAXBContext.newInstance(Domain.class);

					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					Domain domain = (Domain) jaxbUnmarshaller.unmarshal(file);
					ArrayList<Issue> list = domain.getIssueList();
					//System.out.println(list.get(0).getId());

					for (int k = 0; k < list.size(); k++) {
						Issue tempIssue = list.get(k);

						if (tempIssue.isDiscrete == true) {

							for (int m = 0; m < tempIssue.getValueList().size(); m++) {
								
								where.add(tempIssue.getValueList().get(m).getId());
								
							}

						
							discreteValueCombineArray = new String[where.size()];
							where.toArray(discreteValueCombineArray);
							where.clear();
							String valueRow = String.join(",", discreteValueCombineArray);

							Object[] issueRow = new Object[3];
							issueRow[0] = tempIssue.getId();
							issueRow[1] = "DISCRETE";
							issueRow[2] = valueRow;
                            
							nodePanel.model.addRow(issueRow);
						} else if (tempIssue.isDiscrete == false) {
                            where.add("Min:" + tempIssue.getValueList().get(0).getId());
                            where.add("Max:" + tempIssue.getValueList().get(1).getId());
                            integerValueCombineArray = new String[where.size()];
                            where.toArray(integerValueCombineArray);
                            where.clear();
                            
							String valueRow = String.join(",", integerValueCombineArray);

							Object[] issueRow = new Object[3];
							issueRow[0] = tempIssue.getId();
							issueRow[1] = "INTEGER";
							issueRow[2] = valueRow;
                            
							nodePanel.model.addRow(issueRow);
						}
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}

				mainPanel.removeAll();
				mainPanel.repaint();
				nodePanel.setBounds(0, 0, 602, 478);
				mainPanel.add(nodePanel);

			}
		});
	}

}