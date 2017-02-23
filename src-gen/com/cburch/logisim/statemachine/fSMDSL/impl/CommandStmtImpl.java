/**
 */
package com.cburch.logisim.statemachine.fSMDSL.impl;

import com.cburch.logisim.statemachine.fSMDSL.Command;
import com.cburch.logisim.statemachine.fSMDSL.CommandStmt;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.ShortInput;
import com.cburch.logisim.statemachine.fSMDSL.ShortOutput;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl#getIn <em>In</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl#getOut <em>Out</em>}</li>
 *   <li>{@link com.cburch.logisim.statemachine.fSMDSL.impl.CommandStmtImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandStmtImpl extends TOPImpl implements CommandStmt
{
  /**
   * The cached value of the '{@link #getIn() <em>In</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIn()
   * @generated
   * @ordered
   */
  protected EList<ShortInput> in;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected EList<ShortOutput> out;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected EList<Command> commands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandStmtImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FSMDSLPackage.Literals.COMMAND_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ShortInput> getIn()
  {
    if (in == null)
    {
      in = new EObjectContainmentEList<ShortInput>(ShortInput.class, this, FSMDSLPackage.COMMAND_STMT__IN);
    }
    return in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ShortOutput> getOut()
  {
    if (out == null)
    {
      out = new EObjectContainmentEList<ShortOutput>(ShortOutput.class, this, FSMDSLPackage.COMMAND_STMT__OUT);
    }
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Command> getCommands()
  {
    if (commands == null)
    {
      commands = new EObjectContainmentEList<Command>(Command.class, this, FSMDSLPackage.COMMAND_STMT__COMMANDS);
    }
    return commands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FSMDSLPackage.COMMAND_STMT__IN:
        return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.COMMAND_STMT__OUT:
        return ((InternalEList<?>)getOut()).basicRemove(otherEnd, msgs);
      case FSMDSLPackage.COMMAND_STMT__COMMANDS:
        return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FSMDSLPackage.COMMAND_STMT__IN:
        return getIn();
      case FSMDSLPackage.COMMAND_STMT__OUT:
        return getOut();
      case FSMDSLPackage.COMMAND_STMT__COMMANDS:
        return getCommands();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMDSLPackage.COMMAND_STMT__IN:
        getIn().clear();
        getIn().addAll((Collection<? extends ShortInput>)newValue);
        return;
      case FSMDSLPackage.COMMAND_STMT__OUT:
        getOut().clear();
        getOut().addAll((Collection<? extends ShortOutput>)newValue);
        return;
      case FSMDSLPackage.COMMAND_STMT__COMMANDS:
        getCommands().clear();
        getCommands().addAll((Collection<? extends Command>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FSMDSLPackage.COMMAND_STMT__IN:
        getIn().clear();
        return;
      case FSMDSLPackage.COMMAND_STMT__OUT:
        getOut().clear();
        return;
      case FSMDSLPackage.COMMAND_STMT__COMMANDS:
        getCommands().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FSMDSLPackage.COMMAND_STMT__IN:
        return in != null && !in.isEmpty();
      case FSMDSLPackage.COMMAND_STMT__OUT:
        return out != null && !out.isEmpty();
      case FSMDSLPackage.COMMAND_STMT__COMMANDS:
        return commands != null && !commands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CommandStmtImpl
