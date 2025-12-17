import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
public class Message {
    String[] message = new String[2];

    Message (String msg) {
    message[0] = msg;
    String gulp = String.valueOf(LocalDateTime.now());
    message[1] = gulp;
    }

    public String[] getMessage() {
        return message;
    }
}
