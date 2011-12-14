package spheroids;

/*
    This file is part of spheroids

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.Location;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Spheroids extends JavaPlugin {

    //ClassListeners
    private final SpheroidsCommandExecutor commandExecutor = new SpheroidsCommandExecutor(this);
     //ClassListeners

    public Location playerLoc;

	Logger log = Logger.getLogger("Minecraft");//Define your logger


	public void onDisable() {
		log.info("Disabled message here, shown in console on startup");
	}

	public void onEnable() {
        log.info("Enabling spheroids Plugin");

        PluginManager pm = this.getServer().getPluginManager();

        getCommand("command").setExecutor(commandExecutor);


	}

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		//int size = (Integer) ((id != null && id.matches("[-+]?\\d+(\\.\\d+)?")) ? Integer.parseInt(id) : this.config.getInt("plot-size"));
		
		return new SpheroidsGenerator(this);
	}
}
