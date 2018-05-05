package cloud.bolte.serverlistmotd;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import cloud.bolte.serverlistmotd.motd.MotdState;

/*
 * ServerlistMOTD (c) by Strumswell, Philipp Bolte
 * ServerlistMOTD is licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * 
 * You should have received a copy of the license along with this work.
 * If not, see <http://creativecommons.org/licenses/by-nc-sa/3.0/>.
 */

public class SpigotConfig {
	private static Main main;

	public SpigotConfig(Main plugin) {
		setPlugin(plugin);
		migrateConfig();
	}
	
	private static void setPlugin(Main plugin) {
		main = plugin;
	}

	/*
	 * GET STRINGS & LISTS
	 */
	public static String getNewbieMotd() {
		return main.getConfig().getString("Motd.Message.Newbies");
	}

	public static String getRegularsMotd() {
		return main.getConfig().getString("Motd.Message.Regulars");
	}

	public static List<String> getNewbieRandomMotd() {
		return main.getConfig().getStringList("Motd.RandomMessages.Newbies");
	}

	public static List<String> getRegularsRandomMotd() {
		return main.getConfig().getStringList("Motd.RandomMessages.Regulars");
	}

	public static List<String> getHoverText() {
		return main.getConfig().getStringList("Motd.HoverText.Messages");
	}

	public static String getBanTempMotd() {
		return main.getConfig().getString("Motd.BanMessage.MessageTempBan");
	}

	public static String getBanForeverMotd() {
		return main.getConfig().getString("Motd.BanMessage.MessageForeverBan");
	}

	public static String getWhitelistMotd() {
		return main.getConfig().getString("Motd.WhitelistMessage.MessageWhitelisted");
	}

	public static String getNotWhitelistedMotd() {
		return main.getConfig().getString("Motd.WhitelistMessage.MessageNotWhitelisted");
	}

	public static String getFormatDate() {
		return main.getConfig().getString("Motd.BanMessage.FormatDate");
	}

	public static String getFormatTime() {
		return main.getConfig().getString("Motd.BanMessage.FormatTime");
	}

	public static String getRestrictedAccessGrantedMotd() {
		return main.getConfig().getString("RestrictedMode.Motd.AccessGranted");
	}

	public static String getRestrictedAccessDeniedMotd() {
		return main.getConfig().getString("RestrictedMode.Motd.AccessDenied");
	}

	public static String getRestrictedKickMessage() {
		return main.getConfig().getString("RestrictedMode.KickMessage");
	}

	public static String getRestrictedVersionText() {
		return main.getConfig().getString("RestrictedMode.Slots.VersionText");
	}

	public static String getVersionText() {
		return main.getConfig().getString("Motd.Slots.VersionText.Message");
	}

	public static String getRandomPlayerVariableText() {
		return main.getConfig().getString("Variables.RandomPlayerVariable.UseTextWhenNobodyOnline.Text");
	}

	public static String getRainText() {
		return main.getConfig().getString("Variables.WeatherVariable.RainText");
	}

	public static String getSunText() {
		return main.getConfig().getString("Variables.WeatherVariable.SunText");
	}

	public static String getWeatherWorld() {
		return main.getConfig().getString("Variables.WeatherVariable.World");
	}

	public static String getTimeWorld() {
		return main.getConfig().getString("Variables.TimeVariable.World");
	}

	public static String getDayText() {
		return main.getConfig().getString("Variables.TimeVariable.DayText");
	}

	public static String getNightText() {
		return main.getConfig().getString("Variables.TimeVariable.NightText");
	}

	/*
	 * GET BOOLEANS
	 */

	public static boolean randomMotdEnabled() {
		return main.getConfig().getBoolean("Motd.RandomMessages.Enable");
	}

	public static boolean banMotdEnabled() {
		return main.getConfig().getBoolean("Motd.BanMessage.Enable");
	}

