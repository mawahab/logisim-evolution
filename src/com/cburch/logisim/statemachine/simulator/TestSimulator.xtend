package com.cburch.logisim.statemachine.simulator

import static org.junit.Assert.*
import org.junit.Test
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import com.cburch.logisim.statemachine.parser.FSMSerializer
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt

class TestSimulator {
	
	def static BoolExpr boolExpr(String in) throws IOException {
		var InputStream fis = new ByteArrayInputStream(in.getBytes(StandardCharsets.UTF_8))
		val stmt= FSMSerializer.parse(fis) as PredicateStmt
		stmt.predicate
	}
	
	@Test def void test() {
		fail("Not yet implemented")
	}

}
