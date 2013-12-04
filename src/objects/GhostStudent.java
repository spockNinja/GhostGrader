package objects;

import java.util.Comparator;

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
	
    /**
     * Allows for comparison/sorting based on the Students' PseudoNames
     * Simply pass this into Collections.sort() as the comparator
     */
    public static Comparator<GhostStudent> PseudoNameComparator = new Comparator<GhostStudent>() {
        public int compare(GhostStudent s1, GhostStudent s2) {
            String psName1 = s1.getPseudoName().toUpperCase();
            String psName2 = s2.getPseudoName().toUpperCase();
            return psName1.compareTo(psName2);
        };
    };
}
