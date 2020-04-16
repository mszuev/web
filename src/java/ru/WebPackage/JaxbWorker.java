package ru.WebPackage;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
    
//    void convertObjectToXml(ToXML toXml, String filePath) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(ToXML.class);
//            Marshaller marshaller = context.createMarshaller();            
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(toXml, new File(filePath));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
}
