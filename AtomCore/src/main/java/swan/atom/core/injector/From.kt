package swan.atom.core.injector

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class From(
        val value: Int,
        val canBeNull: Boolean = true,
        val values: Array<String> = []
)