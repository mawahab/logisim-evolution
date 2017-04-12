package com.cburch.logisim.statemachine.editor.view

import com.cburch.logisim.statemachine.PrettyPrinter
import com.cburch.logisim.statemachine.fSMDSL.*
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point
import java.awt.RenderingHints
import java.awt.geom.RoundRectangle2D
import org.eclipse.emf.ecore.EObject
import java.util.List
import com.cburch.logisim.statemachine.editor.FSMEditorController
import java.util.ArrayList

class FSMZones {

	FSMEditorController ctrl
	
	new(FSMEditorController ctrl) {
		this.ctrl=ctrl
	}
	
	def getSelectedElement(Point p,FSMElement e) {
		if (isWithinElement(p,e)) {
			e
		} else {
			null
		}
	}

	int xmin;
	int ymin;	
	int xmax;
	int ymax;

	def updateBoundingBox(FSMElement e) {
		xmin= Math.min(xmin, e.layout.x);
		ymin= Math.min(ymin, e.layout.y);
		xmax= Math.max(xmax, e.layout.x+e.layout.width);
		ymax= Math.max(ymax, e.layout.y+e.layout.height);
	}

	def computeBoundingBox(FSM fsm) {
		xmin=Integer.MAX_VALUE
		ymin=Integer.MAX_VALUE;
		xmax=0;
		ymax=0;
		updateBoundingBox(fsm)
		for(s:fsm.states) {
			
			updateBoundingBox(s);
			for(t:s.transition) {
				updateBoundingBox(t)
			}
		}
	} 
	
	public enum AreaType {INPUT,  OUTPUT, STATE, TRANSITION, NONE}
	
	def void detectElement(Point p, FSMElement o, List<FSMElement> l) {
		val isWithinElement = isWithinElement(p, o)
		if (isWithinElement && o !== null && l !== null) {
			l.add(o)
		}

	}

	def List<FSMElement> getActiveElement(Point p) {
		var List<FSMElement> candidates = new ArrayList<FSMElement>()
		val fsm = ctrl.getFSM();
		detectElement(p, fsm, candidates)
		for (Port ip : fsm.getIn()) {
			detectElement(p, ip, candidates)
		}
		for (Port op : fsm.getOut()) {
			detectElement(p, op, candidates)
		}
		for (State s : fsm.getStates()) {
			detectElement(p, s, candidates)
			detectElement(p, s.getCommandList(), candidates)
			for (Transition t : s.getTransition()) {
				detectElement(p, t, candidates)
			}

		}
		var int nbmatch = candidates.size()
		println(candidates)
		return candidates	
	}
	
	def public AreaType getAreaType(Point p, FSM fsm) {
		val List<FSMElement> selection = getActiveElement(p);
		if (selection.size()>0) {
			val first = selection.get(0)
			if(first instanceof State) {
				return AreaType.TRANSITION
			}
		}
		computeBoundingBox(fsm);
		if(p.y>ymin && p.y<ymax) {
			if(p.x<xmin) {
				return AreaType.INPUT
			} else if(p.x>xmax) {
				return AreaType.OUTPUT
			} else {
				return AreaType.STATE
			}
		} else {
			return AreaType.NONE
		}
	}

	def dispatch boolean isWithinElement(Point p,FSMElement e) {
		false
	}

	public static def inRectangle(int x, int y, LayoutInfo l) {
		if (l.height>0)
		return (
			(x >= l.x) && (x <= (l.x+l.width)) &&
			(y >= l.y) && (y <= (l.y+l.height))
			)
		else
		return (
			(x >= l.x) && (x <= (l.x+l.width)) &&
			(y >= l.y+l.height) && (y <= (l.y))
			)
	}
	
	def dispatch isWithinElement(Point p,CommandList e) {
		val l= e.layout	
		println("check if ("+p.x+','+p.y+") within CommandList["+(l.x)+","+(l.y)+","+(l.x+l.width)+","+(l.y+l.height)+"]")
		if (inRectangle(p.x,p.y,e.layout)) {
			println("\tYES !")
			return true
		}
		false
	}
	
	def dispatch isWithinElement(Point p,FSM e) {
		val l= e.layout	
		println("check if ("+p.x+','+p.y+") within FSM ["+(l.x)+","+(l.y+FSMDrawing.FSM_TITLE_HEIGHT)+","+(l.x+l.width)+","+((l.y+FSMDrawing.FSM_TITLE_HEIGHT))+"]")
		if (p.x>l.x && p.x <(l.x+l.width)) {
			if (p.y>l.y && p.y <(l.y+FSMDrawing.FSM_TITLE_HEIGHT)) {
				println("\tYES !")
				return true
			}
		}
		false
	}

	def dispatch isWithinElement(Point p,State e) {
		val l = e.layout
		val radius = l.width
		val dx = (p.x - (l.x+radius)) 
		val dy = (p.y - (l.y+radius))
		val distance = Math.sqrt(dx*dx+dy*dy)
		println("check if ("+p.x+','+p.y+") within circle["+(l.x+radius)+","+(l.y+radius)+","+radius+"] -> distance = "+distance+"  ")
		if (distance<radius) {
			println("\tYES !")
			return true
		}
		false
	}

	def dispatch isWithinElement(Point p,Transition e) {
		val l = e.layout
		println("check if ("+p.x+','+p.y+") within Transition["+(l.x)+","+(l.y)+","+(l.width)+","+(l.height)+",]   ")
		if (inRectangle(p.x,p.y,e.layout) && e.dst!=null) {
			println("\tYES !")
			return true
		}
		false
	}

	def dispatch isWithinElement(Point p,InputPort e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within InPort["+(l.x)+","+(l.y)+","+(l.x+l.width)+","+(l.y+l.height)+"]")
		if (inRectangle(p.x,p.y,e.layout)) {
			println("\tYES !")
			return true
		}
		false
	}

	def dispatch isWithinElement(Point p,OutputPort e) {
		val l= e.layout	
		println('('+p.x+','+p.y+") within OutPort["+(l.x)+","+(l.y)+","+(l.x+l.width)+","+(l.y+l.height)+"]")
		if (inRectangle(p.x,p.y,e.layout)) {
			println("\tYES !")
			return true
		}
		false
	}
}