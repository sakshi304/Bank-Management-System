
package Bank_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener  {


        JButton b1,b2,b3;
        JTextField t1,t2;
        JLabel l1,l2,l3;
        String pin;
        Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("Enter amount you want to withdraw");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("Withdraw");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(170,280,700,35);
        l3.add(l1);
        
        t1.setBounds(150,315,300,35);
        l3.add(t1);
        
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
        public void actionPerformed(ActionEvent ae){
            Date date=new Date();
            int balance=0;
           // System.out.println(number);
            if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }else if(ae.getSource()==b1){
                try{
                    int number =Integer.parseInt(t1.getText());
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
        public static void main(String[]args){
          new Withdrawl("1033");
    }
    }
        


