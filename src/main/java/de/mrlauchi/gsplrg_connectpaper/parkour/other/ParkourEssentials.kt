package de.mrlauchi.gsplrg_connectpaper.parkour.other

import de.mrlauchi.gsplrg_connectpaper.Main
import de.mrlauchi.gsplrg_connectpaper.hungergames.other.HungergamesEssentials
import de.mrlauchi.gsplrg_connectpaper.points.Other.pointsModule
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

object ParkourEssentials {
    var currentplacement  = 0

    var endmsg = listOf<String?>()
    fun getCoordinate(section: Int): Location {
        val config = Main.instance!!.config

        val x = config.getDouble("parkour.$section.x")
        val y = config.getDouble("parkour.$section.y")
        val z = config.getDouble("parkour.$section.z")

        val worldName = config.getString("parkour.$section.world")
        val world = Bukkit.getWorld(worldName!!)

        return Location(world, x, y, z)
    }

    fun setCoordinate(section: Int, player: Player) {
        val config = Main.instance!!.config

        config.set("parkour.$section.x", player.location.x)
        config.set("parkour.$section.y", player.location.y)
        config.set("parkour.$section.z", player.location.z)

        config.set("parkour.$section.world", player.location.world!!.name)

        Main.instance!!.saveConfig()

        return
    }

    fun getCountdownActive() : Int {
        val config = Main.instance!!.config

        if(config.get("parkour.countdown") != 1) {
            return 0
        }

        return 1
    }

    fun setCountdownActive(int : Int) {
        val config = Main.instance!!.config

        config.set("parkour.countdown", int)

        Main.instance!!.saveConfig()
        return
    }

    fun setActive(int: Int) {
        val config = Main.instance!!.config

        config.set("parkour.active", int)

        Main.instance!!.saveConfig()

    }

    fun getActive(): Int {
        val config = Main.instance!!.config

        return config.getInt("parkour.active")
    }

    fun setSection(player: Player, section: Int) {
        val config = Main.instance!!.config

        config.set("parkour.score.${player.name}", section)

        Main.instance!!.saveConfig()
        return
    }

    fun getSection(player: Player): Int {
        val config = Main.instance!!.config

        return config.getInt("parkour.score.${player.name}")
    }

    fun startTimer(){
        val config = Main.instance!!.config
        config.set("parkour.timeractive",1)

        Main.instance!!.saveConfig()
    }
    fun stopTimer(){
        val config = Main.instance!!.config
        config.set("parkour.timeractive",0)

        Main.instance!!.saveConfig()
    }

    fun setPlacement(player : Player){
        val config = Main.instance!!.config

        currentplacement += 1
        if (currentplacement < 10){
            if (currentplacement == 1){
                endmsg += " §l${currentplacement}st:§r §6${player.name}§r with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
            if (currentplacement == 2){
                endmsg += " §l${currentplacement}nd:§r §9${player.name}§r with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
            if (currentplacement == 3){
                endmsg += " §l${currentplacement}rd:§r §a${player.name}§r with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
           if (currentplacement > 3){
               endmsg += " §l${currentplacement}th:§r ${player.name} with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
           }
        }else{
            if (currentplacement != 21 && currentplacement != 22 && currentplacement != 23){
                endmsg += " §l${currentplacement}th:§r ${player.name} with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
            if (currentplacement == 21){
                endmsg += " §l${currentplacement}st:§r ${player.name} with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
            if (currentplacement == 22){
                endmsg += " §l${currentplacement}nd:§r ${player.name} with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
            if (currentplacement == 23){
                endmsg += " §l${currentplacement}rd:§r ${player.name} with time ${config.getString("parkour.playertimes.${player.name}")}(${pointsModule.parkour.placementlist[currentplacement]} extra points)"
            }
        }

    }

    fun resetplacements(){
        endmsg = listOf<String?>()
        currentplacement = 0
    }


}