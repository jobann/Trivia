import java.util.Scanner;

public class Trivia {
    public static void main(String[] args) {

        int input;
        Scanner scanner = null;

        String[] gkUrl = new String[]{"https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=9&difficulty=hard&type=boolean"};


        String[] computersUrl = new String[]{"https://opentdb.com/api.php?amount=10&category=18&difficulty=easy&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=18&difficulty=medium&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=18&difficulty=hard&type=boolean"};


        String[] gadgetsUrl = new String[]{"https://opentdb.com/api.php?amount=10&category=30&difficulty=easy&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=30&difficulty=medium&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=30&difficulty=hard&type=boolean"};

        String[] sportsUrl = new String[]{"https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=21&difficulty=medium&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=21&difficulty=hard&type=boolean"};

        String[] politicsUrl = new String[]{"https://opentdb.com/api.php?amount=10&category=24&difficulty=easy&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=24&difficulty=medium&type=boolean",
                "https://opentdb.com/api.php?amount=10&category=24&difficulty=hard&type=boolean"};


        //Displaying the Main Menu
        do {
            System.out.println("Categories: \n1. General Knowledge\n2. Science: Computers\n3. Science: Gadgets\n" +
                    "4. Sports\n5. Politics\n6. Exit\nChoose your quiz category:");
            try {
                scanner = new Scanner(System.in);
                scanner.reset();
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                input = 0;
            }
            switch (input) {
                case 1:
                    subMenu(gkUrl);
                    break;
                case 2:
                    subMenu(computersUrl);
                    break;
                case 3:
                    subMenu(gadgetsUrl);
                    break;
                case 4:
                    subMenu(sportsUrl);
                    break;
                case 5:
                    subMenu(politicsUrl);
                    break;
                case 6:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Please Enter a valid input!");
                    break;
            }

        } while (input != 6);

        scanner.close();
    }

    /**
     * This method pops up the sub menu with different difficulty level
     * @param urlString Array of urls of category specified
     */
    static void subMenu(String[] urlString) {
        int input;
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            scanner.reset();
            System.out.println("Please choose your difficulty level:\n1. Easy\n2. Medium\n3. Hard\n4. Exit");
            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                input = 0;
            }
            switch (input) {
                case 1:
                    new QuizClass(urlString[0]);
                    break;
                case 2:
                    new QuizClass(urlString[1]);
                    break;
                case 3:
                    new QuizClass(urlString[2]);
                    break;
                case 4:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Please Enter a valid input!");
                    break;
            }

        } while (input != 4);
    }

}
