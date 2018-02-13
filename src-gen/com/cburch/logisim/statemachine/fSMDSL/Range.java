/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.Range#getUb <em>Ub</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.Range#getLb <em>Lb</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends EObject
{
  /**
   * Returns the value of the '<em><b>Ub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ub</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ub</em>' attribute.
   * @see #setUb(int)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getRange_Ub()
   * @model
   * @generated
   */
  int getUb();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.Range#getUb <em>Ub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ub</em>' attribute.
   * @see #getUb()
   * @generated
   */
  void setUb(int value);

  /**
   * Returns the value of the '<em><b>Lb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lb</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lb</em>' attribute.
   * @see #setLb(int)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getRange_Lb()
   * @model
   * @generated
   */
  int getLb();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.Range#getLb <em>Lb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lb</em>' attribute.
   * @see #getLb()
   * @generated
   */
  void setLb(int value);

} // Range
