package assignment_lab.practice.exam.model;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "supplier_data")
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId")
    private Long supplierId;

    @Column(name = "supplierName", nullable = false)
    @NotNull(message = "*Suuplier name is required")
    private String  supplierName;

    public Long getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    @Column(name = "phoneNumber", nullable = false)
    @NotNull(message = "*Phone number is required")
    @NumberFormat(pattern = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")
    private String phoneNumber;

    @Column(name = "city", nullable = false)
    @NotNull(message = "*Supplier city is required")
    @NotBlank(message = "*Supplier city is required")
    private String city;

    @Column(name="state", nullable = false)
    @NotNull(message = "Supplier State is required")
    @NotBlank(message = "Supplier State is required")
    private String state;

    @Column(name="zipcode",nullable = false)
    @NotNull(message = "zipcode is required")
    @NotBlank(message = "zipcode is required")
    private String zipcode;

    @Column(name = "addressLine1", nullable = false)
    @NotNull(message = "Address Line is Required")
    @NotBlank(message = "Address Line is required")
    private String addressLine1;
    public Supplier() {

    }

    public Supplier(String supplierName, String city, String state,String zipcode, String addressLine1,String phoneNumber) {
        this.supplierName = supplierName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.addressLine1 = addressLine1;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (zipcode != supplier.zipcode) return false;
        if (!supplierId.equals(supplier.supplierId)) return false;
        if (!supplierName.equals(supplier.supplierName)) return false;
        if (!city.equals(supplier.city)) return false;
        if (!state.equals(supplier.state)) return false;
        if (!addressLine1.equals(supplier.addressLine1)) return false;
        return phoneNumber.equals(supplier.phoneNumber);

    }


    @Override
    public int hashCode() {

        return Objects.hash(supplierId,supplierName,addressLine1,city,state,zipcode,phoneNumber);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", addressLine1='" + addressLine1 + '\'' +
                '}';
    }
}
