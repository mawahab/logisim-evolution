/**
 */
package com.cburch.logisim.statemachine.fSMDSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Const Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.ConstRef#getConst <em>Const</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getConstRef()
 * @model
 * @generated
 */
public interface ConstRef extends BoolExpr
{
  /**
   * Returns the value of the '<em><b>Const</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Const</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const</em>' reference.
   * @see #setConst(ConstantDef)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getConstRef_Const()
   * @model
   * @generated
   */
  ConstantDef getConst();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.ConstRef#getConst <em>Const</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' reference.
   * @see #getConst()
   * @generated
   */
  void setConst(ConstantDef value);

} // ConstRef
