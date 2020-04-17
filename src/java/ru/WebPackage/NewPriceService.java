package ru.WebPackage;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "NewPriceService")
public class NewPriceService {        
        
    public NewPriceService() throws IOException{
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("../Config.properties")) {
        Properties property = new Properties();
        property.load(input);
        ConfigReader.setMaxPrice(new BigInteger(property.getProperty("maxPrice")));
        ConfigReader.setOrganizationCodeList(property.getProperty("organizationCode"));
        ConfigReader.setMarkup(Integer.parseInt(property.getProperty("markup")));
        }
    }
    
    @WebMethod(operationName = "getNewCost")
    public String getNewCost (String text) {
        List<ToXML> list = new ArrayList();       
        String[] str = text.split("\\n\\n+");
        
        JaxbWorker jaxb = new JaxbWorker();
        FromXML unmarshXML;
        ToXML toXml;
        Calculate calc;
        
        
        for (int i = 0; i < str.length; i++) {                               
        unmarshXML = jaxb.fromXmlToObject(str[i]);
        toXml = new ToXML();
        calc = new Calculate();
        
        calc.setQuantity(unmarshXML.getQuantity());
        calc.setItemName(unmarshXML.getItemName());
        calc.setPrice(unmarshXML.getPrice());
        calc.setDocNumber(unmarshXML.getDocNumber());
        calc.setOrganizationName(unmarshXML.getOrganizationName());
        calc.setOrganizationCodeInXML(unmarshXML.getOrganizationCode());
        
        toXml.setLineNumber(unmarshXML.getLineNumber());
        toXml.setOrganizationName(unmarshXML.getOrganizationName());
        toXml.setOrganizationCode(unmarshXML.getOrganizationCode());
        toXml.setDocNumber(unmarshXML.getDocNumber());
        toXml.setItemName(unmarshXML.getItemName());
        toXml.setPrice(unmarshXML.getPrice());
        toXml.setQuantity(unmarshXML.getQuantity());
        toXml.setNewPrice(calc.getNewPrice());
        toXml.setNewAmount(calc.getNewAmount());
        calc.check();
        toXml.setErrorMessage(calc.getErrorMessage());
        toXml.setNewAmount(calc.getNewAmount());
        toXml.setNewPrice(calc.getNewPrice());
        
        //jaxb.convertObjectToXml(toXml, filepathTo);
        list.add(toXml);
        }
        String result = list.stream().map(Object::toString)
                        .collect(Collectors.joining("\n\n"));
        return result;
    }  
}