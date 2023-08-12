package com.example.beanlifecycle.methodTemplate;

/**
 * @author : KaelvihN
 * @date : 2023/8/12 15:10
 */
public class TestMethodTemplate {
    public static void main(String[] args) {
        MyBeanFactory beanFactory = new MyBeanFactory();
        beanFactory.addBeanPostProcessor(bean ->
                System.out.println("解析 @Autowired")
        );
        beanFactory.addBeanPostProcessor(bean ->
                System.out.println("解析 @Resource")
        );
        beanFactory.getBean();
    }
}
