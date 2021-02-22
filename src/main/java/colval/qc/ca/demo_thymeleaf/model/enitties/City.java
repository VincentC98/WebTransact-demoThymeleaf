package colval.qc.ca.demo_thymeleaf.model.enitties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
        , @NamedQuery(name = "City.findByCityId", query = "SELECT c FROM City c WHERE c.cityId = :cityId")
        , @NamedQuery(name = "City.findByCity", query = "SELECT c FROM City c WHERE c.city = :city")
        , @NamedQuery(name = "City.findByLastUpdate", query = "SELECT c FROM City c WHERE c.lastUpdate = :lastUpdate")
        , @NamedQuery(name = "City.countAll", query = "SELECT count(c) FROM City c")})

@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityId;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getCityId() {
        return this.cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
