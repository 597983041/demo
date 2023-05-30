package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequirementDTO implements Serializable {
    Integer id;
    String name;
    Integer type;
    Integer level;
    Integer state;
    String team;
    String developerPM;
    Date requirementCompleteDate;
    Date planSubmitDate;
    Date submitDate;
    Date planPublishDate;
    Date publishDate;
    Integer selfTest;
    Integer smokePass;
    String tester;
    String developer;
    String productManager;
    String requirementUrl;
    String developUrl;
    String jira;
    String note;
    Integer is_deleted;
}
