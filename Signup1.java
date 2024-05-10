package ATM;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.*
;
public class Signup1 extends JFrame implements ActionListener{

	long random;
	JTextField nameTextField,pincodeTextField,countryTextField,stateTextField,cityTextField,addressTextField,emailTextField,fnameTextField;
	
	JButton next;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser dateChooser;
	Signup1(){
		
		setLayout(null);
		
		
		Random r= new Random();
		random= Math.abs((r.nextLong()%9000L)+1000L);
		
		
		JLabel formno = new JLabel("Application Form number "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField= new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's NAME");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField= new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser= new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(100,100,100));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		
		 male= new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female= new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		
		ButtonGroup gendergroup= new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);

		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Raleway", Font.BOLD, 20));
		Email.setBounds(100,340,200,30);
		add(Email);
		
		emailTextField= new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		JLabel Maritalstatus = new JLabel("Maritalstatus");
		Maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
		Maritalstatus.setBounds(100,390,200,30);
		add(Maritalstatus);
		
		married= new JRadioButton("married");
		married.setBounds(300,390,120,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		
		unmarried= new JRadioButton("unmarried");
		unmarried.setBounds(450,390,120,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		
		other= new JRadioButton("other");
		other.setBounds(620,390,120,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		
		ButtonGroup marriedgroup= new ButtonGroup();
		marriedgroup.add(other);
		marriedgroup.add(married);
		marriedgroup.add(unmarried);

		
		
		JLabel address = new JLabel("address");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField= new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		
		JLabel city = new JLabel("city");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100,490,200,30);
		add(city);
		
		
		cityTextField= new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("state");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100,540,200,30);
		add(state);
		
		
		stateTextField= new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
//		JLabel country = new JLabel("country");
//		country.setFont(new Font("Raleway", Font.BOLD, 20));
//		country.setBounds(100,590,200,30);
//		add(country);
//		
//		
//		countryTextField= new JTextField();
//		countryTextField.setFont(new Font("Raleway", Font.BOLD, 15));
//		countryTextField.setBounds(300,590,400,30);
//		add(countryTextField);
		
		JLabel pincode = new JLabel("pincode");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeTextField= new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		
		next= new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);

		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Signup1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno= ""+random;
		String name= nameTextField.getText();
		String fname= fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="FeMale";
		}
		
		String email=emailTextField.getText();
		String marrital= null;
		if(married.isSelected()) {
			marrital="Married";
		}
		else if(unmarried.isSelected()) {
			marrital="unMarried";
		}
		else if(other.isSelected()) {
			marrital="other";
		}
		
		
		String address= addressTextField.getText();
		String state= stateTextField.getText();
//		String country= countryTextField.getText();
		String city= cityTextField.getText();
		String pincode= pincodeTextField.getText();
		
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"name is required");
			}
			else {
				conn c =new conn();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+state+"','"+city+"','"+pincode+"')";
				c.s.executeUpdate(query);
				
				
				setVisible(false);
				new Signup2(formno).setVisible(true);
			
			}
		}
		catch(Exception e1) {
			System.out.println(e1);
		}

	}

}
