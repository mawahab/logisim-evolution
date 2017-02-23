/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PortRef;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl#getUb <em>Ub</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl#getLb <em>Lb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortRefImpl extends BoolExprImpl implements PortRef
{
  /**
   * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected Port port;

  /**
   * The default value of the '{@link #getUb() <em>Ub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUb()
   * @generated
   * @ordered
   */
  protected static final int UB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUb() <em>Ub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUb()
   * @generated
   * @ordered
   */
  protected int ub = UB_EDEFAULT;

  /**
   * The default value of the '{@link #getLb() <em>Lb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLb()
   * @generated
   * @ordered
   */
  protected static final int LB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLb() <em>Lb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLb()
   * @generated
   * @ordered
   */
  protected int lb = LB_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortRefImpl()
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
    return FSMDSLPackage.Literals.PORT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getPort()
  {
    if (port != null && port.eIsProxy())
    {
      InternalEObject oldPort = (InternalEObject)port;
      port = (Port)eResolveProxy(oldPort);
      if (port != oldPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMDSLPackage.PORT_REF__PORT, oldPort, port));
      }
    }
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort(Port newPort)
  {
    Port oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.PORT_REF__PORT, oldPort, port));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUb()
  {
    return ub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUb(int newUb)
  {
    int oldUb = ub;
    ub = newUb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.PORT_REF__UB, oldUb, ub));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLb()
  {
    return lb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLb(int newLb)
  {
    int oldLb = lb;
    lb = newLb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.PORT_REF__LB, oldLb, lb));
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
      case FSMDSLPackage.PORT_REF__PORT:
        if (resolve) return getPort();
        return basicGetPort();
      case FSMDSLPackage.PORT_REF__UB:
        return getUb();
      case FSMDSLPackage.PORT_REF__LB:
        return getLb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMDSLPackage.PORT_REF__PORT:
        setPort((Port)newValue);
        return;
      case FSMDSLPackage.PORT_REF__UB:
        setUb((Integer)newValue);
        return;
      case FSMDSLPackage.PORT_REF__LB:
        setLb((Integer)newValue);
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
      case FSMDSLPackage.PORT_REF__PORT:
        setPort((Port)null);
        return;
      case FSMDSLPackage.PORT_REF__UB:
        setUb(UB_EDEFAULT);
        return;
      case FSMDSLPackage.PORT_REF__LB:
        setLb(LB_EDEFAULT);
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
      case FSMDSLPackage.PORT_REF__PORT:
        return port != null;
      case FSMDSLPackage.PORT_REF__UB:
        return ub != UB_EDEFAULT;
      case FSMDSLPackage.PORT_REF__LB:
        return lb != LB_EDEFAULT;
    }
    return super.eIsSet(featureID);
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
    result.append(" (ub: ");
    result.append(ub);
    result.append(", lb: ");
    result.append(lb);
    result.append(')');
    return result.toString();
  }

} //PortRefImpl
