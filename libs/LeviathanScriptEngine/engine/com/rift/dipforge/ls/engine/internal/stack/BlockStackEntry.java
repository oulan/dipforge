/*
 * LeviathanScriptEngine: The implementation of the Leviathan script engin.
 * Copyright (C) 2012  Rift IT Contracting
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * BlockStackEntry.java
 */

package com.rift.dipforge.ls.engine.internal.stack;

import com.rift.dipforge.ls.engine.EngineException;
import com.rift.dipforge.ls.engine.internal.Constants;
import com.rift.dipforge.ls.engine.internal.ProcessStackEntry;
import com.rift.dipforge.ls.engine.internal.ProcessorMemoryManager;
import com.rift.dipforge.ls.parser.obj.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brett chaldecott
 */
public class BlockStackEntry extends ProcessStackEntry {

    
    /**
     * The block stack entry constructor.
     * 
     * @param processorMemoryManager The processor memory manager.
     * @param parent The parent reference.
     * @param variables The variables.
     */
    public BlockStackEntry(ProcessorMemoryManager processorMemoryManager,
            ProcessStackEntry parent, Map variables) {
        super(processorMemoryManager, parent, variables);
    }

    
    /**
     * This constructor sets up the processor memory reference and parent
     * reference.
     * 
     * @param processorMemoryManager The processor reference.
     * @param parent The parent reference.
     */
    public BlockStackEntry(ProcessorMemoryManager processorMemoryManager,
            ProcessStackEntry parent) {
        super(processorMemoryManager, parent);
    }

    
    /**
     * The execute method
     */
    @Override
    public void execute() throws EngineException {
        if (StackUtil.popStack(this)) {
            pop();
        } else {
            Statement statement = getNextStatement();
            if (statement != null) {
                executeStatement(statement);
            } else {
                pop();
            }
        }
    }
    
    /**
     * This method is called to set a result value.
     * @param result
     * @throws EngineException 
     */
    @Override
    public void setResult(Object result) throws EngineException {
        // TODO: implement this method.
    }
    
    
    /**
     * This method retrieves the next item in the list
     *
     * @param blk The block that this object is attached to.
     * @param statement The current statement
     * @return The reference to the statement
     */
    protected Statement getNextStatement()
            throws EngineException {
        Block blk = (Block)getVariable(Constants.BLOCK);
        Statement statement = null;
        if (containsVariable(Constants.STATEMENT_POS)) {
            statement = (Statement) getVariable(Constants.STATEMENT_POS);
        }

        if ((statement == null)
                || !(blk.getStatements().contains(statement))) {
            if (blk.getStatements().size() > 0) {
                Statement result = blk.getStatements().get(0);
                addVariable(Constants.STATEMENT_POS, result);
                return result;
            }
        } else {
            int index = blk.getStatements().indexOf(statement) + 1;
            if (blk.getStatements().size() > index) {
                Statement result = blk.getStatements().get(index);
                setVariable(Constants.STATEMENT_POS, result);
                return result;
            }
        }
        return null;
    }

    
    /**
     * This method executes the statement
     *
     * @param statement The statement to execute
     */
    protected void executeStatement(Statement statement) throws EngineException {
        try {
            if (statement instanceof Variable) {
                // retrieve the inital value
                VariableStackEntry stackEntry = new VariableStackEntry(
                        this.getProcessorMemoryManager(),this, 
                        (Variable)statement);
            } else if (statement instanceof CallStatement) {
                CallStatementStackEntry stackEntry = new CallStatementStackEntry(
                        this.getProcessorMemoryManager(),this, null,
                        (CallStatement)statement);
            } else if (statement instanceof IfStatement) {
                IfStatementStackEntry stackEntry = new IfStatementStackEntry(
                        this.getProcessorMemoryManager(),this, null,
                        (IfStatement)statement);
            } else if (statement instanceof WhileStatement) {
                WhileStatementStackEntry stackEntry =
                        new WhileStatementStackEntry(
                        this.getProcessorMemoryManager(),this,
                        (WhileStatement)statement);
            } else if (statement instanceof ForStatement) {
                ForStatementStackEntry stackEntry =
                        new ForStatementStackEntry(
                        this.getProcessorMemoryManager(),this,
                        (ForStatement)statement);
            } else if (statement instanceof CaseStatement) {
                // THIS has been removed from the language for the time being
            } else if (statement instanceof Block) {
                // retrieve the inital value
                Map parameters = new HashMap();
                parameters.put(Constants.BLOCK, statement);
                BlockStackEntry stackEntry = new BlockStackEntry(
                        this.getProcessorMemoryManager(),this,parameters);
            } else if (statement instanceof ContinueStatement) {
                ContinueStatementStackEntry stackEntry =
                        new ContinueStatementStackEntry(
                        this.getProcessorMemoryManager(),this);
            } else if (statement instanceof BreakStatement) {
                BreakStatementStackEntry stackEntry =
                        new BreakStatementStackEntry(
                        this.getProcessorMemoryManager(),this);
            } else if (statement instanceof ReturnStatement) {
                ReturnStatementStackEntry stackEntry =
                        new ReturnStatementStackEntry(
                        this.getProcessorMemoryManager(),this,
                        (ReturnStatement)statement);
            }
        } catch (Exception ex) {
            throw new EngineException("Failed to execute the statement : "
                    + ex.getMessage(), ex);
        }
    }

    
}