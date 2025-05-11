import org.gradle.api.Project

@Suppress("UnstableApiUsage")
internal fun Project.git(vararg command: String): String {
    return this.providers.exec {
        commandLine("git", *command)
        this.workingDir = this@git.rootDir
    }.standardOutput.asText.get().trim()
}
