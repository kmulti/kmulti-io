package kmulti.io

import kotlin.io.use as kotlinJvmUse

/**
 * @author Andrew Bissell
 */

actual typealias Closeable = java.io.Closeable

actual inline fun <T : Closeable?, R> T.use(block: (T) -> R): R = this.kotlinJvmUse(block)
