package at.fhv.mm.handlers;

import org.junit.Assert;
import org.junit.Test;

public class HistoryEndpointTest {
    @Test
    public void testSingleton() {
        Assert.assertNotNull(HistoryHandler.getInstance());
    }
}
