tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

tasks.register("testAll") {
    description = "Run tests in all modules"
    group = "verification"

    subprojects {
        tasks.findByName("test")?.let {
            this@register.dependsOn(it)
        }
    }
}