	public static boolean whitelistMotdEnabled() {
		return main.getConfig().getBoolean("Motd.WhitelistMessage.Enable");
	}

	public static boolean restrictedModeEnabled() {
		return main.getConfig().getBoolean("RestrictedMode.Enable");
	}

	public static boolean fakeMaxPlayerEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.FakeMaxPlayer.Enable");
	}

	public static boolean fakeOnlinePlayerEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.FakeOnlinePlayer.Enable");
	}

	public static boolean fakeOnlinePlayerRandomNumberEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.FakeOnlinePlayer.RandomNumber.Enable");
	}

	public static boolean versionTextEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.VersionText.Enable");
	}

	public static boolean unknownSlotsEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.UnknownSlots.Enable");
	}

	public static boolean slotsPlusOneEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.SlotsPlusOne.Enable");
	}

	public static boolean onlineMultiplierEnabled() {
		return main.getConfig().getBoolean("Motd.Slots.OnlineMultiplier.Enable");
	}

	public static boolean hoverTextEnabled() {
		return main.getConfig().getBoolean("Motd.HoverText.Enable");
	}

	public static boolean randomPlayerVariableUseTextEnabled() {
		return main.getConfig().getBoolean("Variables.RandomPlayerVariable.UseTextWhenNobodyOnline.Enable");
	}

	public static boolean randomPlayerVariableUseDBEnabled() {
		return main.getConfig().getBoolean("Variables.RandomPlayerVariable.UseDatabaseNameWhenNobodyOnline.Enable");
	}

	/*
	 * GET INT
	 */

	public static int autoSaveIntervalInMin() {
		return main.getConfig().getInt("AutoSaveConfig.IntervalInMin");
	}

	public static int getFakeMaxPlayerNumber() {
		return main.getConfig().getInt("Motd.Slots.FakeMaxPlayer.Number");
	}

	public static int getFakeOnlinePlayerNumber() {
		return main.getConfig().getInt("Motd.Slots.FakeOnlinePlayer.Number");
	}

	public static int getFakeOnlinePlayerRandomNumberMin() {
		return main.getConfig().getInt("Motd.Slots.FakeOnlinePlayer.RandomNumber.Min");
	}

	public static int getFakeOnlinePlayerRandomNumberMax() {
		return main.getConfig().getInt("Motd.Slots.FakeOnlinePlayer.RandomNumber.Max");
	}

	public static int getOnlineMultiplierMinSlots() {
		return main.getConfig().getInt("Motd.Slots.OnlineMultiplier.MinSlots");
	}

	public static int getOnlineMultiplierMaxSlots() {
		return main.getConfig().getInt("Motd.Slots.OnlineMultiplier.MaxSlots");
	}

	public static int getOnlineMultiplierAddSlots() {
		return main.getConfig().getInt("Motd.Slots.OnlineMultiplier.AddSlotsWhenOnline>MinSlots");
	}

	public static int getSlotsPlusOneMinSlots() {
		return main.getConfig().getInt("Motd.Slots.SlotsPlusOne.MinSlots");
	}

	public static int getSlotsPlusOneMaxSlots() {
		return main.getConfig().getInt("Motd.Slots.SlotsPlusOne.MaxSlots");
	}

	public static int getSlotsPlusOneAddSlotsToOnline() {
		return main.getConfig().getInt("Motd.Slots.SlotsPlusOne.AddSlotsToOnline");
	}

	/*
	 * GET DOUBLE
	 */

	public static double getOnlineMultiplier() {
		return main.getConfig().getDouble("Motd.Slots.OnlineMultiplier.MultiplyBy");
	}

	/*
	 * SET BOOLEAN
	 */

	public static void toggleRestrictedMode(CommandSender sender) {
		if (SpigotConfig.restrictedModeEnabled()) {
			main.getConfig().set("RestrictedMode.Enable", false);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cRestrictedMode toggled off!");
		} else {
			main.getConfig().set("RestrictedMode.Enable", true);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cRestrictedMode toggled on!");
		}
		SpigotConfig.saveSmotdConfig();
	}

	public static void toggleVersionText(CommandSender sender) {
		if (SpigotConfig.versionTextEnabled()) {
			main.getConfig().set("Motd.Slots.VersionText.Enable", false);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cVersionText toggled off!");
		} else {
			main.getConfig().set("Motd.Slots.VersionText.Enable", true);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cVersionText toggled on!");
		}
		SpigotConfig.saveSmotdConfig();
	}

	public static void toggleRandomMotd(CommandSender sender) {
		if (SpigotConfig.randomMotdEnabled()) {
			main.getConfig().set("Motd.RandomMessages.Enable", false);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cRandomMotd toggled off!");
		} else {
			main.getConfig().set("Motd.RandomMessages.Enable", true);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cRandomMotd toggled on!");
		}
		SpigotConfig.saveSmotdConfig();
	}

	public static void toggleBanMotd(CommandSender sender) {
		if (SpigotConfig.banMotdEnabled()) {
			main.getConfig().set("Motd.BanMessage.Enable", false);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cBanMotd toggled off!");
		} else {
			main.getConfig().set("Motd.BanMessage.Enable", true);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cBanMotd toggled on!");
		}
		SpigotConfig.saveSmotdConfig();
	}

	public static void toggleWhitelistMotd(CommandSender sender) {
		if (SpigotConfig.whitelistMotdEnabled()) {
			main.getConfig().set("Motd.WhitelistMessage.Enable", false);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cWhitelistMotd toggled off!");
		} else {
			main.getConfig().set("Motd.WhitelistMessage.Enable", true);
			sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cWhitelistMotd toggled on!");
		}
		SpigotConfig.saveSmotdConfig();
	}

	/*
	 * UTIL
	 */

	/**
	 * Reload config and inform MotdState of possible changes
	 * @param sender Sender
	 */
	public static void reloadSmotdConfig(CommandSender sender) {
		main.reloadConfig();
		sender.sendMessage("§e§oServerlist§6§lMOTD §7> §cConfig reloaded!");
		MotdState.getInstance().initializeMotds();
	}

	/**
	 * Save config and inform MotdState of possible changes 
	 */
	public static void saveSmotdConfig() {
		main.saveConfig();
		MotdState.getInstance().initializeMotds();
	}


	/**
	 * Checks if world name set in config is existent 
	 */
	public void worldConfigCheck() {
		if (getWeatherWorld() == null || getTimeWorld() == null) {
			Bukkit.getLogger().severe(
					"[ServerlistMOTD] Can't find the defined world from config. Please set your world name in config!");
			System.out.println("[ServerlistMOTD] |------------------------------------|");
			System.out.println("[ServerlistMOTD] |                                    |");
			System.out.println("[ServerlistMOTD] |Please change WORLD NAME in config! |");
			System.out.println("[ServerlistMOTD] |                                    |");
			System.out.println("[ServerlistMOTD] |------------------------------------|");
			Bukkit.getPluginManager().disablePlugin(main);
		}
	}
	
	/**
	 * Rename old config (if available) and write new one
	 */
	public static void migrateConfig() {
		if (main.getConfig().getDouble("DoNOTtouchMe") == 5.0) {
			File oldConfig = new File(main.getDataFolder(), "config.yml");
			File newFile = new File(main.getDataFolder(), "config_old.yml");
			
			if (newFile.exists()) {
				System.out.println("[ServerlistMOTD] Remove your old config.yml!");
				Bukkit.getPluginManager().disablePlugin(main);
			}
			
			boolean fileRanemed = oldConfig.renameTo(newFile);
			if (fileRanemed) {
				main.saveDefaultConfig();
				main.reloadConfig();
				System.out.println("[ServerlistMOTD] Renamed old config and created new config!");
			}
		}
	}
}
