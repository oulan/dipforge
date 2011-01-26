/*
 * Tue Feb 09 03:54:55 SAST 2010
 * view.groovy
 * @author brett chaldecott
 *
 * This is a very simple View Controler.
 */

package ControlPanel.mail

import com.rift.coad.rdf.semantic.Session
import com.rift.coad.rdf.semantic.SPARQLResultRow
import com.rift.coad.rdf.semantic.coadunation.SemanticUtil
import com.rift.coad.web.rdf.RDFConfigure
import java.util.List
import com.rift.coad.rdf.objmapping.inventory.Network



def forward(page, req, res){
  def dis = req.getRequestDispatcher(page);
  dis.forward(req, res);
}

Session session = SemanticUtil.getInstance(RDFConfigure.class).getSession();

List<SPARQLResultRow> entries = session.createSPARQLQuery("SELECT ?s WHERE { " +
                    "?s a <http://www.coadunation.net/schema/rdf/1.0/inventory#Network> ." +
                    "?s <http://www.coadunation.net/schema/rdf/1.0/base#IdForDataType> ?IdForDataType ." +
                    "FILTER (?IdForDataType = \"com.rift.coad.rdf.objmapping.inventory.MailDomain\")}").execute();
List<String> domains = new ArrayList<String>();
for (SPARQLResultRow row : entries) {
    Network network = row.get(0).cast(Network.class)
    if (network.getAssociatedObject() != null) {
        continue
    }
    domains.add(network.getAttribute(com.rift.coad.rdf.objmapping.base.Domain.class,"domain").getValue());
}

request.setAttribute("mail_domains", domains)


forward("view.gsp", request, response)
