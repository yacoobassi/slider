


package moveit;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mastaer Save
 */
public class Solve_F extends JFrame implements KeyListener {
	 boolean running;
   
	 static boolean close;
	 solve s;
	 
	
	private BufferedImage getScaledImage(Image srcImg, int w, int h){

	    //Create a new image with good size that contains or might contain arbitrary alpha values between and including 0.0 and 1.0.
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);

	    //Create a device-independant object to draw the resized image
	    Graphics2D g2 = resizedImg.createGraphics();

	    //This could be changed, Cf. http://stackoverflow.com/documentation/java/5482/creating-images-programmatically/19498/specifying-image-rendering-quality
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

	    //Finally draw the source image in the Graphics2D with the desired size.
	    g2.drawImage(srcImg, 0, 0, w, h, null);

	    //Disposes of this graphics context and releases any system resources that it is using
	    g2.dispose();

	    //Return the image used to create the Graphics2D 
	    return resizedImg;
	}



   public Solve_F(boolean normal) throws IOException
   {
	 
   close=false;
   s=new solve();
	  s.order =info.order;
     s.array=new JLabel[s.order][s.order];
	 int w= 800/s.order;
	 int count=0;
     JPanel p=new JPanel();
     p.setLayout(new GridLayout(s.order,s.order));
	 JLabel lab;
	 s.array=new JLabel[s.order][s.order];


  
	 
	 ImageIcon icon = new ImageIcon("front.png"); 
	 ImageIcon icon1 = new ImageIcon("ground.png"); 
	
	 BufferedImage img = getScaledImage(ImageIO.read(new File(info.img)), 800, 800);
     BufferedImage image;
	 
	Image scaleImage = icon.getImage().getScaledInstance(w, w,Image.SCALE_DEFAULT);
	 Image scaleImage1 = icon1.getImage().getScaledInstance(w, w,Image.SCALE_DEFAULT);
    icon = new ImageIcon(scaleImage); 
     icon1 = new ImageIcon(scaleImage1); 
     
	 for(int i=0;i<s.order;i++) {
		 for(int j=0;j<s.order;j++) {
			
				if(i==j&&j==s.order-1)break;
				if(!normal) { 
					image=   img.getSubimage(j*img.getWidth()/s.order, i*img.getHeight()/s.order, 
				    img.getWidth()/s.order,img.getHeight()/s.order );
				icon=new ImageIcon(image); 
				}
			     lab=new JLabel();
			     lab.setIcon(icon);
			     lab.setText(String.valueOf(++count));
			     lab.setForeground(new Color(140,81,39));
			     lab.setFont(new Font("Serif", Font.PLAIN, 360/s.order));
			     lab.setHorizontalTextPosition(SwingConstants.CENTER);
		         lab.setVerticalTextPosition(SwingConstants.CENTER);
		         lab.setLocation(j*w,i*w);
			   	 lab.setSize(w, w);	
if(!normal)lab.setFont(new java.awt.Font("Lucida Grande", 1, 0));
				 this.add(lab);
				s. array[j][i]=lab;
				 setResizable(false);			
	  }
	 }
	 
	 
	 s.array[s.order-1][s.order-1]=new JLabel();
	s.array[s.order-1][s.order-1].setText("0");
	lab=new JLabel();
	add(lab);
 
	

    for(int i=0;i<s.order*s.order;i++) {
   	 lab=new JLabel();
   	 lab.setSize(w, w);	
   	   lab.setIcon(icon1);
		  p.add(lab);
    }
	 
   
   
    add(p);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );	
    pack();
    addKeyListener(this);
    setLocationRelativeTo(null);
    
  new Thread(new Runnable() {
	
	@Override
	public void run() {
		
	     setVisible(true);
	    	
	}
}).start();
	 
new Thread(new Runnable() {
		
	@Override
	public void run() {
		
		s.Rand();
	   s.sort();
	    	
	}

}).start();
	    	

	


   
  
  
   
	 
   }
   
  

	
    
   
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_D&&s.speed!=800/s.order) s.speed++;
	else if(e.getKeyCode() == KeyEvent.VK_S&&s.speed!=1)s.speed--; 	
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
