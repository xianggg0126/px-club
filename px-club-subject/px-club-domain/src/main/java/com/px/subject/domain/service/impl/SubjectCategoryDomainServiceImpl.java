package com.px.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.px.subject.common.enums.IsDeletedFlagEnum;
import com.px.subject.domain.convert.SubjectCategoryConverter;
import com.px.subject.domain.entity.SubjectCategoryBO;
import com.px.subject.domain.service.SubjectCategoryDomainService;
import com.px.subject.infra.basic.entity.SubjectCategory;
import com.px.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {


    @Resource
    private SubjectCategoryService subjectCategoryService;


    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("add subjectCategoryDTO:{}", JSON.toJSONString(subjectCategoryBO));
            SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryBO);
            subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectCategoryService.insert(subjectCategory);
        }
    }

    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(boList));
        }
//        boList.forEach(bo -> {
//            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
//            bo.setCount(subjectCount);
//        });
        return boList;
    }

    public Boolean update(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {
        return null;
    }

}
