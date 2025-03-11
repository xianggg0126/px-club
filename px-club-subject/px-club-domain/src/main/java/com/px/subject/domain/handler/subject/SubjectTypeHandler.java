package com.px.subject.domain.handler.subject;


import com.px.subject.common.enums.SubjectInfoTypeEnum;
import com.px.subject.domain.entity.SubjectInfoBO;
import com.px.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 实际的题目的插入
     */
    SubjectOptionBO query(int subjectId);

}
