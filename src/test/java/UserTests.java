import ChatApp.ChatHistory;
import ChatApp.Message;
import ChatApp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    private User test;
    private User test2;
    String message;

    @BeforeEach
    public void setUp(){
        test = new User("test");
        test2 = new User("test2");
        message = "Testing Users";
    }

    @Test
    public void testSendMessageAddstoChatHistory(){
        List<User> users = Collections.singletonList(test2);
        Message messageTest = test.sendMessage(message,users);
        assertTrue(test.getChatHistory().getMessageHistory().contains(messageTest));

    }

    @Test
    public void testSendMessageReturns(){
        List<User> users = Collections.singletonList(test2);
        Message actual = test.sendMessage(message,users);
        Message expected = test.getChatHistory().getLastMessage();
        assertEquals(expected,actual);

    }

    @Test
    public void testGetUsername(){
        String actual = test.getUsername();
        String expected = "test";
        assertEquals(expected,actual);

    }

    @Test
    public void testReceiveMessageChatHistory(){
        List<User> users = Collections.singletonList(test2);
        Message testMessage = new Message(test,users,message);
        test.receiveMessage(testMessage);
        Message actual = test.getChatHistory().getLastMessage();
        assertEquals(testMessage,actual);
    }

    @Test
    public void testUndoMessageChatHistory(){
        List<User> users = Collections.singletonList(test2);
        test.sendMessage(message,users);
        test.undoMessage();
        Message actual = test.getChatHistory().getLastMessage();
        Message expected = null;
        assertEquals(expected,actual);

    }

    @Test
    public void testGetChatHistory(){

        ChatHistory actual = test.getChatHistory();
        assertNotNull(actual);


    }

    @Test
    public void testIteratorInstance(){
       Iterator iterator = test.iterator(test);
        assertNotNull(iterator);
    }
}
