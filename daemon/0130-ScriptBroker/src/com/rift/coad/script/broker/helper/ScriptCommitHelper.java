/*
 * ScriptBroker: The script broker daemon.
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
 * ScriptRevisionManagerDaemonImpl.java
 */


// package path
package com.rift.coad.script.broker.helper;

// java imports.
import com.rift.coad.revision.rdf.RDFRevisionInfo;
import com.rift.coad.script.broker.ScriptBrokerException;
import com.rift.coad.script.broker.rdf.RDFScriptChangeInfo;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines the helper interface.
 *
 * @author brett chaldecott
 */
public interface ScriptCommitHelper extends Remote {

    /**
     * This method is called to commit the changes it identifies to the revision store.
     *
     * @param changeInfo The information on the change to commit.
     * @throws com.rift.coad.script.broker.ScriptBrokerException
     * @throws java.rmi.RemoteException
     */
    public RDFRevisionInfo commitChange(RDFScriptChangeInfo changeInfo) throws ScriptBrokerException, RemoteException;
}