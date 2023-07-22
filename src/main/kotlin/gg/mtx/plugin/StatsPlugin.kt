package gg.mtx.plugin

import gg.mtx.plugin.commands.Authentication
import gg.mtx.plugin.listeners.PlayerEvents
import org.bukkit.plugin.java.JavaPlugin

class StatsPlugin: JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerEvents(this), this)
        getCommand("authenticate")?.setExecutor(Authentication(this));
    }

    override fun onDisable() {
        super.onDisable()
    }
}