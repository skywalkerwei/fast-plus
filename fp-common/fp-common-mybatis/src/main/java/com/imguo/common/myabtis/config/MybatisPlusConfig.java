package com.imguo.common.myabtis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 统一配置
 *
 */
@Configuration
@MapperScan("com.imguo.service.*.dao")
public class MybatisPlusConfig {
  /**
   * 使用多个功能需要注意顺序关系,建议使用如下顺序
   *
   * <p>多租户,动态表名 分页,乐观锁 sql 性能规范,防止全表更新与删除 总结: 对 sql 进行单次改造的优先放入,不对 sql 进行改造的最后放入
   *
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 分页插件
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    // 乐观锁
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    // 防止全表更新与删除
    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
    return interceptor;
  }
}
