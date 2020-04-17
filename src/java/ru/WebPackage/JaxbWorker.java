package ru.WebPackage;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JaxbWorker {
    FromXML fromXmlToObject(String str) {
        try {    
            JAXBContext jaxbContext = JAXBContext.newInstance(FromXML.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (FromXML) un.unmarshal(new StringReader(str));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;  
    }
}
