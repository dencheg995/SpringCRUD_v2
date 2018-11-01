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
    private String name;

    @OneToOne(mappedBy = "roleOBJ")
    private User user;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
