package Parsing;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author elshan.abdullayev
 */
public class XsdErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        handleMessage("Warning", exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        handleMessage("Error", exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        handleMessage("Fatal", exception);
    }

    private String handleMessage(String level, SAXParseException exception) throws SAXException {
        int lineNumber = exception.getLineNumber();
        int columnNumber = exception.getColumnNumber();
        String message = exception.getMessage();
        
        throw new SAXException("\n (Xətanın tipi) [" + 
                level + "]\n (Sətir nömrəsi) line no: " + 
                lineNumber + "\n (Sütün nömrəsi) column no: " + 
                columnNumber + "\n (Xətanın mətni) message: " + 
                message );
    }
}
