package models;


import java.sql.Date;

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
})
@Entity
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable =false)
    private Users users;

    @Column(name = "purchase_at", nullable = false)
    private Date purchase_at;

    @Column(name = "category" , nullable = false)
    private Integer category;


    @Column( name = "memo", nullable = false)
    private String memo;

    @Column( name = "purchase_amount", nullable = false)
    private Integer purchase_amount;


    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Users getUsers(){
        return users;
    }

    public void setUsers(Users  users){
        this.users = users;
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


}
