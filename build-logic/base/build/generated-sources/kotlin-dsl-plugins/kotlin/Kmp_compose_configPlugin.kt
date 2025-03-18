/**
 * Precompiled [kmp.compose.config.gradle.kts][Kmp_compose_config_gradle] script plugin.
 *
 * @see Kmp_compose_config_gradle
 */
public
class Kmp_compose_configPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Kmp_compose_config_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
