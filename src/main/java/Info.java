public class Info {
    private String name;
    private String model;
    private int count;
    private String type;

    public Info(String name, String model, int count, String type) {
        this.name = name;
        this.model = model;
        this.count = count;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }
}
