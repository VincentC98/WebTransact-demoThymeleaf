package colval.qc.ca.demo_thymeleaf.model.enitties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "address")
@NamedQueries({
        @NamedQuery(name = "Address.findAddressByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
        @NamedQuery(name = "Address.findByPhone", query = "SELECT a FROM Address a WHERE a.phone = :phone")
})
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @Column(name = "address")
    @Size(min = 2, max = 50)
    private String address;

    @Column(name = "address2")
    @Size(min = 2, max = 50)
    private String address2;

    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private byte[] location;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getLocation() {
        return this.location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
