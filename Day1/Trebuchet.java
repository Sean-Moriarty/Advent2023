package Day1;// Advent of Code 2023 Day 1 Puzzle 1
// https://adventofcode.com/2023/day/1


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) {
        try {
            File file = new File("Day1/trebuchet.txt");
            Scanner in = new Scanner(file);
            ArrayList<Integer> calibrationValues = new ArrayList<Integer>();

            while (in.hasNextLine()) {
                String line = in.nextLine();
                ArrayList<Integer> lineDigits = new ArrayList<Integer>();

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        // converted to string before converting to int because going straight from
                        // char to int resulted in the unicode value of the digit rather than the digit
                        lineDigits.add(Integer.parseInt(Character.toString(line.charAt(i))));
                    }
                }

                int calibrationValue = (lineDigits.get(0) * 10) + lineDigits.get(lineDigits.size() - 1);
                calibrationValues.add(calibrationValue);
            }

            int sum = 0;
            for (int value : calibrationValues) {
                sum += value;
            }

            System.out.println(sum);

        } catch (Exception e) {
            System.out.println("Oops...");
            e.printStackTrace();
        }
    }
}
