import java.util.logging.Logger;


public class PlotMarket extends Plugin{
	
	String name = "PlotMarket";
	String version = " version 1.1";
	String author = " by Spenk";
	String enabled = " is Enabled.";
	String disabled = " is Disabled.";
	
	PlotMarketProperties properties = new PlotMarketProperties();
	PlotMarketPlayerListener listener = new PlotMarketPlayerListener();
	Logger log = Logger.getLogger("Minecraft");
	
	public void enable(){
		etc.getLoader().addListener(PluginLoader.Hook.BLOCK_RIGHTCLICKED, listener, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener(PluginLoader.Hook.BLOCK_DESTROYED, listener, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener(PluginLoader.Hook.SIGN_CHANGE, listener, this, PluginListener.Priority.LOW);
		properties.load();
		log.info(name+version+author+enabled);
	}
	
	public void disable(){
		log.info(name+version+author+disabled);
	}

}
