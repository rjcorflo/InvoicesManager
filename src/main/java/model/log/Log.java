package model.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Solus on 03/01/2017.
 */
public class Log
{
    public enum Type {
        Error(3),
        Warning(2),
        Information(1);

        private int codigoLog;

        private Type(int codigoLog) {
            this.codigoLog = codigoLog;
        }

        public int getCodigoLog() {
            return this.codigoLog;
        }
    }

    private Type logType;

    private String message;

    private LocalDateTime time;

    public Log(Type logType, String message, LocalDateTime localDateTime) {
        this.logType = logType;
        this.message = message;
        this.time = localDateTime;
    }

    public int getType() {
        return logType.getCodigoLog();
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm");
        String out = time.format(format);

        return out;
    }
}
