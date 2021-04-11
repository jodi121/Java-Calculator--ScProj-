package com.jodi.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Calculator {

	/*
	 * Ορισμός μεταβλητών εργασίες (υπάρχουν μεταβλητές περιττες στην 
	 * λειτουργικοτητα του προγράμματος που χρησιμοποιηθηκαν
	 *  στα αρχικα σταδια.
	 */
	private JFrame frame;
	public static String OUTPUT_SHOWING_TEXT = "";
	public static String INPUT_NUMBERSFUNCTION = "";
	public static int[] INPUT_NUMBERS = new int[999];
	public static String[] INPUT_OPERATORS = new String[999];
	public static int total = 0;
	public static String lastOperator = "";
	public static ArrayList<String> input_numbers_list = new ArrayList<String>();
	public static ArrayList<Integer> output_numbers_list = new ArrayList<Integer>();
	public static ArrayList<String> output_operators_list = new ArrayList<String>();
	public static ArrayList<String> input_operators_list = new ArrayList<String>();
	/*
	 * 
	 */
	public static HashMap<String, Integer> number_used_hashmap = new HashMap<String, Integer>();
	
	
	public static boolean operator_used = false;
	public static boolean number_used = false;
	public static int number_used_counter = 0;
	public static String[] operators = {"+", "-", "*"};
	public static JTextPane textPane_1;
	public static JLabel lblNewLabel;
	public static JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					number_used_hashmap.put("0", 0);
					number_used_hashmap.put("1", 0);
					number_used_hashmap.put("2", 0);
					number_used_hashmap.put("3", 0);
					number_used_hashmap.put("4", 0);
					number_used_hashmap.put("5", 0);
					number_used_hashmap.put("6", 0);
					number_used_hashmap.put("7", 0);
					number_used_hashmap.put("8", 0);
					number_used_hashmap.put("8", 9);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*
		 * REGEX USE TEST TO MATCH PATTERN LATER
		 */
		
		//TEST REGEX 
		
		/*
		 * Περιττος κωδικας δοκιμης μοτιβων
		 */
		// System.out.println(matchesPattern("(([0-9]{0,})([+-]?)([0-9]{0,})){0,}", "4+3+2+4+5+"));
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				/*/
				 * Περιττος κωδικας στην προσπαθεια ενταξης του πληκτρολογιου στο κομπιουτερακι
				 */
				if(arg0.getKeyCode() >= 48 && arg0.getKeyCode() <= 57)
				{
					if(number_used == false) {
						OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat(arg0.getKeyText(arg0.getKeyCode()));
						INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat(arg0.getKeyText(arg0.getKeyCode()));
						System.out.println("test: " + arg0.getKeyText(arg0.getKeyCode()));
						textPane_1.setText(OUTPUT_SHOWING_TEXT);
						}
				}
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 410, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 199, 381, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 21, 381, 20);
		frame.getContentPane().add(textPane);
		
		
		JButton button = new JButton("7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("7");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("7");
				switch (lastOperator) {
				case "+":
					 total += 7;
					break;

				case "-":
					total -= 7;
					break;
				
				case "*":
					total *= 7;
					break;
				case "":
					total = 7;
					break;
				default:
					break;
				}
				}
				
				if(operator_used == true) { operator_used = false; lblNewLabel.setText(""); }
				
				number_used = true;
				
				
				
				textPane.setText(OUTPUT_SHOWING_TEXT);
				System.out.println(total);
				
				
				
			}
		});
		button.setBounds(10, 63, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("8");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("8");
				switch (lastOperator) {
				case "+":
					 total += 8;
					break;

				case "-":
					total -= 8;
					break;
				
				case "*":
					total *= 8;
					break;
				case "":
					total = 8;
					break;
				default:
					break;
				}
				}
			
				if(operator_used == true) { operator_used = false; lblNewLabel.setText(""); }

				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
				
				
				
			}
		});
		button_1.setBounds(106, 63, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("9");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("9");
				switch (lastOperator) {
				case "+":
					 total += 9;
					break;

				case "-":
					total -= 9;
					break;
				
				case "*":
					total *= 9;
					break;
				case "":
					total = 9;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText(""); }

				number_used = true;
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_2.setBounds(205, 63, 89, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("4");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("4");
				switch (lastOperator) {
				case "+":
					 total += 4;
					break;

				case "-":
					total -= 4;
					break;
				
				case "*":
					total *= 4;
					break;
				case "":
					total = 4;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; }

				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_3.setBounds(10, 99, 89, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("5");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("5");
				switch (lastOperator) {
				case "+":
					 total += 5;
					break;

				case "-":
					total -= 5;
					break;
				
				case "*":
					total *= 5;
					break;
				case "":
					total = 5;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText(""); }
				
				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_4.setBounds(106, 99, 89, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("6");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("6");
				switch (lastOperator) {
				case "+":
					 total += 6;
					break;

				case "-":
					total -= 6;
					break;
				
				case "*":
					total *= 6;
					break;
				case "":
					total = 6;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText(""); }

				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_5.setBounds(205, 97, 89, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("1");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("1");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("1");
				switch (lastOperator) {
				case "+":
					 total += 1;
					break;

				case "-":
					total -= 1;
					break;
				
				case "*":
					total *= 1;
					break;
				case "":
					total = 1;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText("");}

				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
				
			}
		});
		button_6.setBounds(10, 133, 89, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("2");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("2");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("2");
				switch (lastOperator) {
				case "+":
					 total += 2;
					break;

				case "-":
					total -= 2;
					break;
				
				case "*":
					total *= 2;
					break;
				case "":
					total = 2;
					break;
				default:
					break;
				}

				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText("");}
				
				number_used = true;
				
								System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_7.setBounds(106, 133, 89, 23);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("3");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
				OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("3");
				INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("3");
				switch (lastOperator) {
				case "+":
					 total += 3;
					break;

				case "-":
					total -= 3;
					break;
				
				case "*":
					total *= 3;
					break;
				case "":
					total = 3;
					break;
				default:
					break;
				}
				}
				if(operator_used == true) { operator_used = false; lblNewLabel.setText("");}

				number_used = true;
				
				
				System.out.println(total);
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_8.setBounds(205, 131, 89, 23);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("+");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(operator_used == false && number_used == true) {
					OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("+");
					INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("#+#");
					number_used = false;
					operator_used = true;
					lastOperator = "+";
					
				}else {
					lblNewLabel.setText("ERROR - Αδυναμία εκτέλεσης εντολής");
				}
					
			
				
				
				

				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_9.setBounds(302, 63, 89, 23);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(operator_used == false && number_used == true) {
					OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("-");
					INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("#-#");
					number_used = false;
					operator_used = true;
					lastOperator = "-";
				
				} else {
					lblNewLabel.setText("ERROR - Αδυναμία εκτέλεσης εντολής");
					}

				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_10.setBounds(302, 99, 89, 23);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("*");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator_used == false && number_used == true) {
					OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("*");
					INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("#*#");
					number_used = false;
					operator_used = true;
					lastOperator = "*";
				
				} else {
					lblNewLabel.setText("ERROR - Αδυναμία εκτέλεσης εντολής");
				}
				
				textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_11.setBounds(302, 133, 89, 23);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("=");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator_used == false && !INPUT_NUMBERSFUNCTION.endsWith("+") 
						&& !INPUT_NUMBERSFUNCTION.endsWith("-") 
						&& !INPUT_NUMBERSFUNCTION.endsWith("*"))
				{
					textPane.setText(total + "");
			
				} else {
					textPane.setText("ERROR");
				}
			}
		});
		button_12.setBounds(302, 165, 89, 23);
		frame.getContentPane().add(button_12);
		
		JButton button_14 = new JButton("0");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(number_used == false) {
					OUTPUT_SHOWING_TEXT = OUTPUT_SHOWING_TEXT.concat("0");
					INPUT_NUMBERSFUNCTION = INPUT_NUMBERSFUNCTION.concat("0");
					switch (lastOperator) {
					case "+":
						 total += 0;
						break;

					case "-":
						total -= 0;
						break;
					
					case "*":
						total *= 0;
						break;
					case "":
						total = 0;
						break;
					default:
						break;
					}
					}
					if(operator_used == true) { operator_used = false; textPane_1.setText("");}

					number_used = true;
					
					
					System.out.println(total);
					textPane.setText(OUTPUT_SHOWING_TEXT);
			}
		});
		button_14.setBounds(10, 165, 185, 23);
		frame.getContentPane().add(button_14);
		
		JButton btnNewButton = new JButton("CE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OUTPUT_SHOWING_TEXT = "";
				INPUT_NUMBERSFUNCTION = "";
				total = 0;
				input_numbers_list.clear();
				input_operators_list.clear();
				operator_used = false;
				number_used = false;
				lastOperator = "";
				number_used_counter = 0;
				
				

				textPane.setText("");
				lblNewLabel.setText("");
			}
		});
		btnNewButton.setBounds(205, 165, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		/*
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		textPane_1.setEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setBounds(10, 192, 381, 20);
		frame.getContentPane().add(textPane_1);
		
		*/
		
		
	}
	
	public static boolean matchesPattern(String pattern, String check)
	{
		boolean something;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(check);
		
		something = m.matches();
		
		
		return something;
		
	}
	
	public static String result(String INPUT_NUMBERS)
	{
		String res;
		String input = OUTPUT_SHOWING_TEXT;
		StringBuilder numberStr = new StringBuilder();
		StringBuilder operatorStr = new StringBuilder();
		int total = 0;
		
		for(int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if(c != '+' && c != '-' && c != '*')
			{
				input_numbers_list.add("" + c);
				output_numbers_list.add(Integer.parseInt("" + c));
		//		Calculator.INPUT_NUMBERS[i] = Integer.parseInt(c + "");
			} else {
				input_operators_list.add("" + c);
				output_operators_list.add("" + c);
				
		//		INPUT_OPERATORS[i] = "" + c;
			}
			
			
		}
		
		
		for(int i : Calculator.INPUT_NUMBERS)
		{
			System.out.println();
		}
		
		for(String s : INPUT_OPERATORS)
		{
			System.out.print("\n" + s);
		}		
		
		return output_operators_list.toString() + " KAI " + output_numbers_list.toString() + " -- " + OUTPUT_SHOWING_TEXT;
		
	}
}
