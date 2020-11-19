import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import Server.Database.ConnectionManager;

@ApplicationPath("/")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {

        ConnectionManager connectionManager = new ConnectionManager();
        ConnectionManager.getConnection();
        Set<Class<?>> h = new HashSet<>();
        h.add(TourService.class);
        h.add(UserService.class);
        h.add(ServerConnectedService.class);
        return h;
    }
}