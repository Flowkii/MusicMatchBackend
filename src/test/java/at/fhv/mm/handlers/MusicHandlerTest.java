package at.fhv.mm.handlers;

import org.junit.Assert;
import org.junit.Test;

public class MusicHandlerTest {
    @Test
    public void testSingleton() {
        Assert.assertNotNull(MusicHandler.getInstance());
    }
}
