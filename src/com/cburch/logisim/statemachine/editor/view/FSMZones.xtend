package com.cburch.logisim.statemachine.editor.view

import com.cburch.logisim.statemachine.PrettyPrinter
import com.cburch.logisim.statemachine.fSMDSL.*
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point
import java.awt.RenderingHints
import java.awt.geom.RoundRectangle2D
import org.eclipse.emf.ecore.EObject

class FSMZones {

	def getSelectedElement(Point p,FSMElement e) {
		if (isWithinElement(p,e)) {
			e
		} else {
			null
		}
	}


	def dispatch boolean isWithinElement(Point p,FSMElement e) {
		false
	}

	public static def inRectangle(int x, int y, LayoutInfo l) {
		return (
			(x >= l.x) && (x <= (l.x+l.width)) &&
			(y >= l.y) && (y <= (l.y+l.height))
			)
	}
	def dispatch isWithinElement(Point p,CommandList e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within CommandList["+(l.x)+","+(l.y-l.height)+","+(l.x+l.width)+","+(l.y)+"]")
		inRectangle(p.x,p.y+e.layout.height,e.layout)
	}
	def dispatch isWithinElement(Point p,FSM e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within CommandList["+(l.x)+","+(l.y-l.height)+","+(l.x+l.width)+","+(l.y)+"]")
		inRectangle(p.x,p.y,e.layout)
	}

	def dispatch isWithinElement(Point p,State e) {
		val l = e.layout
		val radius = l.width
		val dx = (p.x - (l.x+radius)) 
		val dy = (p.y - (l.y+radius))
		val distance = Math.sqrt(dx*dx+dy*dy)
		//println('('+p.x+','+p.y+") distant from "+distance+" to circle["+(l.x+radius)+","+(l.y+radius)+","+radius+"]")
		return distance<(radius)
	}

	def dispatch isWithinElement(Point p,Transition e) {
		inRectangle(p.x,p.y,e.layout) && e.dst!=null
	}

	def dispatch isWithinElement(Point p,InputPort e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within InPort["+(l.x)+","+(l.y)+","+(l.x+l.width)+","+(l.y+l.height)+"]")
		inRectangle(p.x,p.y,e.layout)
	}

	def dispatch isWithinElement(Point p,OutputPort e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within OutPort["+(l.x)+","+(l.y)+","+(l.x+l.width)+","+(l.y+l.height)+"]")
		inRectangle(p.x,p.y,e.layout)
	}
}