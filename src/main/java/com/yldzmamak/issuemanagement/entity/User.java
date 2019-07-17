package com.yldzmamak.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")//user olarak yaratılacaktı
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)//uniqui aynı username birden fazla olmaz
    private String username;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname",length = 200)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)//bu kullanıcıyı select ettiğimde o kullanıcıya ait issue ları görmek için
    //birtane kullanıcıya birçok issue bağlanabilir. LAZY = ihtiyaç duyulduğunda bu fieldın getteri otomatik olarak orayı çağıracak
    private List<Issue> issues;

}
