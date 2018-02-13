/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage
 * @generated
 */
public interface FSMDSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FSMDSLFactory eINSTANCE = com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>TOP</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TOP</em>'.
   * @generated
   */
  TOP createTOP();

  /**
   * Returns a new object of class '<em>Command Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command Stmt</em>'.
   * @generated
   */
  CommandStmt createCommandStmt();

  /**
   * Returns a new object of class '<em>Constant Def List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Def List</em>'.
   * @generated
   */
  ConstantDefList createConstantDefList();

  /**
   * Returns a new object of class '<em>Predicate Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Predicate Stmt</em>'.
   * @generated
   */
  PredicateStmt createPredicateStmt();

  /**
   * Returns a new object of class '<em>FSM</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FSM</em>'.
   * @generated
   */
  FSM createFSM();

  /**
   * Returns a new object of class '<em>FSM Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FSM Element</em>'.
   * @generated
   */
  FSMElement createFSMElement();

  /**
   * Returns a new object of class '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port</em>'.
   * @generated
   */
  Port createPort();

  /**
   * Returns a new object of class '<em>Command List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command List</em>'.
   * @generated
   */
  CommandList createCommandList();

  /**
   * Returns a new object of class '<em>Layout Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Layout Info</em>'.
   * @generated
   */
  LayoutInfo createLayoutInfo();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition</em>'.
   * @generated
   */
  Transition createTransition();

  /**
   * Returns a new object of class '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command</em>'.
   * @generated
   */
  Command createCommand();

  /**
   * Returns a new object of class '<em>Bool Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Expr</em>'.
   * @generated
   */
  BoolExpr createBoolExpr();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Constant Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Def</em>'.
   * @generated
   */
  ConstantDef createConstantDef();

  /**
   * Returns a new object of class '<em>Input Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Port</em>'.
   * @generated
   */
  InputPort createInputPort();

  /**
   * Returns a new object of class '<em>Output Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Port</em>'.
   * @generated
   */
  OutputPort createOutputPort();

  /**
   * Returns a new object of class '<em>Concat Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concat Expr</em>'.
   * @generated
   */
  ConcatExpr createConcatExpr();

  /**
   * Returns a new object of class '<em>Port Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Ref</em>'.
   * @generated
   */
  PortRef createPortRef();

  /**
   * Returns a new object of class '<em>Const Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Const Ref</em>'.
   * @generated
   */
  ConstRef createConstRef();

  /**
   * Returns a new object of class '<em>Default Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Default Predicate</em>'.
   * @generated
   */
  DefaultPredicate createDefaultPredicate();

  /**
   * Returns a new object of class '<em>Or Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expr</em>'.
   * @generated
   */
  OrExpr createOrExpr();

  /**
   * Returns a new object of class '<em>And Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expr</em>'.
   * @generated
   */
  AndExpr createAndExpr();

  /**
   * Returns a new object of class '<em>Cmp Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cmp Expr</em>'.
   * @generated
   */
  CmpExpr createCmpExpr();

  /**
   * Returns a new object of class '<em>Not Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Expr</em>'.
   * @generated
   */
  NotExpr createNotExpr();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FSMDSLPackage getFSMDSLPackage();

} //FSMDSLFactory
