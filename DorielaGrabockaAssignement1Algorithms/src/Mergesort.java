
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela Grabocka
 */
public class Mergesort {

    /**
     * @param args the command line arguments
     */
    private static ArrayList noOfcomp= new ArrayList();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        if(args.length!=1){
            System.out.println("Please specify a path!");
        }
        else{
            String str=getElements(args[0]);
            String[] arrayStr=str.split(" ");//splitted array containing all elmenets
            int[] unsortedArray=getArray(arrayStr);//construct the array
            /*System.out.println("Inside the unsorted array: ");
            for (int i : unsortedArray) {
                System.out.println(i);
            }*/
        
        //ready sample****************************
        //int[] array={12,4,16,7,9,5,4,10, 7, 18, 13, 11, 6, 1,11};
        /*int[] array={12,4,16,7,9,5,4};
        System.out.println("Before mergesort: ");
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();*/
            long comp=mergesort(unsortedArray);;
            /*System.out.println("After mergesort: ");
            for (int i : unsortedArray) {
                System.out.print(i+" ");
            }*/
            System.out.println();
            System.out.println("Total comaprisons: "+comp);
        //end call mergesort
        } //end of if
    }
    
    private static String getElements(String path){
            /*!!!!!!!!!!!!!!!not using args*/
            FileRead readObj=new FileRead();
            //String path="array10.txt";
            readObj.openFile(path);
            String arrayStr=readObj.readElements();
            readObj.closeFile();
            //System.out.println(arrayStr);
            return arrayStr;
    }
    
    private static int[] getArray(String[] arrayStr) {
        int size=Integer.parseInt(arrayStr[0]);
        int[] unsorted=new int[size];//since the first element is the length
        for(int i=0; i<size; i++){
           unsorted[i]=Integer.parseInt(arrayStr[i+1]);//since we do not take inot account the first element
        }
        return unsorted;
    }
    public static long mergesort(int[] array){
        long comp=0;
        realMergesort(array);
        for (Object i : noOfcomp) {
            comp+=Integer.parseInt(i.toString());//calculating number of comaprisons
        }
        return comp;
    }
    private static void realMergesort(int[] array){
       long comp=0;
        if(array.length>1){
          int[] al=new int[array.length/2];//left subarray
          int[] ar= new int[array.length-array.length/2];//right subarray
          int c=0;
          //constructing the subarrays here
          for(int i=0;i<array.length;i++){
              if(i<al.length){
                al[i]=array[i];
              }
              else{
                  ar[c]=array[i];
                  c++;
              }
          }
          mergesort(al);//splitting happening here
          mergesort(ar);//splitting happening here
          comp=merge(array,al,ar);//merging will happen here
          noOfcomp.add(comp);
          
       }
        
       //return comp;
    }
    private static long merge(int[] arraySorted,int[] leftArray, int[] rightArray){
       long comp=0;
       int a=0;
       int b=0;
       int c=0;
       while(a<leftArray.length && b<rightArray.length){
           //the element on the left is less than the element on the right
           if(leftArray[a]<=rightArray[b]){//element on the first array is smaller than the second
               comp++;
               arraySorted[c]=leftArray[a];
               a++;
               c++;
           }
           else{
               comp++;//the only comparison will happen above
               arraySorted[c]=rightArray[b]; //element on the second array is smaller than the first
               b++;
               c++;
           }
       }//end of while
       if(a==leftArray.length && b<rightArray.length){//we reached the end of left array but not of right
           while(b<rightArray.length){
               arraySorted[c]=rightArray[b];
               b++;
               c++;
           }
       }
       else if(a<leftArray.length && b==rightArray.length){//we reached the end of right array but not of left
            while(a<leftArray.length){
               arraySorted[c]=leftArray[a];
               a++;
               c++;
           }
       
       }
       //System.out.println("Inside mergesort: "+comp);
       return comp;
    }
}
