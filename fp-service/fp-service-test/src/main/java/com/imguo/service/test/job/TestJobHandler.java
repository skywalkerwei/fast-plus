package com.imguo.service.test.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 测试xxljob任务
 *
 */
@Component
public class TestJobHandler {

  /** 1、简单任务示例（Bean模式）方法形式 */
  @XxlJob("testJobHandler")
  public void testJobHandler() throws Exception {
    XxlJobHelper.log("XXL-JOB, Hello World.");

    for (int i = 0; i < 5; i++) {
      XxlJobHelper.log("beat at:" + i);
      TimeUnit.SECONDS.sleep(2);
    }
    // default success
  }
}
