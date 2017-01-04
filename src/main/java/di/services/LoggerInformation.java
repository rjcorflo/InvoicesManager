package di.services;

import javafx.collections.ObservableList;
import model.log.Log;

import java.time.LocalDateTime;

/**
 * Created by Solus on 04/01/2017.
 */
public class LoggerInformation extends Logger
{

    @Override
    public void addEntry(Log.Type logType, String message) {
        this.logObservableList.add(new Log(logType, message, LocalDateTime.now()));
    }

    @Override
    public void addInformation(String message) {
        this.addEntry(Log.Type.Information, message);
    }

    @Override
    public void addWarning(String message) {
        this.addEntry(Log.Type.Warning, message);
    }

    @Override
    public void addError(String message) {
        this.addEntry(Log.Type.Error, message);
    }

    @Override
    public ObservableList<Log> getLogList() {
        return this.logObservableList;
    }
}
