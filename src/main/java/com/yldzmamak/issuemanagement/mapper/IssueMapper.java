package com.yldzmamak.issuemanagement.mapper;

import com.yldzmamak.issuemanagement.dto.IssueDto;
import com.yldzmamak.issuemanagement.entity.Issue;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,ProjectMapper.class})
public interface IssueMapper {
    @Named("toIssue")
    Issue toIssue(IssueDto issueDto);

    @Named("toIssueDto")
    IssueDto toIssueDto(Issue issue);

    @IterableMapping(qualifiedByName = "toIssue")
    List<Issue> toIssueList(List<IssueDto> issueDtoList);

    @IterableMapping(qualifiedByName = "toIssueDto")
    List<IssueDto> toIssueDtoList(List<Issue> issueList);

}
