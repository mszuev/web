package ru.WebPackage;

import java.math.BigInteger;
import java.util.Arrays;

public class Calculate {
    private BigInteger maxPrice = ConfigReader.getMaxPrice();
    private String organizationCodeList = ConfigReader.getOrganizationCodeList();
    private int markup = ConfigReader.getMarkup();
    
    private BigInteger newPrice;
    private BigInteger newAmount;
    private BigInteger quantity;
    private BigInteger price;     
    private String itemName;  
    private String docNumber;
    private String organizationName;
    private String organizationCodeInXML;
    private String errorMessage;  
    StringBuilder sb = new StringBuilder();
    boolean isOkey = true;
    
    public void check(){
        String str[] = organizationCodeList.split("\\s*,\\s*");
        if(newAmount.compareTo(maxPrice) == 1){
            errorMessage = "Стоимость товара " + itemName + ", равная " + newAmount + 
                    ", превышает максимально разрешенную стоимость " + maxPrice + ";";
            sb.append(errorMessage);
            isOkey = false;
        }
        if(!Arrays.asList(str).contains(organizationCodeInXML)){
            errorMessage = "Организация " + organizationName + " отсутствует в списке партнеров" + ";";
            sb.append(errorMessage);
            isOkey = false;
        }
        if(!docNumber.substring(0,4).toLowerCase().contains("dcmt")){
            errorMessage = "Неверный номер документа – " + docNumber + 
                    ", наименование организации - " + organizationName + ";";
            sb.append(errorMessage);
            isOkey = false;
        }
        errorMessage = sb.toString();
    }
    
    public BigInteger getNewPrice() {
        if(isOkey){
        newPrice = price.add(price.multiply(BigInteger.valueOf(markup)).divide(BigInteger.valueOf(100)));
        return newPrice;
        } else return newPrice = BigInteger.ZERO;
    }
    
    public BigInteger getNewAmount() {
        if(isOkey){
        newAmount = newPrice.multiply(quantity);
        return newAmount;
        } else return newAmount = BigInteger.ZERO;
    }
    
    public void setOrganizationCodeInXML(String organizationCodeInXML) {
        this.organizationCodeInXML = organizationCodeInXML;
    }    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
    public void setPrice(BigInteger price) {
        this.price = price;
    }    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }    
    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }   
    public String getErrorMessage() {
        return errorMessage;
    }        
    public void setMaxPrice(BigInteger maxPrice) {
        this.maxPrice = maxPrice;
    }
    public void setOrganizationCodeList(String organizationCodeList) {
        this.organizationCodeList = organizationCodeList;
    }
    public void setMarkup(int markup) {
        this.markup = markup;
    }
}
