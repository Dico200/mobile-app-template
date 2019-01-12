import org.gradle.api.NamedDomainObjectCollection
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.resources.ResourceHandler
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinTargetPreset
import org.jetbrains.kotlin.gradle.plugin.mpp.*

internal typealias Presets = NamedDomainObjectCollection<KotlinTargetPreset<*>>
internal typealias Targets = NamedDomainObjectCollection<KotlinTarget>
internal typealias NativeCompilations = NamedDomainObjectCollection<KotlinNativeCompilation>

val Presets.jvm get() = this["jvm"] as KotlinJvmTargetPreset
val Presets.js get() = this["js"] as KotlinJsTargetPreset
val Presets.linuxX64 get() = this["linuxX64"] as KotlinNativeTargetPreset
val Presets.macosX64 get() = this["macosX64"] as KotlinNativeTargetPreset
val Presets.mingwX64 get() = this["mingwX64"] as KotlinNativeTargetPreset
val Presets.iosX64 get() = this["iosX64"] as KotlinNativeTargetPreset
val Targets.native get() = this["native"] as KotlinNativeTarget
val NativeCompilations.main get() = this["main"]



fun KotlinMultiplatformExtension.`sourceSets`(configure: org.gradle.api.NamedDomainObjectContainer<org.jetbrains.kotlin.gradle.plugin.sources.DefaultKotlinSourceSet>.() -> Unit): Unit =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("sourceSets", configure)

fun KotlinMultiplatformExtension.`targets`(configure: org.gradle.api.NamedDomainObjectContainer<org.jetbrains.kotlin.gradle.plugin.KotlinTarget>.() -> Unit): Unit =
        (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("targets", configure)

fun <T : KotlinTarget> Targets.fromPreset(preset: KotlinTargetPreset<T>, name: String, handler: T.() -> Unit = {}): T {
    val target = preset.createTarget(name)
    add(target)
    handler(target)
    return target
}

internal val hostOs by lazy { System.getProperty("os.name") }

val isLinux by lazy { hostOs == "Linux" }
val isMacos by lazy { hostOs == "Mac OS X" }
val isWindows by lazy { hostOs.startsWith("Windows") }

val NamedDomainObjectCollection<KotlinTargetPreset<*>>.host get() = when {
    isLinux -> linuxX64
    isMacos -> macosX64
    isWindows -> mingwX64
    else -> error("Unknown host platform '$hostOs'")
}
