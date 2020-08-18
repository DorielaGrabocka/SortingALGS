
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
public class InsMergesort {
    private static ArrayList noOfcomp= new ArrayList();//used to keep track of the comparisons
    private static int k;
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
            k=(int) (Math.log10(unsortedArray.length)/Math.log10(2));//finding log_2 of n*/
            /*System.out.println("Inside the unsorted array: ");
            for (int i : unsortedArray) {
                System.out.println(i);
            }*/
            long comp=mergesort(unsortedArray);
            //ready sample****************************
            /*int[] array={12,4,16,7,9,5,4,10, 7, 18, 13, 11, 6, 1,11};*/
            /*int[] array={12,4,16,7,9,5,4};
            System.out.println("Before mergesort: ");
            for (int i : array) {
                System.out.print(i+" ");
            }*/
            System.out.println();
            //long comp=mergesort(array);
            /*System.out.println("After mergesort: ");
            for (int i : array) {
                System.out.print(i+" ");
            }*/
            System.out.println();
            System.out.println("Total comaprisons: "+comp);
            //call mergesort
        }
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
        //comp=insertionsort(array);
        //realMergesort(array);
        /*for (int i : array) {
            System.out.print(i+" ");
        }*/
        /*System.out.println("Number of comp in insertion sort: "+comp);
        System.exit(0);*/
        for (Object i : noOfcomp) {
            comp+=Integer.parseInt(i.toString());//calculating number of comaprisons
        }
        //comp=insertionsort(array);
        return comp;
    }
    private static void realMergesort(int[] array){
       long comp=0;
        if(array.length>5){
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
        else{
            noOfcomp.add(insertionsort(array));
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
    
    public static long insertionsort(int[] array){
        long comp=0;
        for(int i=1; i<array.length;i++){
            boolean entered=false;
            int value=array[i];
            int j=i;
            while(j>0 ){comp++; if( array[j-1]<=value)break;
                //comp++;
                array[j]=array[j-1];//moving values to the right
                j--;
                entered=true;
            }//end of while
            
                //comp++;
            
            array[j]=value;//now we have found the place of value and we insert the value
        }//end of for
        return comp;
    }//end of insertion sort
    
}
