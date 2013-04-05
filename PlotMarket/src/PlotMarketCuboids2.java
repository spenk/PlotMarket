import java.util.ArrayList;


public class PlotMarketCuboids2 {
	public String getAreaName(String player){
		return (String)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_NAME_LOCAL", player});
	}
	
	@SuppressWarnings("unchecked")
	public boolean existsArea(World world, String area){
		ArrayList<String> owners = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_OWNERS", world, area});
		ArrayList<String> player = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_PLAYERLIST", world, area});

		if (owners == null && player == null){
		return false;
		}else{
		return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean isOwner(World world, String area,String player){
		ArrayList<String> owners = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_OWNERS", world, area});
		return owners.contains(player);
	}
	
	public boolean addPLayerAsOwner(String player, String area, World world){
		return (Boolean)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_ADD_PLAYER", world, area, "o:"+player});
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getOwners(World world, String area){
		return (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_OWNERS", world, area});
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPlayers(World world, String area){
		return (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_PLAYERLIST", world, area});
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getGroups(World world, String area){
		return (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_GROUPLIST", world, area });
	}
	
	public void clearArea(String area, World world){
		this.clearOwners(area, world);
		this.clearPlayers(area, world);
		this.clearGroups(area, world);
	}
	@SuppressWarnings("unchecked")
	public void clearGroups(String area, World world){
		ArrayList<String> gps = new ArrayList<String>();
		ArrayList<String> groups = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_GROUPLIST", world, area });
		gps.addAll(groups);
		for (String group : gps){
			etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_REMOVE_GROUP", world, area, group});
		}
	}
	@SuppressWarnings("unchecked")
	public void clearPlayers(String area, World world){
		ArrayList<String> ps = new ArrayList<String>();
		ArrayList<String> players = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_PLAYERLIST", world, area});
		ps.addAll(players);
		for (String player : ps){
			etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_REMOVE_PLAYER", world, area, player});
		}
	}
	@SuppressWarnings("unchecked")
	public void clearOwners(String area, World world){
		ArrayList<String> os = new ArrayList<String>();
		ArrayList<String> owners = (ArrayList<String>)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_GET_OWNERS", world, area});
		os.addAll(owners);
		for (String player : os){
			etc.getLoader().callCustomHook("CuboidAPI", new Object[] {"AREA_REMOVE_PLAYER", world, area, player});
		}
	}
}
