package models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="revenues")
@NamedQueries({
    @NamedQuery(
            name = "getAllRevenues",
            query = "SELECT r FROM Revenue AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getRevenuesCount",
            query = "SELECT COUNT(r) FROM Revenue AS r"
            ),
})
@Entity
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable =false)
    private Users users;


    @Column(name = "income_at", nullable = false)
    private Date income_at;

    @Column(name = "category" , nullable = false)
    private Integer category;

    @Lob
    @Column( name = "memo", nullable = false)
    private String memo;

    @Column( name = "revenue_amount", nullable = false)
    private Integer revenue_amount;

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

    public Date getIncome_at(){
        return income_at;
    }

    public void setIncome_at(Date income_at){
        this.income_at = income_at;
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

    public Integer getRevenue_amount(){
        return revenue_amount;
    }

    public void setRevenue_amount(Integer revenue_amount){
        this.revenue_amount = revenue_amount;
    }

}
