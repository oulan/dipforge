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
 * GroovyEmbeddedBlock.java
 */

// package path
package com.rift.coad.change.rdf.objmapping.change.task.embedded;

// change management
import com.rift.coad.change.rdf.objmapping.change.ActionTaskDefinition;
import com.rift.coad.change.rdf.objmapping.change.task.EmbeddedBlock;

// data type imports
import com.rift.coad.rdf.objmapping.base.URL;

// semantics
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;



/**
 * The reference to the goovy embedded block
 *
 * @author brett chaldecott
 */
@Namespace("http://www.coadunation.net/schema/rdf/1.0/change#")
@RdfType("GroovyEmbeddedBlock")
public class GroovyEmbeddedBlock extends EmbeddedBlock {

    // private member variables
    private URL file;

    /**
     * The default constructor
     */
    public GroovyEmbeddedBlock() {
    }


    /**
     * This constructor sets the name, description and url of the groovy
     * embedded block
     *
     * @param name The name of the groovy embedded block.
     * @param description The description of the groovy embedded block.
     * @param file The
     */
    public GroovyEmbeddedBlock(String name, String description, URL file) {
        super(name, description);
        this.file = file;
    }


    /**
     * This constructor sets all the member variables.
     *
     * @param name The name of this embedded task.
     * @param description The description of this embedded task.
     * @param next The next embedded task.
     * @param file The file that the groovy is stored in.
     */
    public GroovyEmbeddedBlock(String name, String description, ActionTaskDefinition next, URL file) {
        super(name, description, next);
        this.file = file;
    }


    /**
     * This method returns the url of the embedded file.
     *
     * @return The URL of the embedded groovy script.
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/change#GroovyEmbeddedBlockURL")
    public URL getFile() {
        return file;
    }
    

    /**
     * This method sets the file url.
     * 
     * @param file The url of the embedded file
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/change#GroovyEmbeddedBlockURL")
    public void setFile(URL file) {
        this.file = file;
    }
    
}