
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

public class Deposit extends JFrame implements ActionListener  {


        JButton b1,b2;
        JTextField t1,t2;
        JLabel l1;
        String pin;
        Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("Enter amount you want to deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
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
            int balance;
            int newBalance;
            if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }else if(ae.getSource()==b1){
                if(((t1.getText()).equals(""))){
                    JOptionPane.showMessageDialog(null,"Enter the amount");
                }
                else{
                try{
                    int number =Integer.parseInt(t1.getText());
                    Conn c1=new Conn();
                     
                    String q1="Select Balance from bank where PIN=?";
                    PreparedStatement psmt = c1.c.prepareStatement(q1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
                   //the parameter of prepared statment contains typescoll insensitive inorder to use r.last() or r.previous() since without this it was exception : resultset can only go in forward direction
                    psmt.setString(1, pin);
                    System.out.println("hello");
                    ResultSet r = psmt.executeQuery();
                    
                    if(!r.next()){
                        
                        newBalance=number;
                    }else{
                         r.last();
                         balance = Integer.parseInt(r.getString("Balance"));
                         newBalance= balance+number;
                    }
                   
 
                    String q2 = "insert into bank values(?, ?, ?, ?, ?)";
                    psmt = c1.c.prepareStatement(q2);   //c is the connection object
                    psmt.setString(1, pin);
                    psmt.setString(2,date.toString());
                    psmt.setString(3, "deposit");
                    psmt.setString(4,number+"");
                    psmt.setString(5,newBalance+"");
                    psmt.executeUpdate();
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                    
                }catch(Exception e){System.out.println(e);}
            }
           }
        }
        public static void main(String[]args){
          new Deposit("1033");
    }
    }
        


