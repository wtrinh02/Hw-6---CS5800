import ChatApp.ChatHistory;
import ChatApp.ChatServer;
import ChatApp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatServerTests {
    private User testUser;
    private User testUser2;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        testUser = new User("TestUser");
        testUser2 = new User("testUser2");


    }

    @Test
    public void testRegisterUser() {
        ChatServer chatServer = new ChatServer();
        chatServer.registerUser(testUser);
        chatServer.registerUser(testUser2);
        int actual = chatServer.getRegisteredUser().size();
        int expected = 2;
        assertEquals(expected, actual);

    }

    @Test
    public void testUnRegisterUser() {
        ChatServer chatServer = new ChatServer();
        chatServer.registerUser(testUser);
        chatServer.registerUser(testUser2);
        chatServer.unregisterUser(testUser);
        int actual = chatServer.getRegisteredUser().size();
        int expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void testBlockUser() {
        ChatServer chatServer = new ChatServer();
        chatServer.registerUser(testUser);
        chatServer.registerUser(testUser2);
        chatServer.blockUser(testUser, testUser2);
        int actual = chatServer.getBlockedList().get(testUser).size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testBlockedSendMessage() {
        ChatServer chatServer = new ChatServer();
        chatServer.registerUser(testUser);
        chatServer.registerUser(testUser2);
        chatServer.blockUser(testUser, testUser2);

        System.setOut(new PrintStream(outContent));
        chatServer.sendMessage(testUser2,"Hi", Collections.singletonList(testUser));

        String actual = outContent.toString();
        String expected = testUser.getUsername() + " has blocked messages from " + testUser2.getUsername()+"\r\n";
        assertEquals(expected, actual);

    }
}
