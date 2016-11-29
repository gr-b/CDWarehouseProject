import java.util.ArrayList;

public class Model {

	ArrayList<CDModel> cds;
	ArrayList<CDModel> wishlist;
	String selectedGenre;
	String selectedArtist;
	String prevSelection;
	
	public Model(){
		cds = new ArrayList<CDModel>();
		wishlist = new ArrayList<CDModel>();
		selectedGenre = null;
		selectedArtist = null;
		prevSelection = null;
	}
	
	public ArrayList<String> getGenres(){
		ArrayList<String> ret = new ArrayList<String>();
		
		for(CDModel cd : cds){
			if(!ret.contains(cd.genre)){
				ret.add(cd.genre);
			}
		}
		
		return ret;
		
	}
	
	public void add(CDModel cd){
		cds.add(cd);
	}

	public ArrayList<String> constrainBySelection(String selection) {
		ArrayList<String> constrained = new ArrayList<String>();
		for(CDModel cd : cds){
			if(cd.genre.equals(selection)){
				constrained.add(cd.artist);
			} else if(cd.artist.equals(selection)){
				constrained.add(cd.name);
			} 
		}
		
		return constrained;
	}

	public CDModel getCD(String item) {
		for(CDModel cd : cds){
			if(cd.name.equals(item)){
				return cd;
			}
		}
		return null;
	}

	public void addToWishlist(CDModel newCd) {
		wishlist.add(newCd);
		
	}
	
	
}
