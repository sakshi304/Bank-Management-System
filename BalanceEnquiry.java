
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
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class BalanceEnquiry extends JFrame implements ActionListener {
        JButton b1,b2;
        
        JLabel l1;
        String pin;
    BalanceEnquiry(String pin) {

       
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        
        b1 = new JButton("BACK");
        b2 = new JButton();
        
        setLayout(null);
        
        l1.setBounds(170,280,700,35);
        l3.add(l1);
       
        
        b1.setBounds(304,449,150,35);
        l3.add(b1);
        
        b1.addActionListener(this);
    
       try{
            Conn c1=new Conn();
            String q1="Select Balance from bank where PIN=?";
            PreparedStatement psmt=c1.c.prepareStatement(q1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            psmt.setString(1, pin);
            ResultSet r = psmt.executeQuery(); 
            if(!r.next()){
                   JOptionPane.showMessageDialog(null,"Account balance is Rs.0");
                   setVisible(false);
                   new Transactions(pin).setVisible(true);
            }else{
                r.last();
                l1.setText("You account balance is : Rs."+r.getString("Balance")+"/-");
            }
       }catch(Exception ex){}
       
        setSize(800,800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }

    }
    
    public static void main(String[]args){
        new BalanceEnquiry("1033");
    }
    }
        
    

