package cloud.bolte.serverlistmotd.motd;

import java.net.InetAddress;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import cloud.bolte.serverlistmotd.Main;
import cloud.bolte.serverlistmotd.SpigotConfig;

/*
 * ServerlistMOTD (c) by Strumswell, Philipp Bolte
 * ServerlistMOTD is licensed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * 
 * You should have received a copy of the license along with this work.
 * If not, see <http://creativecommons.org/licenses/by-nc-sa/3.0/>.
 */

public class RandomMotd implements MotdInterface {

	@Override
	public String getMOTD(InetAddress ip) {
		Random random = new Random();
		if (Main.IP_UUID.containsKey(ip)) {
			List<String> motds = SpigotConfig.getRegularsRandomMotd();
			return motds.get(random.nextInt(motds.size()));
		} else {
			List<String> motds = SpigotConfig.getNewbieRandomMotd();
			return motds.get(random.nextInt(motds.size()));
		}
	}
	
	//TODO: Weather & Time
	@Override
	public String formatMotd(String motd, InetAddress ip) {
		String formattedMotd = ChatColor.translateAlternateColorCodes('&', motd)
				.replaceAll("%line%", "\n")
				.replaceAll("%weather%", "clear")
				.replaceAll("%time%", "day");		
		
		if (Main.IP_UUID.containsKey(ip)) {
			formattedMotd = formattedMotd
				.replaceAll("%player%", Bukkit.getOfflinePlayer(Main.IP_UUID.get(ip)).getName());
		}
		return formattedMotd;
	}
}
