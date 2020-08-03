package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="users")
@NamedQueries({
    @NamedQuery(
            name = "checkRegisterdName",
            query = "SELECT COUNT(u) FROM USERS AS u WHERE u.name = :name"
            ),
    @NamedQuery(
            name = "checkLoginNameAndPassword",
            query = "SELECT u FROM  USERS AS u WHERE u.name = :name AND u.password = :password"
            )
})
@Entity
public class USERS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" , nullable = false,unique = true)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
