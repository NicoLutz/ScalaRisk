package de.htwg.se.scala_risk.model.impl
import de.htwg.se.scala_risk.model.impl.Colors._
import de.htwg.se.scala_risk.model.{Player => TPlayer}
import de.htwg.se.scala_risk.model.{Country => TCountry}
import de.htwg.se.scala_risk.model.{Continent => TContinent}
import de.htwg.se.scala_risk.model.{World => TWorld}
import de.htwg.se.scala_risk.model.impl.{ Player => ImpPlayer }
import de.htwg.se.scala_risk.model.impl.{ Country => ImpCountry }
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Set


/**
 * This object represents the whole world of ScalaRisk.
 * @author Nico Lutz
 */
class World extends TWorld {
  /**
   * This object holds all the countries of ScalaRisk.
   * @author Nico Lutz
   */
  class Countries (world: TWorld) {
      /* NORDAMERIKA */
      var alaska = Country("ALASKA", world, color = -3993841)
      var nordwestterritorien = Country("NORDWEST-TERRITORIEN", world, color = -772811)
      var alberta = Country("ALBERTA", world, color = -1245184)
      var ontario = Country("ONTARIO", world, color = -3459787)
      var groenland = Country("GROENLAND", world, color = -41635)
      var ostkanada = Country("OSTKANADA", world, color = -4390912)
      var weststaaten = Country("WESTSTAATEN", world, color = -5373952)
      var oststaaten = Country("OSTSTAATEN", world, color = -57312)
      var mittelamerika = Country("MITTELAMERIKA", world, color = -196608)
      
      /* SUEDAMERIKA */
      var venezuela = Country("VENEZUELA", world, color = -923904)
      var peru = Country("PERU", world, color = -164)
      var argentinien = Country("ARGENTINIEN", world, color = -5888)
      var brasilien = Country("BRASILIEN", world, color = -256)
      
      /* AFRIKA */
      var nordafrika = Country("NORDAFRIKA", world, color = -2987746)
      var zentralafrika = Country("ZENTRALAFRIKA", world, color = -7650029)
      var suedafrika = Country("SUEDAFRIKA", world, color = -3308234)
      var madagaskar = Country("MADAGASKAR", world, color = -3316195)
      var ostafrika = Country("OSTAFRIKA", world, color = -32988)
      var aegypten = Country("AEGYPTEN", world, color = -8834304)
      
      /* EUROPA */
      var suedeuropa = Country("SUEDEUROPA", world, color = -16761601)
      var westeuropa = Country("WESTEUROPA", world, color = -16771449)
      var nordeuropa = Country("NORDEUROPA", world, color = -16775425)
      var grossbritannien = Country("GROSSBRITANNIEN", world, color = -16775517)
      var island = Country("ISLAND", world, color = -16772762)
      var skandinavien = Country("SKANDINAVIEN", world, color = -8350209)
      var russland = Country("RUSSLAND", world, color = -12690973)
      
      /* ASIEN */
      var ural = Country("URAL", world, color = -16729574)
      var sibirien = Country("SIBIRIEN", world, color = -10420362)
      var jakutien = Country("JAKUTIEN", world, color = -14962127)
      var irkutsk = Country("IRKUTSK", world, color = -16711900)
      var kamtschatka = Country("KAMTSCHATKA", world, color = -15103447)
      var japan = Country("JAPAN", world, color = -13831608)
      var mongolei = Country("MONGOLEI", world, color = -11941285)
      var china = Country("CHINA", world, color = -11615650)
      var afghanistan = Country("AFGHANISTAN", world, color = -14878917)
      var mittlererosten = Country("MITTLERER-OSTEN", world, color = -15559131)
      var indien = Country("INDIEN", world, color = -13708987)
      var suedostasien = Country("SUEDOSTASIEN", world, color = -13318071)
      
      /* AUSTRALIEN */
      var indonesien = Country("INDONESIEN", world, color = -29696)
      var neuguinea = Country("NEUGUINEA", world, color = -37888)
      var ostaustralien = Country("OSTAUSTRALIEN", world, color = -17612)
      var westaustralien = Country("WESTAUSTRALIEN", world, color = -23296)

