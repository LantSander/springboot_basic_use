import com.lant.springboot_basic_use.SpringbootBasicUseApplication;
import com.lant.springboot_basic_use.task.OrderTask;
import com.lant.springboot_basic_use.threadpool.AbortPolicyWithReport;
import com.lant.springboot_basic_use.threadpool.NamedThreadFactory;
import com.lant.springboot_basic_use.threadpool.SyncThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@SpringBootTest(classes = SpringbootBasicUseApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ThreadPoolTest {
    /*
    *
    * corePoolSize：
线程池的基本大小，即在没有任务需要执行的时候线程池的大小，并且只有在工作队列满了的情况下才会创建超出这个数量的线程。这里需要注意的是：在刚刚创建ThreadPoolExecutor的时候，线程并不会立即启动，而是要等到有任务提交时才会启动，除非调用了prestartCoreThread/prestartAllCoreThreads事先启动核心线程。再考虑到keepAliveTime和allowCoreThreadTimeOut超时参数的影响，所以没有任务需要执行的时候，线程池的大小不一定是corePoolSize。
maximumPoolSize：
线程池中允许的最大线程数，线程池中的当前线程数目不会超过该值。如果队列中任务已满，并且当前线程个数小于maximumPoolSize，那么会创建新的线程来执行任务。这里值得一提的是largestPoolSize，该变量记录了线程池在整个生命周期中曾经出现的最大线程个数。为什么说是曾经呢？因为线程池创建之后，可以调用setMaximumPoolSize()改变运行的最大线程的数目。
poolSize：
线程池中当前线程的数量，当该值为0的时候，意味着没有任何线程，线程池会终止；同一时刻，poolSize不会超过maximumPoolSize。
现在我们通过ThreadPoolExecutor.execute()方法，看一下这3个属性的关系，以及线程池如何处理新提交的任务。以下源码基于JDK1.6.0_37版本。
    *
    *
    * */

/*
* 如果当前线程池的线程数还没有达到基本大小(poolSize < corePoolSize)，无论是否有空闲的线程新增一个线程处理新提交的任务；
2、如果当前线程池的线程数大于或等于基本大小(poolSize >= corePoolSize) 且任务队列未满时，就将新提交的任务提交到阻塞队列排队，等候处理workQueue.offer(command)；
3、如果当前线程池的线程数大于或等于基本大小(poolSize >= corePoolSize) 且任务队列满时；
3.1、当前poolSize<maximumPoolSize，那么就新增线程来处理任务；
3.2、当前poolSize=maximumPoolSize，那么意味着线程池的处理能力已经达到了极限，此时需要拒绝新增加的任务。至于如何拒绝处理新增的任务，取决于线程池的饱和策略RejectedExecutionHandler。
*
* */

    @Test
    public void tesf(){
       // ThreadPoolExecutor executor = SyncThreadPool.getExecutor(1, -1);
        BlockingQueue<Runnable> workQueue;
        //workQueue=new LinkedBlockingQueue<>(98);
       // workQueue=new LinkedBlockingQueue<>(2);

        /*
         * workQueue=new SynchronousQueue<>();
         * 使用SynchronousQueue，一般要设置maximumPoolSize=Integer.MAX_VALUE，因为SynchronousQueue不存任务
        * */
//        ThreadPoolExecutor executor =
//       new ThreadPoolExecutor(10,Integer.MAX_VALUE , 0, TimeUnit.MILLISECONDS, workQueue ,
//                new NamedThreadFactory("orderInfo", true), new AbortPolicyWithReport("orderInfo"));

        workQueue=new LinkedBlockingQueue<>();
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(16,20 , 0, TimeUnit.MILLISECONDS, workQueue ,
                        new NamedThreadFactory("orderInfo", true), new AbortPolicyWithReport("orderInfo"));



        for (int i = 0; i <100000000 ; i++) {
            executor.submit(new OrderTask(""+i));
        }
    }

    @Test
    public void test2(){
        ThreadPoolExecutor executor = SyncThreadPool.getExecutor(16, -1);
        for (int i = 0; i <100000000 ; i++) {
            executor.submit(new OrderTask(""+i));
        }



    }


}
