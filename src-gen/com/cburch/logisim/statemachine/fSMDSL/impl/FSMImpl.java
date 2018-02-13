/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.ConstantDef;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.FSMElement;
import com.cburch.logisim.statemachine.fSMDSL.LayoutInfo;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getIn <em>In</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getOut <em>Out</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getStart <em>Start</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMImpl extends TOPImpl implements FSM
{
  /**
   * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayout()
   * @generated
   * @ordered
   */
  protected LayoutInfo layout;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<ConstantDef> constants;

  /**
   * The cached value of the '{@link #getIn() <em>In</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIn()
   * @generated
   * @ordered
   */
  protected EList<Port> in;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected EList<Port> out;

  /**
   * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected static final int WIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected int width = WIDTH_EDEFAULT;

  /**
   * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStart()
   * @generated
   * @ordered
   */
  protected State start;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FSMImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FSMDSLPackage.Literals.FSM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutInfo getLayout()
  {
    return layout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLayout(LayoutInfo newLayout, NotificationChain msgs)
  {
    LayoutInfo oldLayout = layout;
    layout = newLayout;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMDSLPackage.FSM__LAYOUT, oldLayout, newLayout);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLayout(LayoutInfo newLayout)
  {
    if (newLayout != layout)
    {
      NotificationChain msgs = null;
      if (layout != null)
        msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.FSM__LAYOUT, null, msgs);
      if (newLayout != null)
        msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.FSM__LAYOUT, null, msgs);
      msgs = basicSetLayout(newLayout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.FSM__LAYOUT, newLayout, newLayout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.FSM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstantDef> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ConstantDef>(ConstantDef.class, this, FSMDSLPackage.FSM__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getIn()
  {
    if (in == null)
    {
      in = new EObjectContainmentEList<Port>(Port.class, this, FSMDSLPackage.FSM__IN);
    }
    return in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getOut()
  {
    if (out == null)
    {
      out = new EObjectContainmentEList<Port>(Port.class, this, FSMDSLPackage.FSM__OUT);
    }
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWidth()
  {
    return width;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidth(int newWidth)
  {
    int oldWidth = width;
    width = newWidth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.FSM__WIDTH, oldWidth, width));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getStart()
  {
    if (start != null && start.eIsProxy())
    {
      InternalEObject oldStart = (InternalEObject)start;
      start = (State)eResolveProxy(oldStart);
      if (start != oldStart)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMDSLPackage.FSM__START, oldStart, start));
      }
    }
    return start;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetStart()
  {
    return start;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStart(State newStart)
  {
    State oldStart = start;
    start = newStart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.FSM__START, oldStart, start));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, FSMDSLPackage.FSM__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FSMDSLPackage.FSM__LAYOUT:
        return basicSetLayout(null, msgs);
      case FSMDSLPackage.FSM__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.FSM__IN:
        return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.FSM__OUT:
        return ((InternalEList<?>)getOut()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.FSM__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FSMDSLPackage.FSM__LAYOUT:
        return getLayout();
      case FSMDSLPackage.FSM__NAME:
        return getName();
      case FSMDSLPackage.FSM__CONSTANTS:
        return getConstants();
      case FSMDSLPackage.FSM__IN:
        return getIn();
      case FSMDSLPackage.FSM__OUT:
        return getOut();
      case FSMDSLPackage.FSM__WIDTH:
        return getWidth();
      case FSMDSLPackage.FSM__START:
        if (resolve) return getStart();
        return basicGetStart();
      case FSMDSLPackage.FSM__STATES:
        return getStates();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMDSLPackage.FSM__LAYOUT:
        setLayout((LayoutInfo)newValue);
        return;
      case FSMDSLPackage.FSM__NAME:
        setName((String)newValue);
        return;
      case FSMDSLPackage.FSM__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ConstantDef>)newValue);
        return;
      case FSMDSLPackage.FSM__IN:
        getIn().clear();
        getIn().addAll((Collection<? extends Port>)newValue);
        return;
      case FSMDSLPackage.FSM__OUT:
        getOut().clear();
        getOut().addAll((Collection<? extends Port>)newValue);
        return;
      case FSMDSLPackage.FSM__WIDTH:
        setWidth((Integer)newValue);
        return;
      case FSMDSLPackage.FSM__START:
        setStart((State)newValue);
        return;
      case FSMDSLPackage.FSM__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FSMDSLPackage.FSM__LAYOUT:
        setLayout((LayoutInfo)null);
        return;
      case FSMDSLPackage.FSM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FSMDSLPackage.FSM__CONSTANTS:
        getConstants().clear();
        return;
      case FSMDSLPackage.FSM__IN:
        getIn().clear();
        return;
      case FSMDSLPackage.FSM__OUT:
        getOut().clear();
        return;
      case FSMDSLPackage.FSM__WIDTH:
        setWidth(WIDTH_EDEFAULT);
        return;
      case FSMDSLPackage.FSM__START:
        setStart((State)null);
        return;
      case FSMDSLPackage.FSM__STATES:
        getStates().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FSMDSLPackage.FSM__LAYOUT:
        return layout != null;
      case FSMDSLPackage.FSM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FSMDSLPackage.FSM__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case FSMDSLPackage.FSM__IN:
        return in != null && !in.isEmpty();
      case FSMDSLPackage.FSM__OUT:
        return out != null && !out.isEmpty();
      case FSMDSLPackage.FSM__WIDTH:
        return width != WIDTH_EDEFAULT;
      case FSMDSLPackage.FSM__START:
        return start != null;
      case FSMDSLPackage.FSM__STATES:
        return states != null && !states.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == FSMElement.class)
    {
      switch (derivedFeatureID)
      {
        case FSMDSLPackage.FSM__LAYOUT: return FSMDSLPackage.FSM_ELEMENT__LAYOUT;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == FSMElement.class)
    {
      switch (baseFeatureID)
      {
        case FSMDSLPackage.FSM_ELEMENT__LAYOUT: return FSMDSLPackage.FSM__LAYOUT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", width: ");
    result.append(width);
    result.append(')');
    return result.toString();
  }

} //FSMImpl
