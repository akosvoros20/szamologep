package szamologep_uj;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class Szamologep implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JTextField textfield2;
	JButton[] szamok = new JButton[10];
	JButton[] funkciok = new JButton[16];
	JButton plusz, minusz, osztas, szorzas, sqrt, pow, pow2, minus, fact, abs, egyx , nem2;
	JButton dec, equ, del, clr;
	JPanel panel;
	Font font = new Font("MS Mincho",Font.BOLD, 16);
	Font font2 = new Font("MS Mincho", Font.BOLD,16);
	
	
	double num1, num2, result;
	char operator;
	
	Szamologep(){
		setupGui();
	}
		
	public void setupGui() {
		
		frame = new JFrame("Számológép");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setSize(400,600);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBackground(Color.LIGHT_GRAY);
		textfield.setBounds(50, 25, 300, 25);
		textfield.setEditable(false);
		textfield.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield.setFont(font);
		
		textfield2 = new JTextField();
		textfield2.setBackground(Color.DARK_GRAY);
		textfield2.setBounds(50, 55, 300, 25);
		textfield2.setEditable(false);
		textfield2.setHorizontalAlignment(SwingConstants.RIGHT);
		textfield2.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		textfield2.setForeground(Color.WHITE);
		
		plusz = new JButton("+");
		minusz = new JButton("-");
		szorzas = new JButton("x");
		osztas = new JButton("/");
		dec = new JButton(",");
		equ = new JButton("=");
		del = new JButton("Del");
		clr = new JButton("⌫");
		sqrt = new JButton("√");
		pow = new JButton("x^y");
		pow2 = new JButton("x^2");
		minus = new JButton("+/-");
		fact = new JButton("n!");
		abs = new JButton("|x|");
		egyx = new JButton("1/X");
		nem2 = new JButton("XX");
		
		funkciok[0] = plusz;
		funkciok[1] = minusz;
		funkciok[2] = szorzas;
		funkciok[3] = osztas;
		funkciok[4] = dec;
		funkciok[5] = equ;
		funkciok[6] = del;
		funkciok[7] = clr;
		funkciok[8] = sqrt;
		funkciok[9] = pow;
		funkciok[10]= pow2;
		funkciok[11] = minus;
		funkciok[12] = fact;
		funkciok[13] = abs;
		funkciok[14] = egyx;
		funkciok[15] = nem2;
		
		for(int i=0; i<funkciok.length; i++) {
			funkciok[i].addActionListener(this);
			funkciok[i].setFocusable(false);
			funkciok[i].setBackground(Color.LIGHT_GRAY);
			funkciok[i].setBorder(new LineBorder(Color.gray));
			funkciok[i].setFont(font);
		}
		
		for(int i=0; i<szamok.length; i++) {
			szamok[i] = new JButton(String.valueOf(i));
			szamok[i].addActionListener(this);
			szamok[i].setFocusable(false);
			szamok[i].setBackground(Color.LIGHT_GRAY);
			szamok[i].setBorder(new LineBorder(Color.gray));
			szamok[i].setFont(font);
		}
		
		del.setBounds(50, 410, 145, 50);
		clr.setBounds(205,410, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(6,4,5,5));
		panel.setBackground(Color.DARK_GRAY);
		
		panel.add(fact);
		panel.add(abs);
		panel.add(egyx);
		panel.add(nem2);
		
		panel.add(pow);
		panel.add(pow2);
		panel.add(sqrt);
		panel.add(osztas);
		
		panel.add(szamok[7]);
		panel.add(szamok[8]);
		panel.add(szamok[9]);
		panel.add(plusz);
		
		panel.add(szamok[4]);
		panel.add(szamok[5]);
		panel.add(szamok[6]);
		panel.add(minusz);
		
		panel.add(szamok[1]);
		panel.add(szamok[2]);
		panel.add(szamok[3]);
		panel.add(szorzas);
		panel.add(dec);
		panel.add(szamok[0]);
		
		panel.add(equ);
		equ.setBackground(Color.orange);
		panel.add(minus);
		
		frame.add(panel);
		frame.add(del);
		del.setBackground(Color.LIGHT_GRAY);
		frame.add(clr);
		clr.setBackground(Color.LIGHT_GRAY);
		frame.add(textfield);
		frame.add(textfield2);
		frame.setVisible(true);
	}
	
	public double factorial(double num1) {
	    if (num1 <= 2) {
	        return num1;
	    }
	    return num1 * factorial(num1 - 1);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<10; i++) {
			if(e.getSource() == szamok[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()== dec) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()== plusz) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()== minusz) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()== szorzas) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()== osztas) {
			if(textfield.getText().isEmpty()) {
				textfield.setText("");
			} 
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()== sqrt) {
			if(textfield.getText().isEmpty()) {
				textfield.setText("0");
			} else {
				num1 = Double.parseDouble(textfield.getText());
				result = Math.sqrt(num1);
				textfield2.setText("sqrt("+num1+")");
				textfield.setText(String.valueOf(result));	
			}	
		}
		if(e.getSource()== fact) {
			num1 = Double.parseDouble(textfield.getText());
			result = factorial(num1);
			textfield.setText(String.valueOf(result));	
			textfield2.setText("fact("+num1+")");
		}
		if(e.getSource()== pow) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}
		if(e.getSource()== pow2) {
			num1 = Double.parseDouble(textfield.getText());
			result = Math.pow(num1,2);
			textfield.setText(String.valueOf(result));		
		}
		if(e.getSource()== egyx) {
			num1 = Double.parseDouble(textfield.getText());
			result = 1/num1;
			textfield.setText(String.valueOf(result));		
		}
		if(e.getSource()== abs) {
			num1 = Double.parseDouble(textfield.getText());
			result = Math.abs(num1);
			textfield.setText(String.valueOf(result));		
		}
		if(e.getSource()== minus) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource() == equ) {
			if(textfield.getText().isEmpty()){
				textfield.setText(String.valueOf(num1));
			} else {
				num2 =Double.parseDouble(textfield.getText());
				textfield2.setText(String.valueOf(num1)+operator+String.valueOf(num2));
			}
			
			switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					if(num2 == 0.0) {
						textfield.setText("0-val nem lehet osztani");
					}
					else {
						result = num1 / num2;
					}
					break;	
				case '^':
					result = Math.pow(num1, num2);
					break;
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource()== clr) {
			if(textfield.getText().length() > 0) {
				textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
			}
		}
		
		if(e.getSource()== del) {
			textfield.setText("");
			textfield2.setText("");
			result = 0;
			num1=0;
			num2=0;
		}
		
	}

}
