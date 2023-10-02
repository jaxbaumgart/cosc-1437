// Jackson Baumgart

package assignment6;

// Imports
import java.io.*;
import java.util.*;

public class sort {
    public static void main(String[] args) throws IOException {
        // File scanner.
        Scanner infile = new Scanner(new File("src/assignment6/primes1.txt"));

        // Create sort arrays.
        int[] bubble = new int[100000];
        int[] selection = new int[100000];
        int dataSetSize = 100000;

        // Read file into arrays.
        int N;
        for (int i=0; i<100000; i++) {
            N = infile.nextInt();
            bubble[i] = N;
            selection[i] = N;
        }

        // Bubble sort.
        int Temp;
        long bubbleBeginTime = System.currentTimeMillis();
        for (int x=0; x<dataSetSize; x++)
        {
            for (int y=0; y<dataSetSize-1-x; y++)
            {
                // compare data[y] & data[y+1] and swap if needed
                if (bubble[y] > bubble[y+1])
                {
                    Temp = bubble[y];
                    bubble[y] = bubble[y+1];
                    bubble[y+1] = Temp;
                }
            }
        }
        long bubbleEndTime = System.currentTimeMillis();
        double bubbleTime = (bubbleEndTime - bubbleBeginTime) / 1000.0;

        // Selection sort.
        int min;
        long selectionBeginTime = System.currentTimeMillis();
        for (int x=0; x<dataSetSize; x++)
        {
            min = x;  // data[x] will start as the smallest value
            for (int y=x; y<dataSetSize; y++)
            {
                if (selection[y] < selection[min])
                {
                    min = y;
                }
            }
            // swap data[x] with data[min]
            Temp = selection[x];
            selection[x] = selection[min];
            selection[min] = Temp;
        }
        long selectionEndTime = System.currentTimeMillis();
        double selectionTime = (selectionEndTime - selectionBeginTime) / 1000.0;

        // Print results.
        System.out.println("Bubble Sort - Sorted in " + bubbleTime + " seconds.");
        System.out.println("First 10:");
        for (int i=0; i<10; i++) {
            System.out.println(bubble[i]);
        }
        System.out.println();
        System.out.println("Last 10:");
        for (int i=dataSetSize-10; i<dataSetSize; i++) {
            System.out.println(bubble[i]);
        }
        System.out.println();
        System.out.println("Selection Sort - Sorted in " + selectionTime + " seconds.");
        System.out.println("First 10:");
        for (int i=0; i<10; i++) {
            System.out.println(selection[i]);
        }
        System.out.println();
        System.out.println("Last 10:");
        for (int i=dataSetSize-10; i<dataSetSize; i++) {
            System.out.println(selection[i]);
        }
    }
}
