package simpleGUI
import javax.swing.JFrame
import java.awt.Container
import java.awt.LayoutManager
final case class SFrame(key: String, layout: LayoutManager)(children: SComponent*) extends SContainer(children):
    override def getJContainer(): Container = 
        val frame = new JFrame("")
        frame.setVisible(true)
        frame.setLayout(layout)
        frame.setSize(500, 500)
        frame.setDefaultCloseOperation(0)
        frame
