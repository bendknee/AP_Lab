package id.ac.ui.cs.advprog.tutorial2.exercise1.receiver;

public class Light {

    private static final String OUT_FMT = "%s light is %s";

    private String location;
    private boolean lit;

    public Light(String location) {
        this(location, false);
    }

    public Light(String location, boolean lit) {
        this.location = location;
        this.lit = lit;
    }

    public void on() {
        lit = true;
        System.out.println(String.format(OUT_FMT, location, "on"));
    }

    public void off() {
        lit = false;
        System.out.println(String.format(OUT_FMT, location, "off"));
    }

    public boolean isLit() {
        if (lit) {
            return true;
        } else {
            return false;
        }
    }

    public String getLocation() {
        return location;
    }
}
