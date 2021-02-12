package infrastructure.factories;

import infrastructure.utilities.Message;
import infrastructure.utilities.MessageSystem;

public class MessageFactory {

    public static Message getMessage() {return new MessageSystem(); }
}
