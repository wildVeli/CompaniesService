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
@Table(name = "towns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Towns.findAll", query = "SELECT t FROM Towns t"),
    @NamedQuery(name = "Towns.findByCodTown", query = "SELECT t FROM Towns t WHERE t.codTown = :codTown"),
    @NamedQuery(name = "Towns.findByTown", query = "SELECT t FROM Towns t WHERE t.town = :town")})
public class Towns implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTown")
    private Integer codTown;
    @Size(max = 100)
    @Column(name = "town")
    private String town;
    
    @ManyToMany(mappedBy = "towns")
    private Collection<Places> places;  

    @XmlTransient
    public Collection<Places> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Places> places) {
        this.places = places;
    }

    
    public Towns() {
    }

    public Towns(Integer codTown) {
        this.codTown = codTown;
    }

    public Integer getCodTown() {
        return codTown;
    }

    public void setCodTown(Integer codTown) {
        this.codTown = codTown;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTown != null ? codTown.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Towns)) {
            return false;
        }
        Towns other = (Towns) object;
        if ((this.codTown == null && other.codTown != null) || (this.codTown != null && !this.codTown.equals(other.codTown))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Towns[ codTown=" + codTown + " ]";
    }
    
}
