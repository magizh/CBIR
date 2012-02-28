import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class inputprocess {

        public int d []= new int[1024];
       	int pix[][] = new int [128][128];
     public int[] func(String filename)
     {
        ImageIcon icon = new ImageIcon(filename);
	Image ima = icon.getImage();
	PixelGrabber grabber = null;
	int wi = 0, he = 0;
	int orig[] = null;
       	BufferedImage frame = new BufferedImage(
						ima.getWidth(null),
						ima.getHeight(null),
						BufferedImage.TYPE_INT_RGB);
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
	res=sobel01.threshold(res, thresh);
	BufferedImage img = new BufferedImage(wi,he,BufferedImage.TYPE_BYTE_GRAY);
	WritableRaster raster = img.getRaster();
	raster.setPixels(0, 0, wi, he, res);
	DataBuffer dataBuffer = img.getRaster().getDataBuffer();
	for(int i = 0;i < 128;i++) {
			for(int j = 0;j < 128;j++) {
			pix[i][j] = dataBuffer.getElem(j * img.getWidth() + i);
		}
		}

                   	//Perform DWT
			pix=dwt.fun(pix);
			// Display 32x32 pixel matrix
			int c=0;
			for(int f = 0;f < 32;f++) {
				System.out.println(" ");
				for(int w = 0;w < 32;w++) {
				   // System.out.print(" "+pix[f][w]);
					d[c]=pix[f][w];
				    System.out.print(" "+d[c]);
					c++;
				}
			}

		 System.out.println("In  :");
            
                return d;
       }


}


