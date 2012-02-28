/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Magi
 */
public class refine {
    public int[] func(int rel[],int len,int mas[][],int l)

    {
         for(int i=0;i<len;i++)
         {
                 System.out.println(rel[i]);
         }
         int c=0;
         while(c<512)
         {
             mas [l][c]= mas [rel[0]][c++];
         }
         while(c<1024)
         {
             mas[l][c]=mas[rel[1]][c++];
         }
         System.out.println();
         for(int j=0;j<1024;j++)
             System.out.print(" "+mas[l][j]);
         System.out.println();
         for(int j=0;j<1024;j++)
             System.out.print(" "+mas[rel[0]][j]);
         System.out.println();

         for(int j=0;j<1024;j++)
             System.out.print(" "+mas[rel[1]][j]);
     return mas[l];
    }

}
