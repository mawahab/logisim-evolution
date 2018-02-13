/**
 */
package com.cburch.logisim.statemachine.fSMDSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLFactory
 * @model kind="package"
 * @generated
 */
public interface FSMDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fSMDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cburch.com/logisim/statemachine/FSMDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fSMDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FSMDSLPackage eINSTANCE = com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.TOPImpl <em>TOP</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.TOPImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getTOP()
   * @generated
   */
  int TOP = 0;

  /**
   * The number of structural features of the '<em>TOP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl <em>Command Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommandStmt()
   * @generated
   */
  int COMMAND_STMT = 1;

  /**
   * The feature id for the '<em><b>Cst</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_STMT__CST = TOP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_STMT__IN = TOP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Out</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_STMT__OUT = TOP_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_STMT__COMMANDS = TOP_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Command Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_STMT_FEATURE_COUNT = TOP_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefListImpl <em>Constant Def List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefListImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstantDefList()
   * @generated
   */
  int CONSTANT_DEF_LIST = 2;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEF_LIST__CONSTANTS = TOP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant Def List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEF_LIST_FEATURE_COUNT = TOP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl <em>Predicate Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPredicateStmt()
   * @generated
   */
  int PREDICATE_STMT = 3;

  /**
   * The feature id for the '<em><b>Cst</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_STMT__CST = TOP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_STMT__IN = TOP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_STMT__PREDICATE = TOP_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Predicate Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_STMT_FEATURE_COUNT = TOP_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl <em>FSM</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getFSM()
   * @generated
   */
  int FSM = 4;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__LAYOUT = TOP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__NAME = TOP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__CONSTANTS = TOP_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__IN = TOP_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Out</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__OUT = TOP_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__WIDTH = TOP_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Start</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__START = TOP_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM__STATES = TOP_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>FSM</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_FEATURE_COUNT = TOP_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMElementImpl <em>FSM Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMElementImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getFSMElement()
   * @generated
   */
  int FSM_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_ELEMENT__LAYOUT = 0;

  /**
   * The number of structural features of the '<em>FSM Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.PortImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPort()
   * @generated
   */
  int PORT = 6;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__LAYOUT = FSM_ELEMENT__LAYOUT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = FSM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__WIDTH = FSM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = FSM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandListImpl <em>Command List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandListImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommandList()
   * @generated
   */
  int COMMAND_LIST = 7;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_LIST__LAYOUT = FSM_ELEMENT__LAYOUT;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_LIST__COMMANDS = FSM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Command List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_LIST_FEATURE_COUNT = FSM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.LayoutInfoImpl <em>Layout Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.LayoutInfoImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getLayoutInfo()
   * @generated
   */
  int LAYOUT_INFO = 8;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_INFO__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_INFO__Y = 1;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_INFO__WIDTH = 2;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_INFO__HEIGHT = 3;

  /**
   * The number of structural features of the '<em>Layout Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_INFO_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.StateImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getState()
   * @generated
   */
  int STATE = 9;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__LAYOUT = FSM_ELEMENT__LAYOUT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = FSM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__CODE = FSM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Command List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__COMMAND_LIST = FSM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__TRANSITION = FSM_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = FSM_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 10;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__LAYOUT = FSM_ELEMENT__LAYOUT;

  /**
   * The feature id for the '<em><b>Dst</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__DST = FSM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__PREDICATE = FSM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Src</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__SRC = FSM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = FSM_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__VALUE = 1;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.BoolExprImpl <em>Bool Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.BoolExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getBoolExpr()
   * @generated
   */
  int BOOL_EXPR = 12;

  /**
   * The number of structural features of the '<em>Bool Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.RangeImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getRange()
   * @generated
   */
  int RANGE = 13;

  /**
   * The feature id for the '<em><b>Ub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__UB = 0;

  /**
   * The feature id for the '<em><b>Lb</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__LB = 1;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefImpl <em>Constant Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstantDef()
   * @generated
   */
  int CONSTANT_DEF = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEF__VALUE = 1;

  /**
   * The number of structural features of the '<em>Constant Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.InputPortImpl <em>Input Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.InputPortImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getInputPort()
   * @generated
   */
  int INPUT_PORT = 15;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PORT__LAYOUT = PORT__LAYOUT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PORT__NAME = PORT__NAME;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PORT__WIDTH = PORT__WIDTH;

  /**
   * The number of structural features of the '<em>Input Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.OutputPortImpl <em>Output Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.OutputPortImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getOutputPort()
   * @generated
   */
  int OUTPUT_PORT = 16;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PORT__LAYOUT = PORT__LAYOUT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PORT__NAME = PORT__NAME;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PORT__WIDTH = PORT__WIDTH;

  /**
   * The number of structural features of the '<em>Output Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConcatExprImpl <em>Concat Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConcatExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConcatExpr()
   * @generated
   */
  int CONCAT_EXPR = 17;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCAT_EXPR__ARGS = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Concat Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCAT_EXPR_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl <em>Port Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPortRef()
   * @generated
   */
  int PORT_REF = 18;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF__PORT = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF__RANGE = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Port Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstRefImpl <em>Const Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstRefImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstRef()
   * @generated
   */
  int CONST_REF = 19;

  /**
   * The feature id for the '<em><b>Const</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_REF__CONST = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Const Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_REF_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.DefaultPredicateImpl <em>Default Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.DefaultPredicateImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getDefaultPredicate()
   * @generated
   */
  int DEFAULT_PREDICATE = 20;

  /**
   * The number of structural features of the '<em>Default Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_PREDICATE_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.OrExprImpl <em>Or Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.OrExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getOrExpr()
   * @generated
   */
  int OR_EXPR = 21;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__ARGS = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Or Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.AndExprImpl <em>And Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.AndExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getAndExpr()
   * @generated
   */
  int AND_EXPR = 22;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__ARGS = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CmpExprImpl <em>Cmp Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.CmpExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCmpExpr()
   * @generated
   */
  int CMP_EXPR = 23;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CMP_EXPR__ARGS = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CMP_EXPR__OP = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cmp Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CMP_EXPR_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.NotExprImpl <em>Not Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.NotExprImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getNotExpr()
   * @generated
   */
  int NOT_EXPR = 24;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPR__ARGS = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPR_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantImpl
   * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 25;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__VALUE = BOOL_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = BOOL_EXPR_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.TOP <em>TOP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TOP</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.TOP
   * @generated
   */
  EClass getTOP();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt <em>Command Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command Stmt</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt
   * @generated
   */
  EClass getCommandStmt();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCst <em>Cst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cst</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCst()
   * @see #getCommandStmt()
   * @generated
   */
  EReference getCommandStmt_Cst();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getIn()
   * @see #getCommandStmt()
   * @generated
   */
  EReference getCommandStmt_In();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Out</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getOut()
   * @see #getCommandStmt()
   * @generated
   */
  EReference getCommandStmt_Out();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt#getCommands()
   * @see #getCommandStmt()
   * @generated
   */
  EReference getCommandStmt_Commands();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDefList <em>Constant Def List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Def List</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDefList
   * @generated
   */
  EClass getConstantDefList();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDefList#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDefList#getConstants()
   * @see #getConstantDefList()
   * @generated
   */
  EReference getConstantDefList_Constants();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt <em>Predicate Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Predicate Stmt</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PredicateStmt
   * @generated
   */
  EClass getPredicateStmt();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getCst <em>Cst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cst</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getCst()
   * @see #getPredicateStmt()
   * @generated
   */
  EReference getPredicateStmt_Cst();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getIn()
   * @see #getPredicateStmt()
   * @generated
   */
  EReference getPredicateStmt_In();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PredicateStmt#getPredicate()
   * @see #getPredicateStmt()
   * @generated
   */
  EReference getPredicateStmt_Predicate();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.FSM <em>FSM</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>FSM</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM
   * @generated
   */
  EClass getFSM();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getName()
   * @see #getFSM()
   * @generated
   */
  EAttribute getFSM_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getConstants()
   * @see #getFSM()
   * @generated
   */
  EReference getFSM_Constants();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getIn()
   * @see #getFSM()
   * @generated
   */
  EReference getFSM_In();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Out</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getOut()
   * @see #getFSM()
   * @generated
   */
  EReference getFSM_Out();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getWidth()
   * @see #getFSM()
   * @generated
   */
  EAttribute getFSM_Width();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getStart <em>Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Start</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getStart()
   * @see #getFSM()
   * @generated
   */
  EReference getFSM_Start();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.FSM#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM#getStates()
   * @see #getFSM()
   * @generated
   */
  EReference getFSM_States();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.FSMElement <em>FSM Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>FSM Element</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMElement
   * @generated
   */
  EClass getFSMElement();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.FSMElement#getLayout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Layout</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMElement#getLayout()
   * @see #getFSMElement()
   * @generated
   */
  EReference getFSMElement_Layout();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.Port#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Port#getName()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Name();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.Port#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Port#getWidth()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Width();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.CommandList <em>Command List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command List</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandList
   * @generated
   */
  EClass getCommandList();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CommandList#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandList#getCommands()
   * @see #getCommandList()
   * @generated
   */
  EReference getCommandList_Commands();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo <em>Layout Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layout Info</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo
   * @generated
   */
  EClass getLayoutInfo();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getX()
   * @see #getLayoutInfo()
   * @generated
   */
  EAttribute getLayoutInfo_X();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getY()
   * @see #getLayoutInfo()
   * @generated
   */
  EAttribute getLayoutInfo_Y();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getWidth()
   * @see #getLayoutInfo()
   * @generated
   */
  EAttribute getLayoutInfo_Width();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo#getHeight()
   * @see #getLayoutInfo()
   * @generated
   */
  EAttribute getLayoutInfo_Height();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.State#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.State#getCode()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Code();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.State#getCommandList <em>Command List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Command List</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.State#getCommandList()
   * @see #getState()
   * @generated
   */
  EReference getState_CommandList();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.State#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.State#getTransition()
   * @see #getState()
   * @generated
   */
  EReference getState_Transition();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getDst <em>Dst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Dst</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Transition#getDst()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Dst();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Transition#getPredicate()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Predicate();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.Transition#getSrc <em>Src</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Src</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Transition#getSrc()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Src();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.Command#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Command#getName()
   * @see #getCommand()
   * @generated
   */
  EReference getCommand_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.Command#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Command#getValue()
   * @see #getCommand()
   * @generated
   */
  EReference getCommand_Value();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.BoolExpr <em>Bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.BoolExpr
   * @generated
   */
  EClass getBoolExpr();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.Range#getUb <em>Ub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ub</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Range#getUb()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_Ub();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.Range#getLb <em>Lb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lb</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Range#getLb()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_Lb();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef <em>Constant Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Def</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDef
   * @generated
   */
  EClass getConstantDef();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDef#getName()
   * @see #getConstantDef()
   * @generated
   */
  EAttribute getConstantDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDef#getValue()
   * @see #getConstantDef()
   * @generated
   */
  EReference getConstantDef_Value();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.InputPort <em>Input Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Port</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.InputPort
   * @generated
   */
  EClass getInputPort();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.OutputPort <em>Output Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Port</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.OutputPort
   * @generated
   */
  EClass getOutputPort();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.ConcatExpr <em>Concat Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concat Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConcatExpr
   * @generated
   */
  EClass getConcatExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.ConcatExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConcatExpr#getArgs()
   * @see #getConcatExpr()
   * @generated
   */
  EReference getConcatExpr_Args();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.PortRef <em>Port Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Ref</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PortRef
   * @generated
   */
  EClass getPortRef();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.PortRef#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PortRef#getPort()
   * @see #getPortRef()
   * @generated
   */
  EReference getPortRef_Port();

  /**
   * Returns the meta object for the containment reference '{@link com.cburch.logisim.statemachine.fSMDSL.PortRef#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.PortRef#getRange()
   * @see #getPortRef()
   * @generated
   */
  EReference getPortRef_Range();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstRef <em>Const Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Ref</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstRef
   * @generated
   */
  EClass getConstRef();

  /**
   * Returns the meta object for the reference '{@link com.cburch.logisim.statemachine.fSMDSL.ConstRef#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Const</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstRef#getConst()
   * @see #getConstRef()
   * @generated
   */
  EReference getConstRef_Const();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate <em>Default Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Default Predicate</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate
   * @generated
   */
  EClass getDefaultPredicate();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.OrExpr
   * @generated
   */
  EClass getOrExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.OrExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.OrExpr#getArgs()
   * @see #getOrExpr()
   * @generated
   */
  EReference getOrExpr_Args();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.AndExpr
   * @generated
   */
  EClass getAndExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.AndExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.AndExpr#getArgs()
   * @see #getAndExpr()
   * @generated
   */
  EReference getAndExpr_Args();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr <em>Cmp Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cmp Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CmpExpr
   * @generated
   */
  EClass getCmpExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getArgs()
   * @see #getCmpExpr()
   * @generated
   */
  EReference getCmpExpr_Args();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.CmpExpr#getOp()
   * @see #getCmpExpr()
   * @generated
   */
  EAttribute getCmpExpr_Op();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.NotExpr <em>Not Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expr</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.NotExpr
   * @generated
   */
  EClass getNotExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.cburch.logisim.statemachine.fSMDSL.NotExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.NotExpr#getArgs()
   * @see #getNotExpr()
   * @generated
   */
  EReference getNotExpr_Args();

  /**
   * Returns the meta object for class '{@link com.cburch.logisim.statemachine.fSMDSL.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the attribute '{@link com.cburch.logisim.statemachine.fSMDSL.Constant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.cburch.logisim.statemachine.fSMDSL.Constant#getValue()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FSMDSLFactory getFSMDSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.TOPImpl <em>TOP</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.TOPImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getTOP()
     * @generated
     */
    EClass TOP = eINSTANCE.getTOP();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl <em>Command Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommandStmt()
     * @generated
     */
    EClass COMMAND_STMT = eINSTANCE.getCommandStmt();

    /**
     * The meta object literal for the '<em><b>Cst</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_STMT__CST = eINSTANCE.getCommandStmt_Cst();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_STMT__IN = eINSTANCE.getCommandStmt_In();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_STMT__OUT = eINSTANCE.getCommandStmt_Out();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_STMT__COMMANDS = eINSTANCE.getCommandStmt_Commands();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefListImpl <em>Constant Def List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefListImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstantDefList()
     * @generated
     */
    EClass CONSTANT_DEF_LIST = eINSTANCE.getConstantDefList();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEF_LIST__CONSTANTS = eINSTANCE.getConstantDefList_Constants();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl <em>Predicate Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.PredicateStmtImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPredicateStmt()
     * @generated
     */
    EClass PREDICATE_STMT = eINSTANCE.getPredicateStmt();

    /**
     * The meta object literal for the '<em><b>Cst</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE_STMT__CST = eINSTANCE.getPredicateStmt_Cst();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE_STMT__IN = eINSTANCE.getPredicateStmt_In();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE_STMT__PREDICATE = eINSTANCE.getPredicateStmt_Predicate();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl <em>FSM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getFSM()
     * @generated
     */
    EClass FSM = eINSTANCE.getFSM();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FSM__NAME = eINSTANCE.getFSM_Name();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM__CONSTANTS = eINSTANCE.getFSM_Constants();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM__IN = eINSTANCE.getFSM_In();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM__OUT = eINSTANCE.getFSM_Out();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FSM__WIDTH = eINSTANCE.getFSM_Width();

    /**
     * The meta object literal for the '<em><b>Start</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM__START = eINSTANCE.getFSM_Start();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM__STATES = eINSTANCE.getFSM_States();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.FSMElementImpl <em>FSM Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMElementImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getFSMElement()
     * @generated
     */
    EClass FSM_ELEMENT = eINSTANCE.getFSMElement();

    /**
     * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM_ELEMENT__LAYOUT = eINSTANCE.getFSMElement_Layout();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.PortImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__NAME = eINSTANCE.getPort_Name();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__WIDTH = eINSTANCE.getPort_Width();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandListImpl <em>Command List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandListImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommandList()
     * @generated
     */
    EClass COMMAND_LIST = eINSTANCE.getCommandList();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND_LIST__COMMANDS = eINSTANCE.getCommandList_Commands();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.LayoutInfoImpl <em>Layout Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.LayoutInfoImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getLayoutInfo()
     * @generated
     */
    EClass LAYOUT_INFO = eINSTANCE.getLayoutInfo();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_INFO__X = eINSTANCE.getLayoutInfo_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_INFO__Y = eINSTANCE.getLayoutInfo_Y();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_INFO__WIDTH = eINSTANCE.getLayoutInfo_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LAYOUT_INFO__HEIGHT = eINSTANCE.getLayoutInfo_Height();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.StateImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__CODE = eINSTANCE.getState_Code();

    /**
     * The meta object literal for the '<em><b>Command List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__COMMAND_LIST = eINSTANCE.getState_CommandList();

    /**
     * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__TRANSITION = eINSTANCE.getState_Transition();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.TransitionImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Dst</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__DST = eINSTANCE.getTransition_Dst();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__PREDICATE = eINSTANCE.getTransition_Predicate();

    /**
     * The meta object literal for the '<em><b>Src</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__SRC = eINSTANCE.getTransition_Src();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.CommandImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND__NAME = eINSTANCE.getCommand_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMAND__VALUE = eINSTANCE.getCommand_Value();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.BoolExprImpl <em>Bool Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.BoolExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getBoolExpr()
     * @generated
     */
    EClass BOOL_EXPR = eINSTANCE.getBoolExpr();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.RangeImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '<em><b>Ub</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__UB = eINSTANCE.getRange_Ub();

    /**
     * The meta object literal for the '<em><b>Lb</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__LB = eINSTANCE.getRange_Lb();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefImpl <em>Constant Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantDefImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstantDef()
     * @generated
     */
    EClass CONSTANT_DEF = eINSTANCE.getConstantDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_DEF__NAME = eINSTANCE.getConstantDef_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEF__VALUE = eINSTANCE.getConstantDef_Value();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.InputPortImpl <em>Input Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.InputPortImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getInputPort()
     * @generated
     */
    EClass INPUT_PORT = eINSTANCE.getInputPort();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.OutputPortImpl <em>Output Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.OutputPortImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getOutputPort()
     * @generated
     */
    EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConcatExprImpl <em>Concat Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConcatExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConcatExpr()
     * @generated
     */
    EClass CONCAT_EXPR = eINSTANCE.getConcatExpr();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCAT_EXPR__ARGS = eINSTANCE.getConcatExpr_Args();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl <em>Port Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.PortRefImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getPortRef()
     * @generated
     */
    EClass PORT_REF = eINSTANCE.getPortRef();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_REF__PORT = eINSTANCE.getPortRef_Port();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_REF__RANGE = eINSTANCE.getPortRef_Range();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstRefImpl <em>Const Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstRefImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstRef()
     * @generated
     */
    EClass CONST_REF = eINSTANCE.getConstRef();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONST_REF__CONST = eINSTANCE.getConstRef_Const();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.DefaultPredicateImpl <em>Default Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.DefaultPredicateImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getDefaultPredicate()
     * @generated
     */
    EClass DEFAULT_PREDICATE = eINSTANCE.getDefaultPredicate();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.OrExprImpl <em>Or Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.OrExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getOrExpr()
     * @generated
     */
    EClass OR_EXPR = eINSTANCE.getOrExpr();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPR__ARGS = eINSTANCE.getOrExpr_Args();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.AndExprImpl <em>And Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.AndExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getAndExpr()
     * @generated
     */
    EClass AND_EXPR = eINSTANCE.getAndExpr();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPR__ARGS = eINSTANCE.getAndExpr_Args();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.CmpExprImpl <em>Cmp Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.CmpExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getCmpExpr()
     * @generated
     */
    EClass CMP_EXPR = eINSTANCE.getCmpExpr();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CMP_EXPR__ARGS = eINSTANCE.getCmpExpr_Args();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CMP_EXPR__OP = eINSTANCE.getCmpExpr_Op();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.NotExprImpl <em>Not Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.NotExprImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getNotExpr()
     * @generated
     */
    EClass NOT_EXPR = eINSTANCE.getNotExpr();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPR__ARGS = eINSTANCE.getNotExpr_Args();

    /**
     * The meta object literal for the '{@link com.cburch.logisim.statemachine.fSMDSL.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.ConstantImpl
     * @see com.cburch.logisim.statemachine.fSMDSL.impl.FSMDSLPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__VALUE = eINSTANCE.getConstant_Value();

  }

} //FSMDSLPackage
