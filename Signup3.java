package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener{

	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit , cancle;
	String formno;
	Signup3(String formno){
		this.formno=formno;
		setLayout(null);
		
		
		JLabel l1= new JLabel("page 3 :Account Details");
		l1.setFont(new Font("Railway", Font.BOLD, 22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		
		JLabel type= new JLabel("Account Type");
		type.setFont(new Font("Railway", Font.BOLD, 22));
		type.setBounds(100,140,200,40);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Railway",Font.BOLD, 15));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,150,30);
		add(r1);
		
		r2=new JRadioButton("Fixed DepositAccount");
		r2.setFont(new Font("Railway",Font.BOLD, 15));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,180,250,30);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Railway",Font.BOLD, 15));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,220,150,30);
		add(r3);
		
		r4=new JRadioButton("REcurring Deposit Account");
		r4.setFont(new Font("Railway",Font.BOLD, 15));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350,220,250,30);
		add(r4);
		
		ButtonGroup groupAccount= new ButtonGroup();
		
		groupAccount.add(r1);
		groupAccount.add(r2);

		groupAccount.add(r3);
		groupAccount.add(r4);


		
		JLabel card= new JLabel("Card Number");
		card.setFont(new Font("Railway", Font.BOLD, 22));
		card.setBounds(100,300,200,40);
		add(card);
		
		JLabel Number= new JLabel("XXXX-XXXX-XXXX-8796");
		Number.setFont(new Font("Railway", Font.BOLD, 22));
		Number.setBounds(330,300,300,40);
		add(Number);
		
		
		JLabel carddetail= new JLabel("Your 16 digit Card Number");
		carddetail.setFont(new Font("Railway", Font.BOLD, 12));
		carddetail.setBounds(100,330,200,20);
		add(carddetail);
		
		JLabel pin= new JLabel("Pin");
		pin.setFont(new Font("Railway", Font.BOLD, 22));
		pin.setBounds(100,370,200,40);
		add(pin);
		
		JLabel pindetail= new JLabel("Your 4 digit password");
		pindetail.setFont(new Font("Railway", Font.BOLD, 12));
		pindetail.setBounds(100,400,200,20);
		add(pindetail);
		
		JLabel pnumber= new JLabel("XXXX");
		pnumber.setFont(new Font("Railway", Font.BOLD, 22));
		pnumber.setBounds(330,370,300,40);
		add(pnumber);
		
		JLabel Services= new JLabel("Services Required");
		Services.setFont(new Font("Railway", Font.BOLD, 22));
		Services.setBounds(100,450,200,40);
		add(Services);
		
		
		c1= new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setBounds(100,500,200,30);
		c1.setFont(new Font("Railway",Font.BOLD,16));
		add(c1);
		
		c2= new JCheckBox("internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setBounds(350,500,200,30);
		c2.setFont(new Font("Railway",Font.BOLD,16));
		add(c2);
		
		c3= new JCheckBox("mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setBounds(100,550,200,30);
		c3.setFont(new Font("Railway",Font.BOLD,16));
		add(c3);
		
		c4= new JCheckBox("Email Alerts");
		c4.setBackground(Color.WHITE);
		c4.setBounds(350,550,200,30);
		c4.setFont(new Font("Railway",Font.BOLD,16));
		add(c4);
		
		c5= new JCheckBox("Checkbook");
		c5.setBackground(Color.WHITE);
		c5.setBounds(100,600,200,30);
		c5.setFont(new Font("Railway",Font.BOLD,16));
		add(c5);
		
		
		c6= new JCheckBox("Estatement");
		c6.setBackground(Color.WHITE);
		c6.setBounds(350,600,200,30);
		c6.setFont(new Font("Railway",Font.BOLD,16));
		add(c6);
		
		c7= new JCheckBox("I Hereby declare that the above entered details are correct ");
		c7.setBackground(Color.WHITE);
		c7.setBounds(100,680,600,30);
		c7.setFont(new Font("Railway",Font.BOLD,16));
		add(c7);
		
		submit= new JButton();
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(250, 720, 100,30);
		submit.setFont(new Font("Railway", Font.BOLD, 15));
		submit.addActionListener(this);
		add(submit);
		
		cancle= new JButton();
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setBounds(420, 720, 100,30);
		cancle.setFont(new Font("Railway", Font.BOLD, 15));
		cancle.addActionListener(this);

		add(cancle);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		
		
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Signup3("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			String accounttype= null;
			if(r1.isSelected()) {
				accounttype="saving Account";
			}
			else if(r2.isSelected()) {
				accounttype="fixed deposit";
			}
			else if(r3.isSelected()) {
				accounttype="current Account";
			}
			else if(r4.isSelected()) {
				accounttype="Reccuring Account";
			}
			
			
			Random random = new Random();
			String cardno= ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
			
			String pinno=""+Math.abs((random.nextLong()%9000L)+1000L);
			
			
			String facility ="";
			
			if(c1.isSelected()) {
				facility=facility+"ATM Card";
			}
			else if(c2.isSelected()) {
				facility=facility+"Internet Banking";
			}
			else if(c3.isSelected()) {
				facility=facility+"Mobile BAnking";
			}
			else if(c4.isSelected()) {
				facility=facility+"Email Alert";
			}
			else if(c5.isSelected()) {
				facility=facility+"Check Book";
			}
			else if(c6.isSelected()) {
				facility=facility+"E Statement";
			}
			
			try {
				if(accounttype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account type is Required");
					
					
				}
				else {
					conn conn =new conn();
					String query1= "insert into signup3 values('"+formno+"','"+accounttype+"','"+cardno+"','"+pinno+"','"+facility+"')";
					
					String query2= "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";

					
					conn.s.executeUpdate(query1);
					
       				conn.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null,"Card Number "+ cardno+ "\n pin"+ pinno);
					
					setVisible(false);
					new Deposit(pinno).setVisible(true);
				}
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
			
			
		}
		else if(e.getSource()==cancle) {
			setVisible(false);
			new Login().setVisible(true);
		
		}
	}

}
