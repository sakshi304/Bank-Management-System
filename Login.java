
package Bank_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Login extends JFrame implements ActionListener{
    
    JButton clear,signup,login;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        ImageIcon i1=new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\logo.jpg");
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);   // to scale the image in the prefered size
        ImageIcon i3=new ImageIcon(i2);   // AS i2 cannot be given to the label
        JLabel label=new JLabel(i3);  
        label.setBounds(70, 10, 100, 100);
       
        JLabel wel=new JLabel("Welcome to the ATM");
        wel.setFont(new Font("Osward",Font.BOLD,38));
        wel.setBounds(200, 40, 400, 40);
        
        JLabel cardno=new JLabel("Card No : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 400, 38);
        add(cardno);
        
         cardTextField=new JTextField();
        cardTextField.setBounds(300,155,230,30);
        cardTextField.setFont(new Font("Ariel",Font.PLAIN,14));
        add(cardTextField);
        
        
        JLabel pin=new JLabel("Pin : ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 400, 38);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,225,230,30);
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);

        
        clear=new JButton("clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.addActionListener(this);
        
        signup=new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        add(signup);
        signup.addActionListener(this);
        
        add(wel);
        add(label);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setLocation(350,200);
        setVisible(true);
        setSize(800,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
       @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource()==login){
              
        }else if(e.getSource()==signup){
                setVisible(false);
                new SignupOne().setVisible(true);
        }
       
    }
    public static void main(String[]args){
       new Login();
        
    }

 
    
}
