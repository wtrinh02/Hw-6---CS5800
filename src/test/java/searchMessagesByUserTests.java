import ChatApp.ChatHistory;
import ChatApp.Message;
import ChatApp.User;
import ChatApp.searchMessagesByUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class searchMessagesByUserTests {

    private User testUser;
    private User testUser2;
    private Message testMessage;
    private Message testMessage2;


    @BeforeEach
    public void setUp(){
        testUser = new User("TestUser");
        testUser2 = new User("testUser2");
        testMessage = new Message(testUser, Collections.singletonList(testUser2),"Test Message");
        testMessage2 = new Message(testUser, Collections.singletonList(testUser2),"Test Message2");
        testUser.getChatHistory().addMessage(testMessage);
        testUser.getChatHistory().addMessage(testMessage2);
    }

    @Test
    public void testHasNext(){
        searchMessagesByUser iterator = new searchMessagesByUser(testUser);
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testNext(){

        searchMessagesByUser iterator = new searchMessagesByUser(testUser);
        Message next = iterator.next();
        assertEquals(testMessage,next);
    }
}
