package cz.czechitas.beginnerjava.classroom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class PizzaToppingsApp implements ActionListener {

	private JFrame frame;
	JPanel leftPanel;
	JPanel rightPanel;
	JPanel checkBoxesPanel;
	JPanel buttonPanel;
	JCheckBox chckbxNewCheckBox;
	JCheckBox chckbxNewCheckBox_1;
	JCheckBox chckbxNewCheckBox_2;
	JCheckBox chckbxNewCheckBox_3;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JCheckBox chckbxNewCheckBox_4;
	JCheckBox chckbxNewCheckBox_5;
	JCheckBox chckbxNewCheckBox_6;
	JCheckBox chckbxNewCheckBox_7;
	JTextArea txtrMyPizzaTopping;

	// Declare my checkboxes array

	JCheckBox[] checkBoxArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaToppingsApp window = new PizzaToppingsApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PizzaToppingsApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.setBounds(100, 100, 529, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(220, 10));
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		checkBoxesPanel = new JPanel();
		checkBoxesPanel.setBackground(Color.YELLOW);
		leftPanel.add(checkBoxesPanel);
		checkBoxesPanel.setLayout(new GridLayout(4, 2, 0, 0));

		// here are all my check boxes

		chckbxNewCheckBox = new JCheckBox("Extra cheese");
		chckbxNewCheckBox.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("Extra Ham");
		chckbxNewCheckBox_1.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("Mushrooms");
		chckbxNewCheckBox_2.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3 = new JCheckBox("Onion");
		chckbxNewCheckBox_3.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_3);

		chckbxNewCheckBox_4 = new JCheckBox("Garlic");
		chckbxNewCheckBox_4.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_4);

		chckbxNewCheckBox_5 = new JCheckBox("Olives");
		chckbxNewCheckBox_5.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_5);

		chckbxNewCheckBox_6 = new JCheckBox("Jalapenos");
		chckbxNewCheckBox_6.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_6);

		chckbxNewCheckBox_7 = new JCheckBox("Salami");
		chckbxNewCheckBox_7.setBackground(Color.YELLOW);
		checkBoxesPanel.add(chckbxNewCheckBox_7);

		checkBoxArray = new JCheckBox[8];
		checkBoxArray[0] = chckbxNewCheckBox;
		checkBoxArray[1] = chckbxNewCheckBox_1;
		checkBoxArray[2] = chckbxNewCheckBox_2;
		checkBoxArray[3] = chckbxNewCheckBox_3;
		checkBoxArray[4] = chckbxNewCheckBox_4;
		checkBoxArray[5] = chckbxNewCheckBox_5;
		checkBoxArray[6] = chckbxNewCheckBox_6;
		checkBoxArray[7] = chckbxNewCheckBox_7;

		// here my checkboxes end

		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.ORANGE);
		leftPanel.add(buttonPanel);

		btnNewButton = new JButton("Show selection");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("Show");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonPanel.add(btnNewButton);

		btnNewButton_1 = new JButton("Clear selection");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("Clear");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		buttonPanel.add(btnNewButton_1);

		rightPanel = new JPanel();
		rightPanel.setForeground(Color.CYAN);
		frame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		rightPanel.setLayout(new BorderLayout(0, 0));

		txtrMyPizzaTopping = new JTextArea();
		txtrMyPizzaTopping.setEditable(false);
		txtrMyPizzaTopping.setFont(new Font("Myanmar Text", Font.BOLD, 13));
		txtrMyPizzaTopping.setText("My pizza topping selection :");
		rightPanel.add(txtrMyPizzaTopping);
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand;
		actionCommand = e.getActionCommand();

		if (actionCommand.equals("Show")) {
			showSelection();
		} else if (actionCommand.equals("Clear")) {
			clearSelection();
		}
	}

	public void showSelection() {
		int x;
		for (x = 0; x < 8; x++) {
			if (checkBoxArray[x].isSelected()) {
				String checkboxText;
				checkboxText = checkBoxArray[x].getText();
				txtrMyPizzaTopping.append("\n - ");
				txtrMyPizzaTopping.append(checkboxText);
			}
		}
	}

	public void clearSelection() {
		int i;
		for (i = 0; i < 8; i++) {
			checkBoxArray[i].setSelected(false);
		}
		txtrMyPizzaTopping.setText("My pizza topping selection :");
	}
}
