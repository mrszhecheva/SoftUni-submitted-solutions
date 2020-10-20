package CustomList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<String>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] split = command.split("\\s+");
            String commandName = split[0];

            switch (commandName) {
                case "Add":
                    String element = split[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(split[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = split[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    index = Integer.parseInt(split[1]);
                    int index2 = Integer.parseInt(split[2]);
                    customList.swap(index, index2);
                    break;
                case "Greater":
                    element = split[1];
                    System.out.println(customList.countGreater(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter sorter = new Sorter();
                    sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
            command = scanner.nextLine();
        }
    }
}
