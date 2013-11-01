package objects;

/**
 * Creates a 'ghost student' to help obfuscate real student grades
 * 
 * @author Jesse W Milburn
 * @date 01 October, 2013
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
