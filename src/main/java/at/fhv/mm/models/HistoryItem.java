package at.fhv.mm.models;

// Start of user code (user defined imports)

// End of user code

public class HistoryItem {
	/**
	 * Description of the property searchString.
	 */
	public String searchString = null;
	
	/**
	 * Description of the property requestDate.
	 */
	public long requestDate = 0;
	
	/**
	 * Description of the property lyricsresult.
	 */
	public at.fhv.mm.models.LyricsResult lyricsresult = null;
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public String getSearchString(){
		   return this.searchString;
		}
		
		public void setSearchString(String searchString){
		   this.searchString = searchString;
		}
		
		public long getRequestDate(){
		   return this.requestDate;
		}
		
		public void setRequestDate(long requestDate){
		   this.requestDate = requestDate;
		}
		
		public at.fhv.mm.models.LyricsResult getLyricsresult(){
		   return this.lyricsresult;
		}
		
		public void setLyricsresult(at.fhv.mm.models.LyricsResult lyricsresult){
		   this.lyricsresult = lyricsresult;
		}
		
	
}
