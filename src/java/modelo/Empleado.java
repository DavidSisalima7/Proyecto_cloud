/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAVID
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmple", query = "SELECT e FROM Empleado e WHERE e.idEmple = :idEmple")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emple")
    private Integer idEmple;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    @ManyToOne(optional = false)
    private Departamento idDep;

    public Empleado() {
    }

    public Empleado(Integer idEmple) {
        this.idEmple = idEmple;
    }

    public Empleado(Integer idEmple, String nombre) {
        this.idEmple = idEmple;
        this.nombre = nombre;
    }

    public Integer getIdEmple() {
        return idEmple;
    }

    public void setIdEmple(Integer idEmple) {
        this.idEmple = idEmple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getIdDep() {
        return idDep;
    }

    public void setIdDep(Departamento idDep) {
        this.idDep = idDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmple != null ? idEmple.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmple == null && other.idEmple != null) || (this.idEmple != null && !this.idEmple.equals(other.idEmple))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleado[ idEmple=" + idEmple + " ]";
    }
    
}
