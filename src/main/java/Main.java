import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception{
        Frontend frontend = new Frontend();
        Mirror mirror = new Mirror();
        AccountService accountService = new AccountService();
        SignIn signIn = new SignIn(accountService);
        SignUp signUp = new SignUp(accountService);

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
