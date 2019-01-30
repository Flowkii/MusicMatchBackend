package at.fhv.mm.endpoints;
import at.fhv.mm.endpoint.MusicEndpoint;
import org.junit.Test;

public class MusicEndpointClass {
    @Test(expected = Exception.class)
    public void testAnalyzeEmptyToken() throws Exception {
        MusicEndpoint analysisEndpoint = new MusicEndpoint();
        analysisEndpoint.getLyrics("oasis", "wonderwall",  "");
    }
    @Test(expected = Exception.class)
    public void testAnalyzeNullToken() throws Exception {
        MusicEndpoint analysisEndpoint = new MusicEndpoint();
        analysisEndpoint.getLyrics("oasis", "wonderwall",  null);
    }
}
