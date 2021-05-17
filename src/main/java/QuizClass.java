import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class QuizClass {

    static int score = 0;

    public static class Result {
        public String question;
        public String correct_answer;
    }

    public static class Root {
        public int response_code;
        public List<Result> results;
    }

    public QuizClass(String urlString) {

        Gson gson = new Gson();

        Root root;
        try {
            root = gson.fromJson(readFromURL(urlString), Root.class);

            //If Json retrieved successfully
            if (root.response_code == 0) {
                readFromGSON(root.results);
            } else {
                System.out.println("Error: Please try again!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method return the content of a url in a string format
     *
     * @param urlString url to retrieve the json data from
     * @return content of url in string format
     * @throws Exception exception occur during url initiate or to read from buffer
     */
    private static String readFromURL(String urlString) throws Exception {
        BufferedReader bufferedReader;

        URL url = new URL(urlString);
        bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = bufferedReader.read(chars)) != -1) {
            stringBuffer.append(chars, 0, read);
        }
        return stringBuffer.toString();
    }

    /**
     * This method read the content in json format and organize a quiz of 10 questions
     * and also keeps a record of correct answers by assigning scores
     *
     * @param results the list of result from the json (url)
     */
    private static void readFromGSON(List<QuizClass.Result> results) {
        int input;
        score = 0;
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            System.out.println((i + 1) + ". " + result.question);
            System.out.println("1. True\n2. False\nEnter your choice: ");

            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter valid option!\n" + i);

                i--;

                continue;
            }

            //check if answer is correct
            if (result.correct_answer.equals("True") && input == 1 || (result.correct_answer.equals("False") && input == 2)) {
                score++;
                System.out.println("Cheers! That's a right answer!\n");
            } //check if answer is not correct
            else if (result.correct_answer.equals("True") && input == 2 || (result.correct_answer.equals("False") && input == 1)) {
                System.out.println("Oops! That's a wrong answer!\n");
            } //check if answer is invalid
            else if (input != 1 && input != 2) {
                i--;
                System.out.println("Please enter valid option!\n");
            }
        }//end of for loop


        System.out.println("\n\n\nYour Scored " + score + "/10\n\n\n");


    }

}
