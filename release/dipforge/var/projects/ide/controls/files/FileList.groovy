
import groovy.json.*;
import org.apache.log4j.Logger;

def tree = []
def builder = new JsonBuilder()
def log = Logger.getLogger(String.class);

try {
	log.info("the parameters are " + params)
	
	if (params.node == "root") {
		tree = [
	            [
	               name:'test',
	               usr:'Tommy Maintz',
	               leaf:true,
	            	image:'favicon.ico'
	            ],
	            [
	             	name:'bob',
	               user:'Fred',
	               leaf:true,
	            	image:'favicon.ico' 
	            ],
			]
	}
} catch (Exception ex) {
   log.error("This is an error" + ex.getMessage());
}
log.info("Tree " + tree)
builder(tree)
println builder.toString()