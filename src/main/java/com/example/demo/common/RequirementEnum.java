package com.example.demo.common;

import lombok.AllArgsConstructor;

public interface RequirementEnum {

    //需求类型
    @AllArgsConstructor
    enum Type {
        PROJECT(0,"业务需求"),
        TECH_OPTIMIZE(1,"技术需求"),
        DAILY(2,"紧急需求"),
        ;
        /**
         * 根据value获取枚举值
         *
         * @param value
         * @return
         */
        public static String getInstance(Integer value) {
            for (Type type : values()) {
                if (type.value.equals(value)) {
                    return type.desc;
                }
            }
            return null;
        }

        private Integer value;

        private String desc;

        public Integer getValue() {
            return value;
        }
    }

    //需求等级
    @AllArgsConstructor
    enum Level {
        P0(0,"P0"),
        P1(1,"P1"),
        P2(2,"P2"),
        P3(3,"P3"),
        ;

        public static String getInstance(Integer value) {
            for (Level level : values()) {
                if (level.value.equals(value)) {
                    return level.desc;
                }
            }
            return null;
        }

        private Integer value;

        private String desc;

        public Integer getValue() {
            return value;
        }
    }


    //需求状态
    @AllArgsConstructor
    enum State {
        REQUIRE(0, "需求阶段"),
        WAITING(1, "排期阶段"),
        DEVELOP(2, "开发阶段"),
        TEST(3, "测试阶段"),
        PRETEST(4, "预发阶段"),
        FINISH(5, "已发布"),
        ;
        public static String getInstance(Integer value) {
            for (State state : values()) {
                if (state.value.equals(value)) {
                    return state.desc;
                }
            }
            return null;
        }
        private Integer value;

        private String desc;

        public Integer getValue() {
            return value;
        }
    }


    //开发自测
    @AllArgsConstructor
    enum SelfTest {
        YES(0,"是"),
        NO(1,"否"),
        ;
        public static String getInstance(Integer value) {
            for (SelfTest selfTest : values()) {
                if (selfTest.value.equals(value)) {
                    return selfTest.desc;
                }
            }
            return null;
        }
        private Integer value;

        private String desc;

        public Integer getValue() {
            return value;
        }
    }

    //冒烟通过
    @AllArgsConstructor
    enum SmokePass {
        YES(0,"是"),
        NO(1,"否"),
        ;
        public static String getInstance(Integer value) {
            for (SmokePass smokePass : values()) {
                if (smokePass.value.equals(value)) {
                    return smokePass.desc;
                }
            }
            return null;
        }
        private Integer value;

        private String desc;

        public Integer getValue() {
            return value;
        }
    }

}
