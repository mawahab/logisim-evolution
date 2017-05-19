package com.cburch.logisim.statemachine.editor.view

import com.cburch.logisim.statemachine.PrettyPrinter

import com.cburch.logisim.statemachine.fSMDSL.*
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Point
import java.awt.RenderingHints
import java.awt.geom.QuadCurve2D
import java.awt.geom.RoundRectangle2D
import org.eclipse.emf.ecore.EObject
import java.awt.BasicStroke
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo
import com.cburch.logisim.statemachine.fSMDSL.State
import com.cburch.logisim.statemachine.fSMDSL.FSMElement
import java.util.List

class FSMDrawing {

	static final public int RADIUS = 30

	static final public int CHAR_HEIGHT = 15

	static final public int PORT_HEIGHT = 15

	static final public int INPUT_X = 100
	static final public int OUTPUT_X = 100
	
	
	final public static int FSM_BORDER_X=30;
	final public static int FSM_BORDER_Y=30;
	final public static int FSM_TITLE_HEIGHT=30;
	
	final static boolean DEBUG=false;

	def updateLayout(FSMElement e, int x, int y, int width, int heigh) {
		e.layout.x = x;
		e.layout.y = y;
		e.layout.width = width;
		e.layout.height = heigh;
	}

	def checkLayout(FSMElement e) {
		if (e.layout == null) {
			e.layout = FSMDSLFactory.eINSTANCE.createLayoutInfo
		}
		e.layout
	}

	def dispatch drawElement(FSMElement e, Graphics2D page, List<FSMElement> selection) {
		
	}

	def computeCommandBoxWidth(CommandList e, Graphics2D g) {
		
		var l = e.layout
		var w = FSMCustomFactory.CMD_WIDTH
		for (Command c : e.commands) {
			w = Math.max(w, g.getFontMetrics().stringWidth(PrettyPrinter.pp(c)));
		}
		l.width = w;
	}

	def updateBoundingBox(CommandList e, Graphics2D g) {
		var l = e.layout
		val lineHeight = g.getFontMetrics().height
		val nbCommands = e.commands.size
		var height = Math.max(FSMCustomFactory.CMD_HEIGHT, 6 + lineHeight * nbCommands)
		height
	}

	def dispatch drawElement(CommandList e, Graphics2D g, List<FSMElement> selection) {
		highlightSelection(e,g,selection)
		checkLayout(e);
		var l = e.layout
		val newH = updateBoundingBox(e,g)
		if (newH!=l.height) {
			l.x=l.x+l.height
			l.height =newH;
			l.x = l.x-l.height
		}
		
		val lineHeight = g.getFontMetrics().height
		g.setColor(Color.white);
		g.fillRoundRect(l.x, l.y, l.width, l.height, 5, 5);
		g.setColor(Color.black);
		g.drawRoundRect(l.x, l.y, l.width, l.height, 5, 5);
		var int line = 1;
		for (Command c : e.commands) {
			g.drawString(PrettyPrinter.pp(c), l.x + 4, l.y  + line * lineHeight + 1);
			line++;
		}
		showZone(e.layout,g)

	}

	def dispatch drawElement(FSM e, Graphics2D g, List<FSMElement> selection) {
				highlightSelection(e,g,selection)
		val l = e.layout
		if(l.x==0) l.x=FSM_BORDER_X
		if(l.y==0) l.y=FSM_BORDER_Y
		if (l.width==0) l.width=FSMCustomFactory.FSM_WIDTH;
		if (l.height==0) l.height=FSMCustomFactory.FSM_HEIGHT;
		
		val lineHeight = g.getFontMetrics().height
		val label = e.width+"-bit FSM : "+ e.name+ " "
		val lblWidth =g.getFontMetrics().stringWidth(label);
		g.drawRoundRect(l.x, l.y, l.width, l.height,15,15);
		g.drawString(label, l.x+l.width/2-lblWidth/2,  l.y+(FSM_TITLE_HEIGHT+lineHeight)/2);
		g.drawLine(l.x, l.y+FSM_TITLE_HEIGHT, l.x+l.width,l.y+FSM_TITLE_HEIGHT);

		for(p:e.in) drawElement(p,g, selection);
		for(p:e.out) drawElement(p,g, selection);
		for(s:e.states) for (t:s.transition) drawElement(t,g, selection);
		for(s:e.states) drawElement(s,g, selection);
		for(s:e.states) drawElement(s.commandList,g, selection);

	}
	def dispatch drawElement(State e, Graphics2D g, List<FSMElement> selection) {
		highlightSelection(e, g, selection)
		val l = e.layout
		if (l.width==0) {
			l.width=FSMCustomFactory.STATE_RADIUS;
			l.height=FSMCustomFactory.STATE_RADIUS;
		}
		val radius = l.width
		g.setColor(Color.white);
		g.fillOval(l.x, l.y, 2 * radius, 2 * radius);
		g.setColor(Color.black);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		var labelWidth = g.getFontMetrics().stringWidth(e.name);
		g.drawString(e.name, l.x + radius - labelWidth / 2, l.y + radius - 3);

		labelWidth = g.getFontMetrics().stringWidth(e.code);
		g.drawString(e.code, l.x + radius - labelWidth / 2, l.y + radius + 13);
		g.drawOval(l.x, l.y, 2 * radius, 2 * radius);
		if(e.eContainer!=null && e.eContainer instanceof FSM) {
			val fsm = e.eContainer as FSM
			if (fsm.start==e) {
				g.drawOval(l.x-3, l.y-3, 2 * radius+6, 2 * radius+6);
			}
		}

	}
	
