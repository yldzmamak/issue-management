package com.yldzmamak.issuemanagement.mapper;

import com.yldzmamak.issuemanagement.dto.ProjectDto;
import com.yldzmamak.issuemanagement.entity.Project;
import com.yldzmamak.issuemanagement.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface ProjectMapper {

    @Named("toProject")
    Project toProject(ProjectDto projectDto);

    @Named("toProjectDto")
    ProjectDto toProjectDto(Project project);

    @IterableMapping(qualifiedByName = "toProject")
    List<Project> toProjectList(List<ProjectDto> projectDtoList);

    @IterableMapping(qualifiedByName = "toProjectDto")
    List<ProjectDto> toProjectDtoList(List<Project> projectList);
}
