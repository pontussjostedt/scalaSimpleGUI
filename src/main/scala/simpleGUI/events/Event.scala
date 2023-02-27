package simpleGUI.events

trait Event
final case class ButtonPressed(button: String) extends Event
final case class SliderMovedEvent(key: String) extends Event

