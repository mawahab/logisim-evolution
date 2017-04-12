package com.cburch.logisim.statemachine.bdd;

import com.cburch.logisim.statemachine.fSMDSL.AndExpr;
import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.CmpExpr;
import com.cburch.logisim.statemachine.fSMDSL.Constant;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory;
import com.cburch.logisim.statemachine.fSMDSL.NotExpr;
import com.cburch.logisim.statemachine.fSMDSL.OrExpr;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;
import com.cburch.logisim.statemachine.fSMDSL.Range;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RemoveCompare {
  public RemoveCompare() {
  }
  
  protected BoolExpr _replace(final BoolExpr e) {
    BoolExpr _xblockexpression = null;
    {
      TreeIterator<Object> _allContents = EcoreUtil.<Object>getAllContents(e, false);
      Iterator<CmpExpr> _filter = Iterators.<CmpExpr>filter(_allContents, CmpExpr.class);
      final List<CmpExpr> list = IteratorExtensions.<CmpExpr>toList(_filter);
      for (final CmpExpr n : list) {
        {
          InputOutput.<String>println("");
          BoolExpr _slice = this.slice(n);
          EcoreUtil.replace(n, _slice);
        }
      }
      _xblockexpression = e;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _replace(final CmpExpr e) {
    BoolExpr _xblockexpression = null;
    {
      TreeIterator<Object> _allContents = EcoreUtil.<Object>getAllContents(e, false);
      Iterator<CmpExpr> _filter = Iterators.<CmpExpr>filter(_allContents, CmpExpr.class);
      final List<CmpExpr> list = IteratorExtensions.<CmpExpr>toList(_filter);
      for (final CmpExpr n : list) {
        {
          InputOutput.<String>println("");
          BoolExpr _slice = this.slice(n);
          EcoreUtil.replace(n, _slice);
        }
      }
      _xblockexpression = this.slice(e);
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final BoolExpr e, final int offset) {
    throw new RuntimeException(("Cannot bitslice expression " + e));
  }
  
  public BoolExpr and(final BoolExpr a, final BoolExpr b) {
    AndExpr _xblockexpression = null;
    {
      AndExpr and = FSMDSLFactory.eINSTANCE.createAndExpr();
      EList<BoolExpr> _args = and.getArgs();
      Iterables.<BoolExpr>addAll(_args, Collections.<BoolExpr>unmodifiableSet(CollectionLiterals.<BoolExpr>newHashSet(a, b)));
      _xblockexpression = and;
    }
    return _xblockexpression;
  }
  
  public BoolExpr or(final BoolExpr a, final BoolExpr b) {
    OrExpr _xblockexpression = null;
    {
      OrExpr or = FSMDSLFactory.eINSTANCE.createOrExpr();
      EList<BoolExpr> _args = or.getArgs();
      Iterables.<BoolExpr>addAll(_args, Collections.<BoolExpr>unmodifiableSet(CollectionLiterals.<BoolExpr>newHashSet(a, b)));
      _xblockexpression = or;
    }
    return _xblockexpression;
  }
  
  public BoolExpr not(final BoolExpr a) {
    NotExpr _xblockexpression = null;
    {
      NotExpr not = FSMDSLFactory.eINSTANCE.createNotExpr();
      EList<BoolExpr> _args = not.getArgs();
      _args.add(a);
      _xblockexpression = not;
    }
    return _xblockexpression;
  }
  
  public BoolExpr equ(final BoolExpr a, final BoolExpr b) {
    BoolExpr _copy = EcoreUtil.<BoolExpr>copy(a);
    BoolExpr _copy_1 = EcoreUtil.<BoolExpr>copy(b);
    BoolExpr _and = this.and(_copy, _copy_1);
    BoolExpr _copy_2 = EcoreUtil.<BoolExpr>copy(a);
    BoolExpr _copy_3 = EcoreUtil.<BoolExpr>copy(b);
    BoolExpr _or = this.or(_copy_2, _copy_3);
    BoolExpr _not = this.not(_or);
    return this.or(_and, _not);
  }
  
  public BoolExpr nequ(final BoolExpr a, final BoolExpr b) {
    BoolExpr _copy = EcoreUtil.<BoolExpr>copy(a);
    BoolExpr _not = this.not(_copy);
    BoolExpr _copy_1 = EcoreUtil.<BoolExpr>copy(b);
    BoolExpr _and = this.and(_not, _copy_1);
    BoolExpr _copy_2 = EcoreUtil.<BoolExpr>copy(a);
    BoolExpr _copy_3 = EcoreUtil.<BoolExpr>copy(b);
    BoolExpr _not_1 = this.not(_copy_3);
    BoolExpr _and_1 = this.and(_copy_2, _not_1);
    return this.or(_and, _and_1);
  }
  
  protected BoolExpr _slice(final CmpExpr e) {
    AndExpr _xblockexpression = null;
    {
      AndExpr and = FSMDSLFactory.eINSTANCE.createAndExpr();
      boolean canDoIt = true;
      int i = 0;
      while (canDoIt) {
        try {
          BoolExpr slice = null;
          EList<BoolExpr> _args = e.getArgs();
          BoolExpr _get = _args.get(0);
          final BoolExpr left = this.slice(_get, i);
          EList<BoolExpr> _args_1 = e.getArgs();
          BoolExpr _get_1 = _args_1.get(1);
          final BoolExpr right = this.slice(_get_1, i);
          String _op = e.getOp();
          switch (_op) {
            case "==":
              BoolExpr _equ = this.equ(left, right);
              slice = _equ;
              break;
            case "!=":
              BoolExpr _nequ = this.nequ(left, right);
              slice = _nequ;
              break;
          }
          boolean _notEquals = (!Objects.equal(slice, null));
          if (_notEquals) {
            EList<BoolExpr> _args_2 = and.getArgs();
            _args_2.add(slice);
          }
          i++;
        } catch (final Throwable _t) {
          if (_t instanceof IndexOutOfBoundsException) {
            final IndexOutOfBoundsException ex = (IndexOutOfBoundsException)_t;
            canDoIt = false;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = and;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final AndExpr e, final int offset) {
    AndExpr _xblockexpression = null;
    {
      AndExpr and = FSMDSLFactory.eINSTANCE.createAndExpr();
      EList<BoolExpr> _args = and.getArgs();
      EList<BoolExpr> _args_1 = e.getArgs();
      final Function1<BoolExpr, BoolExpr> _function = (BoolExpr arg) -> {
        return this.slice(arg, offset);
      };
      List<BoolExpr> _map = ListExtensions.<BoolExpr, BoolExpr>map(_args_1, _function);
      _args.addAll(_map);
      _xblockexpression = and;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final OrExpr e, final int offset) {
    OrExpr _xblockexpression = null;
    {
      OrExpr or = FSMDSLFactory.eINSTANCE.createOrExpr();
      EList<BoolExpr> _args = or.getArgs();
      EList<BoolExpr> _args_1 = e.getArgs();
      final Function1<BoolExpr, BoolExpr> _function = (BoolExpr arg) -> {
        return this.slice(arg, offset);
      };
      List<BoolExpr> _map = ListExtensions.<BoolExpr, BoolExpr>map(_args_1, _function);
      _args.addAll(_map);
      _xblockexpression = or;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final NotExpr e, final int offset) {
    NotExpr _xblockexpression = null;
    {
      NotExpr not = FSMDSLFactory.eINSTANCE.createNotExpr();
      EList<BoolExpr> _args = not.getArgs();
      EList<BoolExpr> _args_1 = e.getArgs();
      final Function1<BoolExpr, BoolExpr> _function = (BoolExpr arg) -> {
        return this.slice(arg, offset);
      };
      List<BoolExpr> _map = ListExtensions.<BoolExpr, BoolExpr>map(_args_1, _function);
      _args.addAll(_map);
      _xblockexpression = not;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final Constant e, final int offset) {
    Constant _xblockexpression = null;
    {
      Constant c = FSMDSLFactory.eINSTANCE.createConstant();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _value = e.getValue();
      char _charAt = _value.charAt((offset + 1));
      _builder.append(_charAt, "");
      _builder.append("\"");
      c.setValue(_builder.toString());
      _xblockexpression = c;
    }
    return _xblockexpression;
  }
  
  protected BoolExpr _slice(final PortRef e, final int offset) {
    PortRef _xifexpression = null;
    Range _range = e.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      PortRef _xblockexpression = null;
      {
        Range _range_1 = e.getRange();
        int _lb = _range_1.getLb();
        int _plus = (offset + _lb);
        Port _port = e.getPort();
        int _width = _port.getWidth();
        boolean _greaterEqualsThan = (_plus >= _width);
        if (_greaterEqualsThan) {
          Port _port_1 = e.getPort();
          String _plus_1 = ((("Offset " + Integer.valueOf(offset)) + " is out of bound w.r.t to port ") + _port_1);
          throw new IndexOutOfBoundsException(_plus_1);
        }
        PortRef pref = FSMDSLFactory.eINSTANCE.createPortRef();
        Port _port_2 = e.getPort();
        pref.setPort(_port_2);
        Range _createRange = FSMDSLFactory.eINSTANCE.createRange();
        pref.setRange(_createRange);
        Range _range_2 = pref.getRange();
        Range _range_3 = e.getRange();
        int _lb_1 = _range_3.getLb();
        int _plus_2 = (offset + _lb_1);
        _range_2.setLb(_plus_2);
        Range _range_4 = pref.getRange();
        Range _range_5 = e.getRange();
        int _lb_2 = _range_5.getLb();
        int _plus_3 = (offset + _lb_2);
        _range_4.setUb(_plus_3);
        _xblockexpression = pref;
      }
      _xifexpression = _xblockexpression;
    } else {
      PortRef _xblockexpression_1 = null;
      {
        Port _port = e.getPort();
        int _width = _port.getWidth();
        boolean _greaterEqualsThan = (offset >= _width);
        if (_greaterEqualsThan) {
          Port _port_1 = e.getPort();
          String _plus = ((("Offset " + Integer.valueOf(offset)) + " is out of bound w.r.t to port ") + _port_1);
          throw new IndexOutOfBoundsException(_plus);
        }
        PortRef pref = FSMDSLFactory.eINSTANCE.createPortRef();
        Port _port_2 = e.getPort();
        pref.setPort(_port_2);
        Range _createRange = FSMDSLFactory.eINSTANCE.createRange();
        pref.setRange(_createRange);
        Range _range_1 = pref.getRange();
        _range_1.setLb(offset);
        Range _range_2 = pref.getRange();
        _range_2.setUb(offset);
        _xblockexpression_1 = pref;
      }
      _xifexpression = _xblockexpression_1;
    }
    return _xifexpression;
  }
  
  public BoolExpr replace(final BoolExpr e) {
    if (e instanceof CmpExpr) {
      return _replace((CmpExpr)e);
    } else if (e != null) {
      return _replace(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public BoolExpr slice(final BoolExpr e, final int offset) {
    if (e instanceof AndExpr) {
      return _slice((AndExpr)e, offset);
    } else if (e instanceof Constant) {
      return _slice((Constant)e, offset);
    } else if (e instanceof NotExpr) {
      return _slice((NotExpr)e, offset);
    } else if (e instanceof OrExpr) {
      return _slice((OrExpr)e, offset);
    } else if (e instanceof PortRef) {
      return _slice((PortRef)e, offset);
    } else if (e != null) {
      return _slice(e, offset);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e, offset).toString());
    }
  }
  
  public BoolExpr slice(final CmpExpr e) {
    return _slice(e);
  }
}
