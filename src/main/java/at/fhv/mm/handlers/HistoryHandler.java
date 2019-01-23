package at.fhv.mm.handlers;

// Start of user code (user defined imports)

// End of user code

import at.fhv.mm.models.HistoryItem;
import at.fhv.mm.models.User;

import java.time.Instant;

public class HistoryHandler {
	// Start of user code (user defined attributes)
	
	// End of user code
	

	private static HistoryHandler INSTANCE;
	
	private HistoryHandler(){
	    // singleton
	}
	
	public static HistoryHandler getInstance(){
	    if(INSTANCE == null){
	        INSTANCE = new HistoryHandler();
	    }
	
	    return INSTANCE;
	}
	
	public void addHistory(String token, String searchString, at.fhv.mm.models.LyricsResult result) throws Exception {
		// Start of user code addHistory
		User user = AuthHandler.getInstance().getUser(token);
		HistoryItem item = new HistoryItem();
		item.setRequestDate(Instant.now().toEpochMilli());
		item.setSearchString(searchString);
		item.setLyricsresult(result);
		user.getHistory().getHistoryitem().add(item);
		// End of user code
	}
	
	public at.fhv.mm.models.History getHistory(String token) throws Exception {
		// Start of user code getHistory
		if (token == null || token.equals("")) {
			throw new Exception("Invalid Token");
		}

		User user = AuthHandler.getInstance().getUser(token);
		return user.getHistory();
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
