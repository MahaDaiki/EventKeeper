package Models;

public class Events {
	private static int lastId = 0;
	private int Id;
	private String Date;
	private String Place;
	private String Type;
	
	
	public Events ( String Date, String Place, String Type) {
		this.Id = ++lastId;
		this.Date = Date;
		this.Place = Place;
		this.Type = Type;
	}
		
	 public int getId() {
	        return Id;
	    }
	 
		public String getDate() {
	        return Date;
	    }
	    public void setDate(String Date) {
	        this.Date = Date;
	    }
    
	    public String getPlace() {
	    	return Place;
	    }
	    public void  setPlace(String Place) {
	    	this.Place = Place;
	    }
	    
	    public String getType(){
	    	return Type;
	    }
	    public void setType(String Type) {
	    	this.Type = Type;
	    }
	    
	    @Override
	    public String toString() {
	        return "Event -> ID:" + Id + ", Date:" + Date + ", Place:" + Place + ", Type:" + Type + "]";
	    }
    
    
    
}
