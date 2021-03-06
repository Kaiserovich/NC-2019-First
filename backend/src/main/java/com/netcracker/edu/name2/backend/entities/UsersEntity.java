package com.netcracker.edu.name2.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "mydb")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getUserByLogin",
                procedureName = "getUserByLogin",
                resultClasses = { UsersEntity.class },
                parameters = {
                        @StoredProcedureParameter(
                                name = "log",
                                type = String.class,
                                mode = ParameterMode.IN)})
})
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "addUser",
                procedureName = "addUser",
                resultClasses = { UsersEntity.class },
                parameters = {
                        @StoredProcedureParameter(
                                name = "name",
                                type = String.class,
                                mode = ParameterMode.IN)})
})
public class UsersEntity {
    private int idUsers;
    private String login;
    private String password;
    private String personalData;
    //private int idRole;
    private RolesEntity idRole;

    @Id
    @Column(name = "idUsers" )
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "personalData")
    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

  /*  @Basic
    @Column(name = "idRole" insertable = false, updatab,le = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUsers != that.idUsers) return false;
        //if (idRole != that.idRole) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (personalData != null ? !personalData.equals(that.personalData) : that.personalData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (personalData != null ? personalData.hashCode() : 0);
        //result = 31 * result + idRole;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idRole", referencedColumnName = "idRole", nullable = false)
    public RolesEntity getIdRole() {
        return idRole;
    }

    public void setIdRole(RolesEntity idRole) {
        this.idRole = idRole;
    }
}
