package ATM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	JButton deposit,exit,balanceenquiry,pinchange,ministatement,fastcash,Withdraw;
	String pinno;
	FastCash(String pinno){
		this. pinno= pinno;
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text= new JLabel("Select WIthdrawel amount");
		text.setBounds(235,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Railway",Font.BOLD, 14));
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		Withdraw = new JButton("Rs 500");
		Withdraw.setBounds(345,415,150,30);
		Withdraw.addActionListener(this);
		image.add(Withdraw);
		
		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Rs 2000");
		ministatement.setBounds(345,450,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Rs 10000");
		balanceenquiry.setBounds(345,485,150,30);
		balanceenquiry.addActionListener(this);

		image.add(balanceenquiry);
		
		
		exit = new JButton("back");
		exit.setBounds(345,525,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new FastCash("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

			if (e.getSource()==exit) {

				setVisible(false);
				new Transaction(pinno).setVisible(true);
			}
			else  {
				String amount = ((JButton)e.getSource()).getText().substring(3);
				try {
				conn c = new conn();
				ResultSet rs= c.s.executeQuery("select * from bank where pin= '"+pinno+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+= Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
						
					}
				}
				if(e.getSource()!= exit && balance <Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null,"Insufficient balance");
					return;
				}
				
				Date date = new Date();
				String query="insert into bank values ('"+pinno+"','"+date+"','Withdraw','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"RS"+amount +"Debited successfully");
				
				setVisible(false);
				new Transaction(pinno).setVisible(true);
				
				
				
				
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
				}
			
	}

}
