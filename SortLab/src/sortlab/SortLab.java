/*
Lab 4: Quicksort vs. Merge sort
Holly Beeson

This program was written to compare two sorts: quicksort and merge sort. It reads in an
input file with any number of integer data values. It then sorts the data using each
type of sort, and writes the resulting sorted data to the output file. The input and output
files should be passed in as command line arguments. 
*/
package sortlab;

import java.io.*;
import java.util.*;

public class SortLab {

    public static void main(String[] args) {

        //Quicksort
        ArrayList<Integer> al = new ArrayList<Integer>();
        al = readFile(args[0]);
        Object[] array = al.toArray();
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = (Integer) array[i];
        }
        int n = al.size();
        QuickSort qs = new QuickSort();
        Time timer = new Time();
        long start = timer.startTime();
        qs.sort(newArr, 0, n-1);
        
        /*below is the call to the middle of three pivot selection quicksort.
        It can be uncommented out and the line above commented out to keep the output
        simple and easy to read. */
        
        //qs.midOfThreePivot(newArr, 0, n - 1);
        long run = timer.runTime(start);

        qs.printArray(newArr);
        Object[] objArr = new Object[newArr.length];
        for(int i = 0; i < newArr.length; i++) {
            objArr[i] = newArr[i];
        }
        writeFile(args[1], objArr);
        
        /* Below is the code to run the merge sort. I kept it commented out
        to keep the output less confusing.         
        */
        
        /*
        ArrayList<Integer> al = new ArrayList<Integer>();
        al = readFile(args[0]);
        MergeSort ms;
        ms = new MergeSort(al);

        for (int i = 0; i < al.size(); i++) {
            ms.push(al.get(i));
        }

        Time timer = new Time();
        long start = timer.startTime();;
        ms.mergeSort(ms.head);
        timer.runTime(start);
        ms.printList(ms.head);
        writeFileMS(args[1], ms);
        */    
    }

    //This funciton reads in the input file and puts the data into an array list.
    public static ArrayList<Integer> readFile(String input) {
        BufferedReader br = null;
        String line = null;
        ArrayList<Integer> data = new ArrayList<Integer>();

        try {
            br = new BufferedReader(new FileReader(input));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                for (int i = 0; i < split.length; i++) {
                    try {
                        data.add(Integer.parseInt(split[i]));

                    } catch (Exception e) {
                        //do nothing
                    }
                }

            }
            br.close();

        } catch (IOException ioe) {
            System.out.println("File cannot be read.");
        }
        return data;
    }

    //This function writes an array to the output file. It is used to write the results of
    //the quicksort.
    public static void writeFile(String output, Object[] data) {

        try {

            FileWriter fw = new FileWriter(new File(output));
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write("Sorted data: " + System.lineSeparator());
            for (int i = 0; i < data.length; i++) {
                fw.write(data[i].toString() + "\n" + System.lineSeparator());
            }
            fw.close();
        } catch (Exception ioe) {
            System.out.println("File cannot be writeen.");
        }
    }

    //This function also writes to the output file. This one is used for the merge sort
    //results because it is a linked implementatoin. 
    public static void writeFileMS(String output, MergeSort m) {

        try {
            FileWriter fw = new FileWriter(new File(output));

            while (m.head != null) {
                fw.write(m.head.value + System.lineSeparator());
                m.head = m.head.next;
            }
            fw.close();

        } catch (Exception e) {
            System.out.println("File cannot be writeen.");
        }
    }
}
