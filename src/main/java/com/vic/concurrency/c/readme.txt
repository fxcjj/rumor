1. Thread类中的两个过期方法
/**
 * Suspends this thread.
 * <p>
 * First, the <code>checkAccess</code> method of this thread is called with no arguments.
 * This may result in throwing a <code>SecurityException </code>(in the current thread).
 * <p>
 * If the thread is alive, it is suspended and makes no further
 * progress unless and until it is resumed.
 *
 * @exception  SecurityException  if the current thread cannot modify this thread.
 * @see #checkAccess
 * @deprecated   This method has been deprecated, as it is
 *   inherently deadlock-prone.  If the target thread holds a lock on the
 *   monitor protecting a critical system resource when it is suspended, no
 *   thread can access this resource until the target thread is resumed. If
 *   the thread that would resume the target thread attempts to lock this
 *   monitor prior to calling <code>resume</code>, deadlock results.  Such
 *   deadlocks typically manifest themselves as "frozen" processes.
 *   For more information, see
 *   <a href="{@docRoot}/../technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *   are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 */
@Deprecated
public final void suspend() {
    checkAccess();
    suspend0();
}

/**
 * Resumes a suspended thread.
 * <p>
 * First, the <code>checkAccess</code> method of this thread is called with no arguments.
 * This may result in throwing a
 * <code>SecurityException</code> (in the current thread).
 * <p>
 * If the thread is alive but suspended, it is resumed and is
 * permitted to make progress in its execution.
 *
 * @exception  SecurityException  if the current thread cannot modify this thread.
 * @see        #checkAccess
 * @see        #suspend()
 * @deprecated This method exists solely for use with {@link #suspend},
 *     which has been deprecated because it is deadlock-prone.
 *     For more information, see
 *     <a href="{@docRoot}/../technotes/guides/concurrency/threadPrimitiveDeprecation.html">Why
 *     are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>.
 */
@Deprecated
public final void resume() {
    checkAccess();
    resume0();
}

2. AlternateSuspendResume
使用标记位控制线程suspend和resume，不靠谱
