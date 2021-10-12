// Calculator GUI Program
// using Shunting Yard Algorith and PostFix Interpreter
// Created by Saviru Perera - 260966369

import acm.gui.*;
import acm.program.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class JCalcGui extends Program {
	
	postFix a = new postFix(); // create an instance of the postFix class
	
	public void init() {

		setLayout(new TableLayout(8,4)); // create a 8 by 4 TableLayout display
		setBackground(Color.BLUE); // set the canvas to a blue color
		JLabel info = new JLabel("Press the = button or Enter/Return button on the Keyboard to get an answer."); // instructions for user
		add(info, SOUTH);
		inputField = new JTextField(30); // initialize the number of characters the textField can store 
		inputField.setActionCommand("=");
		inputField.addActionListener(this); // add an actionListener to the inputField so it generates an event when return/enter key is hit
		outputField = new JTextField(30); // set up outputField same way as inputField
		outputField.setEditable(false); // make the textField uneditable for the user
		add(inputField, "gridwidth=4"); // make the inputField and outputField span all the columns
		add(outputField, "gridwidth=4");
		add(new JButton("C")); // following add lines add all the buttons to the TableLayout
		add(new JButton("."));
		add(new JButton("="));
		add(new JButton("/"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		add(new JButton("*"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("-"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("+"));
		add(new JButton("0"));
		add(new JButton("("));
		add(new JButton(")"));
		add(new JButton("Delete"));
		add(new JButton("^"));
		add(new JButton("Quit"));
		addActionListeners(); // addActionListeners registers the program as an actionListener for the buttons
	
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (!cmd.equals("C")&&!cmd.equals("Delete")&&!cmd.equals("=")&&!cmd.equals("Quit")) {
			inputField.setText(inputField.getText()+cmd); // add the string for each button to the textField
		} else if (cmd.equals("=")) { // if user clicks the = button
			String infix = inputField.getText(); // store the contents of the inputField in the variable infix
			Queue pFix = a.In2Post(a.parse(infix)); // convert the infix expression to postFix
			double answer = a.PostEval(pFix); // evaluate postFix expression
			outputField.setText(Double.toString(answer)); // set the outputField with the answer to the postFix expression
		} else if (cmd.equals("C")) { // set both fields to empty if the C button is pressed
			inputField.setText("");
			outputField.setText("");
		} else if (cmd.equals("Delete")) { // delete characters one at a time each time the Delete button is pressed
			String input = inputField.getText();
			input = input.substring(0, input.length()-1); // make the string in the textField one character shorter than it was before delete button was pressed
			inputField.setText(input);
		} else if (cmd.equals("Quit")) {
			System.exit(0); // terminates the GUI
		}
		
	}
	
	private JTextField inputField; // private instance variables for the testFields
	private JTextField outputField;

}
