package simpleGUI
import simpleGUI.events.*
import scala.collection.mutable
import javax.swing.SwingUtilities
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
case class GUI(sFrame: SFrame):
    private val eventQueue: BlockingQueue[Event] = LinkedBlockingQueue[Event]
    private val valueGetter: mutable.Map[String, () => Any] = mutable.Map.empty
    sFrame.setCTX(this)
    SwingUtilities.invokeLater{() => 
        val jFrame = sFrame.cascade().asInstanceOf[javax.swing.JFrame]
        //jFrame.pack()
    }

    def setGetter(key: String, getter: () => Any): Unit = 
        valueGetter += key -> getter

    def getValueMap(): Map[String, Any] =
        val out: mutable.Map[String, Any] = valueGetter.map {(k, v) =>
            k -> v()
        }
        out.toMap

    def offerEvent(event: Event): Unit = synchronized {
        eventQueue.put(event)
        notifyAll()
    }

    def awaitEvent(): (Event, Map[String, Any]) = synchronized {
        while(eventQueue.isEmpty()) do
            wait()
        val eventOut = eventQueue.remove()
        eventOut -> getValueMap()
    }