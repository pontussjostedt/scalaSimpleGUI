package simpleGUI

import simpleGUI.SLeafComponent
import simpleGUI.events.*
import java.awt.Component
import javax.swing.JSlider
import javax.swing.event.ChangeListener
import javax.swing.event.ChangeEvent
case class SSlider(key: String, min: Int, max: Int, startValue: Int, extraOptions: ((JSlider) => Unit)*) extends SLeafComponent:
    override def getJComponent(): Component = 
        val slider = new JSlider(min, max, startValue)
        getCTX().setGetter(key, slider.getValue)
        slider.addChangeListener(DefaultSliderChangeListener(getCTX(), key))
        extraOptions.foreach(_(slider))
        slider    

object SSlider:
    def apply(key: String, min: Int, max: Int): SSlider =
        new SSlider(key, min, max, (min + max)/2)

    def addTicks(minorTickSpacing: Int, majorTickSpacing: Int, drawLabels: Boolean = false)(slider: JSlider): Unit =
        slider.setMajorTickSpacing(majorTickSpacing)
        slider.setMinorTickSpacing(minorTickSpacing)
        slider.setPaintLabels(drawLabels)
        slider.setPaintTicks(true)

   // def addLabel(label: String)(slider: JSlider): Unit =
   //     slider.set


final case class DefaultSliderChangeListener(ctx: GUI, key: String) extends ChangeListener:
    override def stateChanged(e: ChangeEvent): Unit = 
        ctx.offerEvent(SliderMovedEvent(key))
