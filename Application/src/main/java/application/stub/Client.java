
package application.stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Client", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Client {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "list", targetNamespace = "http://service/", className = "application.stub.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://service/", className = "application.stub.ListResponse")
    @Action(input = "http://service/Client/listRequest", output = "http://service/Client/listResponse")
    public String list(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "status", targetNamespace = "http://service/", className = "application.stub.Status")
    @ResponseWrapper(localName = "statusResponse", targetNamespace = "http://service/", className = "application.stub.StatusResponse")
    @Action(input = "http://service/Client/statusRequest", output = "http://service/Client/statusResponse")
    public String status(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "search", targetNamespace = "http://service/", className = "application.stub.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://service/", className = "application.stub.SearchResponse")
    @Action(input = "http://service/Client/searchRequest", output = "http://service/Client/searchResponse")
    public String search(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
