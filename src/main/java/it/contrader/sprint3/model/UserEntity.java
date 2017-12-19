package it.contrader.sprint3.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UserEntity implements Serializable {

    @Id
    private String username;
    @Column
    private String password ;
    @Column
    private String firstname ;
    @Column
    private String lastname;
    @Column
    private String dateofbirth;
    @Column
    private String fiscalcode ;
    @Column
    private String businessname;
    @Column
    private String vat ;
    @Column
    private String municipality ;
    @Column
    private String post;
    @Column
    private String city ;
    @Column
    private String address ;
    @Column
    private String telephone ;
    @Column
    private  String role ;

    public UserEntity(){}

    public UserEntity( String username, String password, String firstname, String lastname, String dateofbirth, String fiscalcode, String businessname, String vat, String municipality, String post, String city, String address, String telephone, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.fiscalcode = fiscalcode;
        this.businessname = businessname;
        this.vat = vat;
        this.municipality = municipality;
        this.post =post;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity userEntity = (UserEntity) o;

        if (username != null ? !username.equals(userEntity.username) : userEntity.username != null) return false;
        if (password != null ? !password.equals(userEntity.password) : userEntity.password != null) return false;
        if (firstname != null ? !firstname.equals(userEntity.firstname) : userEntity.firstname != null) return false;
        if (lastname != null ? !lastname.equals(userEntity.lastname) : userEntity.lastname != null) return false;
        if (dateofbirth != null ? !dateofbirth.equals(userEntity.dateofbirth) : userEntity.dateofbirth != null) return false;
        if (fiscalcode != null ? !fiscalcode.equals(userEntity.fiscalcode) : userEntity.fiscalcode != null) return false;
        if (businessname != null ? !businessname.equals(userEntity.businessname) : userEntity.businessname != null) return false;
        if (vat != null ? !vat.equals(userEntity.vat) : userEntity.vat != null) return false;
        if (municipality != null ? !municipality.equals(userEntity.municipality) : userEntity.municipality != null) return false;
        if (post != null ? !post.equals(userEntity.post) : userEntity.post != null) return false;
        if (city != null ? !city.equals(userEntity.city) : userEntity.city != null) return false;
        if (address != null ? !address.equals(userEntity.address) : userEntity.address != null) return false;
        if (telephone != null ? !telephone.equals(userEntity.telephone) : userEntity.telephone != null) return false;
        return role != null ? role.equals(userEntity.role) : userEntity.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (fiscalcode != null ? fiscalcode.hashCode() : 0);
        result = 31 * result + (businessname != null ? businessname.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (municipality != null ? municipality.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User: " + "\n username: " + username + "\n password: " + password + "\n firstname: " + firstname + "\n lastname: " + lastname + "\n dateofbirth: " + dateofbirth + "\n cf: " + fiscalcode + "\n businessname: " + businessname + "\n vat: " + vat + "\n municipality: " + municipality + "\n cap: " + post + "\n city: " + city + "\n address: " + address + "\n telephone: " + telephone + "\n role: " + role;
    }


}
