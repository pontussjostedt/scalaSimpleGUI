import simpleGUI.*
import java.awt.GridLayout

object test:
    @main
    def main: Unit =
        val gui: GUI = GUI(
            SFrame("Window Name", GridLayout(2, 2))(
                SButton("Button"),
                SSlider("Slider", 0, 100),
                SSlider("SliderTicks", 0, 100, 50, SSlider.addTicks(5, 10, true)),
                PagePanel("PageThingi")(
                    "Page1" -> SButton("ButtonPage1"),
                    "Page2" -> SButton("ButtonPage2")
                )
            )
        )

        while(true)
            println(gui.awaitEvent())
        
  

