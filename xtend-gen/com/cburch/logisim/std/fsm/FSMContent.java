/**
 * This file is part of logisim-evolution.
 * logisim-evolution is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * logisim-evolution is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 * Original code by Carl Burch (http://www.cburch.com), 2011.
 * Subsequent modifications by :
 * + Haute École Spécialisée Bernoise
 * http://www.bfh.ch
 * + Haute École du paysage, d'ingénierie et d'architecture de Genève
 * http://hepia.hesge.ch/
 * + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 * http://www.heig-vd.ch/
 * The project is currently maintained by :
 * + REDS Institute - HEIG-VD
 * Yverdon-les-Bains, Switzerland
 * http://reds.heig-vd.ch
 */
package com.cburch.logisim.std.fsm;

import com.cburch.logisim.instance.Port;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.InputPort;
import com.cburch.logisim.statemachine.fSMDSL.OutputPort;
import com.cburch.logisim.statemachine.parser.FSMSerializer;
import com.cburch.logisim.std.fsm.FSMEntity;
import com.cburch.logisim.std.fsm.FSMModelListener;
import com.cburch.logisim.std.fsm.Strings;
import com.cburch.logisim.util.EventSourceWeakSupport;
import com.cburch.logisim.util.StringGetter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class FSMContent implements Cloneable {
  protected static <T extends Object> T[] concat(final T[] first, final T[] second) {
    int _length = first.length;
    int _length_1 = second.length;
    int _plus = (_length + _length_1);
    T[] result = Arrays.<T>copyOf(first, _plus);
    int _length_2 = first.length;
    int _length_3 = second.length;
    System.arraycopy(second, 0, result, _length_2, _length_3);
    return result;
  }
  
  protected EventSourceWeakSupport<FSMModelListener> listeners;
  
  private void init() {
    this.listeners = null;
    HashMap<Port, InputPort> _hashMap = new HashMap<Port, InputPort>();
    this.inMap = _hashMap;
    HashMap<Port, OutputPort> _hashMap_1 = new HashMap<Port, OutputPort>();
    this.outMap = _hashMap_1;
  }
  
  public FSMContent(final String text) {
    this.init();
    this.parseContent(text);
  }
  
  public FSMContent() {
    this.init();
    this.parseContent(FSMContent.TEMPLATE);
  }
  
  public void updateContent(final String txt) {
    this.init();
    this.parseContent(txt);
  }
  
  public FSM getFsm() {
    return this.fsm;
  }
  
  public void setFsm(final FSM fsm) {
    this.fsm = fsm;
  }
  
  @Override
  public FSMContent clone() {
    try {
      Object _clone = super.clone();
      FSMContent ret = ((FSMContent) _clone);
      FSM _copy = EcoreUtil.<FSM>copy(this.fsm);
      ret.fsm = _copy;
      ret.listeners = null;
      return ret;
    } catch (final Throwable _t) {
      if (_t instanceof CloneNotSupportedException) {
        final CloneNotSupportedException ex = (CloneNotSupportedException)_t;
        return this;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void addFSMModelListener(final FSMModelListener l) {
    if ((this.listeners == null)) {
      EventSourceWeakSupport<FSMModelListener> _eventSourceWeakSupport = new EventSourceWeakSupport<FSMModelListener>();
      this.listeners = _eventSourceWeakSupport;
    }
    this.listeners.add(l);
  }
  
  protected void fireContentSet() {
    if ((this.listeners == null)) {
      return;
    }
    boolean found = false;
    for (final FSMModelListener l : this.listeners) {
      {
        found = true;
        l.contentSet(this);
      }
    }
    if ((!found)) {
      this.listeners = null;
    }
  }
  
  public void removeFSMModelListener(final FSMModelListener l) {
    if ((this.listeners == null)) {
      return;
    }
    this.listeners.remove(l);
    boolean _isEmpty = this.listeners.isEmpty();
    if (_isEmpty) {
      this.listeners = null;
    }
  }
  
  private final static String TEMPLATE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("fsm example @[ 50 , 50 , 800 , 500 ] { in A [ 3 ] @[ 50 , 100 , 44 , 15 ] ; out");
      _builder.newLine();
      _builder.append("X [ 4 ] @[ 807 , 140 , 43 , 15 ] ; codeWidth = 2 ; reset = S0 ; state S0 = \"01\"");
      _builder.newLine();
      _builder.append("@[ 297 , 181 , 30 , 30 ] { commands @[ 246 , 173 , 50 , 40 ] { X = \"0001\" ; }");
      _builder.newLine();
      _builder.append("transitions { S0 -> S1 when default @[ 432 , 151 , 50 , 21 ] ; S0 -> S3 when A");
      _builder.newLine();
      _builder.append("== \"000\" @[ 346 , 269 , 68 , 21 ] ; } } state S1 = \"10\" @[ 470 , 186 , 30 , 30");
      _builder.newLine();
      _builder.append("] { commands @[ 522 , 190 , 40 , 40 ] { X = \"0010\" ; } transitions { S1 -> S2");
      _builder.newLine();
      _builder.append("when default @[ 533 , 276 , 50 , 21 ] ; S1 -> S0 when A == \"000\" @[ 399 , 230 ,");
      _builder.newLine();
      _builder.append("68 , 21 ] ; } } state S2 = \"00\" @[ 471 , 339 , 30 , 30 ] { commands @[ 524 ,");
      _builder.newLine();
      _builder.append("353 , 60 , 40 ] { X = { \"00\" , A [ 1 ] , \"1\" } ; } transitions { S2 -> S3 when");
      _builder.newLine();
      _builder.append("default @[ 392 , 398 , 50 , 21 ] ; S2 -> S1 when A [ 2 : 1 ] == \"11\" @[ 557 ,");
      _builder.newLine();
      _builder.append("250 , 90 , 21 ] ; } } state S3 = \"11\" @[ 287 , 325 , 30 , 30 ] { commands @[");
      _builder.newLine();
      _builder.append("244 , 341 , 60 , 40 ] { X = \"1000\" ; } transitions { S3 -> S0 when default @[");
      _builder.newLine();
      _builder.append("248 , 278 , 50 , 21 ] ; S3 -> S2 when A == \"000\" @[ 388 , 313 , 68 , 21 ] ; } }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  final static int CLK = 0;
  
  final static int CLR = 1;
  
  final static int EN = 2;
  
  protected Port[] inputs;
  
  protected Port[] outputs;
  
  protected Map<Port, InputPort> inMap;
  
  protected Map<Port, OutputPort> outMap;
  
  protected String name;
  
  private FSM fsm;
  
  private Port[] ctrl;
  
  public String getContent() {
    return FSMSerializer.saveAsString(this.fsm);
  }
  
  public Port[] getInputs() {
    if ((this.inputs == null)) {
      return new Port[0];
    }
    return this.inputs;
  }
  
  public int getInputsNumber() {
    if ((this.inputs == null)) {
      return 0;
    }
    return this.inputs.length;
  }
  
  public String getName() {
    if ((this.fsm == null)) {
      return "";
    }
    return this.fsm.getName();
  }
  
  public Port[] getOutputs() {
    if ((this.outputs == null)) {
      return new Port[0];
    }
    return this.outputs;
  }
  
  public int getOutputsNumber() {
    if ((this.outputs == null)) {
      return 0;
    }
    return this.outputs.length;
  }
  
  public Port[] getPorts() {
    Port[] _concat = FSMContent.<Port>concat(this.inputs, this.outputs);
    return FSMContent.<Port>concat(this.ctrl, _concat);
  }
  
  public Port[] getAllInPorts() {
    return FSMContent.<Port>concat(this.ctrl, this.inputs);
  }
  
  public int getPortsNumber() {
    if (((this.inputs == null) || (this.outputs == null))) {
      return 0;
    }
    int _length = this.ctrl.length;
    int _length_1 = this.inputs.length;
    int _plus = (_length + _length_1);
    int _length_2 = this.outputs.length;
    return (_plus + _length_2);
  }
  
  private boolean parseContent(final String content) {
    FSMSerializer parser = new FSMSerializer();
    try {
      String _string = content.toString();
      FSM _load = FSMSerializer.load(_string);
      this.fsm = ((FSM) _load);
      String _name = this.fsm.getName();
      this.name = _name;
      EList<com.cburch.logisim.statemachine.fSMDSL.Port> _in = this.fsm.getIn();
      List<InputPort> inputsDesc = ((List) _in);
      EList<com.cburch.logisim.statemachine.fSMDSL.Port> _out = this.fsm.getOut();
      List<OutputPort> outputsDesc = ((List) _out);
      Port[] _newArrayOfSize = new Port[3];
      this.ctrl = _newArrayOfSize;
      int _size = inputsDesc.size();
      Port[] _newArrayOfSize_1 = new Port[_size];
      this.inputs = _newArrayOfSize_1;
      int _size_1 = outputsDesc.size();
      Port[] _newArrayOfSize_2 = new Port[_size_1];
      this.outputs = _newArrayOfSize_2;
      Port _port = new Port(0, FSMEntity.HEIGHT, Port.INPUT, 1);
      this.ctrl[FSMContent.CLK] = _port;
      Port _port_1 = new Port(0, (FSMEntity.HEIGHT + FSMEntity.PORT_GAP), Port.INPUT, 1);
      this.ctrl[FSMContent.CLR] = _port_1;
      Port _port_2 = new Port(0, (FSMEntity.HEIGHT + (2 * FSMEntity.PORT_GAP)), Port.INPUT, 1);
      this.ctrl[FSMContent.EN] = _port_2;
      Port _get = this.ctrl[FSMContent.CLK];
      StringGetter _ter = Strings.getter("registerClkTip");
      _get.setToolTip(_ter);
      Port _get_1 = this.ctrl[FSMContent.CLR];
      StringGetter _ter_1 = Strings.getter("registerClrTip");
      _get_1.setToolTip(_ter_1);
      Port _get_2 = this.ctrl[FSMContent.EN];
      StringGetter _ter_2 = Strings.getter("registerEnableTip");
      _get_2.setToolTip(_ter_2);
      for (int i = 0; (i < inputsDesc.size()); i++) {
        {
          InputPort desc = inputsDesc.get(i);
          int _length = this.ctrl.length;
          int _plus = (i + _length);
          int _multiply = (_plus * FSMEntity.PORT_GAP);
          int _plus_1 = (_multiply + FSMEntity.HEIGHT);
          int _width = desc.getWidth();
          Port _port_3 = new Port(0, _plus_1, Port.INPUT, _width);
          this.inputs[i] = _port_3;
          Port _xblockexpression = null;
          {
            final int _rdIndx_inputs = i;
            _xblockexpression = this.inputs[_rdIndx_inputs];
          }
          String _name_1 = desc.getName();
          StringGetter _ter_3 = Strings.getter(_name_1);
          _xblockexpression.setToolTip(_ter_3);
          Port _xblockexpression_1 = null;
          {
            final int _rdIndx_inputs = i;
            _xblockexpression_1 = this.inputs[_rdIndx_inputs];
          }
          this.inMap.put(_xblockexpression_1, desc);
        }
      }
      for (int i = 0; (i < outputsDesc.size()); i++) {
        {
          OutputPort desc = outputsDesc.get(i);
          {
            final Port[] _wrVal_outputs = this.outputs;
            final int _wrIndx_outputs = i;
            int _length = this.ctrl.length;
            int _plus = (i + _length);
            int _multiply = (_plus * FSMEntity.PORT_GAP);
            int _plus_1 = (_multiply + FSMEntity.HEIGHT);
            int _width = desc.getWidth();
            Port _port_3 = new Port(FSMEntity.WIDTH, _plus_1, 
              Port.OUTPUT, _width);
            _wrVal_outputs[_wrIndx_outputs] = _port_3;
          }
          Port _xblockexpression = null;
          {
            final int _rdIndx_outputs = i;
            _xblockexpression = this.outputs[_rdIndx_outputs];
          }
          String _name_1 = desc.getName();
          StringGetter _ter_3 = Strings.getter(_name_1);
          _xblockexpression.setToolTip(_ter_3);
          Port _xblockexpression_1 = null;
          {
            final int _rdIndx_outputs = i;
            _xblockexpression_1 = this.outputs[_rdIndx_outputs];
          }
          this.outMap.put(_xblockexpression_1, desc);
        }
      }
      this.fireContentSet();
      return true;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ex.printStackTrace();
        String _message = ex.getMessage();
        String _get_3 = Strings.get("validationParseError");
        JOptionPane.showMessageDialog(null, _message, _get_3, 
          JOptionPane.ERROR_MESSAGE);
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public Port[] getControls() {
    return this.ctrl;
  }
}
