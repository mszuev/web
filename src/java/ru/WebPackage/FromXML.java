package ru.WebPackage;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlRootElement(name = "Line")
public class FromXML {    
    private int LineNumber;
    private String OrganizationName;
    private String OrganizationCode;
    private String DocNumber;
    private String ItemName;
    private BigInteger Price;
    private BigInteger Quantity;
         
    public int getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(int LineNumber) {
        this.LineNumber = LineNumber;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String OrganizationName) {
        this.OrganizationName = OrganizationName;
    }

    public String getOrganizationCode() {
        return OrganizationCode;
    }

    public void setOrganizationCode(String OrganizationCode) {
        this.OrganizationCode = OrganizationCode;
    }

    public String getDocNumber() {
        return DocNumber;
    }

    public void setDocNumber(String DocNumber) {
        this.DocNumber = DocNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public BigInteger getPrice() {
        return Price;
    }

    public void setPrice(BigInteger Price) {
        this.Price = Price;
    }

    public BigInteger getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigInteger Quantity) {
        this.Quantity = Quantity;
    }
}