      val alaska_n: Set[TCountry] = Set(kamtschatka, nordwestterritorien, alberta)
      val nordwestterritorien_n: Set[TCountry] = Set(alaska, alberta, ontario, groenland)
      val alberta_n: Set[TCountry] = Set(alaska, nordwestterritorien, ontario, weststaaten)
      val ontario_n: Set[TCountry] = Set(nordwestterritorien, alberta, groenland, ostkanada, weststaaten, oststaaten)
      val groenland_n: Set[TCountry] = Set(nordwestterritorien, ontario, ostkanada, island)
      val ostkanada_n: Set[TCountry] = Set(ontario, groenland, oststaaten)
      val weststaaten_n: Set[TCountry] = Set(alberta, ontario, oststaaten, mittelamerika)
      val oststaaten_n: Set[TCountry] = Set(ontario, ostkanada, weststaaten, mittelamerika)
      val mittelamerika_n: Set[TCountry] = Set(weststaaten, oststaaten, venezuela)
      val venezuela_n: Set[TCountry] = Set(mittelamerika, peru, brasilien)
      val peru_n: Set[TCountry] = Set(venezuela, argentinien, brasilien)
      val argentinien_n: Set[TCountry] = Set(peru, brasilien)
      val brasilien_n: Set[TCountry] = Set(venezuela, peru, argentinien, nordafrika)
      val nordafrika_n: Set[TCountry] = Set(brasilien, zentralafrika, ostafrika, aegypten, suedeuropa, westeuropa)
      val zentralafrika_n: Set[TCountry] = Set(nordafrika, suedafrika, ostafrika)
      val suedafrika_n: Set[TCountry] = Set(zentralafrika, madagaskar, ostafrika)
      val madagaskar_n: Set[TCountry] = Set(suedafrika, ostafrika)
      val ostafrika_n: Set[TCountry] = Set(nordafrika, zentralafrika, suedafrika, madagaskar, aegypten, mittlererosten)
      val aegypten_n: Set[TCountry] = Set(nordafrika, ostafrika, suedeuropa, mittlererosten)
      val suedeuropa_n: Set[TCountry] = Set(nordafrika, aegypten, westeuropa, nordeuropa, russland, mittlererosten)
      val westeuropa_n: Set[TCountry] = Set(nordafrika, suedeuropa, nordeuropa, grossbritannien)
      val nordeuropa_n: Set[TCountry] = Set(suedeuropa, westeuropa, grossbritannien, skandinavien, russland)
      val grossbritannien_n: Set[TCountry] = Set(westeuropa, nordeuropa, island, skandinavien)
      val island_n: Set[TCountry] = Set(groenland, grossbritannien, skandinavien)
      val skandinavien_n: Set[TCountry] = Set(nordeuropa, grossbritannien, island, russland)
      val russland_n: Set[TCountry] = Set(suedeuropa, nordeuropa, skandinavien, ural, afghanistan, mittlererosten)
      val ural_n: Set[TCountry] = Set(russland, sibirien, china, afghanistan)
      val sibirien_n: Set[TCountry] = Set(ural, jakutien, irkutsk, mongolei, china) 
      val jakutien_n: Set[TCountry] = Set(sibirien, irkutsk, kamtschatka)
      val irkutsk_n: Set[TCountry] = Set(sibirien, jakutien, kamtschatka, mongolei)
      val kamtschatka_n: Set[TCountry] = Set(alaska, jakutien, irkutsk, japan, mongolei)
      val japan_n: Set[TCountry] = Set(kamtschatka, mongolei)
      val mongolei_n: Set[TCountry] = Set(sibirien, irkutsk, kamtschatka, japan, china)
      val china_n: Set[TCountry] = Set(ural, sibirien, mongolei, afghanistan, indien, suedostasien)
      val afghanistan_n: Set[TCountry] = Set(russland, mittlererosten, indien, china, ural)
      val mittlererosten_n: Set[TCountry] = Set(russland, suedeuropa, aegypten, ostafrika, indien, afghanistan)
      val indien_n: Set[TCountry] = Set(afghanistan, mittlererosten, suedostasien, china)
      val suedostasien_n: Set[TCountry] = Set(china, indien, indonesien)
      val indonesien_n: Set[TCountry] = Set(suedostasien, neuguinea, westaustralien)
      val neuguinea_n: Set[TCountry] = Set(indonesien, ostaustralien, westaustralien)
      val ostaustralien_n: Set[TCountry] = Set(westaustralien, neuguinea)
      val westaustralien_n: Set[TCountry] = Set(indonesien, neuguinea, ostaustralien)

