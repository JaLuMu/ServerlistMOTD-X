package cloud.bolte.serverlistmotd;

import java.io.File;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import cloud.bolte.serverlistmotd.cmd.Serverlist;
import cloud.bolte.serverlistmotd.events.IpLogging;
import cloud.bolte.serverlistmotd.events.Ping;
import cloud.bolte.serverlistmotd.events.ProtocolLibImplementation;
import cloud.bolte.serverlistmotd.events.RestrictedModeJoin;
import cloud.bolte.serverlistmotd.motd.MotdState;
import cloud.bolte.serverlistmotd.util.IO;
import cloud.bolte.serverlistmotd.util.VaultIntegration;

/*
 * ServerlistMOTD (c) by Strumswell, Philipp Bolte
 * ServerlistMOTD is licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * 
 * You should have received a copy of the license along with this work.
 * If not, see <http://creativecommons.org/licenses/by-nc-sa/3.0/>.
 */

//TODO: Testing (IP_UUID from old ver working?, ...)
//TODO: Commands, Ban plugins

public class Main extends JavaPlugin implements Listener {
	public static Map<InetAddress, UUID> IP_UUID = new HashMap<InetAddress, UUID>();

	@Override
	public void onDisable() {
		//Prepare HashMap and save it to disk
		IO.removeUnusedEntries(); // Experimental
		IO.saveHashMapIntoFlatfile(new File("plugins/ServerlistMOTD/IP_UUID.dat"), IP_UUID);
	}

	@Override
	public void onEnable() {
		//Load Userdata in HashMap & write config if necessary 
		IO.loadFlatfileIntoHashMap(new File("plugins/ServerlistMOTD/IP_UUID.dat"), IP_UUID);
		saveDefaultConfig();
		
		//Handover plugin instance to classes
		SpigotConfig config = new SpigotConfig(this);
		ProtocolLibImplementation pli = new ProtocolLibImplementation(this);
		MotdState state = new MotdState();
		
		//Check if world set in config exists (time, weather var!)
		config.worldConfigCheck();
		
		//Start ProtocolLib for slots stuff
		pli.listenToServerlistPackets();
		
		//Register listeners
		Bukkit.getServer().getPluginManager().registerEvents(new Ping(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new IpLogging(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new RestrictedModeJoin(), this);
		
		//Register command
		this.getCommand("serverlist").setExecutor(new Serverlist());
		
		//Setup Vault for money var
		VaultIntegration.setupVault();
		
		//Timer for saving userdata to disk 
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.runTaskTimerAsynchronously(this, new Runnable() {
			@Override
			public void run() {
				IO.saveHashMapIntoFlatfile(new File("plugins/ServerlistMOTD/IP_UUID.dat"), IP_UUID);
			}
		}, SpigotConfig.autoSaveIntervalInMin() * 1200L, SpigotConfig.autoSaveIntervalInMin() * 1200L);
	}
}
