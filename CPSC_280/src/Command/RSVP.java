package Command;

import java.util.Scanner;

public class RSVP {

    public static class Person {
        String first = "";
        String last = "";
    }

    public static void main(String[] args) {
        RSVPList rsvp = new RSVPList();
        boolean exit = false;
        try (Scanner scan = new Scanner(System.in)) {
            do {
                rsvp.printList();
                System.out.printf("[Redo:%d Undo:%d Sort:%s] Write command: ",
                        rsvp.getRedoSize(), rsvp.getUndoSize(),
                        rsvp.byLastname() ? "LAST" : "FIRST");
                String command = scan.nextLine();
                String[] array = command.split(" ");
                switch (array[0]) {
                    case "exit":
                        exit = true;
                        break;
                    case "add":
                        Command add = rsvp.new AddPerson();
                        rsvp.execute(add);
                        break;
                    case "remove":
                        try {
                            Command remove = rsvp.new RemovePerson(
                                    Integer.parseInt(array[1]));
                            rsvp.execute(remove);
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(
                                    "incomplete command. expected: remove <index>");
                        }
                        catch (NumberFormatException e) {
                            System.out.println(
                                    "index is not an integer number. expected: remove <index>");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(
                                    "index is not on the list. expected: remove <index>");
                        }
                        break;
                    case "first":
                        try {
                            Command set = rsvp.new SetFirstName(
                                    Integer.parseInt(array[1]),
                                    array.length > 2 ? array[2] : "");
                            rsvp.execute(set);
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(
                                    "incomplete command. expected: first <index> [name]");
                        }
                        catch (NumberFormatException e) {
                            System.out.println(
                                    "index is not an integer number. expected: first <index> [name]");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(
                                    "index is not on the list. expected: first <index> [name]");
                        }
                        break;
                    case "last":
                        try {
                            Command set = rsvp.new SetLastName(
                                    Integer.parseInt(array[1]),
                                    array.length > 2 ? array[2] : "");
                            rsvp.execute(set);
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(
                                    "incomplete command. expected: last <index> [name]");
                        }
                        catch (NumberFormatException e) {
                            System.out.println(
                                    "index is not an integer number. expected: last <index> [name]");
                        }
                        catch (IllegalArgumentException e) {
                            System.out.println(
                                    "index is not on the list. expected: last <index> [name]");
                        }
                        break;
                    case "sortfirst":
                        Command byfirst = rsvp.new SortByFirst();
                        rsvp.execute(byfirst);
                        break;
                    case "sortlast":
                        Command bylast = rsvp.new SortByLast();
                        rsvp.execute(bylast);
                        break;
                    case "undo":
                        rsvp.undo();
                        break;
                    case "redo":
                        rsvp.redo();
                        break;
                    default:
                        System.out.println("unknown command. type: help");
                }
            } while (!exit);
            System.out.println("bye-bye!");
        }
    }
}