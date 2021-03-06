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
 * LogicalException.java
 */

package com.rift.coad.change.rdf.objmapping.client.change.task.operator;

/**
 * This exception is thrown when there are problems with the logical handling
 *
 * @author brett chaldecott
 */
public class LogicalException extends Exception implements java.io.Serializable {

    /**
     * Creates a new instance of <code>LogicalException</code> without detail message.
     */
    public LogicalException() {
    }


    /**
     * Constructs an instance of <code>LogicalException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public LogicalException(String msg) {
        super(msg);
    }


    /**
     * Constructs an instance of <code>LogicalException</code> with the specified detail message.
     * @param message The message for this exception.
     * @param cause The cause of this exception.
     */
    public LogicalException(String message, Throwable cause) {
        super(message, cause);
    }



}
