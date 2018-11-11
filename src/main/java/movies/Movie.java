package movies;

import java.math.BigDecimal;
import java.util.List;

public class Movie {
	String title;
	String year;
	List<String> cast;
	List<String> genres;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", cast=" + cast + ", genres=" + genres + "]";
	}
	
	
}
