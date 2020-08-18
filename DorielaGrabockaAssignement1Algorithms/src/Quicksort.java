
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doriela Grabocka
 */
public class Quicksort {
    //QUICKSORT-pivot finding the median
    private static ArrayList noOfcomp= new ArrayList();
    //private static int k=0;
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
            long comp =quicksort(unsortedArray);
            //ready sample****************************
            /*int[] array={12,4,16,7,9,5,4,10, 7, 18, 13, 11, 6, 1,11,45,67,89,34,12};
            System.out.println("Before quicksort: ");
            for (int i : array) {
                System.out.print(i+" ");
            }
            System.out.println();
            long comp=quicksort(array);*/
           /*System.out.println("After quicksort: ");
            for (int i : unsortedArray) {
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
    
    public static long quicksort(int[] array) {
        long comp=0;
        realQuicksort(array, 0, array.length-1);
        for (Object i : noOfcomp) {
            comp+=Integer.parseInt(i.toString());//calculating number of comparisons
        }
        return comp;
    }
    
    private static void realQuicksort(int[] array, int start, int end){
        if(start<end){
            int pivot=partition(array, start, end);//setting the pivot
            realQuicksort(array, start, pivot-1);
            realQuicksort(array, pivot+1, end);
        }
    }
    
    private static int partition(int[] array,int start,int end){
        long comp=0;//setting the comparisons to0  at the beginning
        //System.out.println("Start: "+start+" End: "+end);
        int pivot= randomChoosePivot(start, end); //this is the random pivot 
        //System.out.println(pivot);
        //int pivot=myChoosePivot(array,start,end);//this is the position of pivot using my method
        //here we exchange the last element with the pivot so that the algorithm will proceed as normal
        int temp=array[pivot];
        array[pivot]=array[end];
        array[end]=temp;
        //System.out.println("The pivot value: "+array[end]);
        
        //normal algorithm of the book starts here
        int x=array[end];//this is the pivot element
        int i=start-1;
        
        //now starts the real partition
        for(int j=start;j<end; j++){
            comp++;//incemrenting the comparison
            if(array[j]<=x){
                i=i+1;
                //exchanging a[i] with a[j]
                int temp1=array[i];
                array[i]=array[j];
                array[j]=temp1;
            }
        }//end of for
        //exchange the pivot value with A[i+1]
        int temp1=array[i+1];
        array[i+1]=array[end];
        array[end]=temp1;
        /*for (int j : array) {
            System.out.print(j+" ");
        }
        System.out.println();*/
        noOfcomp.add(comp);//adding the comparisons to the arraylist
        return i+1;//returning the pivot position to be used in the next partiotion
    }
    private static int myChoosePivot(int[] array, int start, int end){
        long comp=0;
        boolean entered=false;
        int max=array[start];
        int min=array[start];
        for(int i=start;i<=end;i++){
            if(array[i]<min){
                entered=true;
                min=array[i];
                comp++;
            }
            else if(array[i]>max){
                max=array[i];
                entered=true;//used to count the comparisons 
                comp=comp+2;//we have checked 2 conditions if enetering here
            }
            if(!entered){
                comp=comp+2;
            }
        }
        int mean=min+max/2;//finding the mean of the highest and lowest element
        int dif=max;//the diference between the mean and an elemnt of the array
        int pos=0;//poition of the supposed median of our array
        //now we need to find the value in the array that is the closest to the mean
        for(int i=start;i<=end;i++){
            comp++;
            if(Math.abs(array[i]-mean)<dif){
                dif=Math.abs(array[i]-mean);//setting the new difference
                pos=i;//setting the position of our supposed pivot
            }
        }//end of for
        noOfcomp.add(comp);//adding the number of compariosns here to the arrayList
        //System.out.println("Min: "+min+" Max: "+max+" Mean: "+mean+" pp: "+pos);
        return pos;
    }
    
    private static int randomChoosePivot(int start, int end){
         
        int numberOfElements=end-start+1;//number of elements in the current subarray
        Random ran= new Random();
        //here we select a random position from start to end and put it as the pivot value
        int pos=start+ran.nextInt(numberOfElements);//will produce an integer between start-end
        //System.out.println("Inside randomChoosePivot : The position is: "+pos);
        return pos;
    
    }
    
}
