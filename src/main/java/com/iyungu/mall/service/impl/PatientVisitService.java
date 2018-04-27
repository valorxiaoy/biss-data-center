package com.iyungu.mall.service.impl;

import com.iyungu.mall.bean.po.PatientVisit;
import com.iyungu.config.MyBatisUtil;
import com.iyungu.mall.dao.PatientVisitMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 9:56 2018/4/18
 * @Modified By:
 */
public class PatientVisitService {

    private final static Logger logger = Logger.getLogger(PatientVisitService.class);

    public static PatientVisit searchPatientVisit() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PatientVisitMapper mapper = sqlSession.getMapper(PatientVisitMapper.class);
        PatientVisit patientVisit = mapper.selectByPrimaryKey(300);
        MyBatisUtil.closeSession(sqlSession);
        return patientVisit;
    }

}
