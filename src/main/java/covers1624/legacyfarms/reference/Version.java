package covers1624.legacyfarms.reference;

/**
 * Created by covers1624 on 12/6/2015.
 */
public class Version {
	// Replaced in the build.gradle with the actual values.
	public static final String MAJOR = "${major}";// Incremented each MC release, never reset.
	public static final String RELEASE = "${release}"; // Incremented each feature release, reset each mc release.
	public static final String PATCH = "${patch}"; //Incremented each patch, reset each mc release.
	public static final String BUILD = "${build}"; // Incremented each Jenkins Build, never reset.


	public static String getVersion(){
		return String.format("%s.%s.%s.%s", MAJOR, RELEASE, PATCH, BUILD);
	}
}
