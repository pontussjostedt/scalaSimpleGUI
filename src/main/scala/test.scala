import simpleGUI.*
import java.awt.GridLayout

object blob:
    @main
    def main: Unit =
        val x: GUI = GUI(
            SFrame("Hello", GridLayout(2, 1))(
                SButton("Button"),
                SButton("OtherButton")
            )
        )


        while(true)
            println(x.awaitEvent())
        
  

