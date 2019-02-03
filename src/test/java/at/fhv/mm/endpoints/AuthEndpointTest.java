package at.fhv.mm.endpoints;

import at.fhv.mm.endpoint.AuthEndpoint;
import org.junit.Assert;
import org.junit.Test;

public class AuthEndpointTest {
    @Test
    public void testLogin() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        String token = endpoint.login("user@test.com");
        Assert.assertNotNull(token);
        Assert.assertNotEquals("", token);
    }
    @Test(expected = Exception.class)
    public void testLoginEmptyMail() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        endpoint.login("");
    }
    @Test(expected = Exception.class)
    public void testLoginNullMail() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        endpoint.login(null);
    }
    @Test
    public void testLogout() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        endpoint.logout("user@test.com");
    }
    @Test(expected = Exception.class)
    public void testLogoutEmptyMail() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        endpoint.logout("");
    }
    @Test(expected = Exception.class)
    public void testLogoutNullMail() throws Exception {
        AuthEndpoint endpoint = new AuthEndpoint();
        endpoint.logout(null);
    }
}
