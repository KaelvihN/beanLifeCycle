package com.example.beanlifecycle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : KaelvihN
 * @date : 2023/8/11 21:49
 */

@Component
@Slf4j
public class LifeCycleBean {
    public LifeCycleBean() {
        log.info("LifeCycleBean 调用构造方法");
    }

    /**
     * 注入的对象需要 动态计算的属性值 需要@value
     */
    @Resource
    public void autowired(@Value("${JAVA_HOME}") String home) {
        log.info("LifeCycleBean 依赖注入{}", home);
    }

    @PostConstruct
    public void init(){
        log.info("LifeCycleBean {}","初始化");
    }

    @PreDestroy
    public void destroy(){
        log.info("LifeCycleBean {}","销毁");
    }
}
