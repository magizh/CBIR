/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Magi
 */
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ser {
public static void main(String [] args)
{
 String filename = "db1024.ser";
  pre obj2= new pre();
    FileOutputStream fos = null;
    ObjectOutputStream out = null;
     try
     {
       fos = new FileOutputStream(filename);
      out = new ObjectOutputStream(fos);
       out.writeObject(obj2);
       out.close();
     }
     catch(IOException ex)
     {
       ex.printStackTrace();
     }
   }

}
