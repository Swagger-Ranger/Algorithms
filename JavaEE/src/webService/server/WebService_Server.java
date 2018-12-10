package webService.server;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebService_Server {

    @WebMethod
    public String greet( String name );

    @WebMethod
    public String reverseString( String string );
}