      alaska.neighboring_countries = alaska_n
      nordwestterritorien.neighboring_countries = nordwestterritorien_n
      alberta.neighboring_countries = alberta_n
      ontario.neighboring_countries = ontario_n
      groenland.neighboring_countries = groenland_n
      ostkanada.neighboring_countries = ostkanada_n
      weststaaten.neighboring_countries = weststaaten_n
      oststaaten.neighboring_countries = oststaaten_n
      mittelamerika.neighboring_countries = mittelamerika_n
      venezuela.neighboring_countries = venezuela_n
      peru.neighboring_countries = peru_n
      argentinien.neighboring_countries = argentinien_n
      brasilien.neighboring_countries = brasilien_n
      nordafrika.neighboring_countries = nordafrika_n
      zentralafrika.neighboring_countries = zentralafrika_n
      suedafrika.neighboring_countries = suedafrika_n
      madagaskar.neighboring_countries = madagaskar_n
      ostafrika.neighboring_countries = ostafrika_n
      aegypten.neighboring_countries = aegypten_n
      suedeuropa.neighboring_countries = suedeuropa_n
      westeuropa.neighboring_countries = westeuropa_n
      nordeuropa.neighboring_countries = nordeuropa_n
      grossbritannien.neighboring_countries = grossbritannien_n
      island.neighboring_countries = island_n
      skandinavien.neighboring_countries = skandinavien_n
      russland.neighboring_countries = russland_n
      ural.neighboring_countries = ural_n
      sibirien.neighboring_countries = sibirien_n
      jakutien.neighboring_countries = jakutien_n
      irkutsk.neighboring_countries = irkutsk_n
      kamtschatka.neighboring_countries = kamtschatka_n
      japan.neighboring_countries = japan_n
      mongolei.neighboring_countries = mongolei_n
      china.neighboring_countries = china_n
      afghanistan.neighboring_countries = afghanistan_n
      mittlererosten.neighboring_countries = mittlererosten_n
      indien.neighboring_countries = indien_n
      suedostasien.neighboring_countries = suedostasien_n
      indonesien.neighboring_countries = indonesien_n
      neuguinea.neighboring_countries = neuguinea_n
      ostaustralien.neighboring_countries = ostaustralien_n
      westaustralien.neighboring_countries = westaustralien_n


    import scala.collection._
    val listCountries = ArrayBuffer[TCountry](alaska, nordwestterritorien, alberta, ontario, groenland,
      ostkanada, weststaaten, oststaaten, mittelamerika, venezuela, peru, argentinien, brasilien, nordafrika, zentralafrika, suedafrika,
      madagaskar, ostafrika, aegypten, suedeuropa, westeuropa, nordeuropa, grossbritannien, island, skandinavien, russland, ural,
      sibirien, jakutien, irkutsk, kamtschatka, japan, mongolei, china, afghanistan, mittlererosten, indien, suedostasien,
      indonesien, neuguinea, ostaustralien, westaustralien)
    val test : ArrayBuffer[TCountry] = ArrayBuffer[TCountry](alaska, nordwestterritorien, alberta, ontario, groenland, ostkanada)  
    def  getColor(name: String) : Integer = {
      var country = null.asInstanceOf[TCountry]
      listCountries.foreach { x => if (x.getName.toUpperCase().equals(name.toUpperCase())) {country = x} }
      return country.getRefColor()
    }
      
