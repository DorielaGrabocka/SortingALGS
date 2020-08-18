
import java.security.SecureRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela Grabocka
 */

/*Done and functions correctly all files have the specified arrays*************/
public class GenerateArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               
        //first sample
        creatingSamples('a');
          
        //second sample..........................................................
        creatingSamples('b');
        
        //third sample...........................................................
        creatingSamples('c');
        
        //fourth sample..........................................................
        creatingSamples('d');
        
        //fifth sample...........................................................
        creatingSamples('e');
        
        
        //domain-size: 10,20,50,100, 200, 500, 1000, 2000, 5000, 10000, 20000,50000,100000
        
        
}//end of main
 
//here we create a sample
//the argument is used to create the file
public static void creatingSamples(char x){
    int[] indexes={10,20,50,100,200,500,1000,2000,5000,10000,20000,50000,100000};
    int[] array10= new int[10];
    int[] array20= new int[20];
    int[] array50= new int[50];
    int[] array100= new int[100];
    int[] array200= new int[200];
    int[] array500= new int[500];
    int[] array1000= new int[1000];
    int[] array2000= new int[2000];
    int[] array5000= new int[5000];
    int[] array10000= new int[10000];
    int[] array20000= new int[20000];
    int[] array50000= new int[50000];
    int[] array100000= new int[100000];
        
    String array10Str="10\n";
    String array20Str="20\n";
    String array50Str="50\n";
    String array100Str="100\n";
    String array200Str="200\n";
    String array500Str="500\n";
    String array1000Str="1000\n";
    String array2000Str="2000\n";
    String array5000Str="5000\n";
    String array10000Str="10000\n";
    String array20000Str="20000\n";
    String array50000Str="50000\n";
    String array100000Str="100000\n";
    int[][] array={array10,array20,array50,
                   array100,array200,array500,
                   array1000,array2000,array5000,
                   array10000,array20000,array50000,
                   array100000};
        
    String[] arrayStr= {array10Str, array20Str, array50Str, 
                        array100Str,array200Str, array500Str, 
                        array1000Str, array2000Str, array5000Str,
                        array10000Str, array20000Str, array50000Str,
                        array100000Str};
    SecureRandom ran= new SecureRandom();
    //for(int i=0;i<array.length;i++){//for each array inside the array as parameter
        for(int j=0;j<100000;j++){//for each elemenet of the su
            int number=ran.nextInt();
            if(number<0){
                 number=-number;//change the value if it is negative 
              }
            if(j<10){
              
              array[0][j]=number;
              arrayStr[0]+=""+array[0][j]+" ";
              //System.out.println(array10aStr);
              
           }
           //fill 20 elements array
           if(j<20){
              
              array[1][j]=number;//assing the value to array20
              arrayStr[1]+=""+array[1][j]+" ";
           }
        
        
        //fill 50 elements array
        if(j<50){
              
              array[2][j]=number;//assing the value to array50
              arrayStr[2]+=""+array[2][j]+" ";
           }
        
        //fill 100 elements array
        if(j<100){
              
              array[3][j]=number;//assing the value to array100
              arrayStr[3]+=""+array[3][j]+" ";
        }
        //fill 200 elements array
        if(j<200){
              
              array[4][j]=number;//assing the value to array200
              arrayStr[4]+=""+array[4][j]+" ";
        }
        //fill 500 elements array
        if(j<500){
              
              array[5][j]=number;//assing the value to array500
              arrayStr[5]+=""+array[5][j]+" ";
        }
        //fill 1000 elements array
        if(j<1000){
              
              array[6][j]=number;//assing the value to array1000
              arrayStr[6]+=""+array[6][j]+" ";
        }
        //fill 2000 elements array
        if(j<2000){
              
              array[7][j]=number;//assing the value to array2000
              arrayStr[7]+=""+array[7][j]+" ";
        }
        //fill 5000 elements array
        if(j<5000){
              
              array[8][j]=number;//assing the value to array5000
              arrayStr[8]+=""+array[8][j]+" ";
        }
        //fill 10000 elements array
        if(j<10000){
              
              array[9][j]=number;//assing the value to array10000
              arrayStr[9]+=""+array[9][j]+" ";
        }
        //fill 20000 elements array
        if(j<20000){
              
              array[10][j]=number;//assing the value to array20000
              arrayStr[10]+=""+array[10][j]+" ";
        }
        //fill 50000 elements array
        if(j<50000){
              
              array[11][j]=number;//assing the value to array50000
              arrayStr[11]+=""+array[11][j]+" ";
        }
        //fill 100000 elements array
        if(j<100000){
              
              array[12][j]=number;//assing the value to array100000
              arrayStr[12]+=""+array[12][j]+" ";
        }
      System.out.println("Element "+j+" :"+array[12][j]);
       }//end of for
        //System.out.println(array10aStr);
       FileWrite writeObj =new FileWrite();//creating the write object to write into the array
        //writing to file
       for(int i=0; i<indexes.length; i++){
            writeObj.openFile(indexes[i],x);//the arguments are used to name the file
            writeObj.addElements(arrayStr[i]);//we will write the string inside the string here
            writeObj.closeWrite();//close the write
        }
        
        
    }//end of create samples
    

    
}//end of class
