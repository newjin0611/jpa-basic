package basic;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name="name" , columnNames = "name"))
public class Member {
    @Id
    private Long id;
    @Column(name = "name", updatable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    @Column(nullable = false)
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate test1;
    private LocalDateTime test2;

    @Transient
    private String temp;

    @Lob
    private String description;

    public Member() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


