import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String,String> accountMap;

    public AccountService(){
        accountMap = new HashMap<>();
    }

    public boolean addAccount(String login, String password){
        if (accountMap.containsKey(login))
            return false;
        else
            accountMap.put(login,password);
        return true;
    }

    public boolean checkAccount(String login, String password){
        if (password.equals(accountMap.get(login)))
            return true;
        else
            return false;
    }
}
