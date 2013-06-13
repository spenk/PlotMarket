
public class PlotMarketExampleProcessor {
	public boolean processSignCreationEvent(Sign sign, Player player){
		if (!player.canUseCommand("/plotmarketadmin")) {
			player.notify("§f[§3PlotMarket§f]§c - You are not allowed to create a ExampleMarket sign!");
			return true;
		}
		sign.setText(0, "§4[PlotMarket]");
		sign.setText(1, "AreaName");
		sign.setText(2, "Price $");
		sign.setText(3, "Owner/Empty");
		player.sendMessage("§3Sign Created");
		return false;
	}
	
	public boolean processSignClickEvent(Player player, Sign sign){
		if (!player.canUseCommand("/plotmarketuse") && !player.canUseCommand("/plotmarketadmin")){
			player.notify("§f[§3PlotMarket§f]§c - You can't view this tutorial!");
			return true;
		}else{
		printTut(player);
		}
		return false;
	}
	
	public boolean processBlockHitEvent(Player player, Block block, Sign sign) {
		if (block.getStatus() == 0) {
			if (!player.canUseCommand("/plotmarketuse") && !player.canUseCommand("/plotmarketadmin")){
				player.notify("§f[§3PlotMarket§f]§c - You can't view this tutorial!");
			return true;
		}else{
			printTut(player);
		}
		}
		if (block.getStatus() == 2){
			if (!player.canUseCommand("/plotmarketadmin")){
				player.notify("You can't break this sign!");
				return true;
			}
		}
		return false;
	}
	
	public void printTut(Player player){
		player.sendMessage("§1-§4-§1-§4-§1-§4-§1-§4-§f§f[§3PlotMarket§f]§1-§4-§1-§4-§1-§4-§1-§4-");
		player.sendMessage("§2On the first line,§3 You'll have to write your name");
		player.sendMessage("§2On the second line,§3 You'll have to fill in the area name.");
		player.sendMessage("§2On the third line,§3 You'll have to put a price (you may include letters).");
		player.sendMessage("§2On the last line,§3 You'll have to enter your name, or leave it empty to auto fill.");
		player.sendMessage("§2To buy a plot you need to have the amount of money on line 3, then youll have to rightclick a sign.");
		player.sendMessage("§3You'll become owner instantly and they money gets deposited to the previous owner.");
	}
}
