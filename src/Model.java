import java.util.ArrayList;

public class Model {

	ArrayList<CDModel> cds;
	ArrayList<CDModel> wishlist;
	String selectedGenre;
	String selectedArtist;
	String prevSelection;
	
	String username;
	public boolean hasAlreadyParsed = false;
	
	public Model(String username){
		cds = new ArrayList<CDModel>();
		wishlist = new ArrayList<CDModel>();
		selectedGenre = null;
		selectedArtist = null;
		prevSelection = null;
		this.username = username;
	}
	
	public void printCDs(){
		for(CDModel cd : cds){
			System.out.println("(" + cd.name + ")"); //+ ", " + cd.artist + ", " + cd.genre + );
		}
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
		// First, check if it would be a duplicate
		if(!this.wishlist.contains(newCd)){
			wishlist.add(newCd);
		}
		
	}

	public CDModel getCDModelWithTitle(String title) {
		for(CDModel cd : cds){
			if(cd.name.equals(title)){
				return cd;
			}
		}
		return null;
	}

	public void removeCDFromWishlistWithTitle(String title) {
		int i = 0;
		for(CDModel cd : wishlist){
			if(cd.name.equals(title)){
//				System.out.println("Found mathcing cd");
				wishlist.remove(i);
				return;
			}
			i++;
		}
		
	}
	
	
}
