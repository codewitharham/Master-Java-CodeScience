package Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Queston1 {

    public static void main(String[] args) {

        // Initializing 2D array with 7 rows and 3 columns
        String[][] HighScore = new String[7][3];

        HighScore = ReadData(HighScore);

        System.out.println("Before: ");
        System.out.println("");
        OutputHighScores(HighScore);

        System.out.println("");

        System.out.println("After: ");
        System.out.println("");
        sortScores(HighScore);
        OutputHighScores(HighScore);



        
    }

    public static String[][] ReadData(String[][] arr){
        
        try {
            File myFile = new File("11. Practice Question\\src\\Question1\\HighScoreTable.txt");
            Scanner FileTobeRead = new Scanner(myFile);

            try {
                while (FileTobeRead.hasNextLine()) {
                    
                    for (int i = 0; i < arr.length; i++) {
                        
                        String PlayerID = FileTobeRead.nextLine().trim();
                        String GameLevel = FileTobeRead.nextLine().trim();
                        String GameScore = FileTobeRead.nextLine().trim();

                        arr[i][0] = PlayerID;
                        arr[i][1] = GameLevel;
                        arr[i][2] = GameScore;
                       
                    }
   
                }


            } catch (Exception e) {
                
            }

            FileTobeRead.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");

        }
        return arr;
    }

    public static void OutputHighScores(String[][] arr){
        int rowCount = 0;
        
        while (rowCount < arr.length) {
   
                System.out.println(arr[rowCount][0]+" reached level "+
                    arr[rowCount][1] + " with a score of "+ arr[rowCount][2]
                );

            rowCount = rowCount + 1;
        }
    }

    public static String[][] sortScores(String[][] arr){
        int round = 0;
        int i;
        String temp1;
        String temp2;
        String temp3;

        while ( (round < arr.length - 1)) {
            i = 0;
            while (i < arr.length - 1) {
                if (Integer.parseInt(arr[i][2]) < Integer.parseInt(arr[i+1][2])) {
                    temp1 = arr[i][0];
                    temp2 = arr[i][1];
                    temp3 = arr[i][2];

                    arr[i][0] = arr[i+1][0];
                    arr[i][1] = arr[i+1][1];
                    arr[i][2] = arr[i+1][2];

                    arr[i+1][0] = temp1;
                    arr[i+1][1] = temp2;
                    arr[i+1][2] = temp3;

                   

                }
                i = i + 1;
            }
            round = round + 1;
        }


        return arr;
    }
}