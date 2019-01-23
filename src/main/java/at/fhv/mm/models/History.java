package at.fhv.mm.models;

// Start of user code (user defined imports)

// End of user code

public class History {
	/**
	 * Description of the property historyitem.
	 */
	public java.util.Set<at.fhv.mm.models.HistoryItem> historyitem = new java.util.HashSet<at.fhv.mm.models.HistoryItem>();
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public java.util.Set<at.fhv.mm.models.HistoryItem> getHistoryitem(){
		   return this.historyitem;
		}
		
		public void setHistoryitem(java.util.Set<at.fhv.mm.models.HistoryItem> historyitem){
		   this.historyitem = historyitem;
		}
		
	
}
