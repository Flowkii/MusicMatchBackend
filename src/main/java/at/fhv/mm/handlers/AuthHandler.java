package at.fhv.mm.handlers;

// Start of user code (user defined imports)

// End of user code

import at.fhv.mm.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;

public class AuthHandler {
    // Start of user code (user defined attributes)
    protected Map<String, User> users = new HashMap<>();
    // End of user code


    private static AuthHandler INSTANCE;

    private AuthHandler() {
        // singleton
    }

    public static AuthHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthHandler();
        }

        return INSTANCE;
    }

    public String login(String email) throws Exception {
        // Start of user code login
        if (email == null || email.equals("")) {
            throw new Exception("You have to enter an Email Address");
        }

        String token = DigestUtils.md5Hex(email);
        if (!users.containsKey(token)) {
            User user = new User();
            user.setEmail(email);
            user.setHistory(new at.fhv.mm.models.History());
            users.put(token, user);
        }

        return token;
        // End of user code
    }

    public void logout(String token) throws Exception {
        // Start of user code logout
        if (token == null || token.equals("")) {
            throw new Exception("Invalid Token");
        }
        users.remove(token);
        // End of user code
    }

    // Start of user code (user defined operations)

    public User getUser(String token) throws Exception {
        if (users.containsKey(token)) {
            return users.get(token);
        }
        throw new Exception("User not found!");
    }

    // End of user code

}
