
package Bank_Management_System;

import java.awt.Font;
//import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.util.Random;
import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//-----------NOTE : YOU cannot truncate a table whose primary key is used as foreign key in oter table but you can use delete from table_nameq2 
public class SignupOne extends JFrame implements ActionListener {
        Random ran=new Random();
        int rand=Math.abs(ran.nextInt()%9000)+100;
        JTextField nam, fnam,eml,city,addr,stat,pincode;
       // JDateChooser date;
        JRadioButton r1,r2,r3,r4;
        JButton b;
        JDateChooser d;
        
        SignupOne(){
            
//        ImageIcon i1 = new ImageIcon(("D:\\Java_netbeans_project\\Bank Mangement System\\src\\icons\\logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l11 = new JLabel(i3);
//        l11.setBounds(20, 0, 100, 100);
//        add(l11);
        setTitle("NEW ACCOUNT APPLICATION FORM");
        JLabel title=new JLabel("APPLICATION FORM NO."+rand);
        title.setBounds(200,40,800,50);
        title.setFont(new Font("Raleway",Font.BOLD,30));
        add(title);
        
        System.out.println(rand);
        JLabel page=new JLabel("Page 1: Personal Details");
        page.setBounds(280,110,400,25);
        page.setFont(new Font("Raleway",Font.BOLD,23));
        add(page);
        
        JLabel name=new JLabel("Name: ");
        name.setBounds(150,160,100,30);
        name.setFont(new Font("Ariel",Font.BOLD,20));
        add(name);
        
        nam=new JTextField(20);
        nam.setBounds(350,160,320,30);
        nam.setFont(new Font("Areil",Font.PLAIN,20));
        add(nam);
        
        
        
        JLabel fname=new JLabel("Father's Name: ");
        fname.setBounds(150,220,150,30);
        fname.setFont(new Font("Ariel",Font.BOLD,20));
        add(fname);
        
        fnam=new JTextField(20);
        fnam.setBounds(350,220,320,30);
        fnam.setFont(new Font("Ariel",Font.PLAIN,20));
        add(fnam);
        
        JLabel dob=new JLabel("Date of Birth: ");
        dob.setBounds(150,280,150,30);
        dob.setFont(new Font("Ariel",Font.BOLD,20));
        add(dob);
        
        d=new JDateChooser();
        d.setBounds(350,280,320,30);
       // d.setForeground(Color.black);
        add(d);
        
        JLabel gender=new JLabel("Gender: ");
        gender.setBounds(150,340,100,30);
        gender.setFont(new Font("Ariel",Font.BOLD,20));
        add(gender);
        
        r1=new JRadioButton("Male");
        r1.setBounds(350,340,100,30);
        r1.setFont(new Font("Ariel",Font.BOLD,15));
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(450,340,100,30);
        r2.setFont(new Font("Ariel",Font.BOLD,15));
        add(r2);
        
        ButtonGroup groupgender= new ButtonGroup();     // a buttongroup is made so that at a time only one radiobut is selected
        groupgender.add(r1);
        groupgender.add(r2);
        
        JLabel email=new JLabel("Email Address: ");
        email.setBounds(150,400,150,30);
        email.setFont(new Font("Ariel",Font.BOLD,20));
        add(email);
        
        eml=new JTextField(20);
        eml.setBounds(350,400,320,30);
        eml.setFont(new Font("Ariel",Font.PLAIN,20));
        add(eml);
        
        
        
        JLabel status=new JLabel("Marital Status: ");
        status.setBounds(150,460,150,30);
        status.setFont(new Font("Ariel",Font.BOLD,20));
        add(status);
        
        r3=new JRadioButton("Married");
        r3.setBounds(350,460,100,30);
        r3.setFont(new Font("Ariel",Font.BOLD,15));
        add(r3);
        
        r4=new JRadioButton("Unmarried");
        r4.setBounds(450,460,120,30);
        r4.setFont(new Font("Ariel",Font.BOLD,15));
        add(r4);
        
        ButtonGroup groupmarry= new ButtonGroup();     // a buttongroup is made so that at a time only one radiobut is selected
        groupmarry.add(r3);
        groupmarry.add(r4);
  
        
        JLabel addrr=new JLabel("Address: ");
        addrr.setBounds(150,520,100,30);
        addrr.setFont(new Font("Ariel",Font.BOLD,20));
        add(addrr);
        
        addr=new JTextField(20);
        addr.setBounds(350,520,320,30);
        addr.setFont(new Font("Ariel",Font.PLAIN,20));
        add(addr);
        
        JLabel cit=new JLabel("City: ");
        cit.setBounds(150,580,100,30);
        cit.setFont(new Font("Ariel",Font.BOLD,20));
        add(cit);
        
        
        city=new JTextField(20);
        city.setBounds(350,580,320,30);
        city.setFont(new Font("Ariel",Font.PLAIN,20));
        add(city);
        
        JLabel state=new JLabel("State: ");
        state.setBounds(150,640,100,30);
        state.setFont(new Font("Ariel",Font.BOLD,20));
        add(state);
        
        stat=new JTextField(20);
        stat.setBounds(350,640,320,30);
        stat.setFont(new Font("Ariel",Font.PLAIN,20));
        add(stat);
        
        
        JLabel pin=new JLabel("Pin Code: ");
        pin.setBounds(150,700,100,30);
        pin.setFont(new Font("Ariel",Font.BOLD,20));
        add(pin);
        
        pincode=new JTextField(20);
        pincode.setBounds(350,700,320,30);
        pincode.setFont(new Font("Ariel",Font.PLAIN,20));
        add(pincode);
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(550,750,120,30);
        add(b);
        b.addActionListener(this);
        
        setLayout(null);
        setSize(850,830);
        setLocation(250,10);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
        
        @Override
    public void actionPerformed(ActionEvent e) {
               // JTextField nam, fnam,eml,city,addr,stat,pincode;
        int formno=rand;
        String name= nam.getText();
        String fname=fnam.getText();
        String email=eml.getText();
        String cit=city.getText();
        String add=addr.getText();
        String state=stat.getText();
        String pin=pincode.getText();
        String dob=((JTextField)d.getDateEditor().getUiComponent()).getText();    // d is my JDateChooser object
        
        String gender=null;
        if(r1.isSelected()){
                gender=r1.getText();
                        

        }else{gender=r2.getText();}
        
        String marital=null;
        if(r3.isSelected()){marital=r3.getText();}
        else{marital=r4.getText();}
                
        System.out.println(dob);
          try{
           
            if(fnam.getText().equals("")||nam.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup values("+formno+",'"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+add+"','"+cit+"','"+pin+"','"+state+"')";
                c1.s.executeUpdate(q1);
                
                new SignupTwo(formno).setVisible(true);
                setVisible(false);
                c1.s.closeOnCompletion();
                
            }
            
        }catch(Exception en){
             en.printStackTrace();
        }
        
    }
        
     // psvm is made hide since this class is been called by login.java ....comment out this when  you just want to test this java file only
//   public static void main(String[]args){
//        new SignupOne();
//   }


}
