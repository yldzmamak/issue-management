package com.yldzmamak.issuemanagement.repository;

import com.yldzmamak.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository Singleton la alakalı
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);
}
