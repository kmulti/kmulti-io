package kmulti.io

/**
 * @author Andrew Bissell
 */

expect interface Closeable {
    fun close()
}

expect inline fun <T : Closeable?, R> T.use(block: (T) -> R): R
