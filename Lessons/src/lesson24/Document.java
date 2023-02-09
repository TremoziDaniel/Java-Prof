package lesson24;

public class Document {
    private final String name;
    private final int pageAmount;

    public Document(String name, int pageAmount) {
        this.name = name;
        this.pageAmount = pageAmount;
    }

    public String getName() {
        return name;
    }

    public int getPageAmount() {
        return pageAmount;
    }
}
