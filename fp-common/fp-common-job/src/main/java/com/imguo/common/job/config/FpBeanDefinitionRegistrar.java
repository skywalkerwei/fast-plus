package com.imguo.common.job.config;

import com.imguo.common.core.constant.SecurityConstants;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
/**
 * 根据注解值动态注入xxlJob配置
 */
public class FpBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    BeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setBeanClassName(XxlJobConfig.class.getName());
    registry.registerBeanDefinition(SecurityConstants.XXLJOB_SERVER_CONFIGURER, beanDefinition);
  }
}
