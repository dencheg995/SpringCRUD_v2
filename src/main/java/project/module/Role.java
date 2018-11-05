package project.module;



import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "users_db")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private long id;

    @Column(name = "role_name")
    private String nameRole;

    @Column(name = "user_id",updatable=false, insertable = false)
    private int userId;

    @ManyToOne
    private User user;

    public Role() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
