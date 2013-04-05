
public class PlotMarketSignProcessor {

	PlotMarketCuboids cuboids = new PlotMarketCuboids();
	PlotMarketProperties properties = new PlotMarketProperties();
	PlotMarketRealms realms = new PlotMarketRealms();
	PlotMarketCuboids2 cuboids2 = new PlotMarketCuboids2();
	
	public boolean processSignCreationEvent(Sign sign, Player player){
		if (!player.canUseCommand("/plotmarketcreate")) {
			player.notify("§f[§3PlotMarket§f]§c - You are not allowed to create a PlotMarket sign!");
			return true;
		}
		
		String area = sign.getText(1);
		String price = sign.getText(2).replaceAll("[^.\\d]", "");;
		String owner = sign.getText(3);
		
		if (area.equals("")){
			if (!properties.autofiller){
				player.notify("§f[§3PlotMarket§f]§c - You left the area name empty!");
				clearSign(sign);
				return true;
			}else{
				if (properties.protection.equalsIgnoreCase("Cuboids")){
					sign.setText(1, cuboids.getAreaName(sign.getBlock()));
				}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
					sign.setText(1, cuboids2.getAreaName(player.getName()));
				}else if (properties.protection.equalsIgnoreCase("Realms")){
					sign.setText(1, realms.getAreaName(player)[0]);
				}else{
					player.notify("§f[§3PlotMarket§f]§c - Could not find a protection plugin! make sure you set the right settings!");
					this.clearSign(sign);
					return true;
				}
			}
			area = sign.getText(1);
		}
		
		if (price.equals("")){
				player.notify("§f[§3PlotMarket§f]§c - You left the price empty!");
				clearSign(sign);
				return true;
		}
		
		if (!isNumber(price)){
			player.notify("§f[§3PlotMarket§f]§c - The price must be a correct number!");
			clearSign(sign);
			return true;
		}
		
		if (owner.equals("")){
			sign.setText(3, player.getName());
			owner = player.getName();
		}
		
		
		
		
		if (properties.protection.equalsIgnoreCase("Cuboids")){
			
			if (!cuboids.existsArea(area)){
				player.notify("§f[§3PlotMarket§f]§c - We could not find this area or this area doesnt contain any members!");
				clearSign(sign);
				return true;
			}
			
			if (owner.contains("Server")){
				if (!player.canUseCommand("/plotmarketadmin")){
					player.notify("§f[§3PlotMarket§f]§c - You are not allowed to make server signs!");
					clearSign(sign);
					return true;
				}
			}
			
			if (!cuboids.isOwner(owner, area)){
				if (owner.equalsIgnoreCase(player.getName())){
					player.sendMessage(owner);
				player.notify("§f[§3PlotMarket§f]§c - You dont own this land so you cant sell it!");}else{
					player.notify("§f[§3PlotMarket§f]§c - The player on line 4 doesnt own this land so he cant sell it!");
				}
				clearSign(sign);
				return true;
			}
			
		}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
			
			if (!cuboids2.existsArea(player.getWorld(), area)){
				player.notify("§f[§3PlotMarket§f]§c - We could not find this area or this area doesnt contain any members!");
				clearSign(sign);
				return true;
			}
			
			if (owner.contains("Server")){
				if (!player.canUseCommand("/plotmarketadmin")){
					player.notify("§f[§3PlotMarket§f]§c - You are not allowed to make server signs!");
					clearSign(sign);
					return true;
				}
			}
			
			if (!cuboids2.isOwner(player.getWorld(), area, owner)){
				if (owner.equalsIgnoreCase(player.getName())){
				player.notify("§f[§3PlotMarket§f]§c - You dont own this land so you cant sell it!");}else{
					player.notify("§f[§3PlotMarket§f]§c - The player on line 4 doesnt own this land so he cant sell it!");
				}
				clearSign(sign);
				return true;
			}
			
			
		}else if (properties.protection.equalsIgnoreCase("Realms")){
			if (!realms.existsArea(area)){
				player.notify("§f[§3PlotMarket§f]§c - We could not find this area or this area doesnt contain any members!");
				clearSign(sign);
				return true;
			}
			
			if (owner.contains("Server")){
				if (!player.canUseCommand("/plotmarketadmin")){
					player.notify("§f[§3PlotMarket§f]§c - You are not allowed to make server signs!");
					clearSign(sign);
					return true;
				}
			}
				
			if (!realms.isOwner(player, area)){
				if (owner.equalsIgnoreCase(player.getName())){
				player.notify("§f[§3PlotMarket§f]§c - You dont own this land so you cant sell it!");}else{
					player.notify("§f[§3PlotMarket§f]§c - The player on line 4 doesnt own this land so he cant sell it!");
				}
				clearSign(sign);
				return true;
			}
		}else{
			player.notify("§f[§3PlotMarket§f]§c - Could not find a protection plugin! make sure you set the right settings!");
			this.clearSign(sign);
			return true;
		}
		
		player.sendMessage("§f[§3PlotMarket§f]§c - Sign sucsessfully created!");
		sign.setText(0, "§3[PlotMarket]");
		return false;
	}
	
	private boolean isNumber(String price) {
		try{
			Double.parseDouble(price);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

	public void clearSign(Sign sign){
		sign.setText(0, "");
		sign.setText(1, "");
		sign.setText(2, "");
		sign.setText(3, "");
		return;
	}
	
}
