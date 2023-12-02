import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Trebuchet2 {

    private static final String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    // This took me all day to research and figure out, I wasted so much time messing with regex before abandoning it
    private static List<String> findNumbers(String str) {
        List<String> numbers = new ArrayList<>();
        int currentIndex = 0;

        while (currentIndex < str.length()) {
            boolean foundMatch = false;

            if (Character.isDigit(str.charAt(currentIndex))) {
                numbers.add(String.valueOf(str.charAt(currentIndex)));
                currentIndex++;
                foundMatch = true;
            }

            for (String word : numberWords) {
                if (str.regionMatches(true, currentIndex, word, 0, word.length())) {
                    numbers.add(String.valueOf(Arrays.asList(numberWords).indexOf(word)));
                    currentIndex += word.length() - 1;
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                currentIndex++;
            }
        }

        return numbers;
    }


    public static void main(String[] args) {
        try {
            File file = new File("trebuchet.txt");
            Scanner in = new Scanner(file);
            ArrayList<Integer> calibrationValues = new ArrayList<Integer>();

            while (in.hasNextLine()) {
                String line = in.nextLine();
                List<String> numbers = findNumbers(line);

                int first = Integer.parseInt(numbers.get(0)) * 10;
                int second = Integer.parseInt(numbers.get(numbers.size() - 1));

                int calibrationValue = first + second;
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
