package spring5aop.aspects;

import java.time.LocalTime;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MeasureTimeAspect {

    @Around("@annotation(MeasureTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalTime timeBefore = LocalTime.now();

        Object result = joinPoint.proceed();

        LocalTime timeAfter = LocalTime.now();

        int delta = timeAfter.getNano() - timeBefore.getNano();

        log.info(String.format("Call time of %s is %s.", joinPoint.getSignature().getName(), delta));

        return result;
    }
}
