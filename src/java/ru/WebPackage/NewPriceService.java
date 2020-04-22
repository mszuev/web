package ru.WebPackage;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "NewPriceService")
public class NewPriceService {        
        
    public NewPriceService() {
        
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("../Config.properties")) {
        Properties property = new Properties();
        property.load(input);
        ConfigReader.setMaxPrice(new BigInteger(property.getProperty("maxPrice")));
        ConfigReader.setOrganizationCodeList(property.getProperty("organizationCode"));
        ConfigReader.setMarkup(Integer.parseInt(property.getProperty("markup")));
        } catch (IOException ex) {
            Logger.getLogger(NewPriceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod(operationName = "getNewCost")
    public String getNewCost (String text) {
        List<ToXML> list = new ArrayList();       
        String[] str = text.split("\\n\\n+");
        
        JaxbWorker jaxb = new JaxbWorker();
        FromXML fromXML;
        ToXML toXml = null;
        Calculate calc;
        
        for (int i = 0; i < str.length; i++) {
            fromXML = jaxb.fromXmlToObject(str[i]);
            toXml = new ToXML();
            calc = new Calculate();

            calc.setQuantity(fromXML.getQuantity());
            calc.setItemName(fromXML.getItemName());
            calc.setPrice(fromXML.getPrice());
            calc.setDocNumber(fromXML.getDocNumber());
            calc.setOrganizationName(fromXML.getOrganizationName());
            calc.setOrganizationCodeInXML(fromXML.getOrganizationCode());

            toXml.setLineNumber(fromXML.getLineNumber());
            toXml.setOrganizationName(fromXML.getOrganizationName());
            toXml.setOrganizationCode(fromXML.getOrganizationCode());
            toXml.setDocNumber(fromXML.getDocNumber());
            toXml.setItemName(fromXML.getItemName());
            toXml.setPrice(fromXML.getPrice());
            toXml.setQuantity(fromXML.getQuantity());
            toXml.setNewPrice(calc.getNewPrice());
            toXml.setNewAmount(calc.getNewAmount());
            calc.check();
            toXml.setErrorMessage(calc.getErrorMessage());
            toXml.setNewAmount(calc.getNewAmount());
            toXml.setNewPrice(calc.getNewPrice());

            list.add(toXml);
        }
        String result = list.stream().map(Object::toString)
                        .collect(Collectors.joining("\n\n"));
        return result;
    }  
}