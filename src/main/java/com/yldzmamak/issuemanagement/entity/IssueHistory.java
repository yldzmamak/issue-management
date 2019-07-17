package com.yldzmamak.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity//bir şemaya denk gelmesini sağlıyor
@Table(name = "issue_history")//tablo oluştuması için belirttik ve adını vermekte fayda otomatik olarak oluşturursa "ıssue" olabilir
@Data
@NoArgsConstructor//boş bir constructor method yaratılır
@AllArgsConstructor//bütün fieldlar kullanılarak bir constructor method yaratır
@ToString //nesnenin tostring metodunu override eder
@EqualsAndHashCode

public class IssueHistory extends BaseEntity {

    @Id//primary keye ihtiyaç var
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sayıların otomatitk olarak artması
    private Long id;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Issue issue;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")//lenght vermedik çünkü enum veriler var
    @Enumerated(EnumType.STRING) //ordinal enum verileri indexine göre tutar araya veri eklendiğinde sayılar kayar, string tutmakta fayda var
    private IssueStatus issueStatus;

    @Column(name = "details",length = 4000)
    private String details;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

}
