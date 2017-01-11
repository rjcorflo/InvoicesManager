package imecorpa.di.services.logger;

import javafx.collections.ObservableList;

/**
 * Created by Solus on 05/01/2017.
 */
public interface LoggerService
{
    void addEntry(Log.Type logType, String message);

    void addInformation(String message);

    void addWarning(String message);

    void addError(String message);

    ObservableList<Log> getLogList();
}
