package de.mrlauchi.gsplrg_connectpaper.tgttos.commands.pz

import de.mrlauchi.gsplrg_connectpaper.tgttos.other.Essentials
import de.mrlauchi.gsplrg_connectpaper.Main
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player

object pz {

    private fun name() = Main.instance!!.PZ()

    fun start() {

        Essentials.setActive(name())

        for (player in Bukkit.getOnlinePlayers()) {
            player.gameMode = GameMode.ADVENTURE
            player.bedSpawnLocation = Essentials.getSpawnLoc(name())

            player.isInvulnerable = false
        }
    }

    fun stop(player: Player) {
        player.sendMessage("§bGame has been stopped!")
        Essentials.setActive(null)
        for (target in Bukkit.getOnlinePlayers()) {
            target.gameMode = GameMode.SPECTATOR
        }
    }

    fun setSpawn(player : Player) {
        Essentials.setSpawnLoc(name(), player)
        player.sendMessage("§bSpawn for ${name()} has been changed to your current location!")
    }

    fun setEnd(player : Player) {
        Essentials.setEndLoc(name(), player)
        player.sendMessage("§bEnd for ${name()} has been changed to your current location!")
    }

    fun teleport(player: Player) {
        player.teleport(Essentials.getSpawnLoc(name()))
    }

}