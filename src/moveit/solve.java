package moveit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;

public  class solve {

	static String save;
	 int order;
	 int speed;
   public  Integer linz,colz,linum,colnum;
    JLabel array[][];
	   int lint = 0;
       int colt = 0;
  
	
      
      
      
public solve() {
    	 speed=1; 
		
	}	
public  boolean isSolvable(int arr[]) {
   int countInversions = 0;
		 for (int i = 0; i < order*order-1; i++) {
		    for (int j = 0; j < i; j++) {
		            if (arr[j] > arr[i]) {
		                countInversions++;
		            }
		        }
		    }
		    return countInversions % 2 == 0;
		}
public  void mov(JLabel array[][],int x,int y,int n) {	
	JLabel save;

int i=0;
 	while( i<800/n) {
 		i++;
 		
		array[colz+y][linz+x].setLocation(array[colz+y][linz+x].getLocation().x-y,array[colz+y][linz+x].getLocation().y-x);
				
				try {
			          if(i%speed==0) Thread.sleep(1);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
 	save=array[colz][linz];
	array[colz][linz]=array[colz+y][linz+x];
	array[colz+y][linz+x]=save;
	linz+=x;colz+=y; 
	
	if(linz==linum&&colz==colnum) {linum-=x;colnum-=y;}

	
 }
public  void PutTrue(int num,int d) {

	if(colnum<colt)d=1;
	 if(colnum>colt)d=-1;
	 
	 if(colt!=colnum) {
	 if(colnum-colz==d) mov(array,0,d,order);
		if(colz==colnum) mov(array,0,d,order);
		
	 if(linz!=linum)	 mov(array,-1,0,order);
	 	 mov(array,0,d*-1,order);
	 	if(colnum!=colt||colz<colnum) mov(array,1,0,order);
	 }
	 
	 if(colnum==colt) {
		 if(num%order==0) {
			
			 while(colz!=colnum-2) mov(array,0,-1,order);
			 while(linz!=linum-1)mov(array,-1,0,order);
			 while(colz!=colnum)mov(array,0,1,order);
			 mov(array,1,0,order);
			 mov(array,0,-1,order);
			 mov(array,-1,0,order);
			 mov(array,0,-1,order);
			 mov(array,1,0,order);
			 lint=linum;
			 return;

		 }
		
		if(colnum<=colt&&colz<colnum&&linz==linum)mov(array,1,0,order);
		 while(colz!=colnum+1) mov(array,0,1,order);
	 	 while(linz!=lint)mov(array,-1,0,order);
	 	 mov(array,0,-1,order);
	 	mov(array,1,0,order);
	 
         return;
	 }
	
}
public  void Sameline(int num,int d,boolean pluse) {

	if(lint==order-2)pluse=false;	
	if(colnum<colt)d=1;
	else d=-1;
	
	if(lint==order-2&&num(colt,lint) == num+order &&
			          num(colt-1,lint)== num && num<order*order-order) {
		while(linz!=order-1)mov(array,1,0,order);
		while(colz!=colt-1)mov(array,0,-1,order);
		mov(array,-1,0,order);
		mov(array,0,1,order);
		mov(array,1,0,order);
	}
	else {
		
			   while(linz>linum+1)mov(array,-1,0,order);
			if(colz-colnum!=1&&colz-colnum!=-1) while(linz<linum+1)   mov(array,1,0,order);
			   while(colz>colnum+1)mov(array,0,-1,order);
			   while(colz<colnum-1)mov(array,0,1,order);
			   while(colnum!=colt) {
				while(colz!=colnum+d)   mov(array,0,d,order);
			 if(linz>linum)  mov(array,-1,0,order);
				   mov(array,0,d*-1,order);
				 if(colnum!=colt||linum==lint&&colnum==colt&&num<order*order-order)  mov(array,1,0,order);
				   
				   
			   }
				  
			   }
			   
}
public  void Findnum(int num ) {

	 for (int x = 0; x < order; x++) 
         for (int y = 0; y < order; y++) {
        	 if(Integer.parseInt(array[y][x].getText()) == 0) {
       	      linz=x;
       		  colz=y;
        	 }
        	
        	 if(Integer.parseInt(array[y][x].getText()) == num ) {
	       	      linum=x;
	       		  colnum=y;
	        	 }
        
        
   } 
 }
public  void PreLine(int num,int d) {

	if(colnum==order-1)d=-1;
	   else d=1;
	
	   
		 if(num%order!=0&&linum==lint)return;  
	   
	   while(linz+1>linum) {
		   mov(array,-1,0,order);}
	   while(linz+1<linum)mov(array,1,0,order);
	     while(colz>colnum)mov(array,0,-1,order);
	     while(colz<colnum)mov(array,0,1,order);
	    
	    	if(linz!=order-1) mov(array,1,0,order);
if(linum==lint+1&&num%order!=0)return;
	    	 mov(array,0,d,order); 	
   
if(colz<colnum)d=1;
if(colz>colnum)d=-1;
while(linz!=linum+1) {
	if(linz>linum)mov(array,-1,0,order);
	else mov(array,1,0,order);
}


}
public  void lastcolumn() {

	while(colz!=colnum-2) mov(array,0,-1,order);
	 while(linz!=linum-1)mov(array,-1,0,order);
	 while(colz!=colnum)mov(array,0,1,order);
	 mov(array,1,0,order);
	 mov(array,0,-1,order);
	 mov(array,-1,0,order);
	 mov(array,0,-1,order);
	 mov(array,1,0,order);
	 lint=linum;
	 
 }
public  void lastline(int num) {

	int d;
	 if(linz==order-1&&lint==order-2&&num(colz,linz-1) == num+order) mov(array,0,1,order);
	 if(linz==order-1) mov(array,-1,0,order);
	 if(colz>colnum)d=-1;
		else d=1;
	 while(colz!=colnum) mov(array,0,d,order);
	 mov(array,1,0,order);
 }
public  void Ifswitch(int i,int j) {

if (order-1-i<2 && num(j,order-1) - num(j,order-2)==-1*order) {
		   
		       while(linz!=order-1)	
			       mov(array,1,0,order);
				   mov(array,0,-1,order);
				   mov(array,-1,0,order);
				   mov(array,0,1,order);
				   mov(array,1,0,order);
				   mov(array,0,1,order);
				   mov(array,-1,0,order);
				   mov(array,0,-1,order);
				   mov(array,0,-1,order);
				   mov(array,1,0,order);
				   mov(array,0,1,order);
				   mov(array,-1,0,order);
				   mov(array,0,1,order);
			   }
			  
}
public  void Ifend(int num) {

	if(num>order*order-order)return;
	
if(lint==order-2&&num(colt-1,order-2)==num+order&&
                  num(colt,order-2)==num&&num%order!=0) {
	
	if(linz!=order-1)  
		mov(array,1,0,order);
	
	while(colz!=colt-1)  
	  mov(array,0,-1,order);
	  mov(array,-1,0,order);
	  mov(array,0,1,order);
 }
}
public  void Reach() {
	while(linz>linum+1)  mov(array,-1,0,order);
	   while(linz<linum)mov(array,1,0,order);
	     while(colz>colnum+1)mov(array,0,-1,order);
	       while(colz<colnum-1)mov(array,0,1,order);
         
}
public  int num(int i,int j) {
	
 return	Integer.parseInt(array[i][j].getText());
}
public  void Rand() {
	order=info.order;
	Random	rand1=new Random();
	Random rand2=new Random();
	boolean solv=false;
	Icon Saveicon;
     int  solve[]=new int[order*order];

	while(!solv) {
		int count=0;
	 	for(int i=0;i<order*order;i++) {

			
			
			int x=rand1.nextInt(order*order);
			int y=rand2.nextInt(order*order);
			if(y==order*order-1) y--;
			if(x==order*order-1)x--;

			save=array[x/order][x%order].getText();
			Saveicon=array[x/order][x%order].getIcon();
			array[x/order][x%order].setText(array[y/order][y%order].getText());
			array[y/order][y%order].setText(save);
			array[x/order][x%order].setIcon(array[y/order][y%order].getIcon());
			array[y/order][y%order].setIcon(Saveicon);
			
		  
		  
			
	 	}
	 	
	 	for(int i=0;i<order;i++) {
	 		for(int j=0;j<order;j++) {
	 			
	 			if(i==j&&j==order-1) {
	 				solve[count]=0;break;
	 				
	 			}
	 			solve[count++]=Integer.parseInt(array[j][i].getText());
	 			
	 			
	 		
	 		}
	 	}

		

	solv=isSolvable(solve);

		}
}
public  void sort() {
	  int num = 0,d=0;    
	  speed=1;
    boolean pluse=false,ret=false;
                   
     while(true) {
    
          
		 for (int i = 0; i < order; i++) 
         for (int j = 0; j < order; j++) {

          num++;
          if(pluse&&lint==order-2)j--;

             if(num(j,i) != num || i==order-2 && num(j,i+1)!= num+order) {
            	    lint=i;
            		colt=j;
            		
            		
      if(lint==order-2 && num<order*order-order) num+=order;	 
       if(pluse) {num-=order+1;colt++;pluse=false;}
	    if(num%order==0)lint++;
	     if(lint==order-1)lint--;
	 
	     Findnum(num);
	  
	
		 if(num%order==0&&linum==lint&&colnum==colt) {
			 lastcolumn();
			 break;}
	 
		 while(colnum!=colt||linum!=lint||lint==order-2) {
			 
		  ret=false;
		
		   if(lint==order-2&&linum!=lint) { lastline(num); if(num==order*order-order)return;}
				 
		   if(linum==lint+1&&lint!=order-2||(linum==lint&&num%order==0&&lint!=order-2))
			   Reach();
				    
		  if(linum==lint) {
			  
		    Sameline(num, d, pluse);
		    Ifswitch(i,j);
		    d=1;			
		    Ifend(num);

          if(num>order*order-order) pluse=true;
		  if(num%order!=0) { ret=true; break;}
		  
			   }
			   
	while((linum!=lint+1&&num%order!=0)||(num%order==0&&linum!=lint)) 
		PreLine(num, d);
		  
	if(ret)break;
	PutTrue(num, d);


	       
	 }
	} 
   }
  }
 }


public static void main(String []sc) throws IOException {
    

        new info();
       
 

}     

}


