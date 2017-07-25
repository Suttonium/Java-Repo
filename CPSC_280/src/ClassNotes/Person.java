package ClassNotes;

@SuppressWarnings("unused")
public class Person {
    private String first, last;
    private String address;
    private int ssn;

    private Person(Builder b) {
        this.first = b.first;
        this.last = b.last;
        this.address = b.address;
        this.ssn = b.ssn;
    }

    public static class Builder {
        private String first;
        private String last;
        private String address;
        private int ssn;

        public Person build() {
            if (isValid())
                return new Person(this);
            else
                throw new IllegalArgumentException();
        }

        public boolean isValid() {
            return first != null && last != null && address != null
                    && ssn != 0;
        }

        public Builder first(String first) {
            this.first = first;
            return this;
        }

        public Builder last(String last) {
            this.last = last;
            return this;
        }

        public Builder ssn(int ssn) {
            this.ssn = ssn;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
    }

    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder();
        builder.address("hey").last("Smith");
        if (builder.isValid()) {
            System.out.println("we shouldnt");
            Person p = builder.build();
        }
        builder.first("mary").ssn(123);
        Person person = builder.build();
        System.out.printf("we just create %s %s as a person", person.first,
                person.last);
    }
}
