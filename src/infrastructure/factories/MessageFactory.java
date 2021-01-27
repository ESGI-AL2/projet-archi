package infrastructure.factories;

import infrastructure.utilities.IMessage;
import infrastructure.utilities.MessageSystem;

public class MessageFactory {

    public static IMessage getMessage() {return new MessageSystem(); }
}
