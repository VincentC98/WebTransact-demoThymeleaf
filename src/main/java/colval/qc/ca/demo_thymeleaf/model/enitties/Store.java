package colval.qc.ca.demo_thymeleaf.model.enitties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "store")
@NamedQueries({
        @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
        , @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId")
        , @NamedQuery(name = "Store.findByLastUpdate", query = "SELECT s FROM Store s WHERE s.lastUpdate = :lastUpdate")})

@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;


    @OneToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    private Staff managerStaff;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getStoreId() {
        return this.storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public Staff getManagerStaff() {
        return this.managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
