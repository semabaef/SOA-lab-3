package configuration;

import lombok.SneakyThrows;
import services.VehicleService;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class RemoteEjbConfig {

    @SneakyThrows
    public static Context remoteContext() {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put(Context.PROVIDER_URL,
                "http-remoting://127.0.0.1:7661");
        return new InitialContext(jndiProps);
    }

    @SneakyThrows
    public static VehicleService getVehicleService(Context context) {
        return (VehicleService) context.lookup("ejb:/VehicleEJB/VehicleServiceImpl!services.VehicleService");
    }

}
