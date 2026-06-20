public class Light {
    private String room;

    public Light(String room) {
        this.room = room;
    }

    public void on() {
        System.out.println(room + " light is ON");
    }

    public void off() {
        System.out.println(room + " light is OFF");
    }
}