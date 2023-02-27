import simpleGUI.*
import java.awt.GridLayout

object blob:
    @main
    def main: Unit =
        val x: GUI = GUI(
            SFrame("Hello", GridLayout(2, 2))(
                SButton("Button"),
                SSlider("bob", 0, 100),
                SSlider("hello", 0, 100, 50, SSlider.addTicks(5, 10, true)),
                PagePanel("pageThingi")(
                    "Page1" -> SButton("Hello"),
                    "Page2" -> SButton("Blobski")
                )
            )
        )

        while(true)
            println(x.awaitEvent())
        
  

