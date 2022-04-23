package com.example.demo.persistence.geo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_country")
public class JpaCountry {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "alpha_2", nullable = false)
    private String alpha2;

    @Column(name = "alpha_3", nullable = false)
    private String alpha3;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<JpaCity> cities;

    public JpaCountry() {
        //~ required due to ORMs
    }

    public static JpaCountry create(final String alpha2, final String alpha3, final String name) {
        var jpaCountry = new JpaCountry();
        jpaCountry.setAlpha2(alpha2);
        jpaCountry.setAlpha3(alpha3);
        jpaCountry.setName(name);
        jpaCountry.activate();
        return jpaCountry;
    }

    public Long getId() {
        return id;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(final String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(final String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = Boolean.TRUE;
    }

    public void deactivate() {
        this.active = Boolean.FALSE;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public void addCity(final JpaCity jpaCity) {
        if (this.cities == null) {
            this.cities = new HashSet<>();
        }
        this.cities.add(jpaCity);
    }

    public Set<JpaCity> getCities() {
        return cities;
    }

}
