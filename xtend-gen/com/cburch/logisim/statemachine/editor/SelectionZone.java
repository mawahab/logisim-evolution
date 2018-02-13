package com.cburch.logisim.statemachine.editor;

import com.google.common.base.Objects;
import java.awt.Point;

@SuppressWarnings("all")
public class SelectionZone {
  private Point start;
  
  private Point end;
  
  public SelectionZone() {
  }
  
  public boolean isSinglePoint() {
    boolean _or = false;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.start, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _equals = Objects.equal(this.end, null);
      _and = _equals;
    }
    if (_and) {
      _or = true;
    } else {
      boolean _equals_1 = this.end.equals(this.start);
      _or = _equals_1;
    }
    return _or;
  }
  
  public Point start(final Point point) {
    Point _point = new Point(point);
    return this.start = _point;
  }
  
  public Point extend(final Point point) {
    Point _point = new Point(point);
    return this.end = _point;
  }
  
  public Point clear() {
    Point _xblockexpression = null;
    {
      this.start = null;
      _xblockexpression = this.end = null;
    }
    return _xblockexpression;
  }
}
