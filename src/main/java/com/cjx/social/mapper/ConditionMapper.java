package com.cjx.social.mapper;

import com.cjx.social.entity.Condition;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 17858 on 2018-05-18.
 */
@Mapper
public interface ConditionMapper {
    void addCondition(Condition condition);
}
