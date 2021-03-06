/*
 * AuditTrail: The audit trail log object.
 * Copyright (C) 2011  Rift IT Contracting
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
 * LogEntry.java
 */

// package path
package com.rift.coad.audit.dto;

// java imports
import java.util.Date;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

// coadunation rdf imports
import com.rift.coad.lib.common.RandomGuid;
import java.io.Serializable;

/**
 * This object represents an audit log entry.
 *
 * @author brett chaldecott
 */
public class LogEntry implements Serializable {

    /**
     * This enum represents the status of the log entry object.
     */
    public enum Status { COMPLETE, INFO, FAILURE, CRITICAL_FAILURE };


    // private member variables
    private String id;
    private String hostname;
    private String source;
    private String user;
    private Date time;
    private String status;
    private String correlationId;
    private String externalId;
    private String request;

    /**
     * The default constructor.
     */
    public LogEntry() {
        time = new Date();
        correlationId = "";
        externalId = "";
        try {
            id = RandomGuid.getInstance().getGuid();
        } catch (Exception ex) {
            // ignore
        }
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
            this.hostname = "Unknown";
        }
    }

    /**
     * This constructor sets all the relevant member variables.
     *
     * @param source The source name of the log entry.
     * @param status The status of the log entry.
     * @param user The name of the user.
     * @param correlationId The correlation id for the log entry.
     * @param externalId The external id for the the log entry.
     * @param request The request.
     */
    public LogEntry(String source, String status, String user,
            String correlationId, String externalId, String request) {
        time = new Date();
        try {
            id = RandomGuid.getInstance().getGuid();
        } catch (Exception ex) {
            // ignore
        }
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception ex) {
            this.hostname = "Unknown";
        }
        this.source = source;
        this.user = user;
        this.status = Status.valueOf(status).name();
        this.correlationId = correlationId;
        this.externalId = externalId;
        this.request = request;
    }


    /**
     *
     * @param hostname
     * @param source
     * @param status
     * @param user
     * @param time
     * @param correlationId
     * @param externalId
     * @param request
     */
    public LogEntry(String hostname, String source, String status, String user,
            Date time,String correlationId, String externalId, String request) {
        try {
            id = RandomGuid.getInstance().getGuid();
        } catch (Exception ex) {
            // ignore
        }
        this.hostname = hostname;
        this.source = source;
        this.user = user;
        this.time = time;
        this.status = Status.valueOf(status).name();
        this.correlationId = correlationId;
        this.externalId = externalId;
        this.request = request;
    }


    /**
     * This constructor that populates all values.
     *
     * @param id The id.
     * @param hostname The hostname
     * @param source The source.
     * @param user The user.
     * @param time The time.
     * @param status The status.
     * @param correlationId The correlation id.
     * @param externalId The external id.
     * @param request The request.
     */
    public LogEntry(String id, String hostname, String source, String user,
            Date time, String status, String correlationId, String externalId, String request) {
        this.id = id;
        this.hostname = hostname;
        this.source = source;
        this.user = user;
        this.time = time;
        this.status = status;
        this.correlationId = correlationId;
        this.externalId = externalId;
        this.request = request;
    }
    
    
    /**
     * This method gets the id of the of the log entry.
     *
     * @return The string containing the audit id.
     */
    public String getId() {
        return id;
    }


    /**
     * This method sets the id of the log entry.
     *
     * @param id The string containing the id of the log entry.
     */
    public void setId(String id) {
        this.id = id;
    }

    
    /**
     * This method returns the correlation id.
     *
     * @return The correlation id.
     */
    public String getCorrelationId() {
        return correlationId;
    }


    /**
     * This method sets the correlation id.
     *
     * @param correlationId The correlation id.
     */
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }


    /**
     * This method sets the external id.
     *
     * @return The external id.
     */
    public String getExternalId() {
        return externalId;
    }


    /**
     * This method sets the external id for the log entry.
     *
     * @param externalId The external id for the log entry.
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }


    /**
     * This method returns the name of the host.
     *
     * @return The string containing the host name.
     */
    public String getHostname() {
        return hostname;
    }


    /**
     * This method sets the name of the host
     *
     * @param hostname The string containing the host name.
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    
    /**
     * The string containing the request information that is being logged.
     *
     * @return The string containing the log information.
     */
    public String getRequest() {
        return request;
    }


    /**
     * This method sets the request information.
     *
     * @param request The string containing the request information.
     */
    public void setRequest(String request) {
        this.request = request;
    }


    /**
     * The string containing the source information.
     *
     * @return This method returns the string containing the source information.
     */
    public String getSource() {
        return source;
    }


    /**
     * This method sets the source information for this log object.
     *
     * @param source The string containing the source information.
     */
    public void setSource(String source) {
        this.source = source;
    }


    /**
     * This method returns the status information.
     *
     * @return The status information.
     */
    public String getStatus() {
        return status;
    }


    /**
     * This method sets the status of the log entry.
     *
     * @param status The status of the log entry.
     */
    public void setStatus(String status) {
        this.status = Status.valueOf(status).name();
    }


    /**
     * This method retrieves the time for the audit entry.
     *
     * @return The time date object.
     */
    public Date getTime() {
        return time;
    }


    /**
     * This method sets the time for the log event.
     *
     * @param time The object containing the time information
     */
    public void setTime(Date time) {
        this.time = time;
    }

    
    /**
     * This method retrieves the user information for this log entry.
     * 
     * @return The string containing the log entry.
     */
    public String getUser() {
        return user;
    }


    /**
     * This method sets the user information for the log.
     *
     * @param user The string containing the user information.
     */
    public void setUser(String user) {
        this.user = user;
    }


    /**
     * This method performs an equals check on the log entry.
     * 
     * @param obj The object to perform the equals check on.
     * @return The return result.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LogEntry other = (LogEntry) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }


    /**
     * This method returns the hash code for the log entry.
     *
     * @return The hash code for the log entry.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }


    /**
     * This method returns the string representation of the entry.
     *
     * @return The string result for this log entry.
     */
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s \"%s\"%n", hostname,source,user,time.toString(),
                status,correlationId,externalId,request);
    }


    
}
