import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Persons persons = new Persons();

    //C:\Users\Yulya\IdeaProjects\HW\out\artifacts\HW_jar>java -jar hw.jar
    public static void main(String[] args) {
        while (true) {
            System.out.println("0 - exit, 1 - add, 2 - oldest, 3 - highest, 4 - largest weight, 5 - name like smth, 6 - show all");

            int command;
            try {
                command = scanner.nextInt();
            } catch (Exception e) {
                command = -1;
            }
            clear();
            switch (command) {
                case 0:
                    System.out.println("bye");
                    return;
                case 1:
                    add();
                    break;
                case 2:
                    showOldest();
                    break;
                case 3:
                    showHighest();
                    break;
                case 4:
                    showPersonWithLargestWeight();
                    break;
                case 5:
                    showPersonsWithSimilarName();
                    break;
                    case 6:
                    printAll();
                    break;
                default:
                    System.out.println("Set correct action please");
                    scanner.nextLine();
            }
        }
    }

    private static void printAll() {
        for (Person person : persons.getAll()) {
            System.out.println(person);
        }
    }

    private static void showPersonsWithSimilarName() {
        scanner.nextLine();
        System.out.println("Enter the string for search: ");
        for (Person person : persons.getPersonsWithSimilarName(scanner.nextLine())) {
            System.out.println(person);
        }
    }

    private static void showPersonWithLargestWeight() {
        System.out.println(persons.findPersonWithLargestWeight());
    }

    private static void showHighest() {
        System.out.println(persons.findHighest());
    }

    private static void showOldest() {
        System.out.println(persons.findOldest());
    }

    private static void add() {
        try {
            Person person = new Person();

            System.out.print("Name: ");

            scanner.nextLine();
            person.setName(scanner.nextLine());

            System.out.print("Age: ");
            person.setAge(scanner.nextInt());

            System.out.print("Sex (true - male, false - female): ");
            person.setSex(scanner.nextBoolean());

            System.out.print("Weight: ");
            person.setWeight(scanner.nextDouble());

            System.out.print("Height: ");
            person.setHeight(scanner.nextInt());

            persons.add(person);
        } catch (Exception e) {
            System.out.println("Some error");
            scanner.nextLine();
        }
    }


    private static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
