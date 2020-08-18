
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela
 */
/*DONE************************************************************************/
public class FileWrite {
    private Formatter out;
    public void openFile(int fileNumber,char a){
        try{
            out=new Formatter("array"+fileNumber+""+a+".txt");
        }
        catch(FileNotFoundException e){
            System.err.println("Cannot open file.");
            
        }
    }
    
    public void addElements(String strArray){
       
        try{
           out.format("%s", strArray);
        }
       catch(Exception e){
           System.err.println("Error writing to file.");
       }
    }
    
    public void closeWrite(){
       if(out!=null){
          out.close();
       }
    }
    
}