	def highlightSelection(FSMElement e, Graphics2D g, List<FSMElement> selection) {
		if(selection.contains(e)) {
			g.setStroke(new BasicStroke(3));
		} else {
			g.setStroke(new BasicStroke(1));
		}
	}

	def Point shift(int dx, int dy, int radius) {
		var Point p = null
		if (dx != 0) {
			val angle = Math.atan(Math.abs((dy as double)/ (dx as double) ));
			var cosx = (radius * Math.cos(angle)) as int
			var cosy = (radius * Math.sin(angle)) as int
			if (dy < 0) {
				cosy = -cosy;
			}
			if (dx < 0) {
				cosx = -cosx;
			}
			p = new Point(cosx, cosy);
		} else {
			if (dy > 0) {
				p = new Point(0, radius);
			} else {
				p = new Point(0, -radius);
			}
		}
		p
	}

	def dispatch drawElement(Transition e, Graphics2D g, List<FSMElement> selection) {
				highlightSelection(e,g,selection)
		
		val src = e.eContainer as State;
		if(src!=e.src) {
			e.src=src;
		}
		val sl = src.layout;
		val l = e.layout;
		val radius = sl.width
		
		val _s = shift(l.x - sl.x - radius, l.y - sl.y - radius, radius)
		val srcx = sl.x + radius + _s.x
		val srcy = sl.y + radius + _s.y
		if (e.dst != null) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			val pp = PrettyPrinter.pp(e.predicate)
			val ph = g.fontMetrics.height + 6
			val pw = g.fontMetrics.stringWidth(pp) + 6;
			g.setColor(Color.GRAY);
 
			g.drawRect(l.x, l.y, pw, ph);
			l.width=pw
			l.height=ph
			g.setColor(Color.BLACK);
			g.drawString(pp, l.x + 3, l.y + ph-3);
			val dl = e.dst.layout;
			val _d = shift(dl.x - l.x + radius, dl.y - l.y + radius, radius)
			val dstx = dl.x + radius - _d.x
			val dsty = dl.y + radius - _d.y
			DrawUtils.drawArrowLine(g, l.x, l.y, dstx, dsty, 8, 8, true);
			val quadCurve = new QuadCurve2D.Double(srcx , srcy , l.x, l.y, dstx, dsty);
			g.draw(quadCurve);
		} else {
			g.drawLine(srcx, srcy, l.x, l.y);
		}
		showZone(e.layout,g)
	}
	
	def showZone(LayoutInfo l, Graphics2D g) {
		if(DEBUG) {
			g.setColor(Color.GREEN);
			g.drawString('''[«l.x»,«l.y»-«l.x+l.width»,«l.y+l.height»]''',l.x, l.y-8)
			g.drawRect(l.x, l.y, l.width, l.height);
			g.setColor(Color.black);
		}
	}

	def dispatch drawElement(InputPort e, Graphics2D page, List<FSMElement> selection) {
		highlightSelection(e,page,selection)
		drawPort(e, page, true);
	}

	def drawPort(Port e, Graphics2D page, boolean left) {
		val LayoutInfo l = e.layout
		val fsmLayout = (e.eContainer as FSM).layout
		var label = e.name
		if (e.width > 1) {
			label += '[' + (e.width - 1) + ":0]"
		}
		l.width = 6 + page.getFontMetrics().stringWidth(label);
		if(left) {
			l.x = (e.eContainer as FSM).layout.x
			l.height = PORT_HEIGHT
			page.drawRect(l.x, l.y, l.width, l.height + 4);
			page.drawString(label, l.x + 3, l.y + l.height);
			DrawUtils.drawArrowLine(page, l.x-INPUT_X/2, l.y+PORT_HEIGHT/2, l.x, l.y+PORT_HEIGHT/2, 8, 8, false);
		} else {
			l.x = fsmLayout.x+fsmLayout.width-l.width
			l.height = PORT_HEIGHT
			page.drawRect(l.x, l.y, l.width, l.height + 4);
			page.drawString(label, l.x + 3, l.y + l.height);
			DrawUtils.drawArrowLine(page, l.x+l.width, l.y+PORT_HEIGHT/2, l.x+l.width+INPUT_X/2, l.y+PORT_HEIGHT/2, 8, 8, false);
		}
	}

	def dispatch drawElement(OutputPort e, Graphics2D page, List<FSMElement> selection) {
		highlightSelection(e,page,selection)
		showZone(e.layout,page)
		drawPort(e, page, false);

	}
}