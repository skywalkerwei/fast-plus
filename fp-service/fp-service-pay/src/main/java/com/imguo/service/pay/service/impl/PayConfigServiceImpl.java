package com.imguo.service.pay.service.impl;

import com.imguo.model.common.service.impl.BaseServiceImpl;
import com.imguo.model.pay.entity.PayConfigEntity;
import com.imguo.service.pay.dao.PayConfigDao;
import com.imguo.service.pay.service.PayConfigService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PayConfigServiceImpl extends BaseServiceImpl<PayConfigDao, PayConfigEntity> implements PayConfigService {



}
