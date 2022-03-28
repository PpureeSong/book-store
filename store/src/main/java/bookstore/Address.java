package bookstore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;



@Embeddable
public class Address  {

    
    private String street;
    
    private String city;
    
    private String state;
    
    private String country;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private String zipcode;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipcode;
    }

    public void setZipCode(String zipcode) {
        this.zipcode = zipcode;
    }




}
