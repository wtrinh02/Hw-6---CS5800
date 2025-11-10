package ChatApp;

public class MessageMemento {

private Message message;

public MessageMemento(Message message){
    this.message=message;
}
public Message getMessage() {
    return message;
}
public void setMessage(Message message) {
    this.message = message;
}


}
