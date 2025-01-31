package basic;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @SequenceGenerator(
            name = "MEMBER_SEQ_GENERATOR",
            sequenceName = "MEMBER_SEQ", initialValue =  50,
            allocationSize = 10 )

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    @Column(name = "name")
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


