package com.yldzmamak.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Entity//bir şemaya denk gelmesini sağlıyor
@Table(name = "project")//tablo oluştuması için belirttik ve adını vermekte fayda otomatik olarak oluşturursa "ıssue" olabilir
@Data
@NoArgsConstructor//boş bir constructor method yaratılır
@AllArgsConstructor//bütün fieldlar kullanılarak bir constructor method yaratır
@ToString //nesnenin tostring metodunu override eder
@EqualsAndHashCode

public class Project extends BaseEntity{

    @Id//primary keye ihtiyaç var
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sayıların otomatitk olarak artması
    private Long id;

    @Column(name = "project_name", length = 300)
    private String projectName;

    @Column(name = "project_code", length = 30)
    private String projectCode;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
