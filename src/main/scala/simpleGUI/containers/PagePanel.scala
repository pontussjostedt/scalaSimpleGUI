package simpleGUI

import java.awt.Container
import java.awt.Component
import javax.swing.JPanel
import javax.swing.JButton
import java.awt.event.ActionEvent
import javax.swing.SwingUtilities
import java.awt.GridLayout
import javax.swing.JLabel
import simpleGUI.events.*


final case class PagePanel(key: String, pages: Map[String, SComponent]) extends SComponent:
    assert(pages.nonEmpty, "Undefined behaviour for empty pagecontainer")
    var currentPageKey: Option[String] = None
    override def cascade(): Component = 
        //Todo refactor
        val pageSelectorPanel = JPanel(GridLayout(2, 1))
        val currentPageHolder = JPanel()
        currentPageHolder.add(JLabel("TODO: FIX DEFAULT PAGE"))
        val buttonPanel = JPanel()
        pages.foreach { (pageName: String, page: SComponent) =>
            val newButton: JButton = JButton(pageName)
            newButton.addActionListener { (event: ActionEvent) =>
                SwingUtilities.invokeLater { () =>
                    currentPageHolder.removeAll()
                    page.setCTX(getCTX())
                    currentPageHolder.add(page.cascade())
                    currentPageHolder.repaint()
                    currentPageHolder.validate()
                    getCTX().offerEvent(PageSwitch(key, currentPageKey.getOrElse("NO-PAGE"), pageName))
                    currentPageKey = Some(pageName)
                }
            }
            buttonPanel.add(newButton)
        }
        //pageSelectorPanel.setMinimumSize(java.awt.Dimension(50, 50))
        pageSelectorPanel.add(buttonPanel)
        pageSelectorPanel.add(currentPageHolder)
        pageSelectorPanel


object PagePanel:
    def apply(key: String)(pages: (String, SComponent)*): PagePanel =
        new PagePanel(key, pages.toMap)