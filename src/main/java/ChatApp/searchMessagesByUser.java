package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class searchMessagesByUser implements Iterator {


    private User user;
    private List<Message> messageHistory;
    private int messageCollectionSize;
    private int indexInMessageCollection;
    public searchMessagesByUser(User userToSearchWith) {
        this.user = userToSearchWith;
        messageHistory = user.getChatHistory().getMessageHistory();
        messageCollectionSize = messageHistory.size();
        indexInMessageCollection = 0;
    }

    @Override
    public boolean hasNext() {
        while(indexInMessageCollection < messageCollectionSize){
            Message message = messageHistory.get(indexInMessageCollection);
            if(message.getSender().equals(user) || message.getRecipients().contains(user)){
                return true;
            }
            else{
                indexInMessageCollection++;
            }

        }
        return false;
    }

    @Override
    public Message next() {
        if(hasNext()){
            return messageHistory.get(indexInMessageCollection++);
        }
        return null;
    }
}
