package com.example.demo.mapper;

import com.example.demo.dto.RequirementDTO;
import com.example.demo.param.GetRequirementListParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementMapper {
    public List<RequirementDTO> getRequirementList(GetRequirementListParam getRequirementListParam);

    public Integer addRequirement(RequirementDTO requirementDTO);
    public Integer updateRequirement(RequirementDTO requirementDTO);

    public Integer deleteRequirement(Integer id);

    public Integer getRequirementCount(GetRequirementListParam getRequirementListParam);
}
