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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public class SpheroidsCommandExecutor implements CommandExecutor {

    private Spheroids plugin;
    Logger log = Logger.getLogger("Minecraft");//Define your logger

    public SpheroidsCommandExecutor(Spheroids plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        log.info("onCommand Reached in spheroids");

        if (command.getName().equalsIgnoreCase("command")) {
	    log.info("command used");
            //do something
            return true;
        }
        return false;
    }
}
