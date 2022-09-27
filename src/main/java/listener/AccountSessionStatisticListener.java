package listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import Constants.Constants;


import java.util.List;

public class AccountSessionStatisticListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        List<String> actions = (List<String>) se.getSession().getAttribute(Constants.ACCOUNT_ACTIONS_HISTORY);
        if (actions != null){
            logCurrentActionsHistory(se.getSession().getId(), actions);
        }
    }

    private void logCurrentActionsHistory(String sessionId, List<String> actions){
        System.out.println(sessionId + "\n\t" + String.join("\n\t", actions));
    }
}
