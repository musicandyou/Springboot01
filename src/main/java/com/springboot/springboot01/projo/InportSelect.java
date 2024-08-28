package com.springboot.springboot01.projo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author 韩先楚
 */
public class InportSelect implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.springboot.springboot01.Config.Bean"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
