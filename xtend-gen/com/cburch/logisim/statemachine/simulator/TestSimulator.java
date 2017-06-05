package com.cburch.logisim.statemachine.simulator;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestSimulator {
  public static BoolExpr boolExpr(final String in) throws IOException {
    BoolExpr _xblockexpression = null;
    {
      byte[] _bytes = in.getBytes(StandardCharsets.UTF_8);
      InputStream fis = new ByteArrayInputStream(_bytes);
      EObject _parse = FSMSerializer.parse(fis);
      final PredicateStmt stmt = ((PredicateStmt) _parse);
      _xblockexpression = stmt.getPredicate();
    }
    return _xblockexpression;
  }
  
  @Test
  public void test() {
    Assert.fail("Not yet implemented");
  }
}
