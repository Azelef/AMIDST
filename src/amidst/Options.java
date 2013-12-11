package amidst;

import amidst.preferences.BiomeColorProfile;
import amidst.preferences.BooleanPrefModel;
import amidst.preferences.FilePrefModel;

import java.io.File;
import java.util.prefs.Preferences;

/** Currently selected options that change AMIDST’s behavior
 */
public enum Options {
	instance;
	
	//per-run preferences. TODO: store elsewhere?
	public long seed;
	public String seedText;
	
	//permanent preferences
	public final FilePrefModel jar;
	public final BooleanPrefModel showSlimeChunks;
	public final BooleanPrefModel showGrid;
	public final BooleanPrefModel showNetherFortresses;
	public final BooleanPrefModel showTemples, showPlayers, showStrongholds, showVillages, showSpawn;
	public final BooleanPrefModel mapFlicking, showFPS, showDebug;
	public final BooleanPrefModel maxZoom;
	public BiomeColorProfile biomeColorProfile;
	
	private Options() {
		seed = 0L;
		seedText = null;
		
		
		Preferences pref = Preferences.userNodeForPackage(Amidst.class);
		
		jar                  = new FilePrefModel(   pref, "jar", new File(Util.minecraftDirectory, "bin/minecraft.jar"));
		showSlimeChunks      = new BooleanPrefModel(pref, "slimeChunks",         false);
		showGrid             = new BooleanPrefModel(pref, "grid",                false);
		showNetherFortresses = new BooleanPrefModel(pref, "netherFortressIcons", false);
		mapFlicking          = new BooleanPrefModel(pref, "mapFlicking",         true);
		maxZoom              = new BooleanPrefModel(pref, "maxZoom",             true);
		showStrongholds      = new BooleanPrefModel(pref, "strongholdIcons",     true);
		showPlayers          = new BooleanPrefModel(pref, "playerIcons",         true);
		showTemples          = new BooleanPrefModel(pref, "templeIcons",         true);
		showVillages         = new BooleanPrefModel(pref, "villageIcons",        true);
		showSpawn            = new BooleanPrefModel(pref, "spawnIcon",           true);
		showFPS              = new BooleanPrefModel(pref, "showFPS",             true);
		showDebug            = new BooleanPrefModel(pref, "showDebug",           false);
		biomeColorProfile    = new BiomeColorProfile();
		biomeColorProfile.fillColorArray();
		

				
	}
	
	public File getJar() {
		return jar.get();
	}
	
	public String getSeedMessage() {
		if (seedText == null)
			return "Seed: " + seed;
		else
			return "Seed: \"" + seedText + "\" (" + seed +  ")";
	}
}
