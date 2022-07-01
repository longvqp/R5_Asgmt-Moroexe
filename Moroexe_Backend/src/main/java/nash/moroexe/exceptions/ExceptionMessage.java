package nash.moroexe.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ExceptionMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
    public ExceptionMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

}
