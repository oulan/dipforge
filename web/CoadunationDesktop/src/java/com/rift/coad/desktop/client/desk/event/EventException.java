/*
 * Desktop: The implementation of the Coadunation Desktop.
 * Copyright (C) 2008  Rift IT Contracting
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
 * EventException.java
 */

package com.rift.coad.desktop.client.desk.event;

// java imports
import com.rift.coad.desktop.client.desk.feed.*;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This exception is thrown when an error occurs with the event server.
 * 
 * @author brett chaldecott
 */
public class EventException extends Exception implements IsSerializable {

    /**
     * Creates a new instance of <code>EventException</code> without detail message.
     */
    public EventException() {
    }


    /**
     * Constructs an instance of <code>EventException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EventException(String msg) {
        super(msg);
    }
    
    
    /**
     * Constructs an instance of <code>EventException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EventException(String msg, Throwable ex) {
        super(msg,ex);
    }
    
}