import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JApplet;
import javax.imageio.*;
import javax.swing.event.*;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class master {
    
        public siml obj[]=new siml[10000];
        public  String filename[] = new String[10000];
        public  String dir;
        public  String fname[];
        public int flag1=0;
        public int mas [][]= new int [10000][1024];
        int l;



	//public static void main(String[] args) throws IOException {
     public void initial()
    {
             String filename = "db1024.ser";
   pre obj2 = null;
   FileInputStream fis = null;
   ObjectInputStream in = null;
   try
   {
     fis = new FileInputStream(filename);
     in = new ObjectInputStream(fis);
     obj2 = (pre)in.readObject();
     in.close();
   }
   catch(IOException ex)
   {
     ex.printStackTrace();
   }
   catch(ClassNotFoundException ex)
   {
    ex.printStackTrace();
   }
            l=obj2.func2();
            mas=obj2.func();
        
     }
        public void masfun(String fileName) {
           
             dir = "C:\\Users\\Magi\\z\\sample\\new"; // Location of image directory
		File directory = new File(dir);
                fname = directory.list();
                           int k=0;
                for(k=0;k<fname.length;k++) {
                    filename[k]= dir;
                    filename[k]=filename[k].concat("\\");
                    filename[k]=filename[k].concat(fname[k]);
                   }

            if(flag1==0)
            {
            inputprocess a=new inputprocess();
            mas[l]=a.func(fileName);
            System.out.println("Hello input image processed ");
            flag1=1;
            }
         /* else
            {
                               System.out.println("");
                               System.out.println("");
                               System.out.println("in 2nd rpiund");
             gui b=new gui();
             mas[l]=b.refunc();
                               System.out.println("");
                               System.out.println("");
             for(int i=0;i<1024;i++)
                 System.out.print(" "+mas[l][i]);

            }*/
          System.out.println("In master :");
            for(int i=0;i<1024;i++)
                    System.out.print(" "+mas[l][i]);

            int sim[][] = new int[10000][1024];
              System.out.println();
         for(int j=0;j<1024;j++)
             System.out.print(" "+mas[l][j]);
              System.out.println("Length="+l);
		for(int i=0;i<fname.length;i++) {
	       		for(int j=0;j<1024;j++) {
			       sim[i][j]=Math.abs(mas[fname.length][j]-mas[i][j]);
			 }

		}
              System.out.println("sub done");
		//int arr[]= new int[50];
		//siml obj[]=new siml[50];
		for(int i=0;i<fname.length+1;i++) {
	  		obj[i]=new  siml();
	  		obj[i].num=i+1;
	       		for(int j=0;j<1024;j++)	{
				obj[i].arr+=sim[i][j];
			}
		   System.out.println(obj[i].num+"--"+obj[i].arr);
		}
		siml temp=new siml();
		for(int i=0;i<fname.length-1;i++) {
        		for(int j=i+1;j<fname.length;j++) {
                		if(obj[i].arr>obj[j].arr) {
                   			temp.num=obj[i].num;
					temp.arr=obj[i].arr;
					obj[i].num=obj[j].num;
					obj[i].arr=obj[j].arr;
					obj[j].num=temp.num;
					obj[j].arr=temp.arr;
				}
			}
		}
		System.out.println("________________________________");
		for(int i=0;i<10;i++) {
			System.out.println(obj[i].num+"  "+obj[i].arr);
                         
		}

	
        }// End of main() method

}// End of class master
