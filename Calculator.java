import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class EquationOperator
{
	char op;
	int pos;
	int numStart;
	int numEnd;
	EquationOperator(char o, int p, int s)
	{
		op = o;
		pos = p;
		numStart = s;
	}
}

public class Calculator implements ActionListener
{
	private JFrame frame = new JFrame();
	private JFrame resultsFrame = new JFrame();
	
	private JPanel panel = new JPanel();
	private JPanel resultsPanel = new JPanel();
	
	//Text
	private JLabel titleLabel = new JLabel("Calculator");
	private JLabel textLabel = new JLabel("Cool");
	
	//Buttons
	private JButton zeroButton = new JButton("0");
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	
	private JButton submitButton = new JButton("=");
	
	int resultsOffset = 0;
	
	//Text Fields
	private JTextField inputField = new JTextField("");
	
	public void startCalculator()
	{
		frame.setSize(206, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		
		titleLabel.setBounds(0, 0, 80, 25);
		
		
		//Buttons
		setButtons();
		
		//Input Fields
		inputField.setBounds(0, 20, 200, 25);
		
		//Layout
		panel.setLayout(null);
		
		//Add
		addAll();
		
		frame.setVisible(true);
	}
	private void setButtons()
	{	
		oneButton.setBounds(0, 50, 50, 50);
		oneButton.addActionListener(this);
		
		twoButton.setBounds(50, 50, 50, 50);
		twoButton.addActionListener(this);
		
		threeButton.setBounds(100, 50, 50, 50);
		threeButton.addActionListener(this);
		
		fourButton.setBounds(0, 100, 50, 50);
		fourButton.addActionListener(this);
		
		fiveButton.setBounds(50, 100, 50, 50);
		fiveButton.addActionListener(this);
		
		sixButton.setBounds(100, 100, 50, 50);
		sixButton.addActionListener(this);
		
		sevenButton.setBounds(0, 150, 50, 50);
		sevenButton.addActionListener(this);
		
		eightButton.setBounds(50, 150, 50, 50);
		eightButton.addActionListener(this);
		
		nineButton.setBounds(100, 150, 50, 50);
		nineButton.addActionListener(this);
		
		zeroButton.setBounds(0, 200, 50, 50);
		zeroButton.addActionListener(this);
		
		addButton.setBounds(150, 50, 50, 50);
		addButton.addActionListener(this);
		
		subButton.setBounds(150, 100, 50, 50);
		subButton.addActionListener(this);
		
		mulButton.setBounds(150, 150, 50, 50);
		mulButton.addActionListener(this);
		
		divButton.setBounds(150, 200, 50, 50);
		divButton.addActionListener(this);
		
		submitButton.setBounds(50, 200, 100, 50);
		submitButton.addActionListener(this);
	}
	private void addAll()
	{
		//Panel
		frame.add(panel);
		//Text
		panel.add(titleLabel);
		panel.add(textLabel);
		//Buttons
		panel.add(oneButton);
		panel.add(twoButton);
		panel.add(threeButton);
		panel.add(fourButton);
		panel.add(fiveButton);
		panel.add(sixButton);
		panel.add(sevenButton);
		panel.add(eightButton);
		panel.add(nineButton);
		panel.add(zeroButton);
		panel.add(addButton);
		panel.add(subButton);
		panel.add(mulButton);
		panel.add(divButton);
		panel.add(submitButton);
		
		//Input Field
		panel.add(inputField);
	}
	private void startResults()
	{
		resultsFrame.setSize(206, 279);
		resultsFrame.setTitle("Results");
		resultsFrame.setResizable(false);
		
		resultsFrame.setLocationRelativeTo(null);
		
		resultsPanel.setLayout(null);
		
		resultsFrame.add(resultsPanel);
	}
	private void addResults(JLabel text)
	{
		text.setBounds(0, resultsOffset, 80, 25);
		resultsPanel.add(text);
		resultsOffset+=20;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submitButton)
		{
			resultsPanel.removeAll();
			resultsOffset = 0;
			JLabel equ = new JLabel(inputField.getText());
			addResults(equ);
			
			startResults();
			inputField.setText(calculate(inputField.getText()));
			resultsFrame.setVisible(true);
		}
		else if(e.getSource() == oneButton)
			inputField.setText(inputField.getText() + "1");
		else if(e.getSource() == twoButton)
			inputField.setText(inputField.getText() + "2");
		else if(e.getSource() == threeButton)
			inputField.setText(inputField.getText() + "3");
		else if(e.getSource() == fourButton)
			inputField.setText(inputField.getText() + "4");
		else if(e.getSource() == fiveButton)
			inputField.setText(inputField.getText() + "5");
		else if(e.getSource() == sixButton)
			inputField.setText(inputField.getText() + "6");
		else if(e.getSource() == sevenButton)
			inputField.setText(inputField.getText() + "7");
		else if(e.getSource() == eightButton)
			inputField.setText(inputField.getText() + "8");
		else if(e.getSource() == nineButton)
			inputField.setText(inputField.getText() + "9");
		else if(e.getSource() == zeroButton)
			inputField.setText(inputField.getText() + "0");
		else if(e.getSource() == addButton)
			inputField.setText(inputField.getText() + "+");
		else if(e.getSource() == subButton)
			inputField.setText(inputField.getText() + "-");
		else if(e.getSource() == mulButton)
			inputField.setText(inputField.getText() + "*");
		else if(e.getSource() == divButton)
			inputField.setText(inputField.getText() + "/");
	}
	private String calculate(String equation) //Calculates equation
	{
		int counter = 0;
		for(int i = 0; i < equation.length(); i++)
		{
			if(equation.charAt(i) == '*' || equation.charAt(i) == '/' || equation.charAt(i) == '+' || equation.charAt(i) == '-' && i!=0)
			{
				equation = calculateOnce(equation);
				i = 0;
			}
			counter++;
		}
		return equation;
	}
	private String calculateOnce(String equation) //Calculates one step of equation (PEMDAS)
	{
		String finished = "";
		int num1;
		int num2;
		
		ArrayList<EquationOperator> listOfOperators = new ArrayList<EquationOperator>();
		
		int counter = 0;
		int startOfNum = 0;
		int endOfNum = 0;
		
		for(int i = 0; i < equation.length(); i++)
		{
			if(equation.charAt(i) == '*' || equation.charAt(i) == '/' || equation.charAt(i) == '+' || equation.charAt(i) == '-' && i!=0)
			{
				EquationOperator cur = new EquationOperator(equation.charAt(i), i, startOfNum);
				System.out.println(cur.op + ", " + cur.pos);
				listOfOperators.add(cur);
				startOfNum = i+1;
				
				if(counter != 0)
					listOfOperators.get(counter-1).numEnd = i-1;
				counter++;
			}
		}
		listOfOperators.get(listOfOperators.size()-1).numEnd = equation.length()-1;
		
		
		EquationOperator first = firstPriority(listOfOperators);
		
		System.out.println("Priority: "+first.op + ", " + first.pos);
		System.out.println("Start: "+first.numStart + " End:" + first.numEnd);
		
		num1 = Integer.parseInt(equation.substring(first.numStart, first.pos));
		num2 = Integer.parseInt(equation.substring(first.pos+1, first.numEnd+1));
		
		finished = equation.substring(0, first.numStart);
		
		switch(first.op)
		{
			case '-':
				finished += Integer.toString(num1 - num2);
				break;
			case '+':
				finished += Integer.toString(num1 + num2);
				break;
			case '/':
				finished += Integer.toString(num1 / num2);
				break;
			case '*':
				finished += Integer.toString(num1 * num2);
				break;
		}
		
		finished += equation.substring(first.numEnd+1, equation.length());
		
		JLabel equ = new JLabel(finished);
		addResults(equ);
		
		System.out.println("Done! "+finished);
		
		return finished;
	}
	private EquationOperator firstPriority(ArrayList<EquationOperator> eo)
	{
		EquationOperator saved = eo.get(0);
		
		for(int i = 1; i < eo.size(); i++)
		{
			if(comparePriority(saved.op, eo.get(i).op) == 0)
			{
				saved = eo.get(i);
			}
		}
		return saved;
	}
	private int comparePriority(char a, char b) //a compared to b
	{
		//0 = (a < b), 1 = (a > b), 2 = (a == b)
		int valueOne = 0;
		int valueTwo = 0;
		
		switch(a)
		{
			case '-':
				valueOne = 0;
				break;
			case '+':
				valueOne = 1;
				break;
			case '/':
				valueOne = 2;
				break;
			case '*':
				valueOne = 3;
				break;
		}
		
		switch(b)
		{
			case '-':
				valueTwo = 0;
				break;
			case '+':
				valueTwo = 1;
				break;
			case '/':
				valueTwo = 2;
				break;
			case '*':
				valueTwo = 3;
				break;
		}
		
		if(valueOne < valueTwo)
		{
			return 0;
		}
		else if(valueOne > valueTwo)
		{
			return 1;
		}
		else if(valueOne == valueTwo)
		{
			return 2;
		}
		return -1;
	}
	public static void main(String[]args)
	{
		Calculator c = new Calculator();
		c.startCalculator();
	}
}