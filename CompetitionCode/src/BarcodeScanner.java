
import java.util.ArrayList;
import java.util.Scanner;

public class BarcodeScanner {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            scan.nextLine();// All pipes, not needed for calcs
            findPipes(line);
        }
        scan.close();

    }

    public static void findPipes(String pipes) {
        pipes = pipes.substring(1, pipes.length() - 1);
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            String numStr = pipes.substring(0, 5);
            pipes = pipes.substring(5);

            numList.add(whichNum(numStr));

        }
        String post = "";
        for (int i = 0; i < 5; i++) {
            post += numList.get(i).toString();
        }
        post += '-';
        for (int i = 5; i < 9; i++) {
            post += numList.get(i).toString();
        }

        int sum = 0;

        for (Integer element : numList) {
            sum += element;
        }
        sum -= numList.get(numList.size() - 1);
        sum = 10 - (sum % 10);

        post += "(" + numList.get(9) + "): ";

        if (sum == numList.get(9)) {
            post += "OK";
        }
        else {
            post += "invalid check digit";
        }

        System.out.println(post);

    }

    public static int whichNum(String input) {
        switch (input) {
            case "   ||":
                return 1;
            case "  | |":
                return 2;
            case "  || ":
                return 3;
            case " |  |":
                return 4;
            case " | | ":
                return 5;
            case " ||  ":
                return 6;
            case "|   |":
                return 7;
            case "|  | ":
                return 8;
            case "| |  ":
                return 9;
            case "||   ":
                return 0;
        }

        return -1;// error code
    }

}
