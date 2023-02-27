package simpleGUI
import java.awt.{Component, Container}
trait SComponent:
    val key: String
    protected var guiCTX: Option[GUI] = None
    def setCTX(ctx: GUI): Unit = guiCTX = Some(ctx) 
    def getCTX(): GUI = guiCTX.getOrElse(throw Exception("Ctx was not set correctly"))
         
    def cascade(): Component

trait SContainer(children: Seq[SComponent]) extends SComponent:
    def getJContainer(): Container
    override def cascade(): Component = 
        val container = getJContainer()
        children.foreach { child =>
            child.setCTX(getCTX())
            container.add(child.cascade())
        }
        container

trait SLeafComponent extends SComponent:
    def getJComponent(): Component
    override def cascade(): Component = 
        getJComponent()
  

