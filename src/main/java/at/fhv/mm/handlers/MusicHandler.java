package at.fhv.mm.handlers;

// Start of user code (user defined imports)

// End of user code

import at.fhv.mm.models.LyricsResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MusicHandler {
	// Start of user code (user defined attributes)
	
	// End of user code
	

	private static MusicHandler INSTANCE;
	
	private MusicHandler(){
	    // singleton
	}
	
	public static MusicHandler getInstance(){
	    if(INSTANCE == null){
	        INSTANCE = new MusicHandler();
	    }
	
	    return INSTANCE;
	}
	
	public at.fhv.mm.models.LyricsResult findLyrics(String artist, String token, String title) throws Exception {
		// Start of user code findLyrics
		if(token == null || token.equals("")) {
			throw new Exception("Invalid Token");
		}

		System.out.println("test");
		if(!(artist==null || title == null || artist.equals("") || title.equals(""))) {

			String apiURL = "https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?format=jsonp&callback=callback";
			String trackPart = "&q_track="+ title;
			String artistPart = "&q_artist="+ artist;
			String apiKey = "&apikey=d4ba61ac04e32ad791c1f02fe83a0240";
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https");
			builder.setHost("api.musixmatch.com");
			builder.setPath("/ws/1.1/matcher.lyrics.get");
			builder.addParameter("apikey", "d4ba61ac04e32ad791c1f02fe83a0240");
			builder.addParameter("q_track",title);
			builder.addParameter("q_artist",artist);
			URL urlForGetRequest = builder.build().toURL();

			String readLine = null;
			System.out.println(urlForGetRequest);
			HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

			int responseCode = conection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conection.getInputStream()));
				StringBuffer response = new StringBuffer();

				while ((readLine = in.readLine()) != null) {
					response.append(readLine);
				}
				in.close();
				// print result
				System.out.println("JSON String Result " + response.toString());

				JSONObject jsonObject = new JSONObject(response.toString());
				String lyric = jsonObject.getJSONObject("message").getJSONObject("body").getJSONObject("lyrics").getString("lyrics_body");
				System.out.println(lyric);
				LyricsResult lyricResult = new LyricsResult();
				lyricResult.setLyrics(lyric);

				HistoryHandler.getInstance().addHistory(token, artist+" "+title, lyricResult);
				return lyricResult;
			}
		}
		return null;
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
