package com.yldzmamak.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity//bir şemaya denk gelmesini sağlıyor
@Table(name = "issue")//tablo oluştuması için belirttik ve adını vermekte fayda otomatik olarak oluşturursa "ıssue" olabilir
@Data
@NoArgsConstructor//boş bir constructor method yaratılır
@AllArgsConstructor//bütün fieldlar kullanılarak bir constructor method yaratır
@ToString //nesnenin tostring metodunu override eder
@EqualsAndHashCode

public class Issue extends BaseEntity {

    @Id//primary keye ihtiyaç var
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sayıların otomatitk olarak artması
    private Long id;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "details",length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")//lenght vermedik çünkü enum veriler var
    @Enumerated(EnumType.STRING) //ordinal enum verileri indexine göre tutar araya veri eklendiğinde sayılar kayar, string tutmakta fayda var
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")//
    @ManyToOne(optional = true,fetch = FetchType.LAZY)//birçok issue classı bir tane user classı ile eşleşebilir
    //optinal=issue ya bir nesne atamazssakta olur(true), fetch=issue tablosuna select atılırken issue tablosu üzerşindeki
    // join olduğundan user tablosundaki ilişkili kaydı da getirilsinmi,
    // bager dendiğinde join yapılıp getirilir lazy dendiğinde bu metodun getteri çağırıldığında getirilir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
