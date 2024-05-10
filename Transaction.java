package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
	JButton deposit,exit,balanceenquiry,pinchange,ministatement,FastCash,Withdraw;
	String pinno;
	Transaction(String pinno){
		this. pinno= pinno;
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text= new JLabel("please select your Transaction");
		text.setBounds(235,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Railway",Font.BOLD, 14));
		image.add(text);
		
		deposit = new JButton("DEposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		Withdraw = new JButton("Withdraw");
		Withdraw.setBounds(345,415,150,30);
		Withdraw.addActionListener(this);
		image.add(Withdraw);
		
		FastCash = new JButton("FastCash");
		FastCash.setBounds(170,450,150,30);
		FastCash.addActionListener(this);
		image.add(FastCash);
		
		ministatement = new JButton("ministatement");
		ministatement.setBounds(345,450,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("pinchange");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("balanceenquiry");
		balanceenquiry.setBounds(345,485,150,30);
		balanceenquiry.addActionListener(this);

		image.add(balanceenquiry);
		
		
		exit = new JButton("exit");
		exit.setBounds(345,525,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Transaction("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

			if (e.getSource()==exit) {
				System.exit(0);
			}
			else if(e.getSource()==deposit) {
				setVisible(false);
				new Deposit(pinno).setVisible(true);
			}
			else if(e.getSource()==Withdraw) {
				setVisible(false);
				new Withdraw(pinno).setVisible(true);
			}
			else if(e.getSource()==FastCash) {
				setVisible(false);
				new FastCash(pinno).setVisible(true);
			}
			else if(e.getSource()==pinchange) {
				setVisible(false);
				new PinChange(pinno).setVisible(true);
			}
			else if(e.getSource()==balanceenquiry) {
				setVisible(false);
				new Balanceenquiry(pinno).setVisible(true);
			}
			else if(e.getSource()==ministatement) {
				
				new MiniStatements(pinno).setVisible(true);
			}
	}

}
