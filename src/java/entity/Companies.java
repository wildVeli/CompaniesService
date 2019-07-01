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
@Table(name = "companies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companies.findAll", query = "SELECT c FROM Companies c"),
    @NamedQuery(name = "Companies.findByCodCompany", query = "SELECT c FROM Companies c WHERE c.codCompany = :codCompany"),
    @NamedQuery(name = "Companies.findByMame", query = "SELECT c FROM Companies c WHERE c.mame = :mame"),
    @NamedQuery(name = "Companies.findByWebpage", query = "SELECT c FROM Companies c WHERE c.webpage = :webpage"),
    @NamedQuery(name = "Companies.findByRating", query = "SELECT c FROM Companies c WHERE c.rating = :rating")})
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCompany")
    private Integer codCompany;
    @Size(max = 100)
    @Column(name = "mame")
    private String mame;
    @Size(max = 200)
    @Column(name = "webpage")
    private String webpage;
    @Column(name = "rating")
    private Integer rating;

        /*This makes the join table(the relation table between worktype and companies*/
    @ManyToMany
    private Collection<WorkTypes> workTypes;
    @ManyToMany
    private Collection<Places> workPlaces;

    @XmlTransient
    public Collection<WorkTypes> getWorkTypes() {
        return workTypes;
    }

    public void setWorkTypes(Collection<WorkTypes> workTypes) {
        this.workTypes = workTypes;
    }

    @XmlTransient
    public Collection<Places> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(Collection<Places> workPlaces) {
        this.workPlaces = workPlaces;
    }

    public Companies() {
    }

    public Companies(Integer codCompany) {
        this.codCompany = codCompany;
    }

    public Integer getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(Integer codCompany) {
        this.codCompany = codCompany;
    }

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCompany != null ? codCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companies)) {
            return false;
        }
        Companies other = (Companies) object;
        if ((this.codCompany == null && other.codCompany != null) || (this.codCompany != null && !this.codCompany.equals(other.codCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companies[ codCompany=" + codCompany + " ]";
    }
    
}
