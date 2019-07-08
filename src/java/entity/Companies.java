/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Companies.findByDirecction", query = "SELECT c FROM Companies c WHERE c.direcction = :direcction"),
    @NamedQuery(name = "Companies.findByTechnologies", query = "SELECT c FROM Companies c WHERE c.technologies = :technologies"),
    @NamedQuery(name = "Companies.findByRating", query = "SELECT c FROM Companies c WHERE c.rating = :rating")})
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCompany")
    private Integer codCompany;
    @Size(max = 200)
    @Column(name = "mame")
    private String mame;
    @Size(max = 200)
    @Column(name = "webpage")
    private String webpage;
    @Size(max = 300)
    @Column(name = "direcction")
    private String direcction;
    @Size(max = 200)
    @Column(name = "technologies")
    private String technologies;
    @Column(name = "rating")
    private Integer rating;

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

    public String getDirecction() {
        return direcction;
    }

    public void setDirecction(String direcction) {
        this.direcction = direcction;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
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
