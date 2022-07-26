package com.imguo.common.job.config;

import com.imguo.common.job.properties.XxlJobProperties;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
/**
 * xxlJob调度任务配置
 *
 */
@AllArgsConstructor
public class XxlJobConfig {
  private final XxlJobProperties xxlJobProperties;

  @Bean
  public XxlJobSpringExecutor xxlJobExecutor() {
    XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
    xxlJobSpringExecutor.setAdminAddresses(xxlJobProperties.getAdminAddresses());
    xxlJobSpringExecutor.setAppname(xxlJobProperties.getAppName());
    xxlJobSpringExecutor.setIp(xxlJobProperties.getIp());
    xxlJobSpringExecutor.setPort(xxlJobProperties.getPort());
    xxlJobSpringExecutor.setAccessToken(xxlJobProperties.getAccessToken());
    xxlJobSpringExecutor.setLogPath(xxlJobProperties.getLogPath());
    xxlJobSpringExecutor.setLogRetentionDays(xxlJobProperties.getLogRetentionDays());
    return xxlJobSpringExecutor;
  }
}
