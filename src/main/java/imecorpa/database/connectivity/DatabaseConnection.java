package imecorpa.database.connectivity;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import imecorpa.configuration.Configuration;

import javax.inject.Inject;
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
            String databaseUrl = this.configuration.getValue("databaseUrl");
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + databaseUrl);
        }

        return connectionSource;
    }
}
