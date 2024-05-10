package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	
	JButton change,back;
	JPasswordField pin,repintext;
	String pinno;
	PinChange(String pinno){
		this.pinno= pinno;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text= new JLabel("Change your pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Railway", Font.BOLD, 16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pinchange= new JLabel("New pin");
		pinchange.setForeground(Color.WHITE);
		pinchange.setFont(new Font("Railway", Font.BOLD, 16));
		pinchange.setBounds(165,320,180,25);
		image.add(pinchange);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Railway",Font.BOLD, 25));
		pin.setBounds(330, 320, 180, 25);
		image.add(pin);
		
		
		JLabel repin= new JLabel("Re-Enter Pin");
		repin.setForeground(Color.WHITE);
		repin.setFont(new Font("Railway", Font.BOLD, 16));
		repin.setBounds(165,360,180,25);
		image.add(repin);
		
		repintext = new JPasswordField();
		repintext.setFont(new Font("Railway",Font.BOLD, 25));
		repintext.setBounds(330, 360, 180, 25);
		image.add(repintext);
		
		
		change= new JButton("Change");
		change.setBounds(355,485, 150,30);
		change.addActionListener(this);
		image.add(change);
		
		
	    back= new JButton("Back");
		back.setBounds(355,520, 150,30);
		back.addActionListener(this);

		image.add(back);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("").setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==change) {
		
		try {
			
			String newpin= pin.getText();
			String rpin= repintext.getText();
			
			if(!newpin.equals(rpin)) {
				JOptionPane.showMessageDialog(null,"Enterd pin does not match");
				return;
			}
			if(newpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please ENter new pin");
				return;

			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please re-Enter new pin");
				return;

			}
			
			conn con= new conn();
			String query1= "update bank set pin='"+rpin+"' where pin='"+pinno+"'";
			String query2= "update login set pin='"+rpin+"' where pin='"+pinno+"'";
			String query3= "update signup3 set pin='"+rpin+"' where pin='"+pinno+"'";
			
			
			
			con.s.executeUpdate(query1);
			
			con.s.executeUpdate(query2);

			con.s.executeUpdate(query3);

			JOptionPane.showMessageDialog(null,"Pin change successfully");

			setVisible(false);
			new Transaction(rpin).setVisible(true);

		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		
		}else {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}
	}

}
