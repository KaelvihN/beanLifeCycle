package com.example.beanlifecycle.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : KaelvihN
 * @date : 2023/8/11 23:34
 */

/**
 * 模拟Bean的生命周期
 */

@Slf4j
@Component
public class MyBeanProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {


    /**
     * 实例化前
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================实例化前==========================");
        }
        /**
         * 此处返回的对象会覆盖掉原来的Bean
         */
        return null;
    }

    /**
     * 实例化后
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================实例化后==========================");
        }
        /**
         * 此处返回false 会直接跳过依赖注入阶段
         */
        return true;
    }

    /**
     * 依赖注入阶段
     * @Autowried @Value @Resource 都是在此阶段解析
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================依赖注入==========================");
        }
        return pvs;
    }

    /**
     *初始化前
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================初始化前==========================");
        }
        return bean;
    }

    /**
     * 初始化后
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================初始化后==========================");
        }
        return bean;
    }

    /**
     *销毁前
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.info("=======================销毁前==========================");
        }
    }


}
