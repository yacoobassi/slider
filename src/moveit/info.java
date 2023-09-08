package moveit;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class info extends JFrame  {
	
	int num;
	static int order;
	static String img;
	File file=new File("image");
	
	 
	String[] images=file.list();
	  int imagenum=0;
	  boolean normal;
		
		
	public void change_color(JLabel label) {
		  label.addMouseListener(new MouseAdapter() 
	         {
	            public void mouseEntered(MouseEvent evt) 
	            {
	            	label.setForeground(new Color(80,21,0));
	            }
	            public void mouseExited(MouseEvent evt) 
	            {
	            	label.setForeground(Color.WHITE);
	            }
	         });
		
	}	
	public void addimage(int i,JLabel image) {
     
		 ImageIcon ic = new ImageIcon("image/"+images[i]);
      
     
    	 Image scaleImag = ic.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    	 ic = new ImageIcon(scaleImag); 
         
         image.setLocation(350,470);
         image.setSize(100,100);
         image.setIcon(ic);
	}
	
	public info() {
		
		
		
		 for(int i=0;i<images.length;i++) {
			  if(images[i].equals("normal.png")) {
				  String save=images[0];
				  images[0]="normal.png";
				  images[i]=save;
			  }
		  }
	     JLabel p=new JLabel();
         p.setSize(800,800);
         
         ImageIcon	icon=new ImageIcon("g.jpg"); 
         
    	 Image scaleImage = icon.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
    	 icon = new ImageIcon(scaleImage); 
         p.setIcon(icon);
         
         JLabel label=new JLabel("Size of puzzle");
         label.setBounds(280, 100, 400,50);
         label.setForeground(Color.WHITE);
         label.setFont(new Font("Bold", Font.PLAIN, 40));
         JLabel L_arow=new JLabel("<<");
         JLabel R_arow=new JLabel(">>");
         JLabel L_arow2=new JLabel("<<");
         JLabel R_arow2=new JLabel(">>");
         JLabel image=new JLabel(); 
         JLabel text=new JLabel("3");
         JButton button =new JButton("START");
         
         
         L_arow.setSize(100,100);
         L_arow.setLocation(200,170);
         R_arow.setSize(100,100);
         R_arow.setLocation(550,170);
         
         
         L_arow2.setSize(100,100);
         L_arow2.setLocation(200,470);
         R_arow2.setSize(100,100);
         R_arow2.setLocation(550,470);
         
    	 ImageIcon ic = new ImageIcon("image/"+images[0]);
         
     
        
    	 Image scaleImag = ic.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
    	 ic = new ImageIcon(scaleImag); 
         
         image.setLocation(350,470);
         image.setSize(100,100);
         image.setIcon(ic);
         
         JLabel type=new JLabel("Type");
         
         type.setBounds(355, 370, 400,50);
         type.setForeground(Color.WHITE);
         type.setFont(new Font("Bold", Font.PLAIN, 40));
         
         text.setBounds(380, 200, 200,50);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("Bold", Font.PLAIN, 50));

         L_arow.setFont(new Font("Bold", Font.PLAIN, 40));
         L_arow.setForeground(Color.WHITE);
         R_arow.setFont(new Font("Bold", Font.PLAIN, 40));
         R_arow.setForeground(Color.WHITE);
         
         L_arow2.setFont(new Font("Bold", Font.PLAIN, 40));
         L_arow2.setForeground(Color.WHITE);
         R_arow2.setFont(new Font("Bold", Font.PLAIN, 40));
         R_arow2.setForeground(Color.WHITE);
         
         
        
         
       
         button.setSize(150,40);
         button.setLocation(330,650);
         button.setFont(new Font("Bold", Font.PLAIN, 25));
         button.setForeground(Color.WHITE);
         button.setHorizontalAlignment(JTextField.CENTER); 
         button.setBackground(new Color(80,21,0));
         button.setBorder(new LineBorder(Color.BLACK,0));
         button.setFocusPainted(false);
        
         
         button.addMouseListener(new MouseAdapter() 
         {
            public void mouseEntered(MouseEvent evt) 
            {
               button.setBackground(new Color(140,81,39));
            }
            public void mouseExited(MouseEvent evt) 
            {
               button.setBackground(new Color(80,21,0));
            }
            public void mouseClicked(MouseEvent evt) 
            {
            	try {
            		order=Integer.parseInt(text.getText());
            		img="image/"+images[imagenum];
            		if(img.equals("image/normal.png"))normal=true;
            		else normal=false;
            		new Solve_F(normal);
            		
            	
            	
		
								
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
         });
         
         
         L_arow.addMouseListener(new MouseAdapter() 
         {
            public void mouseClicked(MouseEvent evt) 
            {
            	int num=Integer.parseInt(text.getText());
            	if(num!=3)num--;
            	text.setText(num+"");
            }
          
         });
         
         R_arow.addMouseListener(new MouseAdapter() 
         {
            public void mouseClicked(MouseEvent evt) 
            {
            	int num=Integer.parseInt(text.getText());
            	num++;
            	text.setText(num+"");
            }
          
         });
         
         
         L_arow2.addMouseListener(new MouseAdapter() 
         {
            public void mouseClicked(MouseEvent evt) 
            {
           if(imagenum!=0) --imagenum;
           else imagenum=images.length-1;
           addimage(imagenum, image);
            }
          
         });
         
         R_arow2.addMouseListener(new MouseAdapter() 
         {
            public void mouseClicked(MouseEvent evt) 
            {
                if(imagenum!=images.length-1) ++imagenum;
                else imagenum=0;
                addimage(imagenum, image);

            }
          
         });
         
         
         
         change_color(L_arow2);
         change_color(R_arow2);
         change_color(L_arow);
         change_color(R_arow);

         
     
         
         


         
         
         add(button);
         add(image);
         add(L_arow);
         add(R_arow);
         add(L_arow2);
         add(R_arow2);
         add(text);
         add(type);
         add(label);
         add(p);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(800,800);
         setLocationRelativeTo(null);
         setVisible(true);
         setResizable(false);
    	 
	}
}


