import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
public class GUI {
	JFrame frame  = new JFrame("Calculator");
	JTextArea display = new JTextArea(10,20);
	String screen = display.getText();
	JPanel buttons = new JPanel();
	
	public GUI() {
		frame.setResizable(false);
		frame.setSize(400,600);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		
		buttons.setLayout(new FlowLayout());
		addButtons();
		//frame.add(buttons, BorderLayout.CENTER);
		frame.add(display, BorderLayout.NORTH);
		
		functions();
		solve();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addButtons() {
		JPanel numbers = new JPanel();
		//buttons.add(numbers);
		numbers.setLayout(new GridLayout(4,3));
		frame.add(numbers, BorderLayout.CENTER);
		
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton zero = new JButton("0");
		JButton delete = new JButton("<");
		JButton clear = new JButton("C");
		numbers.add(one);
		numbers.add(two);
		numbers.add(three);
		numbers.add(four);
		numbers.add(five);
		numbers.add(six);
		numbers.add(seven);
		numbers.add(eight);
		numbers.add(nine);
		numbers.add(delete);
		numbers.add(zero);
		numbers.add(clear);
		
		one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"1");
            	screen=display.getText();
            }
		});
		two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"2");
            	screen=display.getText();
            }
		});
		three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"3");
            	screen=display.getText();
            }
		});
		four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"4");
            	screen=display.getText();
            }
		});
		five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"5");
            	screen=display.getText();
            }
		});
		six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"6");
            	screen=display.getText();
            }
		});
		seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"7");
            	screen=display.getText();
            }
		});
		eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"8");
            	screen=display.getText();
            }
		});
		nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"9");
            	screen=display.getText();
            }
		});
		delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen.substring(0,screen.length()-1));
            	screen=display.getText();
            }
		});
		zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"0");
            	screen=display.getText();
            }
		});
		clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText("");
            	screen=display.getText();
            }
		});
		
	}
	
	public void functions() {
		JPanel functions = new JPanel();
		//buttons.add(functions);
		functions.setLayout(new GridLayout(4,1));
		frame.add(functions, BorderLayout.EAST);
		
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton divide = new JButton("/");
		JButton multiply = new JButton("X");
		
		functions.add(plus);
		functions.add(minus);
		functions.add(divide);
		functions.add(multiply);
		
		plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"+");
            	screen=display.getText();
            }
		});
		minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"-");
            	screen=display.getText();
            }
		});
		divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"/");
            	screen=display.getText();
            }
		});
		multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	display.setText(screen+"x");
            	screen=display.getText();
            }
		});
	}
	
	public void solve() {
		JButton equals = new JButton("=");
		frame.add(equals, BorderLayout.SOUTH);
		equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String done = math();
            	display.setText(done);
            	screen="";
            }
		});
	}
	
	public String math() {
		if(screen.length()>0) {
			ArrayList<String> parts = new ArrayList<String>();
			for(int i=0; i<=screen.length()-1; i++) {
				parts.add(screen.substring(i,i+1));
			}
			ArrayList<Integer> n = new ArrayList<Integer>();
			
			for(int i=0; i<parts.size(); i++) {
				try {
					 Integer.parseInt(parts.get(i));
				}
				catch (NumberFormatException e){
					n.add(i);
					/*int num = 0;
					for(int j=n.size()-1; j>0; j--) {
						num+=(n.get(j))*(Math.pow(10,n.size()-j));
					}
					
					String sym = parts.get(i);
					if(sym.equals("+")) {
						
					}
					else if(sym.equals("-")) {
						
					}
					else if(sym.equals("/")) {
						
					}
					else if(sym.equals("x")) {
						
					}
					return ""+num;*/
				}
				catch (IndexOutOfBoundsException e) {
					display.setText("ERROR");
					screen="";
				}
			}
			int num = 0;
			int num2 = 0;
			
			for(int i=0, j=n.get(0)-1; i<n.get(0); i++, j--) {
				num+=Integer.parseInt(parts.get(i)) * (Math.pow(10,j));
			}
			
			try {
				for(int i=n.get(0)+1, j=n.get(1)-1; i<=n.get(1)-1; i++, j--) {
					num2+=Integer.parseInt(parts.get(i)) * (Math.pow(10,j));
				}
			}
			catch (IndexOutOfBoundsException e) {
				for(int i=n.get(0)+1, j=parts.size()-1; i<=parts.size()-1; i++, j--) {
					num2+=Integer.parseInt(parts.get(i)); //* (Math.pow(10,j));
				}
			}
			
			String sym = parts.get(n.get(0));
			if(sym.equals("+")) {
				num+=num2;
			}
			else if(sym.equals("-")) {
				num-=num2;
			}
			else if(sym.equals("/")) {
				num=num/num2;
			}
			else if(sym.equals("x")) {
				num=num*num2;
			}
			else {
				display.setText("NO OPERATION FOUND");
			}
			
			
			return ""+num;
			
		}
		else {
			return "";
		}
	}

}
