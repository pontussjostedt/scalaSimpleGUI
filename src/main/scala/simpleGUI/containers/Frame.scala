package simpleGUI
import javax.swing.JFrame
import java.awt.Container
import java.awt.LayoutManager
import java.awt.Dimension
final case class SFrame(key: String, layout: LayoutManager)(children: SComponent*) extends SContainer(children):
    override def getJContainer(): Container = 
        val frame = new JFrame("")
        frame.setVisible(true)
        frame.setLayout(layout)
        frame.setDefaultCloseOperation(1)
        frame.setMinimumSize(Dimension(500, 500))
        frame
