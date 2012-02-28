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
    
        public siml obj[][]=new siml[10000][64];
        public siml ob[]=new siml[10000];
        public siml nob[]=new siml[10000];
        public  String filename[] = new String[10000];
        public  String dir;
        public  String fname[];
        public int flag1=2;
        public int mas [][]= new int [10000][1024];
        int l;
        public int fin[]=new int[10];
        public int flagr=0;


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
           
             dir = "H:\\NetBeansProjects\\GUI\\imgdb"; // Location of image directory
		File directory = new File(dir);
                fname = directory.list();
                           int k=0;
                for(k=0;k<fname.length;k++) {
                    filename[k]= dir;
                    filename[k]=filename[k].concat("\\");
                    filename[k]=filename[k].concat(fname[k]);
                   }

            if(flag1==2)
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
             
                               System.out.println("");
                               System.out.println("");
             for(int i=0;i<1024;i++)
                 System.out.print(" "+mas[l][i]);

            }
          //System.out.println("In master :");
            for(int i=0;i<1024;i++) {
        //            System.out.println(" "+mas[l][i]);
            }*/
          k=0;
          int mast[][][]= new int[10000][32][32];
          for(int x=0;x<fname.length+1;x++) {
              k=0;
            for(int i=0;i<32;i++){
                for(int j=0;j<32;j++){
                  //      if(k<1024){
                        mast[x][i][j]=mas[x][k];
                        k++;
                  //  }
                }
              }
          }
          float mean[][]=new float[10000][64];
          float sim[] = new float[10000];
          // System.out.println();
          for(int i=0;i<fname.length+1;i++) {
            for(int j=0;j<32;j++) {
                for(k=0;k<32;k++){
                    mean[i][j]+=(mast[i][j][k]);
                    mean[i][j+32]+=(mast[i][k][j]);
                 }
                mean[i][j]/=32.0;
                mean[i][j+32]/=32;
            }
    //      mean[i][j][k]/=1024.0;
    //              obj[i]=new  siml();
    //              obj[i].num=i+1;
    //              obj[i].arr=mean[i];
            }
            float var[][]= new float [10000][64];
            int sum=0;
            for(int i=0;i<fname.length+1;i++) {
                //  	obj[i]=new  siml();
	  	//	obj[i].num=i+1;
                //        sum=0;
                for(int j=0;j<32;j++) {
                        obj[i][j]=new  siml();
                        obj[i][j+32]=new  siml();
	  		obj[i][j].num=i;
                        obj[i][j+32].num=i;
                    for(k=0;k<32;k++) {
                        var[i][j]+=(float) Math.pow(mast[i][j][k]-mean[i][j],2);
                        var[i][j+32]+=(float) Math.pow(mast[i][k][j]-mean[i][j+32],2);
                    //sum+=var[i];
                    }
                    var[i][j]/=32.0;
                    var[i][j+32]/=32.0;
                    obj[i][j].arr=(float)Math.sqrt(var[i][j]);
                    obj[i][j+32].arr=(float)Math.sqrt(var[i][j+32]);
                }
               // sum=sum/1024;
               // var[i]/=1024;
               // obj[i].arr=(float)Math.sqrt(var[i]);
               // System.out.println(obj[i].num+"--"+obj[i].arr);

            }
      
            int siml[][]= new int[10000][64];
     /*    for(int j=0;j<1024;j++){
             System.out.print(" "+mas[l][j]);
              System.out.println("Length="+l);
         }
    *///	    System.out.println("________________________________");
            for(int i=0;i<fname.length;i++) {
                ob[i]=new siml();
                if (flag1==1)
                    nob[flag1+i-1]=new siml();
                for(int j=0;j<64;j++) {
                    ob[i].arr+=(float)Math.pow((obj[l][j].arr-obj[i][j].arr),2);
                    //System.out.print(" "+ob[i].arr);
                    //siml[i]=sim[i];
                 }
                ob[i].arr=(float)Math.sqrt(ob[i].arr);
                ob[i].num=i;
//                System.out.print(" "+ob[i].arr);
            }
           
     /*       int t=0;
              for(int i=0;i<fname.length-1;i++) {
                  for(int j=i+1;j<fname.length;j++) {
                      if(siml[i]>siml[j]) {
                          t=siml[i];
                          siml[i]=siml[j];
                          siml[j]=t;
                      }

                  }
              }
      
      */
              //int perc=(25/100)*siml[0];
              //System.out.println("sub done"+ perc);
		//int arr[]= new int[50];
		//siml obj[]=new siml[50];
		/*for(int i=0;i<fname.length+1;i++) {
	  		obj[i]=new  siml();
	  		obj[i].num=i+1;
	       		for(int j=0;j<1024;j++)	{
				obj[i].arr+=sim[i][j];
			}
		   System.out.println(obj[i].num+"--"+obj[i].arr);
		}*/
		siml temp=new siml();
               // int t=0;
		for(int i=0;i<fname.length-1;i++) {
        		for(int j=i+1;j<fname.length;j++) {
                		if((ob[i].arr>=ob[j].arr)){//&&(sim[i]<perc)) {
                                       // t=sim[i];
                   			temp.num=ob[i].num;
					temp.arr=ob[i].arr;
                                       // sim[i]=sim[j];
					ob[i].num=ob[j].num;
					ob[i].arr=ob[j].arr;
                                       // sim[j]=t;
					ob[j].num=temp.num;
					ob[j].arr=temp.arr;
				}
			}
		}
		System.out.println("________________________________");
                if(flagr==0){


		for(int i=0;i<10;i++) {
			System.out.println(ob[i].num+"  "+ob[i].arr);
                         fin[i]=(int) ob[i].num;
		}
                flagr=4;
            }
             /*  if(flagr==3)
               {
                 int u;
                 int in=0;
                   gui b=new gui();
                    u=b.count();
                    System.out.println("count="+u);
                    for(int r=0;r<u;r++)
                        System.out.println("  "+fin[r]);
                    int f5=1;
                    int y=u;
                  while(u<10)
                  {
                      f5=1;
                    for(int j=0;j<y;j++)
                      {
                        if(ob[in].num==fin[j])
                        {
                            f5=0;
                            break;
                        }
                      }
                      if(f5==1)
                          fin[u++]=ob[in].num;
                      in++;
                 }
            }*/
        }// End of main() method

}// End of class master
