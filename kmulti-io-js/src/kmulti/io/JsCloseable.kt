package kmulti.io

/**
 * @author Andrew Bissell
 */

actual interface Closeable {
    actual fun close()
}

/**
 * Lifted from JVM Kotlin source, see https://github.com/JetBrains/kotlin/blob/1.2.40/libraries/stdlib/src/kotlin/io/Closeable.kt
 */
actual inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
    var exception: Throwable? = null
    try {
        return block(this)
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        this.closeFinally(exception)
    }
}

@PublishedApi
internal fun Closeable?.closeFinally(cause: Throwable?) = when {
    this == null -> {}
    cause == null -> close()
    else ->
        try {
            close()
        } catch (closeException: Throwable) {
            // We cannot do anything here, so just catch the Throwable
        }
}
