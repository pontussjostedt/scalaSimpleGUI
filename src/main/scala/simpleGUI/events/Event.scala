package simpleGUI.events

trait Event
final case class ButtonPressed(button: String) extends Event
  

