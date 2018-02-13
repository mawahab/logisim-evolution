/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.State;
import com.cburch.logisim.statemachine.fSMDSL.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl#getDst <em>Dst</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl#getSrc <em>Src</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends FSMElementImpl implements Transition
{
  /**
   * The cached value of the '{@link #getDst() <em>Dst</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDst()
   * @generated
   * @ordered
   */
  protected State dst;

  /**
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected BoolExpr predicate;

  /**
   * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrc()
   * @generated
   * @ordered
   */
  protected State src;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl()
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
    return FSMDSLPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getDst()
  {
    if (dst != null && dst.eIsProxy())
    {
      InternalEObject oldDst = (InternalEObject)dst;
      dst = (State)eResolveProxy(oldDst);
      if (dst != oldDst)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMDSLPackage.TRANSITION__DST, oldDst, dst));
      }
    }
    return dst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetDst()
  {
    return dst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDst(State newDst)
  {
    State oldDst = dst;
    dst = newDst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.TRANSITION__DST, oldDst, dst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpr getPredicate()
  {
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPredicate(BoolExpr newPredicate, NotificationChain msgs)
  {
    BoolExpr oldPredicate = predicate;
    predicate = newPredicate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMDSLPackage.TRANSITION__PREDICATE, oldPredicate, newPredicate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPredicate(BoolExpr newPredicate)
  {
    if (newPredicate != predicate)
    {
      NotificationChain msgs = null;
      if (predicate != null)
        msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.TRANSITION__PREDICATE, null, msgs);
      if (newPredicate != null)
        msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.TRANSITION__PREDICATE, null, msgs);
      msgs = basicSetPredicate(newPredicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.TRANSITION__PREDICATE, newPredicate, newPredicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State getSrc()
  {
    if (src != null && src.eIsProxy())
    {
      InternalEObject oldSrc = (InternalEObject)src;
      src = (State)eResolveProxy(oldSrc);
      if (src != oldSrc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMDSLPackage.TRANSITION__SRC, oldSrc, src));
      }
    }
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetSrc()
  {
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSrc(State newSrc)
  {
    State oldSrc = src;
    src = newSrc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.TRANSITION__SRC, oldSrc, src));
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
      case FSMDSLPackage.TRANSITION__PREDICATE:
        return basicSetPredicate(null, msgs);
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
      case FSMDSLPackage.TRANSITION__DST:
        if (resolve) return getDst();
        return basicGetDst();
      case FSMDSLPackage.TRANSITION__PREDICATE:
        return getPredicate();
      case FSMDSLPackage.TRANSITION__SRC:
        if (resolve) return getSrc();
        return basicGetSrc();
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
      case FSMDSLPackage.TRANSITION__DST:
        setDst((State)newValue);
        return;
      case FSMDSLPackage.TRANSITION__PREDICATE:
        setPredicate((BoolExpr)newValue);
        return;
      case FSMDSLPackage.TRANSITION__SRC:
        setSrc((State)newValue);
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
      case FSMDSLPackage.TRANSITION__DST:
        setDst((State)null);
        return;
      case FSMDSLPackage.TRANSITION__PREDICATE:
        setPredicate((BoolExpr)null);
        return;
      case FSMDSLPackage.TRANSITION__SRC:
        setSrc((State)null);
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
      case FSMDSLPackage.TRANSITION__DST:
        return dst != null;
      case FSMDSLPackage.TRANSITION__PREDICATE:
        return predicate != null;
      case FSMDSLPackage.TRANSITION__SRC:
        return src != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionImpl
