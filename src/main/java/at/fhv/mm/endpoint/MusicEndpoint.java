package at.fhv.mm.endpoint;

// Start of user code (user defined imports)

import org.springframework.web.bind.annotation.CrossOrigin;

// End of user code
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class MusicEndpoint {
	// Start of user code (user defined attributes)
	
	// End of user code
	
	
	@org.springframework.web.bind.annotation.GetMapping("/lyrics")
	public at.fhv.mm.models.LyricsResult getLyrics(@org.springframework.web.bind.annotation.RequestParam("artist") String artist, @org.springframework.web.bind.annotation.RequestParam("title") String title, @org.springframework.web.bind.annotation.RequestParam("token") String token) throws Exception {
		// Start of user code getLyrics
		return at.fhv.mm.handlers.MusicHandler.getInstance().findLyrics(artist,token,title);
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
}
