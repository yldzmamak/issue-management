package com.yldzmamak.issuemanagement.service.impl;

import com.yldzmamak.issuemanagement.dto.IssueDto;
import com.yldzmamak.issuemanagement.entity.Issue;
import com.yldzmamak.issuemanagement.mapper.IssueMapper;
import com.yldzmamak.issuemanagement.repository.IssueRepository;
import com.yldzmamak.issuemanagement.service.IssueService;
import com.yldzmamak.issuemanagement.util.TPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private IssueMapper issueMapper;

    @Override
    public IssueDto save(IssueDto issueDto) {
        if (issueDto.getDate() == null)
            throw new IllegalArgumentException("Issue date cannot be date!!!");
        return issueMapper.toIssueDto(issueRepository.save(issueMapper.toIssue(issueDto)));
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        List<IssueDto> dtos = issueMapper.toIssueDtoList(data.getContent());
        page.setStat(data, dtos);
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
