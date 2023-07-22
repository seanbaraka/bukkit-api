package gg.mtx.plugin.listeners

import gg.mtx.plugin.StatsPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

interface StatisticKey {
    override fun toString(): String;
}

class PlayerEvents(private var plugin: StatsPlugin) : Listener {

    private var stats : MutableMap<UUID, MutableMap<String, Int>>? = ConcurrentHashMap();

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        plugin.logger.info("Yoh, someone just joined " + event.player.name);
    }

    @EventHandler
    fun onPlayerBreakStuff(event: BlockBreakEvent) {
        val playerId = event.player.uniqueId
        stats?.computeIfAbsent(playerId) { ConcurrentHashMap()}?.set(event.block.type.name, 1)
        plugin.logger.info("Yoh, you are breaking stuff: " + stats?.get(playerId));
    }
}