package ChatApp;

import java.time.*;
import java.util.Date;
import java.util.List;

public class Message {

    private User sender;
    private List<User> recipients;
    private String content;
    private Date timestamp;

    public Message(User sender, List<User> recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.content = content;
        this.timestamp = new Date();
    }

    public User getSender() {
        return sender;
    }
    public List<User> getRecipients() {
        return recipients;
    }
    public String getContent() {
        return content;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "["+timestamp+"] "+ sender.getUsername()+ ": "+ content;
    }
}
