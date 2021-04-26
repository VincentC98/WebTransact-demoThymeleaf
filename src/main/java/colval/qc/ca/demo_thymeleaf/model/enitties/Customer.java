package colval.qc.ca.demo_thymeleaf.model.enitties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
        , @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName")
        , @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName")
        , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
        , @NamedQuery(name = "Customer.findByActive", query = "SELECT c FROM Customer c WHERE c.active = :active")
        , @NamedQuery(name = "Customer.findByCreateDate", query = "SELECT c FROM Customer c WHERE c.createDate = :createDate")
        , @NamedQuery(name = "Customer.findByLastUpdate", query = "SELECT c FROM Customer c WHERE c.lastUpdate = :lastUpdate")
        , @NamedQuery(name = "Customer.findAllCustomerSortedByLastName", query = "SELECT  c FROM Customer c order by c.lastName asc ")
        , @NamedQuery(name = "Customer.findByFirstNameSubStr", query = "select c from Customer c where substring(c.firstName, 1, length(:subStr)) = :subStr")
        , @NamedQuery(name = "Customer.findAllCustomerIdDesc", query = "SELECT c FROM Customer c ORDER BY c.customerId desc ")
        , @NamedQuery(name = "Customer.getSimilarFirstLastName", query = "SELECT c FROM Customer c WHERE c.lastName LIKE CONCAT('%',:name ,'%') or c.firstName LIKE CONCAT('%',:name ,'%')")

})
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private Store store;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @Column(name = "active")
    private boolean active;

    @Column(name = "create_date")
    @Basic(optional = false)
    private Date createDate;

    @Column(name = "last_update")
    @Basic(optional = false)
    private Date lastUpdate;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", store=" + store +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", active=" + active +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }


    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
