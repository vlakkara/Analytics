package movies;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import com.google.gson.Gson;
import java.nio.file.Files;

/**
 * Hello world!
 *
 */
public class AppCinema {
	public static void main(String[] args) {
	
		Gson gson = new Gson();
		String fileName = "file/test.json";
		ClassLoader classLoader = new AppCinema().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		String jsonInString = null;
		try {
			jsonInString = new String(Files.readAllBytes(file.toPath()));
			Movie[] movieList = gson.fromJson(jsonInString, Movie[].class);
		   HashSet<String> resList=new HashSet<String>();  
		   searchString(movieList, "Action", 0,resList,0);
		   
		   resList=new HashSet<String>();  
		   searchString(movieList, "Jeremy Renner", 0,resList,0);
		   
		   resList=new HashSet<String>();  
		   searchString(movieList, "Chris", 0,resList,0);

		   resList=new HashSet<String>();  
 		   searchString(movieList, "Adam", 0,resList,0);
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(jsonInString);
	}


	public static void searchString(Movie[] movList, String searchString, int i,HashSet<String> resList,int count) {
	
	
		if (i < movList.length) {
			Movie obj = movList[i];
			List<String> genres = obj.getGenres();
			
			List<String> cast = obj.getCast();
			
			String title = obj.getTitle();
		
				for (String curVal : genres) {
					if (curVal.contains(searchString)) {				
						resList.add(obj.getTitle());
						++count;
					}
				}	

				for (String curVal : cast) {
					if (curVal.contains(searchString)) {				
						resList.add(obj.getTitle());
						++count;
					}
				}	
				
				if (title.contains(searchString)) {				
					resList.add(obj.getTitle());
					++count;
				}
			
		}
		else {
			
			System.out.print("Search Term:     "+searchString);
			System.out.print("\t \t Movies:    "+resList);
			System.out.println("\t  \t count:  "+count);

			
			return;
			
			
		}
		searchString(movList,searchString,++i,resList,count);
		
	}
}
