package com.example.beanlifecycle.methodTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : KaelvihN
 * @date : 2023/8/12 15:11
 */
public class MyBeanFactory {
    private List<BeanPostprocessor> postprocessors = new ArrayList<>();

    public Object getBean() {
        Object bean = new Object();
        System.out.println("实例化bean" + bean);
        System.out.println("依赖注入" + bean);
        for (BeanPostprocessor postprocessor : postprocessors) {
            postprocessor.inject(bean);
        }
        System.out.println("初始化bean" + bean);
        return bean;
    }

    public void addBeanPostProcessor(BeanPostprocessor beanPostprocessor) {
        postprocessors.add(beanPostprocessor);
    }

}
