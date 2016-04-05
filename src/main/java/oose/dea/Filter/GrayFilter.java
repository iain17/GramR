package oose.dea.Filter;

public class GrayFilter extends Filter {
    private int percentage;

    public GrayFilter() {
        super("gray");
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
