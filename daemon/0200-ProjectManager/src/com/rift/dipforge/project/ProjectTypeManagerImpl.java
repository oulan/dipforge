/*
 * ProjectClient: The project client interface..
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
 * ProjectTypeManager.java
 */

package com.rift.dipforge.project;

// general imports
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

// dipforge import
import com.rift.coad.lib.configuration.Configuration;
import com.rift.coad.type.TypeManagerDaemon;
import com.rift.coad.type.dto.ResourceDefinition;
import com.rift.coad.util.connection.ConnectionManager;
import com.rift.dipforge.project.factory.ProjectBean;
import com.rift.dipforge.project.factory.ProjectFactory;
import com.rift.dipforge.project.type.XMLTypeInfoParser;
import java.util.List;

/**
 * The project type manager implementation.
 *
 * @author brett chaldecott
 */
public class ProjectTypeManagerImpl implements ProjectTypeManager {

    // class static variables
    private static Logger log = Logger.getLogger(ProjectTypeManagerImpl.class);

    /**
     * The project type manager implementation
     */
    public ProjectTypeManagerImpl() {
        
        
    }


    /**
     * This method returns the project types information.
     * 
     * @param project The project to get the information for
     * @return
     * @throws ProjectException
     * @throws RemoteException
     */
    public String getProjectTypes(String project) throws ProjectException {
        try {
            ProjectBean projectBean =
                    ProjectFactory.getInstance().getProject(project);
            return projectBean.getFile(Constants.PROJECT_TYPES);
        } catch (Exception ex) {
            log.error("Failed to retrieve the types file : " + ex.getMessage(),ex);
            throw new ProjectException
                    ("Failed to retrieve the types file : " + ex.getMessage(),ex);
        }
    }


    /**
     * This method sets the project types.
     * 
     * @param project The string containing the project name.
     * @param xml The string containing the xml.
     * @throws ProjectException
     * @throws RemoteException
     */
    public void setProjectTypes(String project, String xml) throws ProjectException {
        try {
            new XMLTypeInfoParser(xml);
            ProjectBean projectBean =
                    ProjectFactory.getInstance().getProject(project);
            projectBean.updateFile(Constants.PROJECT_TYPES, xml);
        } catch (Exception ex) {
            log.error("Failed to retrieve the types file : " + ex.getMessage(),ex);
            throw new ProjectException
                    ("Failed to retrieve the types file : " + ex.getMessage(),ex);
        }
    }


    /**
     * This method publishes types.
     *
     * @param project The name of the project
     * @throws ProjectException
     */
    public void publishTypes(String project) throws ProjectException {
        try {
            ProjectBean projectBean =
                    ProjectFactory.getInstance().getProject(project);
            XMLTypeInfoParser parser = new XMLTypeInfoParser(
                    projectBean.getFile(Constants.PROJECT_TYPES));
            List<ResourceDefinition> resources = parser.getTypes();
            TypeManagerDaemon daemon = (TypeManagerDaemon)
                    ConnectionManager.getInstance().getConnection(TypeManagerDaemon.class,
                    "type/ManagementDaemon");
            for (ResourceDefinition resource: resources) {
                daemon.updateType(resource);
            }
        } catch (Exception ex) {
            log.error("Failed to retrieve the types file : " + ex.getMessage(),ex);
            throw new ProjectException
                    ("Failed to retrieve the types file : " + ex.getMessage(),ex);
        }
    }


    
}