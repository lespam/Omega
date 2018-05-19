
package webservicecli;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservicecli package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClassNotFoundException_QNAME = new QName("http://webservices/", "ClassNotFoundException");
    private final static QName _CreateTable_QNAME = new QName("http://webservices/", "createTable");
    private final static QName _CreateTableResponse_QNAME = new QName("http://webservices/", "createTableResponse");
    private final static QName _DeleteRow_QNAME = new QName("http://webservices/", "deleteRow");
    private final static QName _DeleteRowResponse_QNAME = new QName("http://webservices/", "deleteRowResponse");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _InsertRow_QNAME = new QName("http://webservices/", "insertRow");
    private final static QName _InsertRowResponse_QNAME = new QName("http://webservices/", "insertRowResponse");
    private final static QName _Operation_QNAME = new QName("http://webservices/", "operation");
    private final static QName _OperationResponse_QNAME = new QName("http://webservices/", "operationResponse");
    private final static QName _ShowTable_QNAME = new QName("http://webservices/", "showTable");
    private final static QName _ShowTableResponse_QNAME = new QName("http://webservices/", "showTableResponse");
    private final static QName _UpdateRow_QNAME = new QName("http://webservices/", "updateRow");
    private final static QName _UpdateRowResponse_QNAME = new QName("http://webservices/", "updateRowResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservicecli
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClassNotFoundException }
     * 
     */
    public ClassNotFoundException createClassNotFoundException() {
        return new ClassNotFoundException();
    }

    /**
     * Create an instance of {@link CreateTable }
     * 
     */
    public CreateTable createCreateTable() {
        return new CreateTable();
    }

    /**
     * Create an instance of {@link CreateTableResponse }
     * 
     */
    public CreateTableResponse createCreateTableResponse() {
        return new CreateTableResponse();
    }

    /**
     * Create an instance of {@link DeleteRow }
     * 
     */
    public DeleteRow createDeleteRow() {
        return new DeleteRow();
    }

    /**
     * Create an instance of {@link DeleteRowResponse }
     * 
     */
    public DeleteRowResponse createDeleteRowResponse() {
        return new DeleteRowResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link InsertRow }
     * 
     */
    public InsertRow createInsertRow() {
        return new InsertRow();
    }

    /**
     * Create an instance of {@link InsertRowResponse }
     * 
     */
    public InsertRowResponse createInsertRowResponse() {
        return new InsertRowResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link ShowTable }
     * 
     */
    public ShowTable createShowTable() {
        return new ShowTable();
    }

    /**
     * Create an instance of {@link ShowTableResponse }
     * 
     */
    public ShowTableResponse createShowTableResponse() {
        return new ShowTableResponse();
    }

    /**
     * Create an instance of {@link UpdateRow }
     * 
     */
    public UpdateRow createUpdateRow() {
        return new UpdateRow();
    }

    /**
     * Create an instance of {@link UpdateRowResponse }
     * 
     */
    public UpdateRowResponse createUpdateRowResponse() {
        return new UpdateRowResponse();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "ClassNotFoundException")
    public JAXBElement<ClassNotFoundException> createClassNotFoundException(ClassNotFoundException value) {
        return new JAXBElement<ClassNotFoundException>(_ClassNotFoundException_QNAME, ClassNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "createTable")
    public JAXBElement<CreateTable> createCreateTable(CreateTable value) {
        return new JAXBElement<CreateTable>(_CreateTable_QNAME, CreateTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "createTableResponse")
    public JAXBElement<CreateTableResponse> createCreateTableResponse(CreateTableResponse value) {
        return new JAXBElement<CreateTableResponse>(_CreateTableResponse_QNAME, CreateTableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "deleteRow")
    public JAXBElement<DeleteRow> createDeleteRow(DeleteRow value) {
        return new JAXBElement<DeleteRow>(_DeleteRow_QNAME, DeleteRow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "deleteRowResponse")
    public JAXBElement<DeleteRowResponse> createDeleteRowResponse(DeleteRowResponse value) {
        return new JAXBElement<DeleteRowResponse>(_DeleteRowResponse_QNAME, DeleteRowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertRow")
    public JAXBElement<InsertRow> createInsertRow(InsertRow value) {
        return new JAXBElement<InsertRow>(_InsertRow_QNAME, InsertRow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertRowResponse")
    public JAXBElement<InsertRowResponse> createInsertRowResponse(InsertRowResponse value) {
        return new JAXBElement<InsertRowResponse>(_InsertRowResponse_QNAME, InsertRowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "showTable")
    public JAXBElement<ShowTable> createShowTable(ShowTable value) {
        return new JAXBElement<ShowTable>(_ShowTable_QNAME, ShowTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowTableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "showTableResponse")
    public JAXBElement<ShowTableResponse> createShowTableResponse(ShowTableResponse value) {
        return new JAXBElement<ShowTableResponse>(_ShowTableResponse_QNAME, ShowTableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "updateRow")
    public JAXBElement<UpdateRow> createUpdateRow(UpdateRow value) {
        return new JAXBElement<UpdateRow>(_UpdateRow_QNAME, UpdateRow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "updateRowResponse")
    public JAXBElement<UpdateRowResponse> createUpdateRowResponse(UpdateRowResponse value) {
        return new JAXBElement<UpdateRowResponse>(_UpdateRowResponse_QNAME, UpdateRowResponse.class, null, value);
    }

}
