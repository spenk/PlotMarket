import java.io.File;


public class PlotMarketProperties {
	
	public String protection;
	public boolean removePlayersAfter;
	public boolean autofiller;
	public boolean SignDelete;
	
	public PlotMarketProperties(){
		load();
	}

	public void load() {
		new File("plugins/config").mkdir();
		PropertiesFile f = new PropertiesFile("plugins/config/PlotMarket.properties");
		this.removePlayersAfter = f.getBoolean("Remove_players_after_buy",true);
		this.autofiller = f.getBoolean("Auto_filler",true);
		this.protection = f.getString("Protection_Type(cuboids_cuboids2_realms)","Cuboids2");
		this.SignDelete = f.getBoolean("Delete_sign_after_buy",true);
	}
}
