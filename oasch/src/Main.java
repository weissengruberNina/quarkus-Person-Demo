public class Main {

    static Person head = new Person(1L, "A",
            new Person(2L, "B",
                    new Person(3L, "C",
                            new Person(4L, "D",
                                    new Person(5L, "E", null)))));

    public static void main(String[] args) {
        delete(1);

        System.out.println(personsAsString());

        delete(5);

        System.out.println(personsAsString());

        delete(3);

        System.out.println(personsAsString());

        delete(4);

        System.out.println(personsAsString());
    }

    public static String personsAsString() {
        Person curr = head;
        StringBuilder sb = new StringBuilder();

        sb.append(curr.getName());

        do {
            if (curr.getNext() != null) {
                curr = curr.getNext();
                sb.append(curr.getName());
            }
        } while (curr.getNext() != null);

        return sb.toString();
    }

    public static void delete(long id) {
        Person curr = head;
        boolean hasChanged = false;

        if (curr.getId() == id) {
            head = curr.getNext();
            hasChanged = true;
        }

        do {
            if (curr != null) {
                if (curr.getNext() != null) {
                    if (curr.getNext().getId() == id) {
                        curr.setNext(curr.getNext().getNext());
                        hasChanged = true;
                    }

                    if (curr.getNext() != null) {
                        curr = curr.getNext();
                    }
                }
            }
        } while (!hasChanged || curr.getNext() != null);
    }
}
