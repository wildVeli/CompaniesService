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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "workTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkTypes.findAll", query = "SELECT w FROM WorkTypes w"),
    @NamedQuery(name = "WorkTypes.findByWorkType", query = "SELECT w FROM WorkTypes w WHERE w.workType = :workType")})
public class WorkTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "workType")
    private String workType;

      @ManyToMany(mappedBy = "workTypes")
    private Collection<Companies> companies;

    @XmlTransient
    public Collection<Companies> getCompanies() {
        return companies;
    }

    public void setCompanies(Collection<Companies> companies) {
        this.companies = companies;
    }
    
    
    public WorkTypes() {
    }

    public WorkTypes(String workType) {
        this.workType = workType;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workType != null ? workType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkTypes)) {
            return false;
        }
        WorkTypes other = (WorkTypes) object;
        if ((this.workType == null && other.workType != null) || (this.workType != null && !this.workType.equals(other.workType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WorkTypes[ workType=" + workType + " ]";
    }
    
}
