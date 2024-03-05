//package com.atradius.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.core.Ordered;
//import org.springframework.dao.PessimisticLockingFailureException;
//
//@Aspect
//public class ConcurrentOperationExecutor implements Ordered {
//
//    private static final int DEFAULT_MAX_RETRIES = 2;
//
//    private int maxRetries = DEFAULT_MAX_RETRIES;
//    private int order = 1;
//
//    public void setMaxRetries(int maxRetries) {
//        this.maxRetries = maxRetries;
//    }
//
//    public int getOrder() {
//        return this.order;
//    }
//
//    public void setOrder(int order) {
//        this.order = order;
//    }
//
////    @Around("com.xyz.CommonPointcuts.businessService()")
//    @Around("org.springframework.kafka.core.KafkaTemplate.send(..)")
//    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
//        int numAttempts = 0;
//        PessimisticLockingFailureException lockFailureException;
//        do {
//            numAttempts++;
//            try {
//                return pjp.proceed();
//            }
//            catch(PessimisticLockingFailureException ex) {
//                lockFailureException = ex;
//            }
//        } while(numAttempts <= this.maxRetries);
//        throw lockFailureException;
//    }
//}