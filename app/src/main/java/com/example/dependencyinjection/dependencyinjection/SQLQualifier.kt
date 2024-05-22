package com.example.dependencyinjection.dependencyinjection

import javax.inject.Qualifier


// Qualifiers  :- A qualifier is a custom annotation that will be used to identify a dependency.

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SQLQualifier