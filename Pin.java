/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.PreparedStatement;


public class Pin extends JFrame implements ActionListener{
        JButton b1,b2;
        JTextField t1,t2;
        JLabel l1,l2;
        String pin;
        Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("Enter New Pin");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Re-enter New Pin");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("Change PIN");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(150,280,200,35);
        l3.add(l1);
        
        t1.setBounds(290,280,164,35);
        l3.add(t1);
        
        l2.setBounds(150,350,200,35);
        l3.add(l2);
        
        t2.setBounds(290,350,164,35);
        l3.add(t2);
        
        
        
        b1.setBounds(304,410,150,35);
        l3.add(b1);
        
        b2.setBounds(304,449,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(800,800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            setVisible(false);
            new Transactions(pin).setVisible(true); 
        }
        else if(e.getSource()==b1){   // pin change for 3 tables signup,login,bank
            String x=(String)t1.getText();
            String y=(String)t2.getText();
            if(x.equals(y)){
                try{
                    String newpin=t1.getText();
               
                    Conn c1=new Conn();
   
                    String q1="Update signup3 set pin=? where pin=? ";
                    PreparedStatement psmt=c1.c.prepareStatement(q1);
                    psmt.setString(1, newpin);
                    psmt.setString(2, pin);
                    psmt.executeUpdate();
                    
                    String q2="Update login set pin=? where pin=? ";
                    psmt=c1.c.prepareStatement(q2);
                    psmt.setString(1, newpin);
                    psmt.setString(2, pin);
                    psmt.executeUpdate();
                    
                    String q3="Update bank set pin=? where pin=? ";
                    psmt=c1.c.prepareStatement(q3);
                    psmt.setString(1, newpin);
                    psmt.setString(2, pin);
                    psmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null,"Pin changed successfully" );
                    
                }catch(Exception ex){}
            }
            else{
                JOptionPane.showMessageDialog(null,"Re-entered pin does not match" );
            }

        
        }
        
    }
    public static void main(String[]args){
       new Pin("1033");
    }
}