    val nordamerikaCountries = ArrayBuffer[TCountry](alaska, nordwestterritorien, alberta, ontario, groenland, ostkanada, weststaaten, oststaaten, mittelamerika)
    val suedamerikaCountries = ArrayBuffer[TCountry](venezuela, peru, argentinien, brasilien)
    val afrikaCountries = ArrayBuffer[TCountry](nordafrika, zentralafrika, suedafrika, madagaskar, ostafrika, aegypten)
    val europaCountries = ArrayBuffer[TCountry](suedeuropa, westeuropa, nordeuropa, grossbritannien, island, skandinavien, russland)
    val asienCountries = ArrayBuffer[TCountry](ural, sibirien, jakutien, irkutsk, kamtschatka, japan, mongolei, china, afghanistan,
                                     mittlererosten, indien, suedostasien)                                  
    val australienCountries = ArrayBuffer[TCountry](indonesien, neuguinea, ostaustralien, westaustralien)
    
    val nordamerika = Continent("Nordamerika", nordamerikaCountries, 5, world)
    val suedamerika = Continent("Südamerika", suedamerikaCountries, 2, world)
    val afrika = Continent("Afrika", afrikaCountries, 3, world)
    val europa = Continent("Europa", europaCountries, 5, world)
    val asien = Continent("Asien", asienCountries, 7, world)
    val australien = Continent("Australien", australienCountries, 2, world)
    
    val listContinents = ArrayBuffer[TContinent](nordamerika, suedamerika, afrika, europa, asien, australien)
  }
  /**
   * This object holds all the players of the current game.
   * @author Nico Lutz
   */
  class Players (world: TWorld) {
    // List to hold the players.
    var playerList: ArrayBuffer[TPlayer] = ArrayBuffer()

    // List to hold the remaining colors.
    var colorList: List[Color] = List(RED, YELLOW, GREEN, BLUE, PINK, ORANGE)
    // Default Player e.g. if a country or a continent is not occupied yet.
    val Default = Player("", null.asInstanceOf[Color], 0, world)

    var currentPlayer = -1
    /**
     * Function to add Players (defined by (String, String)) to the List
     * and remove the taken colors from colorList. The players name and color
     * are Strings because the controller passes them the way it receives input
     * from the view layer.
     *
     * @param name Name of the player as a String
     * @param color
     */
    def addPlayer(name: String, color: String) /*: String = */ {
      var colorFromString: Color = stringToColor(color)
      if (colorList.contains(colorFromString)) {
        playerList += Player(name, colorFromString, 3, world)
        colorList = colorList.filter { x => x != colorFromString }
      } else {
        println("Color already taken!")
      }
    }
    /**
     * This function transforms a String representation of a color into a player
     * usint stringToColor(color : String) (the color is unique).
     *
     * @param String representation of a color.
     * @return Player associated with the color, default player if
     * color does not exist or is not taken.
     */
    def getPlayerFromColorString(color: String): TPlayer = {
      val playerInList = this.playerList.filter { x => x.getColor == stringToColor(color) }
      if (playerInList.length == 1) playerInList(0) else this.Default
    }

    /**
     * This function transforms a String representation of a color into a
     * color of type "Color".
     *
     * @param String representation of a color.
     * @return The corresponding color or an error code if the color does not exist.
     */
    private[Players] def stringToColor(color: String): Color = {
      var colorFromString: Color = null.asInstanceOf[Color]
 
        // Check if the string represents a valid color.
      try {
        colorFromString = Colors.withName(color.toUpperCase())
      } catch {
        case nosuchelement: scala.NoSuchElementException => colorFromString = null
      }
        

      return colorFromString
    }

    def nextPlayer(): TPlayer = {
      
      currentPlayer += 1
      println(currentPlayer)
      if (currentPlayer >= playerList.length)
        currentPlayer = 0
      playerList(currentPlayer)
    }
  }
  
  

  
  val players = new Players(this)
  val countries = new Countries(this) 
 
  def getCountriesList :  ArrayBuffer[TCountry] = this.countries.listCountries
  
  def getPlayerList: ArrayBuffer[TPlayer] = this.players.playerList
  def getDefaultPlayer: TPlayer = this.players.Default
  def nextPlayer: TPlayer = this.players.nextPlayer()
  def getCurrentPlayerIndex: Int = this.players.currentPlayer
  def addPlayer(name: String, color: String) = this.players.addPlayer(name, color)
  def getPlayerColorList: List[Color] = this.players.colorList
  
  def getContinentList : ArrayBuffer[TContinent] = this.countries.listContinents
}