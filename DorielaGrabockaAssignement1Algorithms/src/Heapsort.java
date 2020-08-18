
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela
 */
public class Heapsort {
    //private static ArrayList noOfcomp= new ArrayList();
    //private static long comp=0;
    /**
     * @param args the command line arguments
     */
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
            heapsort(unsortedArray);//building a max heap*/
            //ready sample****************************
            /*int[] array={9,8,5,4,7,1 };
            heapsort(array);*/
        
            //call heapsort
        
        
        }//end of else
    }//end of main
    
    private static String getElements(String path){
            /*!!!!!!!!!!!!!!!not using args*/
            FileRead readObj=new FileRead();
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
    
    public static long heapsort(int[] array){
       long compTotal=0;
       long compIns=0;
       long compDel=0;
       
       //int[] heapArray=new int[array.length];
       //building the heap here
       for(int i=(int)array.length/2;i>=0;i--){
          compIns+=insert(array, array.length, i);
       }//order and size property are not violated
       //System.out.println("Inside Insert: "+compIns);
       /* for (int j : heapArray) {
            System.out.print(j+" ");
        }*/
       //sorting the heap here
       for(int i=array.length-1; i>0;i--){//0 is the first element
           //System.out.println("Size= "+(i)+" ");
           //exchange the values of the maximum with the last element
           compDel++;//since one comparison will be made here
           if(array[i]<array[0]){
            int temp=array[0];//now the new maximum will become position 0
            array[0]=array[i];
            array[i]=temp;
            compDel+=insert(array,i-1,0);
           }
       }
       
       /*System.out.println("Final: ");
       
       for (int j : array) {
            System.out.print(j+" ");
        }*/
         compTotal=compDel+compIns;
         //System.out.println();
         //System.out.println("Inside Del: "+compDel);
         System.out.println("Total: "+compTotal);
       /*1. do insertions
         2. do percolations
         3. delete the maxs
       */
       return compTotal;
    }
    
    //building a max heap and deleting maximums
    /*
    @params array: the array which will be bulit as a maxHeap
    @params heapSize:array length-for bulding the heap , changes for deleting the max
    @params pos: the position to check if it is in place 
    */
    private static long insert(int[] array, int heapSize, int pos){
       long comp=0;
       int l=2*pos+1;//left child position
       int r=2*pos+2;//right child position
       int largest;
       comp++;
       if(l<heapSize && array[l]>array[pos]){
          largest=l;//setting the position of the largest
       }
       else{
          largest=pos;
       }
       comp++;
       if(r<heapSize && array[r]>array[largest]){
          largest=r;//setting the position of the largest
       }
       if(pos!= largest){//if the largest is one of the children then exchange it with our element
           int temp=array[largest];
           array[largest]=array[pos];
           array[pos]=temp;
           comp+=insert(array, heapSize,largest);//now we compare the new largest with it children
       }
       return comp;
    }
}
    

    