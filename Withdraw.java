package ATM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener{
	JTextField amount;
	JButton Withdraw,back;
	String pinno;
	Withdraw(String pinno){
		this.pinno= pinno;
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text= new JLabel("Enter the amount want to Withdraw");
		text.setFont(new Font("System", Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Railway", Font.BOLD, 22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		Withdraw = new JButton("Withdraw");
		Withdraw.setBounds(355,485,150,30);
		Withdraw.addActionListener(this);
		image.add(Withdraw);
		
		back = new JButton("back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);

		image.add(back);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Withdraw("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Withdraw) {
			String number= amount.getText();
			Date date= new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the amount you want to Withdraw");
			}else {
				try {
				conn con= new conn();
				String query= "insert into bank values('"+pinno+"', '"+date+"','Withdraw','"+number+"')";
				
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs"+number+" Withdraw successfully");
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
