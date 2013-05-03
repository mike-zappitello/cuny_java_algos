/*
//CS 212 Homework 3 - GUI Binary addition machine
//@author		Mike Zappitello
//@lastUpdate	18 Oct 2012
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui extends JFrame implements ActionListener {

	private JButton b0;
	private JButton b1;	
	private JButton bPlus;
	private JButton bClr;
	private JButton bEql;
	
	private JLabel lblNumber1;
	private JLabel lblNumber2;
	private JLabel lblSum;
	private JLabel plusSign;
	private JLabel equalSign;
	
	private boolean add;
	private boolean equals;
	
	public Gui() {
		init();
	}
	
	public String sum(String num1, String num2){
		while(num1.length() != num2.length()){
			if(num1.length()<num2.length()){
				num1 = 0 + num1;
			}
			else{
				num2 = 0 + num2;
			}
		}
		
		int length = num1.length();
		int digit1;
		int digit2;
		
		int cary = 0;
		int returnDigit = 0;
		String returnString = "";
		
		for(int n=0; n<length; n++){
			digit1 = Character.getNumericValue(num1.charAt(length-n-1));
			digit2 = Character.getNumericValue(num2.charAt(length-n-1));
			if(digit1+digit2+cary == 0){
				cary = 0;
				returnDigit = 0;
			}
			else if(digit1+digit2+cary == 1){
				cary = 0;
				returnDigit = 1;
			}
			else if(digit1+digit2+cary == 2){
				cary = 1;
				returnDigit = 0;
			}
			else if(digit1+digit2+cary == 3){
				cary = 1;
				returnDigit = 1;
			}
			returnString = returnDigit + returnString;
		}
		if(cary!=0){
			returnString = cary + returnString;
		}
		return returnString;
	}
	
	private void init() {

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		lblNumber1 = new JLabel();
		lblNumber2 = new JLabel();
		lblSum = new JLabel();
		
		plusSign = new JLabel();
		equalSign = new JLabel();
		
		add = false;
		equals = false;
		
		setLayout(new BorderLayout());
		
		add(panel1,BorderLayout.NORTH);
		add(panel3,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
		panel1.setLayout(new FlowLayout());
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		bPlus = new JButton("+");
		bClr = new JButton("clr");
		bEql = new JButton("=");
		
		panel1.add(b0);
		panel1.add(b1);
		
		panel3.add(bPlus);
		panel3.add(bClr);
		panel3.add(bEql);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		bPlus.addActionListener(this);
		bClr.addActionListener(this);
		bEql.addActionListener(this);
		
		panel2.add(lblNumber1);
		panel2.add(plusSign);
		panel2.add(lblNumber2);
		panel2.add(equalSign);
		panel2.add(lblSum);

		setSize(300, 200);
		setVisible(true);
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b0){
			if(!add){
				lblNumber1.setText(lblNumber1.getText()+"0");
			}
			else if(!equals){
				lblNumber2.setText(lblNumber2.getText()+"0");
			}
			else{
				//do nothing?
			}
		}
		else if (e.getSource() == b1){
			if(!add){
				lblNumber1.setText(lblNumber1.getText()+"1");
			}
			else if(!equals){
				lblNumber2.setText(lblNumber2.getText()+"1");
			}
			else{
				//do nothing?
			}
		}
		else if (e.getSource() == bPlus){
			//a second add should change number1 to the sum and let you input number3?
			if(!add){
				add = true;
				plusSign.setText("+");
			}
			if(equals){
				lblNumber1.setText(lblSum.getText());
				lblNumber2.setText("");
				lblSum.setText("");
				equalSign.setText("");
				equals = false;
			}
		}
		else if (e.getSource() == bClr){
			if(!add){
				lblNumber1.setText("");
			}
			else if(!equals){
				lblNumber2.setText("");
			}
			else{
				lblNumber1.setText("");
				lblNumber2.setText("");
				lblSum.setText("");
				plusSign.setText("");
				equalSign.setText("");
				add = false;
				equals = false;
			}
		}
		else if (e.getSource() == bEql){
			if(!add){
			}
			else if(add && !equals){
				equals = true;
				equalSign.setText("=");
				lblSum.setText(sum(lblNumber1.getText(), lblNumber2.getText()));
			}
			else if(add  && equals){
				lblNumber1.setText(lblSum.getText());
				lblSum.setText(sum(lblNumber1.getText(), lblNumber2.getText()));
			}
		}
	}

}
