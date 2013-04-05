public class PlotMarketClickProcessor {
	PlotMarketDconomy dco = new PlotMarketDconomy();
	PlotMarketCuboids cuboids = new PlotMarketCuboids();
	PlotMarketProperties properties = new PlotMarketProperties();
	PlotMarketRealms realms = new PlotMarketRealms();
	PlotMarketCuboids2 cuboids2 = new PlotMarketCuboids2();

	public boolean processSignClickEvent(Player player, Sign sign){
		if (!player.canUseCommand("/plotmarketuse")){
			player.notify("§f[§3PlotMarket§f]§c - You do not have the rights to buy this plot!");
			return true;
		}
		
		String area = sign.getText(1);
		double price = Double.parseDouble(sign.getText(2));
		String owner = sign.getText(3);
		
		if (owner.equalsIgnoreCase(player.getName())){
			player.notify("§f[§3PlotMarket§f]§c - You do not have the rights to buy your own plot!");
			return true;
		}
		
		if (price > dco.getPlayerBalance(player.getName())){
			player.notify("§f[§3PlotMarket§f]§c - You do not have enough funds to buy this plot!");
			return true;
		}
		
		if (properties.protection.equalsIgnoreCase("Cuboids")){
			if (properties.removePlayersAfter){
				cuboids.clearArea(area);
			}
			cuboids.addPLayerAsOwner(player.getName(), area);
		}else if (properties.protection.equalsIgnoreCase("Cuboids2")){
			if (properties.removePlayersAfter){
				cuboids2.clearArea(area, player.getWorld());
			}
			cuboids2.addPLayerAsOwner(player.getName(), area, player.getWorld());
		}else if (properties.protection.equalsIgnoreCase("Realms")){
			realms.addPLayerAsOwner(player.getName(), area);
		}else{
			player.notify("§f[§3PlotMarket§f]§c - Could not find a protection plugin! make sure you set the right settings!");
			return true;
		}
		
		dco.withdrawFromPlayer(player.getName(), price);
		dco.DepositToPlayer(owner, price);
		
		player.sendMessage("§f[§3PlotMarket§f]§c - Transaction sucsessfull!");
		double balance = dco.getPlayerBalance(player.getName());
		player.sendMessage("§f[§3PlotMarket§f]§c - Your new balance is now §2"+balance+"§3"+dco.getMoneyName());
		clearSign(sign);
		return false;
	}
	
	public void clearSign(Sign sign){
		sign.setText(0, "");
		sign.setText(1, "");
		sign.setText(2, "");
		sign.setText(3, "");
		int type = sign.getBlock().getType();
		int data = sign.getBlock().getData();
		int x = sign.getX();
		int y = sign.getY();
		int z = sign.getZ();
		sign.getWorld().setBlockAt(type, x, y, z);
		sign.getWorld().setBlockData(x, y, z, data);
		return;
	}
}
