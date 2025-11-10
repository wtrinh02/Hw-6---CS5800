package ChatApp;

import java.util.Iterator;
import java.util.List;

public class User implements IterableByUser{
    private String username;
    private ChatHistory chatHistory;
    MessageMemento messageMemento;

    public User(String username){

        this.username = username;
        chatHistory = new ChatHistory();
        messageMemento = new MessageMemento(null);


    }

    public Message sendMessage(String message, List<User> recipients){
        Message sentMessage = new Message(this,recipients,message);
        chatHistory.addMessage(sentMessage);
        saveMessage(sentMessage);

        return sentMessage;
    }

    public String getUsername() {
        return username;
    }


    public void receiveMessage(Message message){
        for(User recipient : message.getRecipients()){
            System.out.println(recipient.getUsername() + " has recieved a message: " + message);
        }

        chatHistory.addMessage(message);
    }
    public void undoMessage(){
            if (messageMemento == null){
                System.out.println("No message to undo");
                return;
            }
            Message message = messageMemento.getMessage();

            chatHistory.removeLastMessage(message);

            for(User recipient : message.getRecipients()){
                recipient.getChatHistory().removeLastMessage(message);
            }

    }

    public void saveMessage(Message message){
        messageMemento.setMessage(message);
    }

    public void printChatHistory()
    {
        chatHistory.printChatHistory();
    }

    public ChatHistory getChatHistory()
    {
        return chatHistory;
    }

    @Override
    public Iterator iterator(User userToSearchWith) {
        return new searchMessagesByUser(this);
    }
}
