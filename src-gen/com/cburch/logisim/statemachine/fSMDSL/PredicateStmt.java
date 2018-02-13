/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getCst <em>Cst</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getIn <em>In</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getPredicate <em>Predicate</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getPredicateStmt()
 * @model
 * @generated
 */
public interface PredicateStmt extends TOP
{
  /**
   * Returns the value of the '<em><b>Cst</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cst</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cst</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getPredicateStmt_Cst()
   * @model containment="true"
   * @generated
   */
  EList<ConstantDef> getCst();

  /**
   * Returns the value of the '<em><b>In</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getPredicateStmt_In()
   * @model containment="true"
   * @generated
   */
  EList<Port> getIn();

  /**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference.
   * @see #setPredicate(BoolExpr)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getPredicateStmt_Predicate()
   * @model containment="true"
   * @generated
   */
  BoolExpr getPredicate();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(BoolExpr value);

} // PredicateStmt
