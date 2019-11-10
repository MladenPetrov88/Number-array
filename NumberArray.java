import java.lang.reflect.Array;
import java.util.*;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];
            int negativeSum = 0;
            int positiveSum = 0;
            int totalSum = 0;

            if (firstCommand.equals("Switch")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < numbers.size()) {
                    if (numbers.get(Integer.parseInt(temp[1])) > 0) {
                        numbers.set(Integer.parseInt(temp[1]), -1 * numbers.get(Integer.parseInt(temp[1])));
                    } else if (numbers.get(Integer.parseInt(temp[1])) < 0) {
                        numbers.set(Integer.parseInt(temp[1]), -1 * numbers.get(Integer.parseInt(temp[1])));
                    }
                }
            }

            if (firstCommand.equals("Change")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < numbers.size()) {
                    numbers.set(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
                }
            }

            if (firstCommand.equals("Sum")) {
                if (temp[1].equals("Negative")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < 0) {
                            negativeSum += numbers.get(i);
                        }
                    }
                    System.out.println(negativeSum);
                } else if (temp[1].equals("Positive")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= 0) {
                            positiveSum += numbers.get(i);
                        }
                    }
                    System.out.println(positiveSum);
                } else if (temp[1].equals("All")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        totalSum += numbers.get(i);
                    }
                    System.out.println(totalSum);
                }
            }

            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }


    }
}
