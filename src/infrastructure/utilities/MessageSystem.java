package infrastructure.utilities;

public class MessageSystem implements Message {
    @Override
    public void send(String string) {
        System.out.println(string);

    }
}
