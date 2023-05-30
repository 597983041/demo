package com.example.demo.vo;

import com.example.demo.common.RequirementEnum;
import com.example.demo.dto.RequirementDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RequirementVO {
    Integer id;
    String name;
    String type;
    String level;
    String state;
    String team;
    String developerPM;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date requirementCompleteDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date planSubmitDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date submitDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date planPublishDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date publishDate;
    String selfTest;
    String smokePass;
    String tester;
    String developer;
    String productManager;
    String requirementUrl;
    String developUrl;
    String jira;
    String note;

    /**
     * DTO list
     */
    @JsonIgnore
    private List<RequirementVO> voList;


    /**
     * DO转DTO
     *
     * @param d
     */
    public RequirementVO(RequirementDTO d) {
        this.id = d.getId();
        this.name = d.getName();
        this.type = RequirementEnum.Type.getInstance(d.getType());
        this.level = RequirementEnum.Level.getInstance(d.getLevel());
        this.state = RequirementEnum.State.getInstance(d.getState());
        this.team = d.getTeam();
        this.developerPM = d.getDeveloperPM();
        this.requirementCompleteDate = d.getRequirementCompleteDate();
        this.planSubmitDate = d.getPlanSubmitDate();
        this.submitDate = d.getSubmitDate();
        this.planPublishDate = d.getPlanPublishDate();
        this.publishDate = d.getPublishDate();
        this.selfTest = RequirementEnum.SelfTest.getInstance(d.getSelfTest());
        this.smokePass = RequirementEnum.SmokePass.getInstance(d.getSmokePass());
        this.tester = d.getTester();
        this.developer = d.getDeveloper();
        this.productManager = d.getProductManager();
        this.requirementUrl = d.getRequirementUrl();
        this.developUrl = d.getDevelopUrl();
        this.jira = d.getJira();
        this.note = d.getNote();
    }

    /**
     * DO list 转 DTO list
     *
     */
    public RequirementVO(List<RequirementDTO> list) {
        List<RequirementVO> voList = new ArrayList<>();
        for (RequirementDTO dto : list) {
            RequirementVO vo = new RequirementVO(dto);
            voList.add(vo);
        }
        this.voList = voList;
    }
}
