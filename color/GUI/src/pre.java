/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Magi
 */
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.lang.Math;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JApplet;
import javax.imageio.*;
import javax.swing.event.*;
import java.io.Serializable;
public class pre implements Serializable{

        String filename[] = new String[10000];
        String dir;
        String fname[];
        int flag1=0;
        int mas [][]= new int [10000][1024];
        int l;
	//public static void main(String[] args) throws IOException {
        public pre() {

            dir = "C:\\Users\\Magi\\z\\sample\\new"; // Location of image directory
		File directory = new File(dir);
                fname = directory.list();
                l=fname.length;
                Image edgeImage, accImage, outputImage;

                int k=0;
                for(k=0;k<fname.length;k++) {
                    filename[k]= dir;
                    filename[k]=filename[k].concat("\\");
                    filename[k]=filename[k].concat(fname[k]);
                   }

                //Recurse directory to process all files
		for (int z = 0;z <l;z++) {
			int pix[][] = new int [128][128];
			ImageIcon icon = new ImageIcon(filename[z]);
			Image ima = icon.getImage();
			PixelGrabber grabber = null;
			int wi = 0, he = 0;
			int orig[] = null;

			// Create empty BufferedImage
                	BufferedImage frame = new BufferedImage(
						ima.getWidth(null),
						ima.getHeight(null),
						BufferedImage.TYPE_INT_RGB);

			// Draw Image into BufferedImage
        	        Graphics g = frame.getGraphics();
                	g.drawImage(ima, 0, 0, null);

			wi = frame.getWidth(null);
			he = frame.getHeight(null);
			orig = new int[wi*he];
			grabber = new PixelGrabber(frame, 0, 0, wi, he, orig, 0, wi);
			try {
				grabber.grabPixels();
		            }
			catch(InterruptedException e2) {
				System.out.println("error: " + e2);
                 			}

			sobel01 edgedetector=new sobel01(orig,wi,he);

			int[] res = edgedetector.process();
			int thresh=40;

			//Threshold
			res=sobel01.threshold(res, thresh);
			BufferedImage img = new BufferedImage(wi,he,BufferedImage.TYPE_BYTE_GRAY);
			WritableRaster raster = img.getRaster();

        		raster.setPixels(0, 0, wi, he, res);

			DataBuffer dataBuffer = img.getRaster().getDataBuffer();

			for(int i = 0;i < 128;i++) {
				for(int j = 0;j < 128;j++) {
					pix[i][j] = dataBuffer.getElem(j * img.getWidth() + i);
					//System.out.print(" "+pix[i][j]);
				}
			}

                   	//Perform DWT
			pix=dwt.fun(pix);
			// Display 32x32 pixel matrix
			int c=0;
			for(int f = 0;f < 32;f++) {
				//System.out.println(" ");
				for(int w = 0;w < 32;w++) {
					//System.out.print(" "+pix[f][w]);
					mas[z][c]=pix[f][w];
				//	System.out.print(" "+mas[t][c]);
					c++;
				}
			}

		}
                System.out.println("done");// End of for-loop
                for(int i=0;i<1024;i++)
                    System.out.print(" "+mas[12][i]);
                
       }

        public int[][] func()
       {
            return mas;
       }

        public int func2()
    {
            return fname.length;
        }

}
