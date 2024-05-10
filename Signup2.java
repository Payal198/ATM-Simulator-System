package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import com.toedter.calendar.JDateChooser;

public class Signup2 extends JFrame implements ActionListener{

	JTextField panTextField,aadharTextField;
	JComboBox religion, Category, Occupation1,Education,Income;
	JButton next;
	JRadioButton yes, no, eyes, eno;
	String formno;
	
	Signup2(String formno){
		this.formno= formno;
		
		setLayout(null);
		
		setTitle("New Account Application  FOrm : PAge 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		JLabel Religion = new JLabel("Religion");
		Religion.setFont(new Font("Raleway", Font.BOLD, 20));
		Religion.setBounds(100,140,100,30);
		add(Religion);
		
		
		String valreligion[]= {"Hindu","Muslim","sikh","other"};
		religion= new JComboBox(valreligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		
		JLabel category = new JLabel("category");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100,190,200,30);
		add(category);
		
		String valcategory[]= {"General","Sc","OBC","other"};
		Category= new JComboBox(valcategory);
		Category.setBounds(300,190,400,30);
		Category.setBackground(Color.WHITE);
		add(Category);
		
		JLabel income = new JLabel("income");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100,240,200,30);
		add(income);
		
		String valincome[]= {"Null","<1,50,000","<2,50,000","upto 5,00,000"};
		Income= new JComboBox(valincome);
		Income.setBounds(300,240,400,30);
		Income.setBackground(Color.WHITE);
		add(Income);
		
		JLabel educational = new JLabel("educational");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100,290,200,30);
		add(educational);
		

		JLabel qualification = new JLabel("qualification");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100,310,200,30);
		add(qualification);
		
		String education[]= {"non-Graduate","Graduate","Post-Graduate","Doctrate","other"};
		Education= new JComboBox(education);
		Education.setBounds(300,300,400,30);
		Education.setBackground(Color.WHITE);
		add(Education);
		
		JLabel Occupation = new JLabel("Occupation");
		Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		Occupation.setBounds(100,360,200,30);
		add(Occupation);
		
		String occupation[]= {"Salarized","Self-Employed","Businness","student","other"};
		Occupation1= new JComboBox(occupation);
		Occupation1.setBounds(300,360,400,30);
		Occupation1.setBackground(Color.WHITE);
		add(Occupation1);
		
		
		
		JLabel pan = new JLabel("Pan number");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100,420,200,30);
		add(pan);
		
		panTextField= new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		panTextField.setBounds(300,420,400,30);
		add(panTextField);
		
		
		JLabel aadhar = new JLabel("AAdhar number");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100,470,200,30);
		add(aadhar);
		
		
		aadharTextField= new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 15));
		aadharTextField.setBounds(300,470,400,30);
		add(aadharTextField);
		
		JLabel senior = new JLabel("Senior citizen");
		senior.setFont(new Font("Raleway", Font.BOLD, 20));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		
		yes= new JRadioButton("Yes");
		yes.setBounds(300,540,60,30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no= new JRadioButton("No");
		no.setBounds(450,540,120,30);
		no.setBackground(Color.WHITE);
		add(no);
		
		
		ButtonGroup seniorgroup= new ButtonGroup();
		seniorgroup.add(yes);
		seniorgroup.add(no);

		
		
		JLabel existing = new JLabel("Existing account");
		existing.setFont(new Font("Raleway", Font.BOLD, 20));
		existing.setBounds(100,590,200,30);
		add(existing);
		
		eyes= new JRadioButton("Yes");
		eyes.setBounds(300,590,60,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno= new JRadioButton("No");
		eno.setBounds(450,590,120,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		
		ButtonGroup existinggroup= new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
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
		new Signup2("");
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String sreligion= ""+religion.getSelectedItem();
		String scategory= ""+Category.getSelectedItem();
        String income=""+Income.getSelectedItem();
        String seducation=""+Education.getSelectedItem();
        String soccupation=""+Occupation1.getSelectedItem();
        
        
		String seniorcitizen=null;
		if(yes.isSelected()) {
			seniorcitizen="Yes";
		}
		else if(no.isSelected()) {
			seniorcitizen="No";
		}
		
		
		String existing=null;
		if(eyes.isSelected()) {
			existing="Yes";
		}
		else if(eno.isSelected()) {
			existing="No";
		}
		
		String pan=panTextField.getText();
		String aadhar=aadharTextField.getText();

		
		
		
		
		
		try {
			
				conn c =new conn();
				String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+income+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existing+"','"+pan+"','"+aadhar+"')";
				c.s.executeUpdate(query);
			
			setVisible(false);
			new Signup3(formno).setVisible(true);
			
		}
		catch(Exception e1) {
			System.out.println(e1);
		}

	}
}
