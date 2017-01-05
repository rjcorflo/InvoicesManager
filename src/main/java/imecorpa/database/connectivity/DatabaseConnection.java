package imecorpa.database.connectivity;

import com.google.inject.Inject;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import imecorpa.configuration.Configuration;

import java.sql.SQLException;

/**
 * Created by Solus on 02/01/2017.
 */
public class DatabaseConnection
{
    private ConnectionSource connectionSource;

    private Configuration configuration;

    @Inject
    public DatabaseConnection(Configuration configuration) {
        this.configuration = configuration;
    }

    public ConnectionSource getConnection() throws SQLException {
        if (connectionSource == null) {
            String databaseUrl = this.configuration.getValue("databaseUrl", "jdbc:sqlite:D:\\Ravier\\Workspace\\JavaProjects\\imecorpa.db");
            connectionSource = new JdbcConnectionSource(databaseUrl);
        }

        return connectionSource;
    }
}
