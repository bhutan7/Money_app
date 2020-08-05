package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="expenditures")
@NamedQueries({
    @NamedQuery(
            name = "getAllExpenditures",
            query = "SELECT e FROM Expenditure AS e ORDER BY e.id DESC"
            ),
    @NamedQuery(
            name = "getExpendituresCount",
            query = "SELECT COUNT(e) FROM Expenditure AS e"
            ),
    @NamedQuery(
            name = "checkRegisterdName",
            query = "SELECT COUNT(e) FROM Expenditure AS e WHERE e.name = :name"
            ),
    @NamedQuery(
            name = "checkLoginNameAndPassword",
            query = "SELECT e FROM  Expenditure AS e WHERE e.name = :name AND e.password = :password"
            )
})
@Entity
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" , nullable = false,unique = true)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "purchase_at", nullable = false)
    private Date purchase_at;

    @Column(name = "category" , nullable = false)
    private Integer category;

    @Column( name = "memo", nullable = false)
    private String memo;

    @Column( name = "purchase_amount", nullable = false)
    private Integer purchase_amount;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

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

    public Date getPurchase_at(){
        return purchase_at;
    }

    public void setPurchase_at(Date purchase_at){
        this.purchase_at = purchase_at;
    }

    public Integer getCategory(){
        return category;
    }

    public void setCategory(Integer category){
        this.category = category;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public Integer getPurchase_amount(){
        return purchase_amount;
    }

    public void setPurchase_amount(Integer purchase_amount){
        this.purchase_amount = purchase_amount;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

}
