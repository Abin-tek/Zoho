import java.util.ArrayList;

public class Menu {
    private static Menu instance;
    private final ArrayList<Option> optionsList;

    private Menu() {
        this.optionsList = new ArrayList<>();
        addOptions();
    }

    protected static Menu getInstance() {
        if (instance == null)
            instance = new Menu();
        return instance;
    }

    private void addOptions() {
        optionsList.add(new BookOption());
        optionsList.add(new CancelOption());
        optionsList.add(new PrintChartOption());
        optionsList.add(new ExitOption());
    }

    protected void listMenu() {
        optionsList.forEach(System.out::println);
    }
}
