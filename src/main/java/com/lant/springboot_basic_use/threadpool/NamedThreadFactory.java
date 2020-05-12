package com.lant.springboot_basic_use.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂类: 用于创建线程对象
 * @author lyj
 */
public class NamedThreadFactory implements ThreadFactory {

	private static final AtomicInteger threadNumber = new AtomicInteger(1);

	private final AtomicInteger mThreadNum = new AtomicInteger(1);

	private final String prefix;

	private final boolean daemonThread;

	private final ThreadGroup threadGroup;

	public NamedThreadFactory() {
		this("syncserver-threadpool-" + threadNumber.getAndIncrement(), false);
	}

	public NamedThreadFactory(String prefix) {
		this(prefix, false);
	}

	public NamedThreadFactory(String prefix, boolean daemon) {
		this.prefix = prefix + "-thread-";
		this.daemonThread = daemon;
		SecurityManager s = System.getSecurityManager();
		threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		String name = prefix + mThreadNum.getAndIncrement();
		Thread ret = new Thread(threadGroup, runnable, name, 0);
		ret.setDaemon(daemonThread);
		return ret;
	}

	public ThreadGroup getThreadGroup() {
		return threadGroup;
	}

}
