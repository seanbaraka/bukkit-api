package gg.mtx.plugin.commands

import gg.mtx.plugin.StatsPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Authentication(private var plugin: StatsPlugin): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        plugin.logger.info("Authenticating the user " + sender.name);
        return true;
    }
}