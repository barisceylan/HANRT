package domainOperator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

public class domainNamer extends domainCreator {

	public JFrame frame;
	public JTextField textField;
	static domainNamer namer;

	domainCreator domainTaker;

	static String text;
	int domainCounterTemp;

	public domainNamer() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 300, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Domain name");
		label.setBounds(10, 25, 100, 30);
		frame.getContentPane().add(label);
		frame.setTitle("create domain");
		textField = new JTextField();
		textField.setBounds(109, 25, 156, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		counter = counter + 1;

		cancel_btn_listener();
		create_btn_listener();

	}

	private void cancel_btn_listener() {
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(140, 56, 117, 37);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}

	private void create_btn_listener() {
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 56, 117, 37);
		frame.getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text = textField.getText();
				if (domainCreator.domainList.contains(text)) {
					frame.setVisible(false);
					JOptionPane.showMessageDialog(frame, "You can't enter this domain it already exists!");
				} else {
					domainCreator.frame.setVisible(false);
					domainTaker = new domainCreator(text);
					frame.setVisible(false);
					domainTaker.frame.setVisible(true);
				}
			}
		});
	}

}