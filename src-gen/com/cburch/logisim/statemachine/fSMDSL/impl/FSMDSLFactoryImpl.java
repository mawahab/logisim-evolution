/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FSMDSLFactoryImpl extends EFactoryImpl implements FSMDSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FSMDSLFactory init()
  {
    try
    {
      FSMDSLFactory theFSMDSLFactory = (FSMDSLFactory)EPackage.Registry.INSTANCE.getEFactory(FSMDSLPackage.eNS_URI);
      if (theFSMDSLFactory != null)
      {
        return theFSMDSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FSMDSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMDSLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case FSMDSLPackage.TOP: return createTOP();
      case FSMDSLPackage.COMMAND_STMT: return createCommandStmt();
      case FSMDSLPackage.PREDICATE_STMT: return createPredicateStmt();
      case FSMDSLPackage.SHORT_INPUT: return createShortInput();
      case FSMDSLPackage.SHORT_OUTPUT: return createShortOutput();
      case FSMDSLPackage.FSM: return createFSM();
      case FSMDSLPackage.FSM_ELEMENT: return createFSMElement();
      case FSMDSLPackage.PORT: return createPort();
      case FSMDSLPackage.COMMAND_LIST: return createCommandList();
      case FSMDSLPackage.LAYOUT_INFO: return createLayoutInfo();
      case FSMDSLPackage.STATE: return createState();
      case FSMDSLPackage.TRANSITION: return createTransition();
      case FSMDSLPackage.COMMAND: return createCommand();
      case FSMDSLPackage.BOOL_EXPR: return createBoolExpr();
      case FSMDSLPackage.RANGE: return createRange();
      case FSMDSLPackage.INPUT_PORT: return createInputPort();
      case FSMDSLPackage.OUTPUT_PORT: return createOutputPort();
      case FSMDSLPackage.PORT_REF: return createPortRef();
      case FSMDSLPackage.DEFAULT_PREDICATE: return createDefaultPredicate();
      case FSMDSLPackage.OR_EXPR: return createOrExpr();
      case FSMDSLPackage.AND_EXPR: return createAndExpr();
      case FSMDSLPackage.CMP_EXPR: return createCmpExpr();
      case FSMDSLPackage.NOT_EXPR: return createNotExpr();
      case FSMDSLPackage.CONSTANT: return createConstant();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TOP createTOP()
  {
    TOPImpl top = new TOPImpl();
    return top;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandStmt createCommandStmt()
  {
    CommandStmtImpl commandStmt = new CommandStmtImpl();
    return commandStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PredicateStmt createPredicateStmt()
  {
    PredicateStmtImpl predicateStmt = new PredicateStmtImpl();
    return predicateStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShortInput createShortInput()
  {
    ShortInputImpl shortInput = new ShortInputImpl();
    return shortInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShortOutput createShortOutput()
  {
    ShortOutputImpl shortOutput = new ShortOutputImpl();
    return shortOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSM createFSM()
  {
    FSMImpl fsm = new FSMImpl();
    return fsm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMElement createFSMElement()
  {
    FSMElementImpl fsmElement = new FSMElementImpl();
    return fsmElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port createPort()
  {
    PortImpl port = new PortImpl();
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommandList createCommandList()
  {
    CommandListImpl commandList = new CommandListImpl();
    return commandList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutInfo createLayoutInfo()
  {
    LayoutInfoImpl layoutInfo = new LayoutInfoImpl();
    return layoutInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Command createCommand()
  {
    CommandImpl command = new CommandImpl();
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpr createBoolExpr()
  {
    BoolExprImpl boolExpr = new BoolExprImpl();
    return boolExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputPort createInputPort()
  {
    InputPortImpl inputPort = new InputPortImpl();
    return inputPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputPort createOutputPort()
  {
    OutputPortImpl outputPort = new OutputPortImpl();
    return outputPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortRef createPortRef()
  {
    PortRefImpl portRef = new PortRefImpl();
    return portRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefaultPredicate createDefaultPredicate()
  {
    DefaultPredicateImpl defaultPredicate = new DefaultPredicateImpl();
    return defaultPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpr createOrExpr()
  {
    OrExprImpl orExpr = new OrExprImpl();
    return orExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpr createAndExpr()
  {
    AndExprImpl andExpr = new AndExprImpl();
    return andExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CmpExpr createCmpExpr()
  {
    CmpExprImpl cmpExpr = new CmpExprImpl();
    return cmpExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotExpr createNotExpr()
  {
    NotExprImpl notExpr = new NotExprImpl();
    return notExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMDSLPackage getFSMDSLPackage()
  {
    return (FSMDSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FSMDSLPackage getPackage()
  {
    return FSMDSLPackage.eINSTANCE;
  }

} //FSMDSLFactoryImpl
