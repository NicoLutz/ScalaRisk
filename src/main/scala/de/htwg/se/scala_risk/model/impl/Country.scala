package de.htwg.se.scala_risk.model.impl
import de.htwg.se.scala_risk.model.{World => TWorld}
import de.htwg.se.scala_risk.model.{ Country => TCountry }
import de.htwg.se.scala_risk.model.{ Player => TPlayer }

/**
 * Class to create country objects.
 * @author Nico Lutz
 */
case class Country(name: String, world: TWorld, var neighboring_countries: Set[TCountry] = Set.empty,
    var troops: Int = 0, var owner: TPlayer = null, color: Int = 0) extends de.htwg.se.scala_risk.model.Country {
  if (this.owner == null) this.owner = world.getDefaultPlayer
  override def getName(): String = return this.name
  override def getTroops(): Int = return this.troops
  override def setTroops(number: Int) = if(number > 0) this.troops = number
  override def getNeighboringCountries(): Set[TCountry] = neighboring_countries
  override def toString(): String = {
    var neighbors: String = ""
    neighboring_countries.foreach { c => neighbors += c.getName + " " }
    "Name: " + name + ", Neigbors: " + neighbors + ", troops: " + troops + ", owner: " + owner.getName
  }
  override def getOwner(): TPlayer = if (owner == null) return world.getDefaultPlayer else return owner
  override def setOwner(player: TPlayer) = this.owner = player
  override def getRefColor() : Int = return this.color
  override def equals(that: Any): Boolean = {
    if (!that.isInstanceOf[TCountry]) return false
    var p = that.asInstanceOf[TCountry]
    return if (this.name.equals(p.getName)) true else false
  }

}