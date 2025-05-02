package Question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        String[][] HighScores = new String[11][2];

        ReadHighScores(HighScores);

        OutputHighScores(HighScores);

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the 3 character player name: ");
        String playerName = userInput.nextLine();

        System.out.println("Enter the player b/w 1 to 100000");
        int playerScore = userInput.nextInt();

        createNewList(playerName, playerScore, HighScores);

        OutputHighScores(HighScores);

        try {
            FileWriter FileToWrite = new FileWriter("11. Practice Question\\src\\Question2\\NewHighScores.txt");
            
            for (int i = 0; i < HighScores.length; i++) {
                FileToWrite.write(HighScores[i][0] + "\n");  // Write name
                FileToWrite.write(HighScores[i][1] + "\n");  // Write score
            }
    
            FileToWrite.close();
            System.out.println("High scores written to file successfully.");
        
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        


    }

    public static void ReadHighScores(String[][] x) {
        try {

            File myFile = new File("11. Practice Question\\src\\Question2\\HighScore.txt");

            Scanner fileToRead = new Scanner(myFile);

            for (int i = 0; i < x.length; i++) {
                if (fileToRead.hasNextLine()) {
                    x[i][0] = fileToRead.nextLine().strip();
                } else {
                    x[i][0] = "N/A";
                }

                if (fileToRead.hasNextLine()) {
                    x[i][1] = fileToRead.nextLine().strip();
                } else {
                    x[i][1] = "0";
                }
            }

            fileToRead.close();

        } catch (FileNotFoundException e) {
            System.out.println("The path of File not found");
        }
    }

    public static void OutputHighScores(String[][] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i][0] + " " + x[i][1]);
        }
    }

    public static void createNewList(String x, int y, String[][] arr){

        int insertIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int currentScore = Integer.parseInt(arr[i][1]);
            if (y > currentScore ) {
                insertIndex = i;
                break;
            }
        }

        if (insertIndex == -1){
            System.out.println("This Score can't be added in top 10`");
        }

         
        for (int i = arr.length - 1; i > insertIndex; i--) {
            arr[i][0] = arr[i - 1][0];
            arr[i][1] = arr[i - 1][1];
        }

        arr[insertIndex][0] = x;
        arr[insertIndex][1] = String.valueOf(y);
    }

}
