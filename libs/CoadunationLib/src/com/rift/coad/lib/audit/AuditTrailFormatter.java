/*
 * CoadunationLib: The coaduntion implementation library.
 * Copyright (C) 2007  Rift IT Contracting
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
 * AuditTrailFormat.java
 */

package com.rift.coad.lib.audit;

/**
 * This interface represents a format object used by the audit trail classes.
 *
 * @author brett chaldecott
 */
public interface AuditTrailFormatter {
    
    /**
     * This method formats the audit trail entries.
     *
     * @param entry The entry to format.
     */
    public void format(AuditTrailEntry entry);
}
