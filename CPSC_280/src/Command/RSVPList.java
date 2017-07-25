package Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RSVPList {
    private List<RSVP.Person> list = new ArrayList<>();
    private Stack<Command> undo = new Stack<>();
    private Stack<Command> redo = new Stack<>();

    public class AddPerson implements Command {
        private RSVP.Person person = new RSVP.Person();

        @Override
        public Command execute() {
            list.add(person);
            return this;
        }

        @Override
        public Command undo() {
            list.remove(person);
            return this;
        }
    }

    public class RemovePerson implements Command {
        private RSVP.Person person = new RSVP.Person();

        public RemovePerson(int loc) {
            person = list.get(loc);
        }

        @Override
        public Command execute() {
            list.remove(person);
            return this;
        }

        @Override
        public Command undo() {
            list.add(person);
            return this;
        }
    }

    public class SetFirstName implements Command {
        private int index;
        private String name;

        public SetFirstName(int index, String name) {
            if (index > -1 && index < list.size()) {
                this.index = index;
                this.name = name;
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        @Override
        public Command execute() {
            RSVP.Person person = list.get(index);
            String n = person.first;
            person.first = name;
            name = n;
            return this;
        }

        @Override
        public Command undo() {
            execute();
            return this;
        }
    }

    public class SetLastName implements Command {
        private int index;
        private String name;

        public SetLastName(int index, String name) {
            if (index > -1 && index < list.size()) {
                this.index = index;
                this.name = name;
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        @Override
        public Command execute() {
            RSVP.Person person = list.get(index);
            String n = person.last;
            person.last = name;
            name = n;
            return this;
        }

        @Override
        public Command undo() {
            execute();
            return this;
        }
    }

    public class SortByFirst implements Command {
        private List<RSVP.Person> originalList;

        @Override
        public Command execute() {
            originalList = new ArrayList<>(list);

            Collections.sort(list, new Comparator<RSVP.Person>() {
                @Override
                public int compare(RSVP.Person p1, RSVP.Person p2) {
                    return p1.first.compareTo(p2.first);
                }
            });

            return this;
        }

        @Override
        public Command undo() {
            list = originalList;
            originalList = null;

            return this;
        }
    }

    public class SortByLast implements Command {
        private List<RSVP.Person> originalList;

        @Override
        public Command execute() {
            originalList = new ArrayList<>(list);

            Collections.sort(list, new Comparator<RSVP.Person>() {
                @Override
                public int compare(RSVP.Person p1, RSVP.Person p2) {
                    return p1.last.compareTo(p2.last);
                }
            });

            return this;
        }

        @Override
        public Command undo() {
            list = originalList;
            originalList = null;

            return this;
        }
    }

    public void printList() {
        int index = 0;
        for (RSVP.Person person : list) {
            System.out.printf("%d) %-12s %-12s%n", index++, person.first,
                    person.last);
        }
    }

    public void execute(Command cmd) {
        undo.push(cmd.execute());
        redo.clear();
    }

    public void undo() {
        if (!undo.isEmpty()) {
            redo.push(undo.pop().undo());
        }
    }

    public void redo() {
        if (!redo.isEmpty()) {
            undo.push(redo.pop().execute());
        }
    }

    public int getRedoSize() {
        return redo.getSize();
    }

    public int getUndoSize() {
        return undo.getSize();
    }

    public boolean byLastname() {
        return false;
    }
}
