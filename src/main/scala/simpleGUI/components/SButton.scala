package simpleGUI
import java.awt.Component
import simpleGUI.SLeafComponent
import simpleGUI.events.*
import java.awt.event.ActionListener
import java.awt.event.ActionEvent


final case class SButton(key: String = "_") extends SLeafComponent:
    override def getJComponent(): Component = 
        val button = javax.swing.JButton(key)
        button.addActionListener(DefaultButtonListener(getCTX(), key))
        button


case class DefaultButtonListener(ctx: GUI, key: String) extends ActionListener:
    override def actionPerformed(e: ActionEvent): Unit = 
        ctx.offerEvent(ButtonPressed(key))