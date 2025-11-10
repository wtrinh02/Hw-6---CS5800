import ChatApp.Message;
import ChatApp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTests {

    Message message;
    User sender;
    User recipient;
    String messageText;


    @BeforeEach
    public void setUp()
    {
        sender = new User("sender");
        recipient = new User("recipient");
        messageText = "Hello World!";
        message = new Message(sender, Collections.singletonList(recipient), messageText);
    }

    @Test
    public void getSenderTest(){
        User actual =  message.getSender();
        User expected = sender;
        assertEquals(expected,actual);
    }
    @Test
    public void getRecpientsTest(){
        List<User> actual =  message.getRecipients();
        List<User> expected = Collections.singletonList(recipient);
        assertEquals(expected,actual);
    }
    @Test
    public void getDateTest(){
        String actual =  message.getTimestamp().toString();
        String expected = new Date().toString();
        assertEquals(expected,actual);
    }
    @Test
    public void toStringTest(){
        String actual =  message.toString();
        String expected = "["+message.getTimestamp()+"] "+ sender.getUsername()+ ": "+ message.getContent();
        assertEquals(expected,actual);
    }

}
