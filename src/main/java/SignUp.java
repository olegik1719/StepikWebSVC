import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet{

    private AccountService accountService;

    public SignUp(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean allOK = false;
        if ((login != null)&&(password!= null)){
            allOK = accountService.addAccount(login,password);
        }
        if (allOK) {
            response.getWriter().printf("Добро пожаловать на портал, %s!%n", login);
        }else{
            response.getWriter().printf("К сожалению, нельзя регистрироваться под таким именем%n");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

}
