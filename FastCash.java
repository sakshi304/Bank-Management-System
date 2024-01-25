/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank_Management_System;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

        @Override
        public void actionPerformed(ActionEvent ae){
            Date date=new Date();
            int balance;
           // System.out.println(number);
            if(ae.getSource()==b7){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }else {
                try{
                    String text=((JButton)ae.getSource()).getText().substring(3);
                    int number =Integer.parseInt(text);
                    Conn c1=new Conn();
                    String q1="Select Balance from bank where PIN=?";
                    PreparedStatement psmt = c1.c.prepareStatement(q1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
                    psmt.setString(1, pin);
                    ResultSet r = psmt.executeQuery();
                        
                    if(!r.next()){  // for no rows in the table
                           // System.out.println("Null che");
                            JOptionPane.showMessageDialog(null,"Account balance is Rs.0");
                            setVisible(false);
                            new Transactions(pin).setVisible(true);
                     
                        
                    }
                        
                    else{
                        r.last();
                        balance = Integer.parseInt(r.getString("Balance"));
                      if(number>balance){
                        JOptionPane.showMessageDialog(null,"Insufficient account balance");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                      }
                      else {
                       
                        int newBalance= balance-number;
                        String q2="insert into bank values(?,?,?,?,?)";
                        psmt=c1.c.prepareStatement(q2);
                        psmt.setString(1,pin);
                        psmt.setString(2,date.toString());
                        psmt.setString(3,"withdraw");
                        psmt.setString(4,number+"");
                        psmt.setString(5,newBalance+"");
                        psmt.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Cash withdrawn successfully");
                       }
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                  
                    
                                  
                  
                    
                }catch(Exception e){}
            }
        }

    public static void main(String[] args) {
        new FastCash("1233").setVisible(true);
    }
}
