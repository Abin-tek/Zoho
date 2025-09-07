public abstract class Option {
    private static int counter = 0;
    private final int id;
    private final String description;

    public Option(String description) {
        this.id = ++counter;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ". " + description;
    }
}
