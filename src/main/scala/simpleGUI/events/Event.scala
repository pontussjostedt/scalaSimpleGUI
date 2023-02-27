package simpleGUI.events

trait Event
final case class ButtonPressed(button: String) extends Event
final case class SliderMovedEvent(key: String) extends Event
final case class PageSwitch(key: String, oldPageKey: String, newPage: String) extends Event
