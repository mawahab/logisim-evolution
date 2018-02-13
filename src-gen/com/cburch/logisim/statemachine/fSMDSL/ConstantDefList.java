/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Def List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDefList#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getConstantDefList()
 * @model
 * @generated
 */
public interface ConstantDefList extends TOP
{
  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getConstantDefList_Constants()
   * @model containment="true"
   * @generated
   */
  EList<ConstantDef> getConstants();

} // ConstantDefList
