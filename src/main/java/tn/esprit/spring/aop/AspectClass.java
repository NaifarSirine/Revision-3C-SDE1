package tn.esprit.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
// La classe : Aspect
public class AspectClass {
    // La méthode : Advice
    @AfterThrowing("execution(* tn.esprit.spring.services.AppService.ajouterTicketsEtAffecterAEvenementEtInternaute(..))")
    // l'expression : JoinPoint
    // @Before , @After, @AfterReturning , ... -> Le type d'advice
    // JoinPoint + Le type d'advice -> PointCut
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Le nombre de places restantes dépasse le nombre de tickets demandés");
    }
}
