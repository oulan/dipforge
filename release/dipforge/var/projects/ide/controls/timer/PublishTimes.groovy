/**
 * The project remove script
 *
 * @author Brett Chaldecott
 */
// package path
package projects;

import com.rift.coad.util.connection.ConnectionManager
import com.rift.dipforge.project.ProjectManager
import com.rift.dipforge.project.ProjectFileManager
import com.rift.dipforge.project.ProjectTimerManager
import java.util.Date
import files.mimes.MimeTypeMapper
    
import groovy.json.*;
import org.apache.log4j.Logger;

def tree = []
def builder = new JsonBuilder()
def log = Logger.getLogger("types.PublishTimer");

try {
	log.info("parameters[" + params + "]")
    def daemon = ConnectionManager.getInstance().getConnection(
    		ProjectFileManager.class,"project/FileManager")
	daemon.updateFile(params.project,params.path,params.content)
    daemon = ConnectionManager.getInstance().getConnection(
			ProjectTimerManager.class,"project/TimerManager")
	daemon.publishTimes(params.content)
} catch (Exception ex) {
    log.error("Failed to publish the project times : " + ex.getMessage());
    throw ex;
}

builder([success:true])
