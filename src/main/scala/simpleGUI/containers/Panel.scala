package simpleGUI

import java.awt.LayoutManager
import simpleGUI.*
import java.awt.Container
import javax.swing.JPanel

final case class SPanel(key: String, layout: LayoutManager)(children: SComponent*) extends SContainer(children):
    override def getJContainer(): Container = 
        val panel = new JPanel(layout)
        panel
