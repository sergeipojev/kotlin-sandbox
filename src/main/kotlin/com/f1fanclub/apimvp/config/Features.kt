package com.f1fanclub.apimvp.config

import org.togglz.core.annotation.Label
import org.togglz.core.context.FeatureContext

enum class Features {

    @Label("F1 Combined Data Feature")
    F1_COMBINED_DATA,
    ;

    fun isActive(): Boolean = FeatureContext.getFeatureManager().isActive { name }
}
