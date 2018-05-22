package com.cjx.social.service.Impl;

import com.cjx.social.entity.Condition;
import com.cjx.social.mapper.ConditionMapper;
import com.cjx.social.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 17858 on 2018-05-18.
 */
@Service
public class ConditionServiceImpl implements ConditionService {

    @Autowired
    ConditionMapper conditionMapper;

    @Override
    public void addCondition1(Condition condition){
        conditionMapper.addCondition(condition);
    }

}
