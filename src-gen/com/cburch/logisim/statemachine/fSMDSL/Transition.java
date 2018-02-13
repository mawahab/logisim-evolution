/**
 */
package com.cburch.logisim.statemachine.fSMDSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getDst <em>Dst</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getSrc <em>Src</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends FSMElement
{
  /**
   * Returns the value of the '<em><b>Dst</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dst</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dst</em>' reference.
   * @see #setDst(State)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getTransition_Dst()
   * @model
   * @generated
   */
  State getDst();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getDst <em>Dst</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dst</em>' reference.
   * @see #getDst()
   * @generated
   */
  void setDst(State value);

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
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getTransition_Predicate()
   * @model containment="true"
   * @generated
   */
  BoolExpr getPredicate();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(BoolExpr value);

  /**
   * Returns the value of the '<em><b>Src</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Src</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' reference.
   * @see #setSrc(State)
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getTransition_Src()
   * @model
   * @generated
   */
  State getSrc();

  /**
   * Sets the value of the '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getSrc <em>Src</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' reference.
   * @see #getSrc()
   * @generated
   */
  void setSrc(State value);

} // Transition
