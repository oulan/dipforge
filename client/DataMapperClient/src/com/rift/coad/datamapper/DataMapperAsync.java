/*
 * DataMapperClient: The client information for the data mapper.
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
 * DataMapper.java
 */


// package path
package com.rift.coad.datamapper;

// java imports
import java.rmi.Remote;
import java.rmi.RemoteException;

// coadunation imports
import com.rift.coad.rdf.objmapping.base.DataType;

/**
 * This interface defines the async version of the data mapper interface.
 *
 * @author brett chaldecott
 */
public interface DataMapperAsync extends Remote {
    /**
     * This method provides an async way of calling the execute method on the data mapper client.
     *
     * @param serviceId The id of the service that is responsible for executing this query.
     * @param method The name of the method to execute.
     * @param parameters The parameter for the request.
     * @return The return result.
     * @throws com.rift.coad.datamapper.DataMapperException
     * @throws java.rmi.RemoteException
     */
    public String execute(String serviceId, String method, DataType[] parameters) throws RemoteException;
}