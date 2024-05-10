package ATM;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatements extends JFrame{

	String pinno;
	MiniStatements(String pinno){
		this.pinno= pinno;
		setTitle("Mini Statements");
		setLayout(null);
		
		
		JLabel balance= new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		JLabel mini= new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank= new JLabel("Indian bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card= new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		try {
			
		
			conn con= new conn();
			ResultSet rs=con.s.executeQuery("select * from login where pin= '"+pinno+"'");
			
			while(rs.next()) {
				card.setText("Card nuber "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
			}
			
			
			
		}
		catch(Exception e) {
	
			System.out.println(e);
		}
		
		try {
			int bal=0;
			conn c= new conn();
			ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
				
				
				if(rs.getString("type").equals("Deposit")) {
					bal+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
					
				}
				
				
			}
			balance.setText("your current account balance is Rs "+ bal);
			
			
		}catch(Exception e2) {
			System.out.println(e2);
			
		}
		
		
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
 new MiniStatements("");
 

		
	}

}
