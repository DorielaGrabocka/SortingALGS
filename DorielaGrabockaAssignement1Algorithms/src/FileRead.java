
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela
 */
public class FileRead {
    Scanner input;
    File arrayHolder;
    
    public void openFile(String path){//opening the file from which we will read
       //System.out.println(path+"inside FIleRead");
        try{
            arrayHolder=new File(path);
            input=new Scanner(arrayHolder);
        }
        catch(FileNotFoundException e){
            System.err.println("File not found!");
            System.exit(1);
        }
    }
    
    public String readElements(){//readinf the contnts of the file
        String arrayStr="";
        try{
            arrayStr=input.next()+" ";
            while(input.hasNext()){
               arrayStr+=input.nextLine();
            }
        }
        catch(Exception e){
           System.out.println("Error reading from file!");
           System.exit(1);
        }
        return arrayStr;
    }
    
    public void closeFile(){//closing the file from which we read
       if(input!=null){
          input.close();
       }
    }
    
}
