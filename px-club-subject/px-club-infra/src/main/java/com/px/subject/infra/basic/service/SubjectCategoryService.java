package com.px.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.px.subject.infra.basic.entity.SubjectCategory;

import java.util.List;


/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2025-03-09 12:01:40
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询岗位大类
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);


    Integer querySubjectCount(Long id);

}
