/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCst <em>Cst</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getIn <em>In</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getOut <em>Out</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCommandStmt()
 * @model
 * @generated
 */
public interface CommandStmt extends TOP
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
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCommandStmt_Cst()
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
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCommandStmt_In()
   * @model containment="true"
   * @generated
   */
  EList<Port> getIn();

  /**
   * Returns the value of the '<em><b>Out</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCommandStmt_Out()
   * @model containment="true"
   * @generated
   */
  EList<Port> getOut();

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link com.cburch.logisim.statemachine.fSMDSL.Command}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage#getCommandStmt_Commands()
   * @model containment="true"
   * @generated
   */
  EList<Command> getCommands();

} // CommandStmt
