package infrastructure.utilities;

public class MessageSystem implements IMessage{
    @Override
    public void send(String string) {
        System.out.println(string);

    }
}
