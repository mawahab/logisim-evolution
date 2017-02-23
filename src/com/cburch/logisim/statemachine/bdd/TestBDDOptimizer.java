package com.cburch.logisim.statemachine.bdd;


import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import static com.cburch.logisim.statemachine.editor.view.FSMCustomFactory.*;

import com.cburch.logisim.statemachine.PrettyPrinter;

public class TestBDDOptimizer {
	
	static InputPort x[] = new InputPort[] {
		inport("x0",1,0,0),
		inport("x1",1,0,0),
		inport("x2",1,0,0),
		inport("x3",1,0,0),
		inport("x4",1,0,0),
		inport("x5",1,0,0),
		inport("x6",1,0,0),
		inport("x7",8,0,0)
	};
		
	static final BoolExpr exp2 = 
			and(new BoolExpr[]{
					negpref(x[0]),
					pref(x[1]),
					negpref(x[2]),
					or(negpref(x[1]),negpref(x[4])),
					negpref(x[3])}
			);

	static final BoolExpr exp3 = 
			and(new BoolExpr[]{
					cst(true)}
			);

	static final BoolExpr exp1 = 
		and( new BoolExpr[]{
				negpref(x[0]),
				and(negpref(x[1]),negpref(x[4])),
				pref(x[2]),
				and(negpref(x[1]),negpref(x[4])),
				negpref(x[3]),
				pref(x[2]),
				pref(x[2])}
//				NEQ(x[7],13),
//				EQU(x[7],12)
		);
	
	static int rand(int max) {
		return (int) (Math.random()*max);
	}
	public static void main(String[] args) {
		BDDOptimizer optimizer = new BDDOptimizer(exp3);
		System.out.println("prefest 1 :");
		System.out.println("Before simplification"+PrettyPrinter.pp(exp3));
		System.out.println("After simplification"+PrettyPrinter.pp(optimizer.simplify()));
		
		optimizer = new BDDOptimizer(exp1);
		System.out.println("Before simplification"+PrettyPrinter.pp(exp1));
		System.out.println("After simplification"+PrettyPrinter.pp(optimizer.simplify()));
	}


}
