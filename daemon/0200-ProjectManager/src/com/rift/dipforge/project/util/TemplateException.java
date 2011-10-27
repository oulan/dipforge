/*
 * 0200-ProjectManager: The project manager implentation.
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
 * TemplateException.java
 */

package com.rift.dipforge.project.util;

/**
 * The exception that is thrown when there is a problem with the template.
 *
 * @author brett chaldecott
 */
public class TemplateException extends Exception {

    /**
     * Creates a new instance of <code>TemplateException</code> without detail message.
     */
    public TemplateException() {
    }


    /**
     * Constructs an instance of <code>TemplateException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TemplateException(String msg) {
        super(msg);
    }


    /**
     * Constructs an instance of <code>TemplateException</code> with the specified detail message.
     *
     * @param msg the detail message.
     * @param cause The cause of this problem.
     */
    public TemplateException(String msg, Throwable cause) {
        super(msg,cause);
    }
}