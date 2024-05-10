package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class Balanceenquiry extends JFrame implements ActionListener {
	
	JButton back ;
	String pinno;
	Balanceenquiry(String pinno){
		this.pinno= pinno;
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		
		JLabel image= new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back =new JButton("Back");
		back.setBounds(350,520,150,30);
		back.addActionListener(this);
		image.add(back);
		int balance=0;
		
		try {
			conn c = new conn();
			ResultSet rs= c.s.executeQuery("select * from bank where pin= '"+pinno+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
					
				}
			}}
		catch(Exception e1) {
			System.out.println(e1);
		}
			
		
		JLabel text= new JLabel("your current Account balance is "+ balance);
		
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);		
	}
	public static void main(String[] args) {


		new Balanceenquiry("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new Transaction(pinno).setVisible(true);
		
	}

}
