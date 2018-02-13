/**
 */
package com.cburch.logisim.statemachine.fSMDSL.util;

import com.cburch.logisim.statemachine.fSMDSL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage
 * @generated
 */
public class FSMDSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FSMDSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMDSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FSMDSLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FSMDSLSwitch<Adapter> modelSwitch =
    new FSMDSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseTOP(TOP object)
      {
        return createTOPAdapter();
      }
      @Override
      public Adapter caseCommandStmt(CommandStmt object)
      {
        return createCommandStmtAdapter();
      }
      @Override
      public Adapter caseConstantDefList(ConstantDefList object)
      {
        return createConstantDefListAdapter();
      }
      @Override
      public Adapter casePredicateStmt(PredicateStmt object)
      {
        return createPredicateStmtAdapter();
      }
      @Override
      public Adapter caseFSM(FSM object)
      {
        return createFSMAdapter();
      }
      @Override
      public Adapter caseFSMElement(FSMElement object)
      {
        return createFSMElementAdapter();
      }
      @Override
      public Adapter casePort(Port object)
      {
        return createPortAdapter();
      }
      @Override
      public Adapter caseCommandList(CommandList object)
      {
        return createCommandListAdapter();
      }
      @Override
      public Adapter caseLayoutInfo(LayoutInfo object)
      {
        return createLayoutInfoAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter caseCommand(Command object)
      {
        return createCommandAdapter();
      }
      @Override
      public Adapter caseBoolExpr(BoolExpr object)
      {
        return createBoolExprAdapter();
      }
      @Override
      public Adapter caseRange(Range object)
      {
        return createRangeAdapter();
      }
      @Override
      public Adapter caseConstantDef(ConstantDef object)
      {
        return createConstantDefAdapter();
      }
      @Override
      public Adapter caseInputPort(InputPort object)
      {
        return createInputPortAdapter();
      }
      @Override
      public Adapter caseOutputPort(OutputPort object)
      {
        return createOutputPortAdapter();
      }
      @Override
      public Adapter caseConcatExpr(ConcatExpr object)
      {
        return createConcatExprAdapter();
      }
      @Override
      public Adapter casePortRef(PortRef object)
      {
        return createPortRefAdapter();
      }
      @Override
      public Adapter caseConstRef(ConstRef object)
      {
        return createConstRefAdapter();
      }
      @Override
      public Adapter caseDefaultPredicate(DefaultPredicate object)
      {
        return createDefaultPredicateAdapter();
      }
      @Override
      public Adapter caseOrExpr(OrExpr object)
      {
        return createOrExprAdapter();
      }
      @Override
      public Adapter caseAndExpr(AndExpr object)
      {
        return createAndExprAdapter();
      }
      @Override
      public Adapter caseCmpExpr(CmpExpr object)
      {
        return createCmpExprAdapter();
      }
      @Override
      public Adapter caseNotExpr(NotExpr object)
      {
        return createNotExprAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.TOP <em>TOP</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.TOP
   * @generated
   */
  public Adapter createTOPAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.CommandStmt <em>Command Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandStmt
   * @generated
   */
  public Adapter createCommandStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDefList <em>Constant Def List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDefList
   * @generated
   */
  public Adapter createConstantDefListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.PredicateStmt <em>Predicate Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.PredicateStmt
   * @generated
   */
  public Adapter createPredicateStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.FSM <em>FSM</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSM
   * @generated
   */
  public Adapter createFSMAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.FSMElement <em>FSM Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.FSMElement
   * @generated
   */
  public Adapter createFSMElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.Port
   * @generated
   */
  public Adapter createPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.CommandList <em>Command List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.CommandList
   * @generated
   */
  public Adapter createCommandListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.LayoutInfo <em>Layout Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.LayoutInfo
   * @generated
   */
  public Adapter createLayoutInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.Command
   * @generated
   */
  public Adapter createCommandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.BoolExpr <em>Bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.BoolExpr
   * @generated
   */
  public Adapter createBoolExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.Range
   * @generated
   */
  public Adapter createRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstantDef <em>Constant Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstantDef
   * @generated
   */
  public Adapter createConstantDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.InputPort <em>Input Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.InputPort
   * @generated
   */
  public Adapter createInputPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.OutputPort <em>Output Port</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.OutputPort
   * @generated
   */
  public Adapter createOutputPortAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.ConcatExpr <em>Concat Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConcatExpr
   * @generated
   */
  public Adapter createConcatExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.PortRef <em>Port Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.PortRef
   * @generated
   */
  public Adapter createPortRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.ConstRef <em>Const Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.ConstRef
   * @generated
   */
  public Adapter createConstRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate <em>Default Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.DefaultPredicate
   * @generated
   */
  public Adapter createDefaultPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.OrExpr
   * @generated
   */
  public Adapter createOrExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.AndExpr
   * @generated
   */
  public Adapter createAndExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.CmpExpr <em>Cmp Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.CmpExpr
   * @generated
   */
  public Adapter createCmpExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.NotExpr <em>Not Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.NotExpr
   * @generated
   */
  public Adapter createNotExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.cburch.logisim.statemachine.fSMDSL.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.cburch.logisim.statemachine.fSMDSL.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //FSMDSLAdapterFactory
