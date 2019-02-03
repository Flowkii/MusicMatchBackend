package at.fhv.mm.endpoints;

import at.fhv.mm.endpoint.HistoryEndpoint;
import org.junit.Test;

public class HistoryEndpointTest {
    @Test(expected = Exception.class)
    public void testGetHistoryEmptyToken() throws Exception {
        HistoryEndpoint endpoint = new HistoryEndpoint();
        endpoint.getHistory("");
    }
    @Test(expected = Exception.class)
    public void testGetHistoryNullToken() throws Exception {
        HistoryEndpoint endpoint = new HistoryEndpoint();
        endpoint.getHistory(null);
    }
}
