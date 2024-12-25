package jcp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharFrequencyApp {

    public static void main(String[] args) {
        int arr[][] = new int[128][2];
        char ch;
        String line;
        int chInt;

        // Initialize the array with ASCII values and counts set to 0
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = 0;
        }
        
        File inputFile = new File("C:/tmp/bf-read.txt");

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    ch = line.charAt(i);
                    if (!Character.isWhitespace(ch)) {
                        chInt = (int) ch;
                        arr[chInt][1] += 1;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Missing file");
        } catch (Exception e){
            System.err.println("Error reading from file '"+ inputFile + "'");
        }

        // Print statistics sorted by character
        System.out.println("Statistics sorted by character:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > 0) {
                System.out.printf("Character: '%c', ASCII: %d, Count: %d\n", (char) arr[i][0], arr[i][0], arr[i][1]);
            }
        }

        // Sort the array by count
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j][1] < arr[j + 1][1]) {
                    // Swap arr[j] with arr[j + 1]
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        //Print statistics sorted by frequency
        System.out.println("\nStatistics sorted by frequency:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > 0) {
                System.out.printf("Character: '%c', ASCII: %d, Count: %d\n", (char) arr[i][0], arr[i][0], arr[i][1]);
            }
        }
    }
}





