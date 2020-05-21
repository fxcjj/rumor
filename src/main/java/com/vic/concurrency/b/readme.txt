SleepInterrupt1
1. 输出结果
1) in run() - about to sleep for 20 seconds
2) in main() - interrupting other thread
3) in main() - leaving
4) in run() - interrupted while sleeping
第1,2行顺序确定，3,4顺序不确定，取决于主线程和新线程哪个先消亡。
2. t.interrupt()方法中断线程，处于休眠状态的线程t将会被中断，同时抛出异常并重置中断标志为false
3. 如果catch块中没有return，方法会继续执行，打印in run() - leaving normally

PendingInterrupt2
1. 如果线程在调用sleep()方法前被中断，那么该中断称为待决中断，它会在刚调用sleep()方法时，立即抛出InterruptedException异常
2. 无参数时
线程不会被中断，休眠2000毫秒，最终输出的时间差距应该在2000毫秒附近
3. 有参数时
线程中断，当调用sleep()方法抛出异常，最终输出的时间差距应该远小于2000毫秒

InterruptCheck3
1. 线程一旦被中断（即调用interrupt()方法），在未调用sleep()方法之前，isInterrupted()方法返回都为true，
而一旦调用sleep()方法抛出异常后，中断标志被清空，此时调用isInterrupted()方法将返回false

InterruptReset4
1. 调用Thread.interrupted()方法会隐式重置中断状态为false

JoinTest5.java
join方法用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。
yield可以直接用Thread类调用，yield让出CPU执行权给同等级的线程，如果没有相同级别的线程在等待CPU的执行权，则该线程继续执行。
