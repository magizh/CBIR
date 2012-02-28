import java.io.*;
public class dwt{

// Discrete-Wavelet Transformation transforms 128x128 pixels to 32x32 matrix
public static int[][] fun(int pix[][])
{
			int x,y,i,j,rows = 128,cols = 128,flag=1;
			while(flag == 1) {
    				if(rows == 32)
         				break;
	    			for(x = 0;x <rows;x++) {
 			       		i = 0;
        				y = 0;
					int temp[] = new int[cols];
	        			while(flag == 1) {
            					if(y == cols)
             						break;
	            				temp[i] = (pix[x][y]+pix[x][y+1])/2;
        	    				temp[i+(cols/2)] = (pix[x][y]-pix[x][y+1])/2;
            					i += 1;
            					y += 2;
					}
					//System.out.println(" ");
					for(int r = 0;r < cols;r++) {
						pix[x][r] = temp[r];
						// System.out.print(" "+pix[x][r]);
			    		}
				}
    				cols /= 2;
		//		System.out.println("--------------------------------------------------------------------------------- ");
	    			for(x = 0;x < cols;x++) {
	        			i = 0;
        				y = 0;
					int temp[] = new int[rows];
        				while(flag == 1) {
						if(y == rows)
	             					break;
        	    				temp[i] = (pix[y][x]+pix[y+1][x])/2;
          					temp[i+(rows/2)] = (pix[y][x]-pix[y+1][x])/2;
	         				i += 1;
        	    				y += 2;
	        			}
					//System.out.println(" ");
					for(y = 0;y < rows;y++) {
              					pix[y][x] = temp[y];
						//System.out.print(" "+pix[y][x]);
			  		}
				}
	    			rows /= 2;
		//System.out.println("--------------------------------------------------------------------------------- ");
			}
			return pix;
	}
}