package com.cburch.logisim.statemachine.bdd;

import com.cburch.logisim.statemachine.PrettyPrinter;
import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.Range;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class BitWidthAnalyzer {
  public BitWidthAnalyzer() {
  }
  
  public Integer getBitwidth(final BoolExpr b) {
    Integer _xifexpression = null;
    boolean _containsKey = this.typeMap.containsKey(b);
    if (_containsKey) {
      _xifexpression = this.typeMap.get(b);
    } else {
      _xifexpression = this.computeBitwidth(b);
    }
    return _xifexpression;
  }
  
  private HashMap<BoolExpr, Integer> typeMap = new HashMap<BoolExpr, Integer>();
  
  public Integer checkWidth(final EList<BoolExpr> args, final BoolExpr b) {
    Integer _xblockexpression = null;
    {
      int width = (-1);
      for (final BoolExpr a : args) {
        boolean _containsKey = this.typeMap.containsKey(a);
        if (_containsKey) {
          final Integer w = this.typeMap.get(a);
          if (((w).intValue() != width)) {
            if ((width != (-1))) {
              String _pp = PrettyPrinter.pp(a);
              String _plus = ("Bitwidth mismatch in term " + _pp);
              String _plus_1 = (_plus + " in ");
              EObject _eContainer = a.eContainer();
              String _pp_1 = PrettyPrinter.pp(((BoolExpr) _eContainer));
              String _plus_2 = (_plus_1 + _pp_1);
              String _plus_3 = (_plus_2 + " ");
              String _plus_4 = (_plus_3 + Integer.valueOf(width));
              String _plus_5 = (_plus_4 + " expected, ");
              String _plus_6 = (_plus_5 + w);
              final String string = (_plus_6 + "found");
              InputOutput.<String>println(string);
              throw new RuntimeException(string);
            } else {
              width = (w).intValue();
            }
          }
        } else {
          throw new RuntimeException("ERROR mismatch in predicate expression ");
        }
      }
      _xblockexpression = this.typeMap.put(b, Integer.valueOf(width));
    }
    return _xblockexpression;
  }
  
  public Integer _computeBitwidth(final BoolExpr b) {
    return null;
  }
  
  public Integer _computeBitwidth(final OrExpr b) {
    Integer _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      final Consumer<BoolExpr> _function = (BoolExpr a) -> {
        this.computeBitwidth(a);
      };
      _args.forEach(_function);
      EList<BoolExpr> _args_1 = b.getArgs();
      _xblockexpression = this.checkWidth(_args_1, b);
    }
    return _xblockexpression;
  }
  
  public Integer _computeBitwidth(final CmpExpr b) {
    Integer _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      int _size = _args.size();
      boolean _notEquals = (_size != 2);
      if (_notEquals) {
        String _pp = PrettyPrinter.pp(b);
        String _plus = ("Inconsistent number of arguments for " + _pp);
        String _plus_1 = (_plus + " ");
        throw new RuntimeException(_plus_1);
      }
      EList<BoolExpr> _args_1 = b.getArgs();
      final Consumer<BoolExpr> _function = (BoolExpr a) -> {
        this.computeBitwidth(a);
      };
      _args_1.forEach(_function);
      EList<BoolExpr> _args_2 = b.getArgs();
      _xblockexpression = this.checkWidth(_args_2, b);
    }
    return _xblockexpression;
  }
  
  public Integer _computeBitwidth(final AndExpr b) {
    Integer _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      final Consumer<BoolExpr> _function = (BoolExpr a) -> {
        this.computeBitwidth(a);
      };
      _args.forEach(_function);
      EList<BoolExpr> _args_1 = b.getArgs();
      _xblockexpression = this.checkWidth(_args_1, b);
    }
    return _xblockexpression;
  }
  
  public Integer _computeBitwidth(final NotExpr b) {
    Integer _xblockexpression = null;
    {
      EList<BoolExpr> _args = b.getArgs();
      final Consumer<BoolExpr> _function = (BoolExpr a) -> {
        this.computeBitwidth(a);
      };
      _args.forEach(_function);
      EList<BoolExpr> _args_1 = b.getArgs();
      _xblockexpression = this.checkWidth(_args_1, b);
    }
    return _xblockexpression;
  }
  
  public Integer _computeBitwidth(final Constant b) {
    String _value = b.getValue();
    int _length = _value.length();
    int _minus = (_length - 2);
    return this.typeMap.put(b, Integer.valueOf(_minus));
  }
  
  public Integer _computeBitwidth(final PortRef b) {
    Integer _xifexpression = null;
    Range _range = b.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      Integer _xblockexpression = null;
      {
        Range _range_1 = b.getRange();
        int _lb = _range_1.getLb();
        Port _port = b.getPort();
        int _width = _port.getWidth();
        int _minus = (_width - 1);
        boolean _greaterThan = (_lb > _minus);
        if (_greaterThan) {
          Range _range_2 = b.getRange();
          int _ub = _range_2.getUb();
          String _plus = ("Inconsistent range [" + Integer.valueOf(_ub));
          String _plus_1 = (_plus + ":");
          Range _range_3 = b.getRange();
          int _lb_1 = _range_3.getLb();
          String _plus_2 = (_plus_1 + Integer.valueOf(_lb_1));
          String _plus_3 = (_plus_2 + "] for port ");
          Port _port_1 = b.getPort();
          String _name = _port_1.getName();
          String _plus_4 = (_plus_3 + _name);
          String _plus_5 = (_plus_4 + "[");
          Port _port_2 = b.getPort();
          int _width_1 = _port_2.getWidth();
          int _minus_1 = (_width_1 - 1);
          String _plus_6 = (_plus_5 + Integer.valueOf(_minus_1));
          String _plus_7 = (_plus_6 + ":0]");
          throw new IndexOutOfBoundsException(_plus_7);
        }
        Integer _xifexpression_1 = null;
        Range _range_4 = b.getRange();
        int _ub_1 = _range_4.getUb();
        boolean _notEquals_1 = (_ub_1 != (-1));
        if (_notEquals_1) {
          Integer _xblockexpression_1 = null;
          {
            Range _range_5 = b.getRange();
            int _ub_2 = _range_5.getUb();
            Port _port_3 = b.getPort();
            int _width_2 = _port_3.getWidth();
            int _minus_2 = (_width_2 - 1);
            boolean _greaterThan_1 = (_ub_2 > _minus_2);
            if (_greaterThan_1) {
              Range _range_6 = b.getRange();
              int _ub_3 = _range_6.getUb();
              String _plus_8 = ("Inconsistent range [" + Integer.valueOf(_ub_3));
              String _plus_9 = (_plus_8 + ":");
              Range _range_7 = b.getRange();
              int _lb_2 = _range_7.getLb();
              String _plus_10 = (_plus_9 + Integer.valueOf(_lb_2));
              String _plus_11 = (_plus_10 + "] for port ");
              Port _port_4 = b.getPort();
              String _name_1 = _port_4.getName();
              String _plus_12 = (_plus_11 + _name_1);
              String _plus_13 = (_plus_12 + "[");
              Port _port_5 = b.getPort();
              int _width_3 = _port_5.getWidth();
              int _minus_3 = (_width_3 - 1);
              String _plus_14 = (_plus_13 + Integer.valueOf(_minus_3));
              String _plus_15 = (_plus_14 + ":0]");
              throw new IndexOutOfBoundsException(_plus_15);
            }
            Range _range_8 = b.getRange();
            int _lb_3 = _range_8.getLb();
            Range _range_9 = b.getRange();
            int _ub_4 = _range_9.getUb();
            boolean _greaterThan_2 = (_lb_3 > _ub_4);
            if (_greaterThan_2) {
              Range _range_10 = b.getRange();
              int _ub_5 = _range_10.getUb();
              String _plus_16 = ("Inconsistent range [" + Integer.valueOf(_ub_5));
              String _plus_17 = (_plus_16 + ":");
              Range _range_11 = b.getRange();
              int _lb_4 = _range_11.getLb();
              String _plus_18 = (_plus_17 + Integer.valueOf(_lb_4));
              String _plus_19 = (_plus_18 + "] ");
              throw new IndexOutOfBoundsException(_plus_19);
            }
            Range _range_12 = b.getRange();
            int _ub_6 = _range_12.getUb();
            Range _range_13 = b.getRange();
            int _lb_5 = _range_13.getLb();
            int _minus_4 = (_ub_6 - _lb_5);
            int _plus_20 = (_minus_4 + 1);
            _xblockexpression_1 = this.typeMap.put(b, Integer.valueOf(_plus_20));
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          _xifexpression_1 = this.typeMap.put(b, Integer.valueOf(1));
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Port _port = b.getPort();
      int _width = _port.getWidth();
      _xifexpression = this.typeMap.put(b, Integer.valueOf(_width));
    }
    return _xifexpression;
  }
  
  public Integer computeBitwidth(final BoolExpr b) {
    if (b instanceof AndExpr) {
      return _computeBitwidth((AndExpr)b);
    } else if (b instanceof CmpExpr) {
      return _computeBitwidth((CmpExpr)b);
    } else if (b instanceof Constant) {
      return _computeBitwidth((Constant)b);
    } else if (b instanceof NotExpr) {
      return _computeBitwidth((NotExpr)b);
    } else if (b instanceof OrExpr) {
      return _computeBitwidth((OrExpr)b);
    } else if (b instanceof PortRef) {
      return _computeBitwidth((PortRef)b);
    } else if (b != null) {
      return _computeBitwidth(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
