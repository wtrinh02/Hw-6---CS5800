package ChatApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User test1 = new User("Name1");
        User test2 = new User("Name2");
        User test3 = new User("Name3");

        List<User> users = new ArrayList<User>();
        users.add(test1);
        users.add(test2);

        server.registerUser(test1);
        server.registerUser(test2);
        server.registerUser(test3);

        System.out.println("-------------Testing 1 Recipient sending-------------");
        server.sendMessage(test1,"Hello testing 1 recipient chat", Collections.singletonList(test2));
        server.sendMessage(test2,"Hello responding test", Collections.singletonList(test1));
        server.printChatHistory(test1);

        System.out.println("-------------Testing Group Recipients sending-------------");
        server.sendMessage(test3,"Hello testing Groupchat",users);
        server.sendMessage(test1,"Hello test3",Collections.singletonList(test3));
        server.printChatHistory(test3);

        System.out.println("-------------Testing 1 Blocking-------------");
        server.blockUser(test2,test3);
        server.sendMessage(test3,"Did you receive my message test2?",Collections.singletonList(test2));
        server.printChatHistory(test2);

        System.out.println("-------------Testing Undoing Messages-------------");
        server.printChatHistory(test2);
        server.undoLastMessage(test2);
        server.printChatHistory(test2);



    }
}
