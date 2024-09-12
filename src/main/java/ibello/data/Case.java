package ibello.data;

import hu.ibello.core.Description;
import hu.ibello.core.Name;
import hu.ibello.data.Model;

import java.time.LocalDate;

@Model
@Name("Ügy")
@Description("Egy ügy adatai")
public class Case {

    @Name("Megnevezés")
    @Description("Megnevezés leírása")
    private String name;
    private String person;
    private Integer zipCode;
    private String city;
    private String street;
    private Integer number;
    private LocalDate validity;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPerson() {
        return person;
    }
    
    public void setPerson(String person) {
        this.person = person;
    }
    
    public Integer getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    public LocalDate getValidity() {
        return validity;
    }
    
    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }
    
}
