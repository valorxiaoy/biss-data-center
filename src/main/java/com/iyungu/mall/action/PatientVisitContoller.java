package com.iyungu.mall.action;

import com.iyungu.annotation.RequestMapping;
import com.iyungu.annotation.RestController;
import com.iyungu.mall.bean.po.PatientVisit;
import com.iyungu.ApiGateway;
import com.iyungu.mall.service.impl.PatientVisitService;
import io.vertx.ext.web.RoutingContext;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 13:32 2018/4/18
 * @Modified By:
 */
@RestController
public class PatientVisitContoller {

    @RequestMapping(value = "searchPatientVisit")
    public PatientVisit searchPatientVisit() {
        PatientVisit patientVisit = PatientVisitService.searchPatientVisit();
        return patientVisit;
    }

}
