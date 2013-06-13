
public class PlotMarketPlayerListener extends PluginListener{
	
	PlotMarketSignProcessor signprocessor = new PlotMarketSignProcessor();
	PlotMarketExampleProcessor exampleprocessor = new PlotMarketExampleProcessor();
	PlotMarketClickProcessor clickprocessor = new PlotMarketClickProcessor();
	PlotMarketDestroyProcessor destroyprocessor = new PlotMarketDestroyProcessor();

	public boolean onSignChange(Player player, Sign sign) {
		if (sign.getText(0).equalsIgnoreCase("[PlotMarket]") || sign.getText(0).equalsIgnoreCase("§3[PlotMarket]")) {
			return signprocessor.processSignCreationEvent(sign, player);
		}
		if (sign.getText(0).equalsIgnoreCase("[PlotExample]")|| sign.getText((0)).equalsIgnoreCase("§4[PlotExample]")){
			return exampleprocessor.processSignCreationEvent(sign, player);
		}
		
		return false;

	}
	
	public boolean onBlockDestroy(Player player,Block block){
		if (block.getType() == 63 || block.getType() == 68){
			Sign sign = (Sign)block.getWorld().getComplexBlock(block.getX(), block.getY(), block.getZ());
			if (sign.getText(0).equals("§3[PlotMarket]")){
				return destroyprocessor.processBlockHitEvent(player, block, sign);
			}
		}
		return false;
		
	}
	
	
	public boolean onBlockRightClick(Player player,Block block,Item itemInHand){
		if (block.getType() == 63 || block.getType() == 68){
			Sign sign = (Sign)block.getWorld().getComplexBlock(block.getX(), block.getY(), block.getZ());
			if (sign.getText(0).equals("§3[PlotMarket]")){
				return clickprocessor.processSignClickEvent(player, sign);
			}
		}
		return false;
	}
	
}
