import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception{
        Frontend frontend = new Frontend();
        Mirror mirror = new Mirror();

        Server server = new Server (8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(frontend), "/authform");
        context.addServlet(new ServletHolder(mirror), "/mirror");
        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
