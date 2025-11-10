package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser{

    private final List<Message> messageHistory = new ArrayList<>();

    public void addMessage(Message message){
        messageHistory.add(message);
    }

    public Message getLastMessage() {
        if(!messageHistory.isEmpty()){
            return messageHistory.get(messageHistory.size()-1);
        }
        return null;
    }

    public void removeLastMessage(Message message){

        messageHistory.remove(message);
    }

    public void printChatHistory(){
        if(messageHistory.isEmpty()){
            System.out.println("No message to print");
            return;
        }
        for(Message message: messageHistory){
            for(User recipient: message.getRecipients()){
                System.out.println("["+message.getTimestamp()+"] "+ message.getSender().getUsername()+ " -> "+ recipient.getUsername()+ ": "+ message.getContent());
            }
        }
    }

    public List<Message> getMessageHistory(){
        return messageHistory;
    }


    @Override
    public Iterator iterator(User userToSearchWith) {
        return new searchMessagesByUser(userToSearchWith);
    }
}
