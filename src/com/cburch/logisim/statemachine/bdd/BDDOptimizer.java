package com.cburch.logisim.statemachine.bdd;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.util.FSMDSLSwitch;

import jdd.bdd.BDD;
import static com.cburch.logisim.statemachine.editor.view.FSMCustomFactory.*;
//import jdd.bdd.BDD;



/*  implement with switch visit ... !!! */

public class BDDOptimizer extends FSMDSLSwitch<Integer> {

	private static final String ZERO = "\"0\"";
	private static final String ONE = "\"1\"";
	private static final boolean VERBOSE = false;
	EList<InputPort> in;

	private BDD bdd;
	private Integer root;
	private BDDVariableMapping map;

	List<BoolExpr> list;

	private void debug(String str) {
		if (VERBOSE)
			System.out.print(str + "\n");
	}

	public BDDOptimizer(BoolExpr bexp) {

		in = new CollectFlags().collect(bexp);
		int bddsize = in.size() * in.size();
		bdd = new BDD(bddsize);
		map = new BDDVariableMapping(bdd);

		for (InputPort icp : in) {
			map.map(icp);
		}

		root = doSwitch(bexp);
		debug("Root is " + root);
	}

	
	public Integer caseAndExpr(AndExpr object) {
		int varBDDAnd = 0;
		;
		boolean first = true;

		for (BoolExpr bexp : object.getArgs()) {
			doSwitch(bexp);
			if (first) {
				first = false;
				varBDDAnd = map.getBDDVarFor(bexp);
			} else {
				int old = varBDDAnd;
				varBDDAnd = bdd.and(varBDDAnd, map.getBDDVarFor(bexp));
				debug("New node id=" + varBDDAnd + "=and(" + old + ","
						+ map.getBDDVarFor(bexp) + ")");
			}
		}
		map.map(object, varBDDAnd);
		return varBDDAnd;
	}

	
	public Integer caseConstant(Constant object) {
		String value =object.getValue();
		if (value.equals(ONE)) {
			map.map(object, bdd.getOne());
			return bdd.getOne();
		} else if (value.equals(ZERO)) {
			map.map(object, bdd.getZero());
			return bdd.getZero();
		} else {
			throw new UnsupportedOperationException("Unknown value "+value);
		}
	}

	
	public Integer casePortRef(PortRef object) {
		InputPort icp = (InputPort) object.getPort();
		if (!in.contains(icp)) {
			throw new RuntimeException("Inconsistency in "+ this.getClass().getSimpleName());
		} else if (icp.getWidth()>1) {
			throw new RuntimeException("No port width other than 1"+ this.getClass().getSimpleName());
		} else {
			int varProduct = map.getBDDVarFor(icp, 0);
			map.map(object, varProduct);
			return varProduct;
		}
	}


	private boolean isBitSetAt(int value, int i) {
		return ((value >> i) & 0x1) == 0x1;
	}

	
	
	public Integer caseOrExpr(OrExpr object) {
		int orBDDExression = 0;
		;
		boolean first = true;
		for (BoolExpr bexp : object.getArgs()) {
			doSwitch(bexp);
			if (first) {
				first = false;
				orBDDExression = map.getBDDVarFor(bexp);
			} else {
				int old = orBDDExression;
				orBDDExression = bdd.or(orBDDExression, map.getBDDVarFor(bexp));
				debug("New node id=" + orBDDExression + "=or(" + old + ","
						+ map.getBDDVarFor(bexp) + ")");
			}
		}
		map.map(object, orBDDExression);
		return orBDDExression;
	}

	
	public Integer caseNotExpr(NotExpr object) {
		int notBDDExpr0;
		BoolExpr bexp = object.getArgs().get(0);
		doSwitch(bexp);
		notBDDExpr0 = bdd.not(map.getBDDVarFor(bexp));
		map.map(object, notBDDExpr0);
		return notBDDExpr0;
	}

	public BoolExpr simplify() {
		list = new ArrayList<BoolExpr>();
		rebuildPredicateFromSimplifiedBDD(bdd, root, null);
		if (list.size() == 0) {
			debug("No solution -> always false");
			return cst(false);
		}
		OrExpr orExp = or(list);
		return orExp;

	}

	public boolean isAlwaysTrue() {
		return root == 1;
	}

	public boolean isAlwaysFalse() {
		return root == 0;
	}

	/** Translates the simplified BDD boolean expression into a FSM predicates **/

	private void rebuildPredicateFromSimplifiedBDD(BDD bdd, int root,
			BoolExpr current) {
		BDDDotExport dot;
		try {
			dot = new BDDDotExport("bdd.dot", bdd, map);
			dot.save(root);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (root >= 2) {

			int bddInputVar = bdd.getVar(root);
			debug("Root=" + root + " var=" + bddInputVar + " high="
					+ bdd.getHigh(root) + " low=" + bdd.getLow(root) + "");
			/**
			 * 
			 * 
			 */

			// if (bddVar<=1) throw new
			// UnsupportedOperationException("Not yet implemented");
			Entry<InputPort, Integer> entry = map
					.getICPortForBDDvar(bddInputVar);
			InputPort port = entry.getKey();

			PortRef t;
			BoolExpr nT;

			if (port.getWidth() == 1) {
				t = pref(port);
				nT = not(pref(port));
//			} else if (port.getWidth() > 1) {
//				t = pref(port, entry.getValue());
//				nT = nT(port, entry.getValue());
			} else {
				throw new RuntimeException("Illegal port width");
			}

			/**
			 * 
			 */
			if (current != null) {
				BoolExpr ResHigh = (BoolExpr) EcoreUtil
						.copy(current);
				rebuildPredicateFromSimplifiedBDD(bdd, bdd.getHigh(root),
						and(t, ResHigh));
			} else {
				rebuildPredicateFromSimplifiedBDD(bdd, bdd.getHigh(root), t);
			}

			/**
			 * 
			 */
			if (current != null) {
				BoolExpr ResLow = (BoolExpr) EcoreUtil
						.copy(current);
				rebuildPredicateFromSimplifiedBDD(bdd, bdd.getLow(root),
						and(nT, ResLow));
			} else {
				rebuildPredicateFromSimplifiedBDD(bdd, bdd.getLow(root), nT);
			}
		} else if (root == 1) {
			// BDD is simplified as a constant to true
			if (current == null) {
				current = cst(true);
			}
			list.add(current);
			debug("Adding " + current + " to predicate");
		} else if (root == 0) {
			// BDD is simplified as a constant to false
			debug("Adding " + current + " to predicate");
		}
	}

	private class CollectFlags extends FSMDSLSwitch<Object> {
		EList<InputPort> list;

		public EList<InputPort> collect(BoolExpr bexp) {
			list = new BasicEList<InputPort>();
			doSwitch(bexp);
			return list;
		}

		
		public Object caseAndExpr(AndExpr object) {
			for (BoolExpr bexp : object.getArgs()) {
				doSwitch(bexp);
			}
			return super.caseAndExpr(object);
		}

		
		public Object caseOrExpr(OrExpr object) {
			for (BoolExpr bexp : object.getArgs()) {
				doSwitch(bexp);
			}
			return super.caseOrExpr(object);
		}



		
		public Object caseNotExpr(NotExpr object) {
			doSwitch(object.getArgs().get(0));
			return super.caseNotExpr(object);
		}

		public Object casePortRef(PortRef object) {
			if (!list.contains(object.getPort()))
				list.add((InputPort)object.getPort());
			return super.casePortRef(object);
		}

	}

}
