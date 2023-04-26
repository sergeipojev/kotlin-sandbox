package com.f1fanclub.apimvp.model

// What are data classes? https://www.baeldung.com/kotlin/data-classes
// Getters and setters? https://www.baeldung.com/kotlin/getters-setters
data class SampleModel(
    // Constructor parameter
    val field1: String = "Hello, World!", // Immutable value
) {
    constructor() : this("Hello, World!") // Secondary constructor

    // Getters and setters
    var field2: String = "Work hard..."
        get() = field // getter
        set(value) { // setter
            field = value
        }

    // Private setter
    var field3: String = "Another string"
        private set
}
