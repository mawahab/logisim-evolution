/**
 */
package com.cburch.logisim.statemachine.fSMDSL.util;

import com.cburch.logisim.statemachine.fSMDSL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage
 * @generated
 */
public class FSMDSLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FSMDSLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMDSLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = FSMDSLPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case FSMDSLPackage.TOP:
      {
        TOP top = (TOP)theEObject;
        T result = caseTOP(top);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.COMMAND_STMT:
      {
        CommandStmt commandStmt = (CommandStmt)theEObject;
        T result = caseCommandStmt(commandStmt);
        if (result == null) result = caseTOP(commandStmt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CONSTANT_DEF_LIST:
      {
        ConstantDefList constantDefList = (ConstantDefList)theEObject;
        T result = caseConstantDefList(constantDefList);
        if (result == null) result = caseTOP(constantDefList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.PREDICATE_STMT:
      {
        PredicateStmt predicateStmt = (PredicateStmt)theEObject;
        T result = casePredicateStmt(predicateStmt);
        if (result == null) result = caseTOP(predicateStmt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.FSM:
      {
        FSM fsm = (FSM)theEObject;
        T result = caseFSM(fsm);
        if (result == null) result = caseTOP(fsm);
        if (result == null) result = caseFSMElement(fsm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.FSM_ELEMENT:
      {
        FSMElement fsmElement = (FSMElement)theEObject;
        T result = caseFSMElement(fsmElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.PORT:
      {
        Port port = (Port)theEObject;
        T result = casePort(port);
        if (result == null) result = caseFSMElement(port);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.COMMAND_LIST:
      {
        CommandList commandList = (CommandList)theEObject;
        T result = caseCommandList(commandList);
        if (result == null) result = caseFSMElement(commandList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.LAYOUT_INFO:
      {
        LayoutInfo layoutInfo = (LayoutInfo)theEObject;
        T result = caseLayoutInfo(layoutInfo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.STATE:
      {
        State state = (State)theEObject;
        T result = caseState(state);
        if (result == null) result = caseFSMElement(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.TRANSITION:
      {
        Transition transition = (Transition)theEObject;
        T result = caseTransition(transition);
        if (result == null) result = caseFSMElement(transition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.COMMAND:
      {
        Command command = (Command)theEObject;
        T result = caseCommand(command);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.BOOL_EXPR:
      {
        BoolExpr boolExpr = (BoolExpr)theEObject;
        T result = caseBoolExpr(boolExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CONSTANT_DEF:
      {
        ConstantDef constantDef = (ConstantDef)theEObject;
        T result = caseConstantDef(constantDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.INPUT_PORT:
      {
        InputPort inputPort = (InputPort)theEObject;
        T result = caseInputPort(inputPort);
        if (result == null) result = casePort(inputPort);
        if (result == null) result = caseFSMElement(inputPort);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.OUTPUT_PORT:
      {
        OutputPort outputPort = (OutputPort)theEObject;
        T result = caseOutputPort(outputPort);
        if (result == null) result = casePort(outputPort);
        if (result == null) result = caseFSMElement(outputPort);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CONCAT_EXPR:
      {
        ConcatExpr concatExpr = (ConcatExpr)theEObject;
        T result = caseConcatExpr(concatExpr);
        if (result == null) result = caseBoolExpr(concatExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.PORT_REF:
      {
        PortRef portRef = (PortRef)theEObject;
        T result = casePortRef(portRef);
        if (result == null) result = caseBoolExpr(portRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CONST_REF:
      {
        ConstRef constRef = (ConstRef)theEObject;
        T result = caseConstRef(constRef);
        if (result == null) result = caseBoolExpr(constRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.DEFAULT_PREDICATE:
      {
        DefaultPredicate defaultPredicate = (DefaultPredicate)theEObject;
        T result = caseDefaultPredicate(defaultPredicate);
        if (result == null) result = caseBoolExpr(defaultPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.OR_EXPR:
      {
        OrExpr orExpr = (OrExpr)theEObject;
        T result = caseOrExpr(orExpr);
        if (result == null) result = caseBoolExpr(orExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.AND_EXPR:
      {
        AndExpr andExpr = (AndExpr)theEObject;
        T result = caseAndExpr(andExpr);
        if (result == null) result = caseBoolExpr(andExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CMP_EXPR:
      {
        CmpExpr cmpExpr = (CmpExpr)theEObject;
        T result = caseCmpExpr(cmpExpr);
        if (result == null) result = caseBoolExpr(cmpExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.NOT_EXPR:
      {
        NotExpr notExpr = (NotExpr)theEObject;
        T result = caseNotExpr(notExpr);
        if (result == null) result = caseBoolExpr(notExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMDSLPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = caseBoolExpr(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TOP</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TOP</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTOP(TOP object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command Stmt</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command Stmt</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandStmt(CommandStmt object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Def List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Def List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantDefList(ConstantDefList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Predicate Stmt</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Predicate Stmt</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePredicateStmt(PredicateStmt object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>FSM</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>FSM</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFSM(FSM object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>FSM Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>FSM Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFSMElement(FSMElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePort(Port object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommandList(CommandList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layout Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layout Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayoutInfo(LayoutInfo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseState(State object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransition(Transition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommand(Command object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolExpr(BoolExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantDef(ConstantDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputPort(InputPort object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputPort(OutputPort object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concat Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concat Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcatExpr(ConcatExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortRef(PortRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Const Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Const Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstRef(ConstRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Default Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Default Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefaultPredicate(DefaultPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpr(OrExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpr(AndExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cmp Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cmp Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCmpExpr(CmpExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotExpr(NotExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //FSMDSLSwitch
