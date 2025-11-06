package modele;

public class Anime {
	protected int malId;
	protected String url;
	protected String images; 
	protected String trailer;
	protected String title;
	protected String titleEnglish;
	protected String titleJapanese;
	protected String type;
	protected int year;
    
    
    
	public Anime() {
		super();
	}
	
	public Anime(String url, String title, String titleJapanese, String type, int year) {
		super();
		this.url = url;
		this.title = title;
		this.titleJapanese = titleJapanese;
		this.type = type;
		this.year = year;
	}

	public Anime(String url, String images, String titleEnglish, String titleJapanese, String type, int year) {
		
		this.url = url;
		this.images = images;
		this.titleEnglish = titleEnglish;
		this.titleJapanese = titleJapanese;
		this.type = type;
		this.year = year;
	}
	public int getMalId() {
		return malId;
	}
	public void setMalId(int malId) {
		this.malId = malId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleEnglish() {
		return titleEnglish;
	}
	public void setTitleEnglish(String titleEnglish) {
		this.titleEnglish = titleEnglish;
	}
	public String getTitleJapanese() {
		return titleJapanese;
	}
	public void setTitleJapanese(String titleJapanese) {
		this.titleJapanese = titleJapanese;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
