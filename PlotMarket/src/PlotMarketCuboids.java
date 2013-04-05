import java.util.ArrayList;


public class PlotMarketCuboids {
	
	public String getAreaName(Block block){
		return (String)etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_NAME", block});
	}
	
	@SuppressWarnings("unchecked")
	public boolean existsArea(String area){
		ArrayList<String> list = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		return list != null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public boolean isOwner(String player, String area){
		ArrayList<String> allowed = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		return allowed.contains("o:"+player);
	}
	
	public boolean addPLayerAsOwner(String player, String area){
		return (Boolean)etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"ALLOW_NEW", area, "o:"+player});
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getOwners(String area){
		ArrayList<String> allowed = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		ArrayList<String> owners = new ArrayList<String>();
		for (String owner : allowed){
			if (owner.contains("o:")){
				owners.add(owner);
			}
		}
		return owners;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getGroups(String area){
		ArrayList<String> allowed = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		ArrayList<String> groups = new ArrayList<String>();
		for (String group : allowed){
			if (group.contains("g:")){
				groups.add(group);
			}
		}
		return groups;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPlayers(String area){
		ArrayList<String> allowed = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		ArrayList<String> players = new ArrayList<String>();
		for (String player : allowed){
			if (!player.contains("o:")&&!player.contains("g:")){
				players.add(player);
			}
		}
		return players;
	}
	
	@SuppressWarnings("unchecked")
	public void clearArea(String area){
		ArrayList<String> allowed = (ArrayList<String>) etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"GET_AREA_ALLOWED", area});
		for (String allow : allowed){
			etc.getLoader().callCustomHook("CuboidPlugin-API", new Object[] {"REMOVE_ALLOWED", area, allow});
		}
	}

}
