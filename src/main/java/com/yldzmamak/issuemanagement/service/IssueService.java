package com.yldzmamak.issuemanagement.service;

import com.yldzmamak.issuemanagement.dto.IssueDto;
import com.yldzmamak.issuemanagement.entity.Issue;
import com.yldzmamak.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);
}
