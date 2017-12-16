import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignIn extends HttpServlet {

    private AccountService accountService;

    public SignIn(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean allOK = false;
        if ((login != null)&&(password!= null)){
            allOK = accountService.checkAccount(login,password);
        }
        if (allOK) {
            response.setStatus(200);
            response.getWriter().printf("Authorized: %s%n", login);
        }else{
            response.setStatus(401);
            response.getWriter().printf("Unauthorized%n");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

}

