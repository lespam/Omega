
package webservicecli;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MyWebService", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyWebService {


    /**
     * 
     * @param parameter
     * @param parameter2
     * @param parameter1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "operation", targetNamespace = "http://webservices/", className = "webservicecli.Operation")
    @ResponseWrapper(localName = "operationResponse", targetNamespace = "http://webservices/", className = "webservicecli.OperationResponse")
    @Action(input = "http://webservices/MyWebService/operationRequest", output = "http://webservices/MyWebService/operationResponse")
    public String operation(
        @WebParam(name = "parameter", targetNamespace = "")
        String parameter,
        @WebParam(name = "parameter1", targetNamespace = "")
        String parameter1,
        @WebParam(name = "parameter2", targetNamespace = "")
        String parameter2);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://webservices/", className = "webservicecli.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://webservices/", className = "webservicecli.HelloResponse")
    @Action(input = "http://webservices/MyWebService/helloRequest", output = "http://webservices/MyWebService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param content
     * @param tableName
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertRow", targetNamespace = "http://webservices/", className = "webservicecli.InsertRow")
    @ResponseWrapper(localName = "insertRowResponse", targetNamespace = "http://webservices/", className = "webservicecli.InsertRowResponse")
    @Action(input = "http://webservices/MyWebService/insertRowRequest", output = "http://webservices/MyWebService/insertRowResponse")
    public Boolean insertRow(
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "content", targetNamespace = "")
        String content);

    /**
     * 
     * @param tableStructure
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createTable", targetNamespace = "http://webservices/", className = "webservicecli.CreateTable")
    @ResponseWrapper(localName = "createTableResponse", targetNamespace = "http://webservices/", className = "webservicecli.CreateTableResponse")
    @Action(input = "http://webservices/MyWebService/createTableRequest", output = "http://webservices/MyWebService/createTableResponse")
    public Boolean createTable(
        @WebParam(name = "tableStructure", targetNamespace = "")
        String tableStructure);

    /**
     * 
     * @param id
     * @param tableName
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteRow", targetNamespace = "http://webservices/", className = "webservicecli.DeleteRow")
    @ResponseWrapper(localName = "deleteRowResponse", targetNamespace = "http://webservices/", className = "webservicecli.DeleteRowResponse")
    @Action(input = "http://webservices/MyWebService/deleteRowRequest", output = "http://webservices/MyWebService/deleteRowResponse")
    public Boolean deleteRow(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName);

    /**
     * 
     * @param name
     * @param tableName
     * @return
     *     returns java.lang.String
     * @throws ClassNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showTable", targetNamespace = "http://webservices/", className = "webservicecli.ShowTable")
    @ResponseWrapper(localName = "showTableResponse", targetNamespace = "http://webservices/", className = "webservicecli.ShowTableResponse")
    @Action(input = "http://webservices/MyWebService/showTableRequest", output = "http://webservices/MyWebService/showTableResponse", fault = {
        @FaultAction(className = ClassNotFoundException_Exception.class, value = "http://webservices/MyWebService/showTable/Fault/ClassNotFoundException")
    })
    public String showTable(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName)
        throws ClassNotFoundException_Exception
    ;

    /**
     * 
     * @param param
     * @param id
     * @param content
     * @param tableName
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateRow", targetNamespace = "http://webservices/", className = "webservicecli.UpdateRow")
    @ResponseWrapper(localName = "updateRowResponse", targetNamespace = "http://webservices/", className = "webservicecli.UpdateRowResponse")
    @Action(input = "http://webservices/MyWebService/updateRowRequest", output = "http://webservices/MyWebService/updateRowResponse")
    public Boolean updateRow(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "param", targetNamespace = "")
        String param,
        @WebParam(name = "content", targetNamespace = "")
        String content);

}
