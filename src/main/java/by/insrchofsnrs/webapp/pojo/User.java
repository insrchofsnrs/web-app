package by.insrchofsnrs.webapp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data

@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="user_id")
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private String phone;
    private String phone2;

    public User() {
    }

    public User(String name, String email, Date birthday, String phone, String phone2) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
        this.phone2 = phone2;
    }
}