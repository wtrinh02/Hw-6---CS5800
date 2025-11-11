import ChatApp.Message;
import ChatApp.MessageMemento;
import ChatApp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMementoTests {
    private Message message;
    private MessageMemento messageMemento;
    User user1;
    User user2;
    String content;
    @BeforeEach
    public void setup() {
        user1 =   new User("test1");
        user2 =   new User("test2");
        content = "test MM";
        message = new Message(user1, Collections.singletonList(user2), content);
        messageMemento = new MessageMemento(message);
    }

    @Test
    public void getMemento() {
        Message expected = message;
        Message actual = messageMemento.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    public void setMemento() {
        Message expected = new Message(user2,Collections.singletonList(user1),content);
        messageMemento.setMessage(expected);
        Message actual = messageMemento.getMessage();
        assertEquals(expected,actual);
    }
}
