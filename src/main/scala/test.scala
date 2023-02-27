import simpleGUI.*
import java.awt.GridLayout

object blob:
    @main
    def main: Unit =
        val x: GUI = GUI(
            SFrame("Hello", GridLayout(3, 1))(
                SButton("Button"),
                SSlider("bob", 0, 100),
                SSlider("bob", 0, 100, 50, SSlider.addTicks(5, 10, true))
            )
        )


        while(true)
            println(x.awaitEvent())
        
  

