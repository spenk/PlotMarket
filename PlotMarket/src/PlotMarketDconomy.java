public class PlotMarketDconomy {
	public String getMoneyName() {
		return (String) etc.getLoader().callCustomHook("dCBalance", new Object[] { "MoneyName" });
	}

	public double getPlayerBalance(String player) {
		return (Double)etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Balance", player});
	}

	public void withdrawFromPlayer(String player, double amount) {
		etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player, (Double) amount});
	}

	public void DepositToPlayer(String player, double amount) {
		etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Pay", player, (Double) amount});
	}
}
