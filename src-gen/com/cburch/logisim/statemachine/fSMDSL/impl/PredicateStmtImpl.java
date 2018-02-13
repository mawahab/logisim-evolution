/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.BoolExpr;
import com.cburch.logisim.statemachine.fSMDSL.ConstantDef;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.cburch.logisim.statemachine.fSMDSL.PredicateStmt;

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
 * An implementation of the model object '<em><b>Predicate Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl#getCst <em>Cst</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl#getIn <em>In</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl#getPredicate <em>Predicate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateStmtImpl extends TOPImpl implements PredicateStmt
{
  /**
   * The cached value of the '{@link #getCst() <em>Cst</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCst()
   * @generated
   * @ordered
   */
  protected EList<ConstantDef> cst;

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
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected BoolExpr predicate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredicateStmtImpl()
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
    return FSMDSLPackage.Literals.PREDICATE_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstantDef> getCst()
  {
    if (cst == null)
    {
      cst = new EObjectContainmentEList<ConstantDef>(ConstantDef.class, this, FSMDSLPackage.PREDICATE_STMT__CST);
    }
    return cst;
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
      in = new EObjectContainmentEList<Port>(Port.class, this, FSMDSLPackage.PREDICATE_STMT__IN);
    }
    return in;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMDSLPackage.PREDICATE_STMT__PREDICATE, oldPredicate, newPredicate);
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
        msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.PREDICATE_STMT__PREDICATE, null, msgs);
      if (newPredicate != null)
        msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMDSLPackage.PREDICATE_STMT__PREDICATE, null, msgs);
      msgs = basicSetPredicate(newPredicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMDSLPackage.PREDICATE_STMT__PREDICATE, newPredicate, newPredicate));
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
      case FSMDSLPackage.PREDICATE_STMT__CST:
        return ((InternalEList<?>)getCst()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.PREDICATE_STMT__IN:
        return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.PREDICATE_STMT__PREDICATE:
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
      case FSMDSLPackage.PREDICATE_STMT__CST:
        return getCst();
      case FSMDSLPackage.PREDICATE_STMT__IN:
        return getIn();
      case FSMDSLPackage.PREDICATE_STMT__PREDICATE:
        return getPredicate();
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
      case FSMDSLPackage.PREDICATE_STMT__CST:
        getCst().clear();
        getCst().addAll((Collection<? extends ConstantDef>)newValue);
        return;
      case FSMDSLPackage.PREDICATE_STMT__IN:
        getIn().clear();
        getIn().addAll((Collection<? extends Port>)newValue);
        return;
      case FSMDSLPackage.PREDICATE_STMT__PREDICATE:
        setPredicate((BoolExpr)newValue);
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
      case FSMDSLPackage.PREDICATE_STMT__CST:
        getCst().clear();
        return;
      case FSMDSLPackage.PREDICATE_STMT__IN:
        getIn().clear();
        return;
      case FSMDSLPackage.PREDICATE_STMT__PREDICATE:
        setPredicate((BoolExpr)null);
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
      case FSMDSLPackage.PREDICATE_STMT__CST:
        return cst != null && !cst.isEmpty();
      case FSMDSLPackage.PREDICATE_STMT__IN:
        return in != null && !in.isEmpty();
      case FSMDSLPackage.PREDICATE_STMT__PREDICATE:
        return predicate != null;
    }
    return super.eIsSet(featureID);
  }

} //PredicateStmtImpl
