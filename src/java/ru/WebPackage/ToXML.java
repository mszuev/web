package ru.WebPackage;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlRootElement(name = "Line")
@XmlType(propOrder = {"lineNumber", "organizationName", "organizationCode", "docNumber", "itemName", "price", "quantity", "newPrice", "newAmount", "errorMessage"})

public class ToXML {       
    
    private int lineNumber;
    private String organizationName;
    private String organizationCode;
    private String docNumber;
    private String itemName;
    private BigInteger price;
    private BigInteger quantity;
    private BigInteger newPrice;
    private BigInteger newAmount;
    private String errorMessage;

    public int getLineNumber() {
        return lineNumber;
    }
    
    public void setLineNumber(int LineNumber) {
        this.lineNumber = LineNumber;
    }

    public String getOrganizationName() {
        return organizationName;
    }
    
    public void setOrganizationName(String OrganizationName) {
        this.organizationName = OrganizationName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }
    
    public void setOrganizationCode(String OrganizationCode) {
        this.organizationCode = OrganizationCode;
    }

    public String getDocNumber() {
        return docNumber;
    }
    
    public void setDocNumber(String DocNumber) {
        this.docNumber = DocNumber;
    }

    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String ItemName) {
        this.itemName = ItemName;
    }

    public BigInteger getPrice() {
        return price;
    }
    
    public void setPrice(BigInteger Price) {
        this.price = Price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }
    
    public void setQuantity(BigInteger Quantity) {
        this.quantity = Quantity;
    }

    public BigInteger getNewPrice() {
        return newPrice;
    }
    
    public void setNewPrice(BigInteger NewPrice) {
        this.newPrice = NewPrice;
    }

    public BigInteger getNewAmount() {
        return newAmount;
    }
    
    public void setNewAmount(BigInteger NewAmount) {
        this.newAmount = NewAmount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String ErrorMessage) {
        this.errorMessage = ErrorMessage;
    }   

    @Override
    public String toString() {
        
        return "<Line>\n" + 
                    "\t<lineNumber>" + lineNumber + "</lineNumber>\n" +
                    "\t<organizationName>" + organizationName + "</organizationName>\n" +
                    "\t<organizationCode>" + organizationCode + "</organizationCode>\n" +
                    "\t<docNumber>" + docNumber + "</docNumber>\n" +
                    "\t<itemName>" + itemName + "</itemName>\n" +
                    "\t<price>" + price + "</price>\n" +
                    "\t<quantity>" + quantity + "</quantity>\n" +
                    "\t<newPrice>" + newPrice + "</newPrice>\n" +
                    "\t<newAmount>" + newAmount + "</newAmount>\n" +
                    "\t<errorMessage>" + errorMessage + "</errorMessage>\n"+
                "</Line>";
    }   
}