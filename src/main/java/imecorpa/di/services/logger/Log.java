package imecorpa.di.services.logger;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

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

    private ObjectProperty<Type> logType;

    private StringProperty logMessage;

    private ObjectProperty<LocalDateTime> time;

    public Log(Type logType, String message, LocalDateTime localDateTime) {
        this.logType = new SimpleObjectProperty<Type>(logType);
        this.logMessage = new SimpleStringProperty(message);
        this.time= new SimpleObjectProperty<LocalDateTime>(localDateTime);
    }

    public Type getLogType() {
        return logType.get();
    }

    public ObjectProperty<Type> logTypeProperty() {
        return logType;
    }

    public String getLogMessage() {
        return logMessage.get();
    }

    public StringProperty logMessageProperty() {
        return logMessage;
    }

    public LocalDateTime getTime() {
        return time.get();
    }

    public ObjectProperty<LocalDateTime> timeProperty() {
        return time;
    }
}
