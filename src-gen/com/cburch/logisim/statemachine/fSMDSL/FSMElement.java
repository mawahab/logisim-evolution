/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.FSMElement#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getFSMElement()
 * @model
 * @generated
 */
public interface FSMElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layout</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout</em>' containment reference.
   * @see #setLayout(LayoutInfo)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getFSMElement_Layout()
   * @model containment="true"
   * @generated
   */
  LayoutInfo getLayout();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.FSMElement#getLayout <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layout</em>' containment reference.
   * @see #getLayout()
   * @generated
   */
  void setLayout(LayoutInfo value);

} // FSMElement
