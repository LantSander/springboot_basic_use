package com.lant.springboot_basic_use.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 同步服务业务处理线程池
 * @author lyj
 */
public class SyncThreadPool {

	/**
	 * 生成指定线程大小的线程池，根据队列大小设置其任务队列模式;
	 * @param threads 工作线程数量
	 * @param capacity 任务队列大小: 
	 *     如果=0,设置任务队列为同步队列;
	 *     如果<0,设置任务队列为
	 * @return
	 */
	public static ThreadPoolExecutor getExecutor(int threads, int capacity) {
		String name = "SyncThreadPool";
		
		BlockingQueue<Runnable> workQueue;
		if(capacity == 0) {
			//同步队列:默认对顺序没有保证
			workQueue = new SynchronousQueue<Runnable>();
		} else if(capacity < 0) {
			//链式阻塞FIFO任务队列,最大容量=Integer.MAX_VALUE
			workQueue = new LinkedBlockingQueue<Runnable>();
		} else {
			//链式阻塞FIFO任务队列,最大容量=capacity
			workQueue = new LinkedBlockingQueue<Runnable>(capacity);
		}



		/*
		* ThreadPoolExecutor类的说明
		* 序号	名称				类型		含义
			1	corePoolSize	int	核心线程池大小
			2	maximumPoolSize	int	最大线程池大小
			3	keepAliveTime	long	线程最大空闲时间
			4	unit	TimeUnit	时间单位
			5	workQueue	BlockingQueue<Runnable>	线程等待队列
			6	threadFactory	ThreadFactory	线程创建工厂
			7	handler	RejectedExecutionHandler	拒绝策略
		*
		* */
		return new ThreadPoolExecutor(threads, threads, 0, TimeUnit.MILLISECONDS, workQueue,
			new NamedThreadFactory(name, true), new AbortPolicyWithReport(name));
	}
}
