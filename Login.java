package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton login, signup, clear;
	JTextField  cardTextField ;
	JPasswordField pinTextField ;
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100,100);
		
		add(label);// frame ke uper icon/label
		
		
		JLabel text= new JLabel("welcome to ATM");
		text.setBounds(200,40,400,40);
		text.setFont(new Font ("osward",Font.BOLD, 38));
		add(text);
		
		JLabel cardno= new JLabel("card number");
		cardno.setBounds(120,150,200,40);
		cardno.setFont(new Font ("osward",Font.BOLD, 28));
		add(cardno);
		

		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		JLabel pin= new JLabel("pin");
		pin.setBounds(120,220,250,30);
		pin.setFont(new Font ("osward",Font.BOLD, 28));
		add(pin);
		

		 pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));

		add(pinTextField);
		
		
		login =new JButton("Sign in");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear =new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.white);
		clear.addActionListener(this);

		add(clear);


		signup =new JButton("Sign up");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.white);
		signup.addActionListener(this);

		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480); //frame created
		setVisible(true); // frame view
		setLocation(350,200); // defalult location istop left
		
	}
	public static void main(String[] args) {
		
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");

		}
		else if(e.getSource()==login) {
			conn conn =new conn();
			String cardno=cardTextField.getText();
			String pinno= pinTextField.getText();
			String query= "select * from login where cardno ='"+cardno+"' and pin ='"+pinno+"'";
			
			try {
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transaction(pinno).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect card number");
				}
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
			
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new Signup1().setVisible(true);
		}
	}

}
