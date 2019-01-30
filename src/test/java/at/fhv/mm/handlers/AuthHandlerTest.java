package at.fhv.mm.handlers;

import at.fhv.mm.models.User;
import org.junit.Assert;
import org.junit.Test;

public class AuthHandlerTest {
    @Test
    public void testSingleton() {
        Assert.assertNotNull(AuthHandler.getInstance());
    }
    @Test
    public void testLogout() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        handler.logout("user@test.com");
        Assert.assertFalse(handler.users.containsKey("user@test.com"));
    }
    @Test(expected = Exception.class)
    public void testLogoutEmptyMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        handler.logout("");
    }
    @Test(expected = Exception.class)
    public void testLogoutNullMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        handler.logout(null);
    }
    @Test
    public void testGetUser() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        Assert.assertNotNull(handler.getUser("user@test.com"));
    }
    @Test(expected = Exception.class)
    public void testGetUserEmptyMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        handler.getUser("");
    }
    @Test(expected = Exception.class)
    public void testGetUserNullMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.users.put("user@test.com", new User());
        handler.getUser(null);
    }
    @Test
    public void testLogin() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        String token = handler.login("user@test.com");
        Assert.assertNotNull(token);
        Assert.assertNotEquals("", token);

        User user = handler.users.get(token);
        Assert.assertEquals("user@test.com", user.getEmail());
        Assert.assertNotNull(user.getHistory());
    }
    @Test(expected = Exception.class)
    public void testLoginEmptyMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.login("");
    }
    @Test(expected = Exception.class)
    public void testLoginNullMail() throws Exception {
        AuthHandler handler = AuthHandler.getInstance();
        handler.login(null);
    }
}
