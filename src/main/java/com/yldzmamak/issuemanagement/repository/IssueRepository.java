package com.yldzmamak.issuemanagement.repository;

import com.yldzmamak.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {//bu interface hangi tabloya hizmet edecek ve o tablonun id sinin tipi nedir

}
