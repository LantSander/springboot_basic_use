package com.lant.springboot_basic_use.threadpool;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class AbortPolicyWithReport extends ThreadPoolExecutor.AbortPolicy {
	
	private final String threadName;

	public AbortPolicyWithReport(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
		String msg = String.format("拒绝创建线程-----RpcServer["
				+ " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d),"
				+ " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)]",
				threadName, e.getPoolSize(), e.getActiveCount(), e.getCorePoolSize(), e.getMaximumPoolSize(), e.getLargestPoolSize(),
				e.getTaskCount(), e.getCompletedTaskCount(), e.isShutdown(), e.isTerminated(), e.isTerminating());
		System.out.println(msg);
		throw new RejectedExecutionException(msg);
	}

}
