package com.example.demo.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetRequirementListParam {
    private String name;
    private String type;
    private String state;
    private String level;
    private String team;
    private String tester;
    private String developer;
    private String developerPM;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitDateStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitDateEnd;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDateStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDateEnd;

    private int page;
    private int size;
}
