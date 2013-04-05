public class PlotMarketRealms {
	
	public boolean existsArea(String area){
		return (Boolean)etc.getLoader().callCustomHook("Realms-ZoneCheck", new Object[] {"Name-Check", area});
	}
	
	public String[] getAreaName(Player player){
		return (String[])etc.getLoader().callCustomHook("Realms-ZoneCheck", new Object[] {"Player-Zone", player});
	}
	
	public boolean isOwner(Player player, String area){
		return (Boolean)etc.getLoader().callCustomHook("Realms-PermissionCheck", new Object[] {"ALL", player, area});
	}
	
	public boolean addPLayerAsOwner(String player, String area){
		return (Boolean)etc.getLoader().callCustomHook("Realms-PermissionChange", new Object[] {player, "ALL", area, "GRANT"});
	}
	
}
