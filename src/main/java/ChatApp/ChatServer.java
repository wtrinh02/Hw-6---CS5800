package ChatApp;

import java.util.*;

public class ChatServer {

    private HashMap<String, User> registeredUser = new HashMap<String, User>();
    private HashMap<User, Set<User>> blockedList = new HashMap<User, Set<User>>();



    public void registerUser(User user){
        if(!registeredUser.containsKey(user.getUsername())){
            registeredUser.put(user.getUsername(), user);
            blockedList.put(user, new HashSet<User>());
            System.out.println("User "+user.getUsername()+" is registered");
        }

    }

    public void unregisterUser(User user){
        registeredUser.remove(user.getUsername());
        blockedList.remove(user);
    }

    public void blockUser(User user, User blockedUser){
        if(blockedList.containsKey(user)){
            blockedList.get(user).add(blockedUser);
            System.out.println("User "+user.getUsername()+" blocked " +  blockedUser.getUsername());
        }
    }
    public void sendMessage(User sender, String message, List<User> recipients){

        for(User recipient: recipients){
            Set<User> recipientBlockList = blockedList.get(recipient);
            if(recipientBlockList != null && recipientBlockList.contains(sender)){
                System.out.println(recipient.getUsername() + " has blocked messages from " + sender.getUsername());
            }
            else{
                System.out.println(sender.getUsername()+ " sent message to " + recipient.getUsername());
                Message sentMessage = sender.sendMessage(message, Collections.singletonList(recipient));
                recipient.receiveMessage(sentMessage);

            }
        }
    }

    public void printChatHistory(User user){
        searchMessagesByUser iterator = new searchMessagesByUser(user);
        while(iterator.hasNext()){
            Message message = iterator.next();

                for(User recipient: message.getRecipients()){
                    System.out.println("["+message.getTimestamp()+"] "+ message.getSender().getUsername()+ " -> "+ recipient.getUsername()+ ": "+ message.getContent());
                }

        }
    }

    public void undoLastMessage(User user){
        user.undoMessage();
    }

    public HashMap<String, User> getRegisteredUser(){
        return registeredUser;
    }
    public HashMap<User, Set<User>> getBlockedList(){
        return blockedList;
    }

}
