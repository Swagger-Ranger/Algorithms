
package webService.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webService.client package. 
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

    private final static QName _Greet_QNAME = new QName("http://server.webService/", "greet");
    private final static QName _ReverseStringResponse_QNAME = new QName("http://server.webService/", "reverseStringResponse");
    private final static QName _ReverseString_QNAME = new QName("http://server.webService/", "reverseString");
    private final static QName _GreetResponse_QNAME = new QName("http://server.webService/", "greetResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webService.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReverseString }
     * 
     */
    public ReverseString createReverseString() {
        return new ReverseString();
    }

    /**
     * Create an instance of {@link GreetResponse }
     * 
     */
    public GreetResponse createGreetResponse() {
        return new GreetResponse();
    }

    /**
     * Create an instance of {@link ReverseStringResponse }
     * 
     */
    public ReverseStringResponse createReverseStringResponse() {
        return new ReverseStringResponse();
    }

    /**
     * Create an instance of {@link Greet }
     * 
     */
    public Greet createGreet() {
        return new Greet();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Greet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webService/", name = "greet")
    public JAXBElement<Greet> createGreet(Greet value) {
        return new JAXBElement<Greet>(_Greet_QNAME, Greet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webService/", name = "reverseStringResponse")
    public JAXBElement<ReverseStringResponse> createReverseStringResponse(ReverseStringResponse value) {
        return new JAXBElement<ReverseStringResponse>(_ReverseStringResponse_QNAME, ReverseStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webService/", name = "reverseString")
    public JAXBElement<ReverseString> createReverseString(ReverseString value) {
        return new JAXBElement<ReverseString>(_ReverseString_QNAME, ReverseString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webService/", name = "greetResponse")
    public JAXBElement<GreetResponse> createGreetResponse(GreetResponse value) {
        return new JAXBElement<GreetResponse>(_GreetResponse_QNAME, GreetResponse.class, null, value);
    }

}
