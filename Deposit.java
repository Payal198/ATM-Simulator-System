package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton deposit,back;
	String pinno;
	Deposit(String pinno){
		this.pinno= pinno;
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text= new JLabel("Enter the amount want to Deposit");
		text.setFont(new Font("System", Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Railway", Font.BOLD, 22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355,485,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);

		image.add(back);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Deposit("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==deposit) {
			String number= amount.getText();
			Date date= new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the amount you want to deposit");
			}else {
				try {
				conn con= new conn();
				String query= "insert into bank values('"+pinno+"', '"+date+"','Deposit','"+number+"')";
				
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs"+number+" Deposited successfully");
					setVisible(false);
					new Transaction(pinno).setVisible(true);
				}catch(Exception e1) {
					System.out.println(e1);
					// TODO Auto-generated catch block
					}
				
			}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}
	}

}
