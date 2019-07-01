/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "places")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Places p"),
    @NamedQuery(name = "Places.findByCodPlace", query = "SELECT p FROM Places p WHERE p.codPlace = :codPlace"),
    @NamedQuery(name = "Places.findByStreet", query = "SELECT p FROM Places p WHERE p.street = :street"),
    @NamedQuery(name = "Places.findByNumber", query = "SELECT p FROM Places p WHERE p.number = :number")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codPlace")
    private Integer codPlace;
    @Size(max = 200)
    @Column(name = "street")
    private String street;
    @Size(max = 40)
    @Column(name = "number")
    private String number;

       
    @ManyToMany(mappedBy = "workPlaces")
    private Collection<Companies> companies;  
    @ManyToMany
    private Collection<Towns> towns;  
    

    @XmlTransient
    public Collection<Companies> getCompanies() {
        return companies;
    }

    public void setCompanies(Collection<Companies> companies) {
        this.companies = companies;
    }

    @XmlTransient
    public Collection<Towns> getTowns() {
        return towns;
    }

    public void setTowns(Collection<Towns> towns) {
        this.towns = towns;
    }
    
    public Places() {
    }

    public Places(Integer codPlace) {
        this.codPlace = codPlace;
    }

    public Integer getCodPlace() {
        return codPlace;
    }

    public void setCodPlace(Integer codPlace) {
        this.codPlace = codPlace;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPlace != null ? codPlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.codPlace == null && other.codPlace != null) || (this.codPlace != null && !this.codPlace.equals(other.codPlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Places[ codPlace=" + codPlace + " ]";
    }
    
}
