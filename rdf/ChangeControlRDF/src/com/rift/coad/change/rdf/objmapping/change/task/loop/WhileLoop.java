/*
 * ChangeControlRDF: The rdf information for the change control system.
 * Copyright (C) 2009  Rift IT Contracting
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
 * WhileLoop.java
 */

// package scope
package com.rift.coad.change.rdf.objmapping.change.task.loop;

// the block information
import com.rift.coad.change.rdf.objmapping.change.ActionTaskDefinition;
import com.rift.coad.change.rdf.objmapping.change.task.Block;
import com.rift.coad.change.rdf.objmapping.change.task.logic.LogicalExpression;

// semantic
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;

/**
 * This object represents a foor loop.
 *
 * @author brett chaldecott
 */
@Namespace("http://www.coadunation.net/schema/rdf/1.0/change#")
@RdfType("ForLoop")
public class WhileLoop extends Block {
    private LogicalExpression expression;

    
    /**
     * The default constructor for the while loop object.
     */
    public WhileLoop() {
    }


    /**
     * This constructor sets all the internal values except the next value.
     *
     * @param name The name of this while loop object.
     * @param description The description of this object.
     * @param child The child flow that will be loop through.
     * @param expression The expression.
     */
    public WhileLoop(String name, String description, ActionTaskDefinition child,
            LogicalExpression expression) {
        super(name, description, child);
        this.expression = expression;
    }

    
    /**
     * This constructor sets up all parameters.
     *
     * @param name The name of the task.
     * @param description The description of this task.
     * @param next The next task.
     * @param child The child tasks.
     * @param expression The expression.
     */
    public WhileLoop(String name, String description, ActionTaskDefinition next,
            ActionTaskDefinition child, LogicalExpression expression) {
        super(name, description, next, child);
        this.expression = expression;
    }


    /**
     * This method returns the expression used to evaluate whether this loop should continue.
     *
     * @return The expression to evaluate.
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/change#WhileLoopExpression")
    public LogicalExpression getExpression() {
        return expression;
    }


    /**
     * This method sets the expression.
     * 
     * @param expression
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/change#WhileLoopExpression")
    public void setExpression(LogicalExpression expression) {
        this.expression = expression;
    }




}