package cms.beans;



//this class made for getting specific column from database
public class CourseTitleAndProvider {
  
	 private String title;
	 private String provider;
	 
	public CourseTitleAndProvider(String title, String provider) {
		super();
		this.title = title;
		this.provider = provider;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

}
