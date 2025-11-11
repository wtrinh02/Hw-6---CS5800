import ChatApp.ChatHistory;
import ChatApp.Message;
import ChatApp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatHistoryTests {

    private User testUser;
    private User testUser2;
    String message;
    ChatHistory chatHistory;
    @BeforeEach
    public void setUp(){
        testUser = new User("TestUser");
        testUser2 = new User("testUser2");
        message = "Testing Chat History";
        chatHistory = new ChatHistory();
    }
    @Test
    public void testGetLastMessage()
    {
        Message expected = testUser.sendMessage(message,Collections.singletonList(testUser2));
        Message actual = testUser.getChatHistory().getLastMessage();
        assertEquals(expected,actual);

    }

    @Test
    public void testAddMessage()
    {
        Message expected = new Message(testUser,Collections.singletonList(testUser2),message);
        chatHistory.addMessage(expected);
        Message actual = chatHistory.getLastMessage();
        assertEquals(expected,actual);
    }
    @Test
    public void testRemoveMessage()
    {
        Message expected = new Message(testUser,Collections.singletonList(testUser2),message);
        chatHistory.addMessage(expected);
        chatHistory.removeLastMessage(expected);
        Message actual = chatHistory.getLastMessage();
        expected = null;
        assertEquals(expected,actual);

    }

    @Test
    public void testGetMessageHistory()
    {
        Message msg = testUser.sendMessage(message,Collections.singletonList(testUser2));
        List<Message> expected = new ArrayList<>();
        expected.add(msg);

        List<Message> actual = testUser.getChatHistory().getMessageHistory();
        assertEquals(expected,actual);

    }

}

