/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cmp Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getArgs <em>Args</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCmpExpr()
 * @model
 * @generated
 */
public interface CmpExpr extends BoolExpr
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.BoolExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCmpExpr_Args()
   * @model containment="true"
   * @generated
   */
  EList<BoolExpr> getArgs();

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCmpExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

} // CmpExpr
