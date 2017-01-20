package de.htwg.se.scala_risk.view

import javax.swing._
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent;

class GUIMenuBar(parent: GUI) extends JMenuBar with ActionListener {
  /* Create menu. */
  val menu = new JMenu("Spiel");
  menu.setMnemonic(KeyEvent.VK_S);

  /* Create item1. */
  val item1 = new JMenuItem("Zeige Kontinente");
  item1.addActionListener(this);

  /* Create item2. */
  val item2 = new JMenuItem("Beenden");
  item2.addActionListener(this);

  /* Create item3. */
  val item3 = new JMenuItem("Spiel fortsetzen");
  item3.addActionListener(this);

  /* Create item4. */
  val item4 = new JMenuItem("Spiel laden");
  item4.addActionListener(this);

  /* Create item3. */
  val item5 = new JMenuItem("Spiel speichern");
  item5.addActionListener(this);

  /* Add items to menu. */
  menu.add(item4)
  menu.add(item5)
  menu.addSeparator()
  menu.add(item1)
  menu.add(item3)
  menu.addSeparator();
  menu.add(item2);

  this.add(menu)

  override def actionPerformed(e: ActionEvent) {
    if (e.getSource == item2) {
      val c = JOptionPane.showConfirmDialog(
        this.getParent,
        "Wollen Sie das Spiel wirklich beenden?",
        "Beenden?",
        JOptionPane.YES_NO_OPTION
      )
      if (c == JOptionPane.YES_OPTION) {
        System.exit(0)
      }
    }
    if (e.getSource == item4) {
      parent.loadGame()
    }
    if (e.getSource == item5) {
      parent.saveGame()
    }

    if (e.getSource == item1) {
      parent.running = false
      parent.countryArray.foreach { x => x.setVisible(false) }
      parent.map.setIcon(new ImageIcon(parent.map_legend))
    }

    if (e.getSource == item3) {
      parent.running = true
      parent.countryArray.foreach { x => x.setVisible(true) }
      parent.map.setIcon(new ImageIcon(parent.map_grey))
    }
  }
}