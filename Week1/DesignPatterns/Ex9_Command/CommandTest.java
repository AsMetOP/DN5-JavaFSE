public class CommandTest {
    public static void main(String[] args) {
        Light hallLight = new Light("Hall");
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(hallLight));
        remote.pressButton();

        remote.setCommand(new LightOffCommand(hallLight));
        remote.pressButton();
    }
}