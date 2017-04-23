package imecorpa.service.logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Solus on 04/01/2017.
 */
abstract class LoggerBase implements LoggerService
{
    protected ObservableList<Log> logObservableList = FXCollections.observableArrayList();

    abstract public void addEntry(Log.Type logType, String message);

    abstract public void addInformation(String message);

    abstract public void addWarning(String message);

    abstract public void addError(String message);

    abstract public ObservableList<Log> getLogList();
}
