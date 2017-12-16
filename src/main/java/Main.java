import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

public class Main {
    public static void main(String[] args) throws Exception{
        Frontend frontend = new Frontend();
        Mirror mirror = new Mirror();
        SignIn signIn = new SignIn();
        SignUp signUp = new SignUp();

        Server server = new Server (8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(frontend), "/authform");
        context.addServlet(new ServletHolder(mirror), "/mirror");
        context.addServlet(new ServletHolder(signIn), "/signin");
        context.addServlet(new ServletHolder(signUp), "/signup");
        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
