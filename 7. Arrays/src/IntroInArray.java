import java.util.Arrays;

public class IntroInArray {
    public static void main(String[] args) {
        /*
            An array in Java is a data structure that holds a fixed number of elements
            of the same type. The elements in an array are stored in contiguous memory
            locations and can be accessed using an index, starting from 0 for the
            first element.


            Key Features:
                Fixed Size: The size of an array is defined at the time of creation and cannot be changed.
                Homogeneous Elements: All elements in an array must be of the same data type.
        */

        // Declare and initialize an array of integers with 5 elements
        int[] numbers = new int[20];


        System.out.println(Arrays.toString(numbers));

        // Assign values to the array elements
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println(Arrays.toString(numbers));


        // Alternatively, you can initialize the array directly

        int[] anotherArray = {5, 10, 15, 20, 25};

        System.out.println(Arrays.toString(anotherArray));

        String[] StudentName = new String[5];
        StudentName[0] = "Arham";
        StudentName[1] = "Ahmed";
        StudentName[2] = "Sarim";
        StudentName[3] = "Ibrahim";
        StudentName[4] = "Abdul Rahim"; 

        System.out.println(Arrays.toString(StudentName));

        for (String names : StudentName) {
            System.out.println(names);
        }

        for (int index = 0; index < StudentName.length; index++) {
            System.out.println(StudentName[index]);
        }
    

    }
}
