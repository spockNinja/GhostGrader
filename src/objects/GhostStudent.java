package objects;

/**
 * 
 * 
 * @author Jesse W Milburn
 * @version version
 */
public class GhostStudent {
	private String pseudoName;
	
	/**
	 * Constructs a ghost/fake student
	 * 
	 * @param pn	The false name assigned
	 */
	public GhostStudent(String pn) {
		pseudoName = pn;
	}
	
	/**
	 * Fetches the false name assigned
	 * 
	 * @return		Name of the fake/ghost student
	 */
	public String getPseudoName() {
		return pseudoName;
	}
}
