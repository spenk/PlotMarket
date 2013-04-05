import java.util.ArrayList;

public class PlotMarketDestroyProcessor {
	
	PlotMarketDconomy dco = new PlotMarketDconomy();
	PlotMarketCuboids cuboids = new PlotMarketCuboids();
	PlotMarketProperties properties = new PlotMarketProperties();
	PlotMarketRealms realms = new PlotMarketRealms();
	PlotMarketCuboids2 cuboids2 = new PlotMarketCuboids2();
	
	public boolean processBlockHitEvent(Player player, Block block, Sign sign) {
		if (block.getStatus() == 0) {
			if (!player.canUseCommand("/plotmarketuse")){
			player.sendMessage("§1-§4-§1-§4-§1-§4-§1-§4-§f§f[§3PlotMarket§f]§1-§4-§1-§4-§1-§4-§1-§4-");
			player.sendMessage("§2PlotName: §3" + sign.getText(1));
			player.sendMessage("§2PlotPrice: §3" + sign.getText(2)+ dco.getMoneyName());
			player.sendMessage("§2PlotOwners: §3" + this.getOwners(player.getWorld(), sign.getText(1)));
			player.sendMessage("§2PlotPlayers: §3" + this.getPlayers(player.getWorld(), sign.getText(1)));
			player.sendMessage("§2PlotGroups: §3" + this.getGroups(player.getWorld(), sign.getText(1)));
			return true;
		}
		}
		if (block.getStatus() == 2){
			if (player.canUseCommand("/plotmarketdestroy")){
				if (!player.getName().equalsIgnoreCase(sign.getText(3))){
					if (!player.canUseCommand("/plotmarketadmin")){
						player.notify("§f[§3PlotMarket§f]§c - You do not have the rights to destroy this sign!");
						return true;
					}
				}
			}else{
				player.notify("§f[§3PlotMarket§f]§c - You do not have the rights to destroy this sign!");
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> getGroups(World world,String area){
		if (properties.protection.equalsIgnoreCase("Cuboids")){
			cuboids.getGroups(area);
		}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
			cuboids2.getGroups(world, area);
		}else if (properties.protection.equalsIgnoreCase("Realms")){
		//TODO
		}else{
			return new ArrayList<String>();
		}
		return new ArrayList<String>();
	}
	
	public ArrayList<String> getPlayers(World world,String area){
		if (properties.protection.equalsIgnoreCase("Cuboids")){
			cuboids.getPlayers(area);
		}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
			cuboids2.getPlayers(world, area);
		}else if (properties.protection.equalsIgnoreCase("Realms")){
		//TODO
		}else{
			return new ArrayList<String>();
		}
		return new ArrayList<String>();
	}
	
	public ArrayList<String> getOwners(World world,String area){
		if (properties.protection.equalsIgnoreCase("Cuboids")){
			cuboids.getOwners(area);
		}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
			cuboids2.getOwners(world, area);
		}else if (properties.protection.equalsIgnoreCase("Realms")){
		//TODO
		}else{
			return new ArrayList<String>();
		}
		return new ArrayList<String>();
	}
}
