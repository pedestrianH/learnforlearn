Java基础001基本类型，语法，关键字https://refactoringguru.cn/design-patterns/abstract-factory/java/example#example-0https://github.com/he2121/MyRPCFromZerohttps://keafmd.blog.csdn.net/基本类型Java的基本数据类型有引用数据类型和基本数据类型基本数据类型主要有 int long boolean char byte float double  short引用数据类型主要有以上基本数据类型的包装类   Byte, Short, Integer, Long, Character, Boolean, Float, Double语法访问控制权限private私有的 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）protected收到保护的对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）public共有的对所有类可见。使用对象：类、接口、变量、方法缺省在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法值传递与引用数据传递其实这里的这个 str = "XXX"; 相当于 str = new String("XXX") 相当于在这个字符串常量池中新建了XXX对象str首先的地址复制实参过来 相当于有两条引用指针指向了 "abc"再然后  执行str = "XXX" 复制过来的指针指向了"XXX"   原来的指针任然指向了 "abc" 因此未改变实际内容数据class Person {
    private Integer id;
    private String personName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }


    public Person (String personName){
        this.personName = personName;

    }
}
public class Test1 {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("XX");
    }
    public void changeValue3(String str) {
        str = "XXX";
    }

    public static void main(String[] args) {
        Test1 test = new Test1();

        // 定义基本数据类型
        int age = 20;
        test.changeValue1(age);
        System.out.println("age ----" + age);

        // 实例化person类
        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName-----" + person.getPersonName());

        // String
        String str = "abc";
        test.changeValue3(str);
        System.out.println("string-----" + str);

    }
结果因为基本数据类型为值传递 在传参的时候会把数据全部复制过去改变引用数据类型在传参的时候会将在栈的引用指针修改指向的数据 相当于原来的值也被改变了而string类型在字符串常量池中 在改变时其实在Java内部本质都是值传递值传递是传递实参副本，函数修改不会影响实参；引用传递是传递实参地址，函数修改会影响实参。在对象进行传参的时候将对象地址进行了拷贝，且对于引用数据类型判断是否为引用传递为看传递的实参是否被改变，而该对象实参为地址且未改变，因此只能为值传递关键字abstract 私有的 final 修饰常量或者不在改变的数据new创建对象实例Class 修饰类static 静态的extend 继承implement 实现接口类synchronized 修饰同步程序 volatile 修饰原子性的变量return 从方法里结束continue 跳出当次循环 到下次循环的开始处break 跳出现在所处块publicclassTempTest{privatevoidtest1(A a){ a.age = 20; System.out.println("test1方法中的age="+a.age); }publicstaticvoidmain(String[] args){ TempTest t = new TempTest(); A a = new A(); a.age = 10; t.test1(a); System.out.println(”main方法中的age=”+a.age); } }classA{publicint age = 0; }运行结果如下：test1方法中的age=20main方法中的age=204：理解按引用传递的过程——内存分配示意图要想正确理解按引用传递的过程，就必须学会理解内存分配的过程，内存分配示意图可以辅助我们去理解这个过程。用上面的例子来进行分析：（1）：运行开始，运行第8行，创建了一个A的实例，内存分配示意如下：（2）：运行第9行，是修改A实例里面的age的值，运行后内存分配示意如下：（3）：运行第10行，是把main方法中的变量a所引用的内存空间地址，按引用传递给test1方法中的a变量。请注意：这两个a变量是完全不同的，不要被名称相同所蒙蔽。内存分配示意如下：由于是按引用传递，也就是传递的是内存空间的地址，所以传递完成后形成的新的内存示意图如下：也就是说：是两个变量都指向同一个空间。（4）：运行第3行，为test1方法中的变量a指向的A实例的age进行赋值，完成后形成的新的内存示意图如下：此时A实例的age值的变化是由test1方法引起的（5）：运行第4行，根据此时的内存示意图，输出test1方法中的age=20（6）：运行第11行，根据此时的内存示意图，输出main方法中的age=205：对上述例子的改变理解了上面的例子，可能有人会问，那么能不能让按照引用传递的值，相互不影响呢？就是test1方法里面的修改不影响到main方法里面呢？方法是在test1方法里面新new一个实例就可以了。改变成下面的例子，其中第3行为新加的：publicclassTempTest{privatevoidtest1(A a){ a = new A();//新加的一行 a.age = 20; System.out.println("test1方法中的age="+a.age); }publicstaticvoidmain(String[] args){ TempTest t = new TempTest(); A a = new A(); a.age = 10; t.test1(a); System.out.println(”main方法中的age=”+a.age); }}classA{publicint age = 0;}运行结果为：test1方法中的age=20main方法中的age=10为什么这次的运行结果和前面的例子不一样呢，还是使用内存示意图来理解一下6：再次理解按引用传递（1）：运行开始，运行第9行，创建了一个A的实例，内存分配示意如下：（2）：运行第10行，是修改A实例里面的age的值，运行后内存分配示意如下：（3）：运行第11行，是把main方法中的变量a所引用的内存空间地址，按引用传递给test1方法中的a变量。请注意：这两个a变量是完全不同的，不要被名称相同所蒙蔽。内存分配示意如下：由于是按引用传递，也就是传递的是内存空间的地址，所以传递完成后形成的新的内存示意图如下：也就是说：是两个变量都指向同一个空间。（4）：运行第3行，为test1方法中的变量a重新生成了新的A实例的，完成后形成的新的内存示意图如下：（5）：运行第4行，为test1方法中的变量a指向的新的A实例的age进行赋值，完成后形成的新的内存示意图如下：注意：这个时候test1方法中的变量a的age被改变，而main方法中的是没有改变的。（6）：运行第5行，根据此时的内存示意图，输出test1方法中的age=20（7）：运行第12行，根据此时的内存示意图，输出main方法中的age=10多态深入public class Test1 {

    public static void main(String[] args) {
        A a = new B();
        a.update(11);
        a.change("c");
        a.getC();

    }
}


class B extends A{
    @Override
    public void update(int n) {
        System.out.println("执行了");
    }
public void getC(){
    System.out.println("独有");
}

}
class A{
    private int  age;
    private String n;
    public void update(int n){
        n++;
    }
    public void change(String n){
        System.out.println("a");
    }
}结果        a.getC();爆红编译未通过多态指的是父类的引用指向子类的实例对象 且只能够调用子类和父类共有的方法在类之间的多态实现时会在子类的方法表中查找运行的是哪个方法，因为方法表有指向父类sendA的指针 也有指向子类sendA方法的指针，会进行覆盖为子类的方法而在接口之间的多态实现中，要搜索父类的整个方法表找到想要的String类操作字符串的类有：String、StringBuffer、StringBuilder。  String 和 StringBuffer、StringBuilder 的区别在于 String 声明的是不可变的对象，每次操作都会生成新的 String 对象，然后将指针指向新的 String 对象，而 StringBuffer、StringBuilder 可以在原有对象的基础上进行操作，所以在经常改变字符串内容的情况下最好不要使用 String。  而StringBuffer 和 StringBuilder 最大的区别在于，StringBuffer 是线程安全的，而 StringBuilder 是非线程安全的，但 StringBuilder 的性能却高于 StringBuffer，所以在单线程环境下推荐使用 StringBuilder，多线程环境下推荐使用 StringBufferStringBuffer任何对它指向的字符串的操作都不会产生新的对象。每个StringBuffer对象都有一定的缓冲区容量，字符串大小没有超过容量时，不会分配新的容量，当字符串大小超过容量时，自动扩容002 安装jdk配置好了003 serverlet，jsp004 多线程多线程操作公共资源数据时public class Test1 {

    public static void main(String[] args) {
        A a = new A();
        for (int i = 0; i < 11; i++) {
            new Thread(() ->{
                for (int j = 0; j <990 ; j++) {
                    a.add();
                }
            },("线程"+i)).start();
        }

        //保证线程执行完毕
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.b);
    }
}


class A {
      int b = 1;
    public   void add(){
          this.b++;
      }
}结果jmm内存的本质不会有可见性 拷贝主内存到工作内存中循环打印abcimport java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    顺序循环打印AA打印5次，BB打印10次，CC打印15次来10轮
    * */
    class ShareResource {
        // A 1   B 2   c 3
        private int number = 1;
        // 创建一个重入锁
        private Lock lock = new ReentrantLock();

        // 这三个相当于备用钥匙
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();


        public void print5() {
            lock.lock();
            try {
                // 判断
                while(number != 1) {
                    // 不等于1，需要等待
                    condition1.await();
                }

                // 干活
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }

                // 唤醒 （干完活后，需要通知B线程执行）
                number = 2;
                // 通知2号去干活了
                condition2.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print10() {
            lock.lock();
            try {
                // 判断
                while(number != 2) {
                    // 不等于1，需要等待
                    condition2.await();
                }

                // 干活
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }

                // 唤醒 （干完活后，需要通知C线程执行）
                number = 3;
                // 通知2号去干活了
                condition3.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print15() {
            lock.lock();
            try {
                // 判断
                while(number != 3) {
                    // 不等于1，需要等待
                    condition3.await();
                }

                // 干活
                for (int i = 0; i < 15; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }

                // 唤醒 （干完活后，需要通知C线程执行）
                number = 1;
                // 通知1号去干活了
                condition1.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public class T1 {

        public static void main(String[] args) {

            ShareResource shareResource = new ShareResource();

            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    shareResource.print5();
                }
            }, "A").start();

            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    shareResource.print10();
                }
            }, "B").start();

            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    shareResource.print15();
                }
            }, "C").start();
        }
    }

结果A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14
A	 1	0
A	 1	1
A	 1	2
A	 1	3
A	 1	4
B	 2	0
B	 2	1
B	 2	2
B	 2	3
B	 2	4
B	 2	5
B	 2	6
B	 2	7
B	 2	8
B	 2	9
C	 3	0
C	 3	1
C	 3	2
C	 3	3
C	 3	4
C	 3	5
C	 3	6
C	 3	7
C	 3	8
C	 3	9
C	 3	10
C	 3	11
C	 3	12
C	 3	13
C	 3	14


因为有了这个lock的condition通知机制保证了顺序执行，利用number为变化的数据synchronizedentrylist存储进入的线程 waitset存储等待的线程重量级修饰锁 参考原理https://aobing.blog.csdn.net/article/details/106180781分布式锁zookeeper当有多个线程来共同访问共享资源时会有问题 加上同步锁sync，lock能够解决单机版的开发但在分布式的部署下，不同的的服务器线程来访问其实这里能够利用zk节点有个唯一的特性，就是我们创建过这个节点了，你再创建zk是会报错加上顺序临时节点参考实现https://aobing.blog.csdn.net/article/details/105352672CASABA参考实现https://aobing.blog.csdn.net/article/details/104691668进程线程之间的同步机制互斥：互斥的机制，保证同一时间只有一个线程可以操作共享资源 synchronized，Lock等。临界值：让多线程串行话去访问资源事件通知：通过事件的通知去保证大家都有序访问共享资源信号量：多个任务同时访问，同时限制数量，比如发令枪CDL，Semaphore等volatilethreadlocallockrunnable实现runnable接口来callable继承thread不能够达到资源共享实现接口会更好一些，因为：●Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；●用同一个Runnable实例对象创建多个线程，这多个线程可以共享Runnable实例对象中的成员变量和类变量，而用Thread对象创建的线程只能共享实例变量。taskthreadfutureautomicconcurrenthashmapput/*
     * 当添加一对键值对的时候，首先会去判断保存这些键值对的数组是不是初始化了，
     * 如果没有的话就初始化数组
     *  然后通过计算hash值来确定放在数组的哪个位置
     * 如果这个位置为空则直接添加，如果不为空的话，则取出这个节点来
     * 如果取出来的节点的hash值是MOVED(-1)的话，则表示当前正在对这个数组进行扩容，复制到新的数组，则当前线程也去帮助复制
     * 最后一种情况就是，如果这个节点，不为空，也不在扩容，则通过synchronized来加锁，进行添加操作
     *    然后判断当前取出的节点位置存放的是链表还是树
     *    如果是链表的话，则遍历整个链表，直到取出来的节点的key来个要放的key进行比较，如果key相等，并且key的hash值也相等的话，
     *          则说明是同一个key，则覆盖掉value，否则的话则添加到链表的末尾
     *    如果是树的话，则调用putTreeVal方法把这个元素添加到树中去
     *  最后在添加完成之后，会判断在该节点处共有多少个节点（注意是添加前的个数），如果达到8个以上了的话，
     *  则调用treeifyBin方法来尝试将处的链表转为树，或者扩容数组
     */
    final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();//K,V都不能为空，否则的话跑出异常
        int hash = spread(key.hashCode());    //取得key的hash值
        int binCount = 0;    //用来计算在这个节点总共有多少个元素，用来控制扩容或者转移为树
        for (Node<K,V>[] tab = table;;) {    //
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)    
                tab = initTable();    //第一次put的时候table没有初始化，则初始化table
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {    //通过哈希计算出一个表中的位置因为n是数组的长度，所以(n-1)&hash肯定不会出现数组越界
                if (casTabAt(tab, i, null,        //如果这个位置没有元素的话，则通过cas的方式尝试添加，注意这个时候是没有加锁的
                             new Node<K,V>(hash, key, value, null)))        //创建一个Node添加到数组中区，null表示的是下一个节点为空
                    break;                   // no lock when adding to empty bin
            }
            /*
             * 如果检测到某个节点的hash值是MOVED，则表示正在进行数组扩张的数据复制阶段，
             * 则当前线程也会参与去复制，通过允许多线程复制的功能，一次来减少数组的复制所带来的性能损失
             */
            else if ((fh = f.hash) == MOVED)    
                tab = helpTransfer(tab, f);
            else {
                /*
                 * 如果在这个位置有元素的话，就采用synchronized的方式加锁，
                 *     如果是链表的话(hash大于0)，就对这个链表的所有元素进行遍历，
                 *         如果找到了key和key的hash值都一样的节点，则把它的值替换到
                 *         如果没找到的话，则添加在链表的最后面
                 *  否则，是树的话，则调用putTreeVal方法添加到树中去
                 *  
                 *  在添加完之后，会对该节点上关联的的数目进行判断，
                 *  如果在8个以上的话，则会调用treeifyBin方法，来尝试转化为树，或者是扩容
                 */
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {        //再次取出要存储的位置的元素，跟前面取出来的比较
                        if (fh >= 0) {                //取出来的元素的hash值大于0，当转换为树之后，hash值为-2
                            binCount = 1;            
                            for (Node<K,V> e = f;; ++binCount) {    //遍历这个链表
                                K ek;
                                if (e.hash == hash &&        //要存的元素的hash，key跟要存储的位置的节点的相同的时候，替换掉该节点的value即可
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)        //当使用putIfAbsent的时候，只有在这个key没有设置值得时候才设置
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {    //如果不是同样的hash，同样的key的时候，则判断该节点的下一个节点是否为空，
                                    pred.next = new Node<K,V>(hash, key,        //为空的话把这个要加入的节点设置为当前节点的下一个节点
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {    //表示已经转化成红黑树类型了
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,    //调用putTreeVal方法，将该元素添加到树中去
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)    //当在同一个节点的数目达到8个的时候，则扩张数组或将给节点的数据转为tree
                        treeifyBin(tab, i);    
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);    //计数
        return null;
    }
扩容在put方法的详解中，我们可以看到，在同一个节点的个数超过8个的时候，会调用treeifyBin方法来看看是扩容还是转化为一棵树同时在每次添加完元素的addCount方法中，也会判断当前数组中的元素是否达到了sizeCtl的量，如果达到了的话，则会进入transfer方法去扩容/**
     * Replaces all linked nodes in bin at given index unless table is
     * too small, in which case resizes instead.
     * 当数组长度小于64的时候，扩张数组长度一倍，否则的话把链表转为树
     */
    private final void treeifyBin(Node<K,V>[] tab, int index) {
        Node<K,V> b; int n, sc;
        if (tab != null) {
                System.out.println("treeifyBin方\t==>数组长："+tab.length);
            if ((n = tab.length) < MIN_TREEIFY_CAPACITY)    //MIN_TREEIFY_CAPACITY 64
                tryPresize(n << 1);        // 数组扩容
            else if ((b = tabAt(tab, index)) != null && b.hash >= 0) {
                synchronized (b) {    //使用synchronized同步器，将该节点出的链表转为树
                    if (tabAt(tab, index) == b) {
                        TreeNode<K,V> hd = null, tl = null;    //hd：树的头(head)
                        for (Node<K,V> e = b; e != null; e = e.next) {
                            TreeNode<K,V> p =
                                new TreeNode<K,V>(e.hash, e.key, e.val,
                                                  null, null);
                            if ((p.prev = tl) == null)        //把Node组成的链表，转化为TreeNode的链表，头结点任然放在相同的位置
                                hd = p;    //设置head
                            else
                                tl.next = p;
                            tl = p;
                        }
                        setTabAt(tab, index, new TreeBin<K,V>(hd));//把TreeNode的链表放入容器TreeBin中
                    }
                }
            }
        }
    }线程池详细讲解其原理为（1）直接申请线程执行该任务；（2）缓冲到队列中等待线程执行；（3）拒绝该任务。线程管理部分是消费者，它们被统一维护在线程池内，根据任务请求进行线程的分配，当线程执行完任务后则会继续获取新的任务去执行，最终当线程获取不到任务的时候，线程就会被回收周期管理 由内部来维护。线程池内部使用一个变量维护两个值：运行状态 (runState) 和线程数量 (workerCount)  程序private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
 ctl 这个 AtomicInteger 类型，是对线程池的运行状态和线程池中有效线程的数量 进行控制的一个字段，它同时包含两部分的信息：线程池的运行状态 (runState) 和 线程池内有效线程的数量 (workerCount)，高 3 位保存 runState，低 29 位保存 workerCount，两个变量之间互不干扰。用一个变量去存储两个值，可避免在做相关 决策时，出现不一致的情况，不必为了维护两者的一致，而占用锁资源。  计算现在的运行信息private static int runStateOf(int c) { return c & ~CAPACITY; } // 计
算当前运行状态
private static int workerCountOf(int c) { return c & CAPACITY; } //
计算当前线程数量
private static int ctlOf(int rs, int wc) { return rs | wc; } // 通过状
态和线程数生成 ctl变换时间任务调度任务调度是线程池的主要入口，当用户提交了一个任务，接下来这个任务将如何执行都是由这个阶段决定的。了解这部分就相当于了解了线程池的核心运行机制。首先，所有任务的调度都是由 execute 方法完成的，这部分完成的工作是：检查现在线程池的运行状态、运行线程数、运行策略，决定接下来执行的流程，是直接申请线程执行，或是缓冲到队列中执行，亦或是直接拒绝该任务。其执行过程如下：1.	首先检测线程池运行状态，如果不是 RUNNING，则直接拒绝，线程池要保证在 RUNNING 的状态下执行任务。2.	如果 workerCount < corePoolSize，则创建并启动一个线程来执行新提交的任务。3.	如果 workerCount >= corePoolSize，且线程池内的阻塞队列未满，则将任务添加到该阻塞队列中。4.	如 果 workerCount >= corePoolSize && workerCount < maximumPoolSize，且线程池内的阻塞队列已满，则创建并启动一个线程来执行新提交的任务。5.	如果 workerCount >= maximumPoolSize，并且线程池内的阻塞队列已满 ,则根据拒绝策略来处理该任务 , 默认的处理方式是直接抛异常任务缓冲和阻塞队列 在队列为空时，获取元素的线程会等待队列变为非空。当队列满时，存储元素的线程 会等待队列可用。阻塞队列常用于生产者和消费者的场景，生产者是往队列里添加元 素的线程，消费者是从队列里拿元素的线程。阻塞队列就是生产者存放元素的容器 而消费者也只从容器里拿元素  任务申请 由上文的任务分配部分可知，任务的执行有两种可能：一种是任务直接由新创建的线 程执行。另一种是线程从任务队列中获取任务然后执行，执行完任务的空闲线程会再 次去从队列中申请任务再去执行。第一种情况仅出现在线程初始创建的时候，第二种 是线程获取任务绝大多数的情况  获取线程的执行步骤拒绝的策略 任务拒绝模块是线程池的保护部分，线程池有一个最大的容量，当线程池的任务缓存 队列已满，并且线程池中的线程数目达到 maximumPoolSize 时，就需要拒绝掉该 后台 < 11 任务，采取任务拒绝策略，保护线程池  public interface RejectedExecutionHandler {
 void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}Worker 线程管理 线程池为了掌握线程的状态并维护线程的生命周期，设计了线程池内的工作线程  private final class Worker extends AbstractQueuedSynchronizer
implements Runnable{
 final Thread thread;//Worker 持有的线程
 Runnable firstTask;// 初始化的任务，可以为 null
}执行任务情况控制线程的引用 线程池需要管理线程的生命周期，需要在线程长时间不运行的时候进行回收。线程池 使用一张 Hash 表去持有线程的引用，这样可以通过添加引用、移除引用这样的操作 来控制线程的生命周期。这个时候重要的就是如何判断线程是否在运行  Worker 是通过继承 AQS，使用 AQS 来实现独占锁这个功能。没有使用可重入锁ReentrantLock，而是使用 AQS，为的就是实现不可重入的特性去反应线程现在的执行状态。1.	lock 方法一旦获取了独占锁，表示当前线程正在执行任务中。2. 如果正在执行任务，则不应该中断线程。3. 如果该线程现在不是独占锁的状态，也就是空闲的状态，说明它没有在处理任务，这时可以对该线程进行中断。4. 线程池在执行 shutdown 方法或 tryTerminate 方法时会调用 interruptIdleWorkers 方法来中断空闲的线程，interruptIdleWorkers 方法会使用tryLock 方法来判断线程池中的线程是否是空闲状态；如果线程是空闲状态则可以安全回收。线程池回收过程增加worker这和新建线程池内的工作线程一样的 addworker 使得线程池真正在运行的线程数量和worker数量一样的增加线程是通过线程池中的 addWorker 方法，该方法的功能就是增加一个线程，该方法不考虑线程池是在哪个阶段增加的该线程，这个分配线程的策略是在上个步骤完成的，该步骤仅仅完成增加线程，并使它运行，最后返回是否成功这个结果。addWorker 方法有两个参数：firstTask、core。firstTask 参数用于指定新增的线程执行的第一个任务，该参数可以为空；core 参数为 true 表示在新增线程时会判断当前活动线程数是否少于 corePoolSize，false 表示新增线程前需要判断当前活动线程数是否少于 maximumPoolSize线程的回收线程池中线程的销毁依赖 JVM 自动的回收，线程池做的工作是根据当前线程池的状态维护一定数量的线程引用，防止这部分线程被 JVM 回收，当线程池决定哪些线程需要回收时，只需要将其引用消除即可。Worker 被创建出来后，就会不断地进行轮询，然后获取任务去执行，核心线程可以无限等待获取任务，非核心线程要限时获取任务。当 Worker 无法获取到任务，也就是获取的任务为空时，循环会结束，Worker 会主动消除自身在线程池内的引用try {
 while (task != null || (task = getTask()) != null) {
 // 执行任务
 }
} finally {
 processWorkerExit(w, completedAbruptly);// 获取不到任务时，主动回收自己
} processWorkerExit  函数内来执行回收将线程引用移出线程池就已经结束了线程销毁的部分。但由于引起线程销毁的可能性有很多，线程池还要判断是什么引发了这次销毁，是否要改变线程池的现阶段状态，是否要根据新状态，重新分配线程执行任务流程 IO 密集型和 CPU 密集型   CPU 密集型 cpu使用率很高 所以线程数一般只需要cpu核数的线程就可以了 IO 密集型 最佳线程数目 = （（线程等待时间+线程CPU时间）/线程CPU时间 ）* CPU数目 cpu使用率很低迁移线程池修改参数在全局分布式配置中 实现线程池参数可动态配置和即时生效  配置的要求动态化线程池的核心设计包括以下三个方面：1.	简化线程池配置：线程池构造参数有 8 个，但是最核心的是 3 个：corePoolSize、maximumPoolSize，workQueue，它们最大程度地决定了线程池的任务分配和线程分配策略。考虑到在实际应用中我们获取并发性的场景主要是两种：（1）并行执行子任务，提高响应速度。这种情况下，应该使用同步队列，没有什么任务应该被缓存下来，而是应该立即执行。（2）并行执行大批次任务，提升吞吐量。这种情况下，应该使用有界队列，使用队列去缓冲大批量的任务，队列容量必须声明，防止任务无限制堆积。所以线程池只需要提供这三个关键参数的配置，并且提供两种队列的选择，就可以满足绝大多数的业务需求，Less is More。2.	参数可动态修改：为了解决参数不好配，修改参数成本高等问题。在 Java 线程池留有高扩展性的基础上，封装线程池，允许线程池监听同步外部的消息，根据消息进行修改配置。将线程池的配置放置在平台侧，允许开发同学简单的查看、修改线程池配置。3.	增加线程池监控：对某事物缺乏状态的观测，就对其改进无从下手。在线程池执行任务的生命周期添加监控能力，帮助开发同学了解线程池状态线程池有重要的七大参数新建线程池            ExecutorService pool= Executors.newCachedThreadPool();
实现原理 public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }主要使用了ThreadPoolExecutor实现内部主要用了七大核心参数来实现一、corePoolSize 线程池核心线程大小线程池中会维护一个最小的线程数量，即使这些线程处理空闲状态，他们也不会被销毁，除非设置了allowCoreThreadTimeOut。这里的最小线程数量即是corePoolSize。二、maximumPoolSize 线程池最大线程数量一个任务被提交到线程池以后，首先会找有没有空闲存活线程，如果有则直接将任务交给这个空闲线程来执行，如果没有则会缓存到工作队列（后面会介绍）中，如果工作队列满了，才会创建一个新线程，然后从工作队列的头部取出一个任务交由新线程来处理，而将刚提交的任务放入工作队列尾部。线程池不会无限制的去创建新线程，它会有一个最大线程数量的限制，这个数量即由maximunPoolSize指定。三、keepAliveTime 空闲线程存活时间一个线程如果处于空闲状态，并且当前的线程数量大于corePoolSize，那么在指定时间后，这个空闲线程会被销毁，这里的指定时间由keepAliveTime来设定四、unit 空闲线程存活时间单位keepAliveTime的计量单位五、workQueue 工作队列新任务被提交后，会先进入到此工作队列中，任务调度时再从队列中取出任务。jdk中提供了四种工作队列：①ArrayBlockingQueue基于数组的有界阻塞队列，按FIFO排序。新任务进来后，会放到该队列的队尾，有界的数组可以防止资源耗尽问题。当线程池中线程数量达到corePoolSize后，再有新任务进来，则会将任务放入该队列的队尾，等待被调度。如果队列已经是满的，则创建一个新线程，如果线程数量已经达到maxPoolSize，则会执行拒绝策略。②LinkedBlockingQuene基于链表的无界阻塞队列（其实最大容量为Interger.MAX），按照FIFO排序。由于该队列的近似无界性，当线程池中线程数量达到corePoolSize后，再有新任务进来，会一直存入该队列，而不会去创建新线程直到maxPoolSize，因此使用该工作队列时，参数maxPoolSize其实是不起作用的。③SynchronousQuene一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。也就是说新任务进来时，不会缓存，而是直接被调度执行该任务，如果没有可用线程，则创建新线程，如果线程数量达到maxPoolSize，则执行拒绝策略。④PriorityBlockingQueue具有优先级的无界阻塞队列，优先级通过参数Comparator实现。六、threadFactory 线程工厂创建一个新线程时使用的工厂，可以用来设定线程名、是否为daemon线程等等七、handler 拒绝策略当工作队列中的任务已到达最大限制，并且线程池中的线程数量也达到最大限制，这时如果有新任务提交进来，该如何处理呢。这里的拒绝策略，就是解决这个问题的，jdk中提供了4种拒绝策略分布式锁本质是为了处理高并发下的数据处理在集群部署下所应用的应具备的条件1、在分布式系统环境下，一个方法在同一时间只能被一个机器的一个线程执行； 2、高可用的获取锁与释放锁； 3、高性能的获取锁与释放锁； 4、具备可重入特性； 5、具备锁失效机制，防止死锁； 6、具备非阻塞锁特性，即没有获取到锁将直接返回获取锁失败1.基于数据库实现排他锁方案1 表结构获取锁INSERT INTO method_lock (method_name, desc) VALUES ('methodName', 'methodName');对method_name做了唯一性约束，这里如果有多个请求同时提交到数据库的话，数据库会保证只有一个操作可以成功。方案2表结构DROP TABLE IF EXISTS `method_lock`;
CREATE TABLE `method_lock` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `method_name` varchar(64) NOT NULL COMMENT '锁定的方法名',
  `state` tinyint NOT NULL COMMENT '1:未分配；2：已分配',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `version` int NOT NULL COMMENT '版本号',
  `PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_method_name` (`method_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='锁定中的方法';先获取锁的信息  select id, method_name, state,version from method_lock where state=1 and method_name='methodName';占有锁  update t_resoure set state=2, version=2, update_time=now() where method_name='methodName' and state=1 and version=2;如果没有更新影响到一行数据，则说明这个资源已经被别人占位了。缺点：    1、这把锁强依赖数据库的可用性，数据库是一个单点，一旦数据库挂掉，会导致业务系统不可用。    2、这把锁没有失效时间，一旦解锁操作失败，就会导致锁记录一直在数据库中，其他线程无法再获得到锁。    3、这把锁只能是非阻塞的，因为数据的insert操作，一旦插入失败就会直接报错。没有获得锁的线程并不会进入排队队列，要想再次获得锁就要再次触发获得锁操作。    4、这把锁是非重入的，同一个线程在没有释放锁之前无法再次获得该锁。因为数据中数据已经存在了。解决方案：     1、数据库是单点？搞两个数据库，数据之前双向同步。一旦挂掉快速切换到备库上。     2、没有失效时间？只要做一个定时任务，每隔一定时间把数据库中的超时数据清理一遍。     3、非阻塞的？搞一个while循环，直到insert成功再返回成功。     4、非重入的？在数据库表中加个字段，记录当前获得锁的机器的主机信息和线程信息，那么下次再获取锁的时候先查询数据库，如果当前机器的主机信息和线程信息在数据库可以查到的话，直接把锁分配给他就可以了。 2.基于redis实现获取锁使用命令:SET resource_name my_random_value NX PX 30000方案：try{	lock = redisTemplate.opsForValue().setIfAbsent(lockKey, LOCK);	logger.info("cancelCouponCode是否获取到锁："+lock);	if (lock) {		// TODO		redisTemplate.expire(lockKey,1, TimeUnit.MINUTES); //成功设置过期时间		return res;	}else {		logger.info("cancelCouponCode没有获取到锁，不执行任务!");	}}finally{	if(lock){			redisTemplate.delete(lockKey);		logger.info("cancelCouponCode任务结束，释放锁!");			}else{		logger.info("cancelCouponCode没有获取到锁，无需释放锁!");	}}缺点：在这种场景（主从结构）中存在明显的竞态:    客户端A从master获取到锁，    在master将锁同步到slave之前，master宕掉了。    slave节点被晋级为master节点，    客户端B取得了同一个资源被客户端A已经获取到的另外一个锁。安全失效！3，zookeeper先看个问题服务A去Redis查询到库存发现是1，那说明我能抢到这个商品对不对，那我就准备减一了，但是还没减。同时服务B也去拿发现也是1，那我也抢到了呀，那我也减。C同理。等所有的服务都判断完了，你发现诶，怎么变成-2了，超卖了呀，这下完了。zk就是基于节点去实现各种分布式锁的。采用顺序临时节点来控制释放锁1，ZooKeeper的每一个节点，都是一个天然的顺序发号器。在每一个节点下面创建临时顺序节点（EPHEMERAL_SEQUENTIAL）类型，新的子节点后面，会加上一个次序编号，而这个生成的次序编号，是上一个生成的次序编号加一2，ZooKeeper节点的递增有序性，可以确保锁的公平一个ZooKeeper分布式锁，首先需要创建一个父节点，尽量是持久节点（PERSISTENT类型），然后每个要获得锁的线程，都在这个节点下创建个临时顺序节点。由于ZK节点，是按照创建的次序，依次递增的。为了确保公平，可以简单的规定：编号最小的那个节点，表示获得了锁。所以，每个线程在尝试占用锁之前，首先判断自己是排号是不是当前最小，如果是，则获取锁。3，ZooKeeper的节点监听机制，可以保障占有锁的传递有序而且高效每个线程抢占锁之前，先尝试创建自己的ZNode。同样，释放锁的时候，就需要删除创建的Znode。创建成功后，如果不是排号最小的节点，就处于等待通知的状态。等谁的通知呢？不需要其他人，只需要等前一个Znode的通知就可以了。前一个Znode删除的时候，会触发Znode事件，当前节点能监听到删除事件，就是轮到了自己占有锁的时候。第一个通知第二个、第二个通知第三个，击鼓传花似的依次向后。ZooKeeper的节点监听机制，能够非常完美地实现这种击鼓传花似的信息传递。具体的方法是，每一个等通知的Znode节点，只需要监听（linsten）或者监视（watch）排号在自己前面那个，而且紧挨在自己前面的那个节点，就能收到其删除事件了。只要上一个节点被删除了，就进行再一次判断，看看自己是不是序号最小的那个节点，如果是，自己就获得锁。另外，ZooKeeper的内部优越的机制，能保证由于网络异常或者其他原因，集群中占用锁的客户端失联时，锁能够被有效释放。一旦占用Znode锁的客户端与ZooKeeper集群服务器失去联系，这个临时Znode也将自动删除。排在它后面的那个节点，也能收到删除事件，从而获得锁。正是由于这个原因，在创建取号节点的时候，尽量创建临时znode节点，4，ZooKeeper的节点监听机制，能避免羊群效应ZooKeeper这种首尾相接，后面监听前面的方式，可以避免羊群效应。所谓羊群效应就是一个节点挂掉，所有节点都去监听，然后做出反应，这样会给服务器带来巨大压力，所以有了临时顺序节点，当一个节点挂掉，只有它后面的那一个节点才做出反应加锁失败了以后，客户端B就会通过ZK的API对他的顺序节点的上一个顺序节点加一个监听器。zk天然就可以实现对某个节点的监听。如果大家还不知道zk的基本用法，可以百度查阅，非常的简单。客户端B的顺序节点是接着，客户端A加锁之后，可能处理了一些代码逻辑，然后就会释放锁。那么，释放锁是个什么过程呢？其实很简单，就是把自己在zk里创建的那个顺序节点，也就是这个节点给删除。删除了那个节点之后，zk会负责通知监听这个节点的监听器，也就是客户端B之前加的那个监听器，说：兄弟，你监听的那个节点被删除了，有人释放了锁此时客户端B的监听器感知到了上一个顺序节点被删除，也就是排在他之前的某个客户端释放了锁。客户端B抢锁成功此时，就会通知客户端B重新尝试去获取锁，也就是获取"my_lock"节点下的子节点集合，此时为集合里此时只有客户端B创建的唯一的一个顺序节点了！然后呢，客户端B判断自己居然是集合中的第一个顺序节点，bingo！可以加锁了！直接完成加锁，运行后续的业务代码即可，运行完了之后再次释放锁。lua脚本redis## -1-库存不足  0-抢购数量大于可抢库存  1-抢购成功  # 通过活动编码获取活动库存数量
local num = redis.call('get', KEYS[1])
if num == 0 then
	return -1
elseif num < KEYS[3] then
	return 0
else
	# 扣减活动库存
	redis.call('decrby', KEYS[1], KEYS[3])
	# 记录会员购买数量
	redis.call('set', KEYS[2],  KEYS[3])
	return 1
endLockSupport概念三种用来唤醒线程的方法同步锁配合notify和wait共同使用这个synchronized 共享同个对象线程锁约束作用作用unpark凭证AQS原理aqs实现原理参考https://aobing.blog.csdn.net/article/details/115339297内部主要有队列来实现在AbstractQueuedSynchronizer内部，有一个队列，我们把它叫做同步等待队列。它的作用是保存等待在这个锁上的线程(由于lock()操作引起的等待）。此外，为了维护等待在条件变量上的等待线程，AbstractQueuedSynchronizer又需要再维护一个条件变量等待队列，也就是那些由Condition.await()引起阻塞的线程排它锁实现程序public final void acquire(int arg) {
    //尝试获得许可， arg为许可的个数。对于重入锁来说，每次请求1个。
    if (!tryAcquire(arg) &&
    // 如果tryAcquire 失败，则先使用addWaiter()将当前线程加入同步等待队列
    // 然后继续尝试获得锁
    acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
    selfInterrupt();
}
addWaiter将当前线程加入同步等待队列 这些函数均在这个aqs抽象类中有实现private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        enq(node);
        return node;
    }把未拿到许可证的工作线程加入到等待队列中浸入队列中再次请求获取锁调用acquireQueued final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }释放锁public final boolean release(int arg) {
    //tryRelease()是一个抽象方法，在子类中有具体实现和tryAcquire()一样
    if (tryRelease(arg)) {
        Node h = head;
        if (h != null && h.waitStatus != 0)
            // 从队列中唤醒一个等待中的线程（遇到CANCEL的直接跳过）
            unparkSuccessor(h);
            return true;
    }
    return false;
}
共享锁释放锁public final boolean releaseShared(int arg) {
    //tryReleaseShared()尝试释放许可，这是一个抽象方法，需要在子类中实现
    if (tryReleaseShared(arg)) {
        //上述代码中已经出现这个函数了，就是唤醒线程，设置传播状态
        doReleaseShared();
        return true;
    }
    return false;
}
ReentrantLock新来的人不一定总得乖乖排队非公平原理同一个线程调用多次lock方法，会在可重入锁内部用一个状态state变量记录，当这个变量为0时，其它线程才能去抢夺资源，如果这个变量不为0，下次这个线程去执行这个方法就不用重复获取锁了。抢夺不到资源的线程会放在队列里边Lock接口   
    void lock();

   
    void lockInterruptibly() throws InterruptedException;

    boolean tryLock();

   
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    void unlock();

 
    Condition newCondition();join在线程中调用另一个线程的 join()方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。助记：joint翻译，让别的线程加入执行，所以当前线程会挂起，等到别的线程执行结束。锁池假设线程A已经拥有了某个对象(注意:不是类)的锁，而其它的线程想要调用这个对象的      某个synchronized方法(或者synchronized块)，由于这些线程在进入对象的synchronized方法之     前必须先获得该对象的锁的拥有权，但是该对象的锁目前正被线程A拥有，所以这些线程就进   入了该对象的锁池中。等待池假设一个线程A调用了某个对象的wait()方法，线程A就会释放该对象的锁后，进    入到了该对象的等待池中notifyAll和wait● 如果线程调用了对象的 wait()方法，那么线程便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。● 当有线程调用了对象的 notifyAll()方法（唤醒所有 wait 线程）或 notify()方法（只随机唤醒一个 wait 线程），被唤醒的的线程便会进入该对象的锁池中，锁池中的线程会去竞争该对象锁。也就是说，调用了notify后只要一个线程会由等待池进入锁池，而notifyAll会将该对象等待池内的所有线程移动到锁池中，等待锁竞争● 优先级高的线程竞争到对象锁的概率大，假若某线程没有竞争到该对象锁，它还会留在锁池   中，唯有线程再次调用 wait()方法，它才会重新回到等待池中。而竞争到对象锁的线程则继续往下执行，直到执行完了 synchronized 代码块，它会释放掉该对象锁，这时锁池中的线程会继       续竞争该对象锁。wait() 和 sleep() 的区别wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；wait() 会释放锁，sleep() 不会。使用 wait() 挂起期间，线程会释放锁。这是因为，如果没有释放锁，那么其它线程就无法进入对象的同步方法或者同步控制块中，那么就无法执行 notify() 或者 notifyAll() 来唤醒挂起的线程，造成死锁。只能用在同步方法或者同步控制块中使用，否则会在运行时抛出 IllegalMonitorStateException。实例 public static void main(String[] args) {
        Object co = new Object();
        System.out.println(co);
 
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, co);
            t.start();
        }
 
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");
            synchronized (co) {
                co.notify();
            }
 
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");
 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    static class MyThread extends Thread {
        private String name;
        private Object co;
 
        public MyThread(String name, Object o) {
            this.name = name;
            this.co = o;
        }
 
        @Override
        public void run() {
            System.out.println(name + " is waiting.");
            try {
                synchronized (co) {
                    co.wait();
                }
                System.out.println(name + " has been notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
 
运行结果：
java.lang.Object@1540e19d
Thread1 is waiting.
Thread2 is waiting.
Thread0 is waiting.
Thread3 is waiting.
Thread4 is waiting.
-----Main Thread notify-----
Thread1 has been notified.
Main Thread is end.
 
将其中的那个notify换成notifyAll，运行结果：
Thread0 is waiting.
Thread1 is waiting.
Thread2 is waiting.
Thread3 is waiting.
Thread4 is waiting.
-----Main Thread notifyAll-----
Thread4 has been notified.
Thread2 has been notified.
Thread1 has been notified.
Thread3 has been notified.
Thread0 has been notified.
Main Thread is end.
 
运行环境jdk8，结论：
notify唤醒一个等待的线程；notifyAll唤醒所有等待的线程
线程池这个run和start虚假唤醒机制AQSReentrantLock实现的原理public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer{
// 指向同步队列的头部
private transient volatile Node head;
// 指向同步队列的尾部
private transient volatile Node tail;
// 同步状态标识
private volatile int state;
// 省略......
}其中head以及tail是AQS的全局变量，其中head指向同步队列的头部，但是需要注意的是head节点为空不存储信息，而tail指向同步队列的尾部。AQS中同步队列采用这种方式构建双向链表结构方便队列进行节点增删操作。state则为我们前面所提到的同步状态标识，当线程在执行过程中调用获取锁的lock()方法后，如果state=0，则说明当前锁资源未被其他线程获取，当前线程将state值设置为1，表示获取锁成功。如果state=1，则说明当前锁资源已被其他线程获取，那么当前线程则会被封装成Node节点加入同步队列进行等待。Node节点是对每一个获取锁资源线程的封装体，其中包括了当前执行的线程本身以及线程的状态，如是否被阻塞、是否处于等待唤醒、是否中断等。每个Node节点中都关联着前驱节点prev以及后继节点next，这样能够方便持有锁的线程释放后能快速释放下一个正在等待的线程。Node类结构如下：static final class Node {
    // 共享模式
    static final Node SHARED = new Node();
    // 独占模式
    static final Node EXCLUSIVE = null;
    // 标识线程已处于结束状态
    static final int CANCELLED =  1;
    // 等待被唤醒状态
    static final int SIGNAL    = -1;
    // Condition条件状态
    static final int CONDITION = -2;
    // 在共享模式中使用表示获得的同步状态会被传播
    static final int PROPAGATE = -3;

    // 等待状态,存在CANCELLED、SIGNAL、CONDITION、PROPAGATE四种
    volatile int waitStatus;

    // 同步队列中前驱结点
    volatile Node prev;

    // 同步队列中后继结点
    volatile Node next;

    // 获取锁资源的线程
    volatile Thread thread;

    // 等待队列中的后继结点（与Condition有关，稍后会分析）
    Node nextWaiter;

    // 判断是否为共享模式
    final boolean isShared() {
        return nextWaiter == SHARED;
    }
    // 获取前驱结点
    final Node predecessor() throws NullPointerException {
        Node p = prev;
        if (p == null)
            throw new NullPointerException();
        else
            return p;
    }
    // 省略代码.....
}在其中SHARED和EXCLUSIVE两个全局常量分别代表着共享模式和独占模式，共享模式即允许多个线程同时对一个锁资源进行操作，例如：信号量Semaphore、读锁ReadLock等采用的就是基于AQS的共享模式实现的。而独占模式则代表着在同一时刻只运行一个线程对锁资源进行操作，如ReentranLock等组件的实现都是基于AQS的独占模式实现。全局变量waitStatus则代表着当前被封装成Node节点的线程的状态，一共存在五种情况：0 初始值状态：waitStatus=0，代表节点初始化。CANCELLED 取消状态：waitStatus=1，在同步队列中等待的线程等待超时或者被中断，需要从同步队列中取消该Node的节点，其节点的waitStatus为CANCELLED，进入该状态后的节点代表着进入了结束状态，当前节点将不会再发生变化。SIGNAL 信号状态：waitStatus=-1，被标识为该状态的节点，当其前驱节点的线程释放了锁资源或被取消，将会通知该节点的线程执行。简单来说被标记为当前状态的节点处于等待唤醒状态，只要前驱节点释放锁，就会通知标识为SIGNAL状态的后续节点的线程执行。CONDITION 条件状态：waitStatus=-2，与Condition相关，被表示为该状态的节点处于等待队列中，节点的线程等待在Condition条件，当其他线程调用了Condition的signal()方法后，CONDITION状态的节点将从等待队列转移到同步队列中，等待获取竞争锁资源。PROPAGATE 传播状态：waitStatus=-3，该状态与共享模式有关，在共享模式中，被标识为该状态的节点的线程处于可运行状态。主要有三种实现可见性的方式： volatilesynchronized，某一个线程进入synchronized代码块前后，线程会获得锁，清空工作内存，从主内存拷贝共享变量最新的值到工作内存成为副本，执行代码，将修改后的副本的值刷新回主内存中，线程释放锁。而获取不到锁的线程会阻塞等待，所以变量的值肯定一直都是最新的。final，被 final 关键字修饰的字段在构造器中一旦初始化完成，并且没有发生 this 逃逸（其它线程通过 this 引用访问到初始化了一半的对象），那么其它线程就能看见 final 字段的值。volatile实现原理当多个处理器的运算任务都涉及同一块主内存区域时，将可能导致各自的缓存数据不一致，举例说明变量在多个CPU之间的共享。

如果真的发生这种情况，那同步回到主内存时以谁的缓存数据为准呢？

为了解决一致性的问题，需要各个处理器访问缓存时都遵循一些协议，在读写时要根据协议来进行操作，这类协议有MSI、MESI（IllinoisProtocol）、MOSI、Synapse、Firefly及DragonProtocol等。
聊一下Intel的MESI吧

MESI（缓存一致性协议）
当CPU写数据时，如果发现操作的变量是共享变量，会发出信号通知其他CPU将该变量的缓存行置为无效状态，因此当其他CPU需要读取这个变量时，发现自己缓存中缓存该变量的缓存行是无效的，那么它就会从内存重新读取。

至于是怎么发现数据是否失效呢？

嗅探
每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器对这个数据进行修改操作的时候，会重新从系统内存中把数据读到处理器缓存里。
有序性有序性是指：在本线程内观察，所有操作都是有序的。在一个线程观察另一个线程，所有操作都是无序的，无序是因为发生了指令重排序。在 Java 内存模型中，允许编译器和处理器对指令进行重排序，重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。如果一个变量被声明volatile的话，那么这个变量不会被进行重排序，也就是说，虚拟机会保证这个变量之前的代码一定会⽐它先执行，⽽之后的代码⼀定会比它慢执行。不过这里需要注意的是，虚拟机只是保证这个变量之前的代码⼀定⽐比它先执行，但并没有保证这个变量之前的代码不可以重排序。之后的也一样005阿里巴巴开发规范1，阿里开发规约禁止内置Executors创建线程池阿里规约之所以强制要求手动创建线程池，也是和这些参数有关。具体为什么不允许，规约是这样说的：线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险Executors各个方法的弊端：
1）newFixedThreadPool和newSingleThreadExecutor:
  主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
2）newCachedThreadPool和newScheduledThreadPool:
  主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。

看一下这两种弊端怎么导致的。

第一种，newFixedThreadPool和newSingleThreadExecutor分别获得 FixedThreadPool 类型的线程池 和 SingleThreadExecutor 类型的线程池。

public static ExecutorService newFixedThreadPool(int nThreads) {
return new ThreadPoolExecutor(nThreads, nThreads,
0L, TimeUnit.MILLISECONDS,
new LinkedBlockingQueue());
}

public static ExecutorService newSingleThreadExecutor() {
return new FinalizableDelegatedExecutorService
(new ThreadPoolExecutor(1, 1,
0L, TimeUnit.MILLISECONDS,
new LinkedBlockingQueue()));
}
因为，创建了一个无界队列LinkedBlockingQueuesize，是一个最大值为Integer.MAX_VALUE的线程阻塞队列，当添加任务的速度大于线程池处理任务的速度，可能会在队列堆积大量的请求，消耗很大的内存，甚至导致OOM。
第二种，newCachedThreadPool 和 newScheduledThreadPool创建的分别是CachedThreadPool 类型和 ScheduledThreadPoolExecutorScheduledThreadPoolExecutor类型的线程池。
CachedThreadPool是一个会根据需要创建新线程的线程池 ，ScheduledThreadPoolExecutor可以用来在给定延时后执行异步任务或者周期性执行任务。
public static ExecutorService newCachedThreadPool() {
return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
60L, TimeUnit.SECONDS,
new SynchronousQueue());
}
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
return new ScheduledThreadPoolExecutor(corePoolSize);
}
public ScheduledThreadPoolExecutor(int corePoolSize) {
super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
new DelayedWorkQueue());
}
创建的线程池允许的最大线程数是Integer.MAX_VALUE，空闲线程存活时间为0，当添加任务的速度大于线程池处理任务的速度，可能会创建大量的线程，消耗资源，甚至导致OOM
006 集合collection关系map关系1，hashmapHashmap中的链表大小超过八个时会自动转化为红黑树，当删除小于六时重新变为链表，为啥呢？根据泊松分布，在负载因子默认为0.75的时候，单个hash槽内元素个数为8的概率小于百万分之一，所以将7作为一个分水岭，等于7的时候不转换，大于等于8的时候才进行转换，小于等于6的时候就化为链表。collection的SynchronizedMap我们在调用这个方法的时候就需要传入一个Map，可以看到有两个构造器，如果你传入了mutex参数，则将对象排斥锁赋值为传入的对象。如果没有，则将对象排斥锁赋值为this，即调用synchronizedMap的对象，就是上面的Map。创建出synchronizedMap之后，操作map的时候，就会对方法上锁，跟HashMap相比Hashtable是线程安全的，适合在多线程的情况下使用，但是效率可不太乐观。哦，你能说说他效率低的原因么？嗯嗯面试官，我看过他的源码，他在对数据操作的时候都会上锁，所以效率比较低下但是你还是没说为啥Hashtable 是不允许键或值为 null 的，HashMap 的键值则都可以为 null？这是因为Hashtable使用的是安全失败机制（fail-safe），这种机制会使你此次读到的数据不一定是最新的数据。如果你使用null值，就会使得其无法判断对应的key是不存在还是为空，因为你无法再调用一次contain(key）来对key是否存在进行判断，ConcurrentHashMap同理。ConcurrentHashMap 源程序探讨1，put函数 public V put(K key, V value) {
        return putVal(key, value, false);
    }
2，putVal函数final V putVal(K key, V value, boolean onlyIfAbsent) {
    //从这里能够看出来ConcurrentHashMap 不能够来进行存储null值
        if (key == null || value == null) throw new NullPointerException();
    进入到第三步 计算keyhash
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            //进入到第四步找到tab数组索引位置
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }3，keyhash函数static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

//    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
内部实现采用了node内部类来实现的未采用entry对象 static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K,V> next;
        Node(int hash, K key, V val, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }
        public final K getKey()       { return key; }
        public final V getValue()     { return val; }
        public final int hashCode()   { return key.hashCode() ^ val.hashCode(); }
        public final String toString(){ return key + "=" + val; }
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }
        public final boolean equals(Object o) {
            Object k, v, u; Map.Entry<?,?> e;
            return ((o instanceof Map.Entry) &&
                    (k = (e = (Map.Entry<?,?>)o).getKey()) != null &&
                    (v = e.getValue()) != null &&
                    (k == key || k.equals(key)) &&
                    (v == (u = val) || v.equals(u)));
        }
        /**
         * Virtualized support for map.get(); overridden in subclasses.
         */
        Node<K,V> find(int h, Object k) {
            Node<K,V> e = this;
            if (k != null) {
                do {
                    K ek;
                    if (e.hash == h &&
                        ((ek = e.key) == k || (ek != null && k.equals(ek))))
                        return e;
                } while ((e = e.next) != null);
            }
            return null;
        }
    }
4，tabAt函数  @SuppressWarnings("unchecked")
    static final <K,V> Node<K,V> tabAt(Node<K,V>[] tab, int i) {
        return (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }未存入值进入到第五步5，同步锁6，cas操作//当前的key值和之前的不同即未存入 
else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {  static final <K,V> boolean casTabAt(Node<K,V>[] tab, int i,
                                        Node<K,V> c, Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }
static final class Segment<K,V> extends ReentrantLock implements Serializable {

    private static final long serialVersionUID = 2249069246763182397L;

    // 和 HashMap 中的 HashEntry 作用一样，真正存放数据的桶
    transient volatile HashEntry<K,V>[] table;

    transient int count;
        // 记得快速失败（fail—fast）么？
    transient int modCount;
        // 大小
    transient int threshold;
        // 负载因子
    final float loadFactor;

}
原理上来说，ConcurrentHashMap 采用了分段锁技术，其中 Segment 继承于 ReentrantLock。不会像 HashTable 那样不管是 put 还是 get 操作都需要做同步处理，理论上 ConcurrentHashMap 支持 CurrencyLevel (Segment 数组数量)的线程并发。每当一个线程占用锁访问一个 Segment 时，不会影响到其他的 Segment。就是说如果容量大小是16他的并发度就是16，可以同时允许16个线程操作16个Segment而且还是线程安全的。jdk1.8其中抛弃了原有的 Segment 分段锁，而采用了 CAS + synchronized 来保证并发安全性。跟HashMap很像，也把之前的HashEntry改成了Node，但是作用不变，把值和next采用了volatile去修饰，保证了可见性，并且也引入了红黑树，在链表大于一定值的时候会转换（默认是8）。HashCode为什么使用31作为乘数// 获取hashCode "abc".hashCode();
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;
        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
数据存储顺序存储数据结构初始化容量大小static final int tableSizeFor(int cap) {
  int n = cap - 1;
  n |= n >>> 1;
  n |= n >>> 2;
  n |= n >>> 4;
  n |= n >>> 8;
  n |= n >>> 16;
  return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
位运算的原理算法就是让初始二进制右移1，2，4，8，16位，分别与自己位或，把高位第一个为1的数通过不断右移，把高位为1的后面全变为1，最后再进行+1操作，111111 + 1 = 1000000 = 2 6 2^62 6  （符合大于50并且是2的整数次幂 ）put public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }往hashmap里存入值先根据hash算法算出其要存放的位置hashstatic final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }由key值的低16位与高16为或操作减少hash冲突putvaluefinal V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; 
	Node<K,V> p; 
	int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
	/*如果table的在（n-1）&hash的值是空，就新建一个节点插入在该位置*/
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
	/*表示有冲突,开始处理冲突*/
        else {
            Node<K,V> e; 
	    K k;
	/*检查第一个Node，p是不是要找的值*/
            if (p.hash == hash &&((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
		/*指针为空就挂在后面*/
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
		       //如果冲突的节点数已经达到8个，看是否需要改变冲突节点的存储结构，　　　　　　　　　　　　　
　　　　　　　　　　　　//treeifyBin首先判断当前hashMap的长度，如果不足64，只进行
                        //resize，扩容table，如果达到64，那么将冲突的存储结构为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
		/*如果有相同的key值就结束遍历*/
                    if (e.hash == hash &&((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
	/*就是链表上有相同的key值*/
            if (e != null) { // existing mapping for key，就是key的Value存在
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;//返回存在的Value值
            }
        }
        ++modCount;
     /*如果当前大小大于门限，门限原本是初始容量*0.75*/
        if (++size > threshold)
            resize();//扩容两倍
        afterNodeInsertion(evict);
        return null;
    }
1，判断键值对数组tab[]是否为空或为null，否则以默认大小resize()；2，根据键值key计算hash值得到插入的数组索引i，如果tab[i]==null，直接新建节点添加，否则转入33，判断当前数组中处理hash冲突的方式为链表还是红黑树(check第一个节点类型即可),分别处理resize扩容 final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
		
	/*如果旧表的长度不是空*/
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
	/*把新表的长度设置为旧表长度的两倍，newCap=2*oldCap*/
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
	      /*把新表的门限设置为旧表门限的两倍，newThr=oldThr*2*/
                newThr = oldThr << 1; // double threshold
        }
     /*如果旧表的长度的是0，就是说第一次初始化表*/
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
		
		
		
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;//新表长度乘以加载因子
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
	/*下面开始构造新表，初始化表中的数据*/
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;//把新表赋值给table
        if (oldTab != null) {//原表不是空要把原表中数据移动到新表中	
            /*遍历原来的旧表*/		
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)//说明这个node没有链表直接放在新表的e.hash & (newCap - 1)位置
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
	/*如果e后边有链表,到这里表示e后面带着个单链表，需要遍历单链表，将每个结点重*/
                    else { // preserve order保证顺序
					新计算在新表的位置，并进行搬运
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
						
                        do {
                            next = e.next;//记录下一个结点
			  //新表是旧表的两倍容量，实例上就把单链表拆分为两队，
　　　　　　　　　　　　　　//e.hash&oldCap为偶数一队，e.hash&oldCap为奇数一对
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
						
                        if (loTail != null) {//lo队不为null，放在新表原位置
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {//hi队不为null，放在新表j+oldCap位置
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
构造hash表时，如果不指明初始大小，默认大小为16（即Node数组大小16），如果Node[]数组中的元素达到（填充比*Node.length）重新调整HashMap大小 变为原来2倍大小,扩容很耗时get  public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }getnodefinal Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab;//Entry对象数组
	Node<K,V> first,e; //在tab数组中经过散列的第一个位置
	int n;
	K k;
	/*找到插入的第一个Node，方法是hash值和n-1相与，tab[(n - 1) & hash]*/
	//也就是说在一条链上的hash值相同的
        if ((tab = table) != null && (n = tab.length) > 0 &&(first = tab[(n - 1) & hash]) != null) {
	/*检查第一个Node是不是要找的Node*/
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))//判断条件是hash值要相同，key值要相同
                return first;
	  /*检查first后面的node*/
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
				/*遍历后面的链表，找到key值和hash值都相同的Node*/
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }get(key)方法时获取key的hash值，计算hash&(n-1)得到在链表数组中的位置first=tab[hash&(n-1)],先判断first的key是否与参数key相等，不等就遍历后面的链表找到相同的key值返回对应的Value值即可jdk1.7内部包含了一个Entry 类型的数组 table。transient Entry<K,V>[] table存储字段static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;
        int hash;

        /**
         * Creates new entry.
         */
        Entry(int h, K k, V v, Entry<K,V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }
拉链法的工作原理主要用来解决hash冲突问题首先putHashMap<String, String> map = new HashMap<>();
map.put("K1", "V1");
map.put("K2", "V2");
map.put("K3", "V3");
新建一个 HashMap，默认大小为 16；
● 插入 <K1,V1> 键值对，先计算 K1 的 hashCode 为 115，使用除留余数法得到所在的桶下标 115%16=3。
● 插入 <K2,V2> 键值对，先计算 K2 的 hashCode 为 118，使用除留余数法得到所在的桶下标 118%16=6。
● 插入 <K3,V3> 键值对，先计算 K3 的 hashCode 为 118，使用除留余数法得到所在的桶下标 118%16=6，插在<K2,V2> 前面。
应该注意到链表的插入是以头插法方式进行的，例如上面的 <K3,V3> 不是插在 <K2,V2> 后面，而
是插入在链表头部。
当put操作的会在该链表中循环查找是否有key值相同   有则更新这个value值且把原来的value返回 key值不相同把null给返回public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
// 键为 null 单独处理 
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);
// 确定桶下标 
        int i = indexFor(hash, table.length);
// 先找出是否已经存在键为 key 的键值对，如果存在的话就更新这个键值对的值为 value 
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
// 插入新键值对 
        addEntry(hash, key, value, i);
        return null;
}
HashMap 允许插入键为 null 的键值对。但是因为无法调用 null 的 hashCode() 方法，也就无法确定该键值对的桶下标，只能通过强制指定一个桶下标来存放。HashMap 使用第 0 个桶存放键为 null 的键值对 private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
}使用链表的头插法，也就是新的键值对插在链表的头部，而不是链表的尾部。 void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            //当大小超过了临界值需要扩容且为两倍
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
}

    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
// 头插法，链表头部指向新的键值对 
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }
// we ha
    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
}
put操作中的这个hash来找到下标int hash = hash(key);
int i = indexFor(hash, table.length);

    final int hash(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
扩容重要参数为什么ArrayList的扩容时1.5倍，而HashMap的扩容时2倍？因为在求桶下标时，要将求余运算变为位运算，需要保证容量为2的n次方    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
}

    void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e : table) {
            while(null != e) {
                Entry<K,V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
 }
重新算新的桶下标假设原数组长度 capacity 为 16，扩容之后 new capacity 为 32：capacity : 00010000new capacity : 00100000 对于一个 Key:       ●它的哈希值如果在第5 位上为 0（刚好第5位是24=16，也就是原来桶的大小），那么取模得到的结果和之前一样；       ●如果为 1，那么得到的结果为原来的结果 +16。是因为长度扩大以后，Hash的规则也随之改变。Hash的公式---> index = HashCode（Key） & （Length - 1）原来长度（Length）是8你位运算出来的值是2 ，新的长度是16你位运算出来的值明显不一样了。计算新数组长度 static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }因为在使用不是2的幂的数字的时候，Length-1的值是所有二进制位全为1，这种情况下，index的结果等同于HashCode后几位的值。只要输入的HashCode本身分布均匀，Hash算法的结果就是均匀的。这是为了实现均匀分布2，hashsetHashSet是如何保证Key不重复的？  HashSet 的值是不能重复的，在业务上经常被用来做数据去重的工作，那么，他是怎么保证元素不重复的呢？  当我们对一个HashSet 的实例添加一个值时，使用到的是它的 add 方法，源码如下：public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}  由代码中的 add 方法实现可知，其维护了一个 HashMap 来实现元素的添加；我们知道，HashMap 作为双列集合，它的键是不能够重复的，HashMap 针对 hashCode 相同且 equals 比较值相同的时候执行的是更新操作，所以Hashmap中的key是唯一的，也决定了hashset元素值也是唯一的3，hashtable4，arraylist 类定义public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable原本容量大小为10    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;扩容public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
}

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); // minCapacity=size+1，比较默认容量16大还是插入一个元素后size+1大，获取大的那个数。
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity); //如果容量不够了，就扩容
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 新容量=1.5x旧容量
        if (newCapacity - minCapacity < 0) // 扩容了以后，仍然小于size+1，只有越界的时候才会出现
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0) //如果扩容后大于允许的最大值
            newCapacity = hugeCapacity(minCapacity); //判断size+1是否小于0，是否大于允许的最大值MAX_ARRAY_SIZE
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
删除 public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
删除元素会删除index位置 且要把index之后的位置数据往前挪因此要使用System.arraycopy来吧index之后的数据往前挪动1个位置5，linkedhashmapput public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        //在这里调用的是LinkedHashMap重写后的addEntry方法
        addEntry(hash, key, value, i);
        return null;
    }
void addEntry(int hash, K key, V value, int bucketIndex) {		
        //调用HashMap的addEntry
        super.addEntry(hash, key, value, bucketIndex);

        // Remove eldest entry if instructed
        Entry<K,V> eldest = header.after;
        if (removeEldestEntry(eldest)) {
            removeEntryForKey(eldest.key);
        }
    }
1
2
3
4
5
6
7
8
9
10
    void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
		//在这里调用LinkedHashMap自己的createEntry方法.
        createEntry(hash, key, value, bucketIndex);
    }
 void createEntry(int hash, K key, V value, int bucketIndex) {
        HashMap.Entry<K,V> old = table[bucketIndex];
        Entry<K,V> e = new Entry<>(hash, key, value, old);
        table[bucketIndex] = e;
        e.addBefore(header);
        size++;
    }
6，treemap7，treeset8，linkedlist private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
}
结构9，queue10，stack11，优先队列12，Vectorgetpublic synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        return elementData(index);
    }扩容private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }对比因为vector的大多数的这个方法都有synchronized来修饰因此vector不会有这个并发问题但由于synchronized为重量级锁同步程序会使得程序效率变得很低13，CopyOnWriteArrayList读写动态数组add public boolean add(E e) {
        final ReentrantLock lock = this.lock;
     //加锁
        lock.lock();
        try {
            //拿到原来数组中的数据
            Object[] elements = getArray();
            //获取长度
            int len = elements.length;
            //复制数组到新数组中
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }CopyOnWriteArrayList在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。但是 CopyOnWriteArrayList 有其缺陷：       ●内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；       ●数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中。所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景007反射JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。基本使用public class T1 {

    public static void main(String[] args) {
        A a = new A();
        Class classA = a.getClass();
        System.out.println("用对象的这个getClass来获取       "+classA.getName());
        System.out.print("用类数据来获取其类型是否等于  用对象的这个getClass来获取");
        System.out.println(A.class==classA);
        System.out.println("根据类全路径名称来获取类");
        try {
            Class<?>  aClass = Class.forName("反射.A");
            System.out.println(aClass==classA);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class A{
    private int info;
    public void getThe(){
        System.out.println("A中的方法被执行了");
    }
}
结果调用构造的方法public class T1 {

    public static void main(String[] args) {
//        A a = new A();
//        Class classA = a.getClass();
//        System.out.println("用对象的这个getClass来获取       "+classA.getName());
//        System.out.print("用类数据来获取其类型是否等于  用对象的这个getClass来获取");
//        System.out.println(A.class==classA);
//        System.out.println("根据类全路径名称来获取类");
        try {
            Class<?>  aClass = Class.forName("反射.A");
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor c:constructors) {
                System.out.println("所有的公有构造器为"+c);
            }
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor c: declaredConstructors) {

                System.out.println("所有的构造器为"+c);
            }
            //根据类型获取构造器
            try {
                Constructor<?> constructor = aClass.getConstructor(null);
                System.out.println(constructor);
              //调用构造器
                    constructor.newInstance();

            } catch (Exception e) {
                e.printStackTrace();
            }


            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class);
            //将调用构造器访问权限设置为都行 原来只能够访问私有
            System.out.println("构造器为"+declaredConstructor);
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance(9);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class A{
    private int info;

    public A(int info) {
        this.info = info;
        System.out.println("构造器执行了参数为"+info);
    }

    public A() {
        System.out.println("无参构造执行了");
    }

    public int getInfo() {
        return info;
    }
    public int getInfo(char a) {
        System.out.println("公有执行了"+a);
        return 1;
    }
    protected int getInfo(int a) {
        System.out.println("受保护");
        return 1;
    }
    private int getInfo(String a) {
        System.out.println("私有的参数为"+a);
        return 1;
    }
    public void setInfo(int info) {
        this.info = info;
    }

    public void getThe(){
        System.out.println("A中的方法被执行了");
    }
}
结果008泛型mysqlleetcode176. 第二高的薪水因为要找到第二高的薪水 会有相同的处于同一排序 因此要用这个distinct来去重由于找到的结果有可能会无第二高的薪水 因此查询结果作为 {"headers": ["SecondHighestSalary"], "values": []}但要求返回的结果找不到要返回null 因此作为中间查询结果 差个空值肯定返回nullselect ( select  distinct Salary as SecondHighestSalary from Employee  order by Salary desc limit 1 offset 1 ) as SecondHighestSalary使用isnull函数SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary

IFNULL() 函数用于判断第一个表达式是否为 NULL，如果为 NULL 则返回第二个参数的值，如果不为 NULL 则返回第一个参数的值。IFNULL() 函数语法格式为：IFNULL(expression, alt_value) 使用子查询select max(distinct 成绩) 
from 成绩表
where 课程='语文' and
      成绩 < (select max(distinct 成绩) 
              from 成绩表 
              where 课程='语文');

首先找到最大值 再利用子查询找到比最大值小的最大值即为第二大的值181. 超过经理收入的员工利用笛卡尔积来查询几张表则会有a*b行结果则要给出where条件select a.Name as Employee from Employee as a, Employee as b where a.ManagerId = b.id and a.Salary > b.Salary join onselect a.Name as Employee  from Employee as a join Employee as b on a.ManagerId = b.id and a.Salary > b.Salary182. 查找重复的电子邮箱子查询 group byselect Email from ( select Email,count(Email) as a from Person group by Email)  as statistic  where a > 1 group by 配合 havingselect Email from Person group by Email having count(Email) > 1;binglog三种格式Statement,MiXED,以及ROW！Statement：每一条会修改数据的sql都会记录在binlog中。Row:不记录sql语句上下文相关信息，仅保存哪条记录被修改。Mixedlevel: 是以上两种level的混合使用，一般的语句修改使用statment格式保存binlog，如一些函数，statement无法完成主从复制的操作，则采用row格式保存binlog,MySQL会根据执行的每一条具体的sql语句来区分对待记录的日志形式，也就是在Statement和Row之间选择一种.新版本的MySQL中队row level模式也被做了优化，并不是所有的修改都会以row level来记录，像遇到表结构变更的时候就会以statement模式来记录。至于update或者delete等修改数据的语句，还是会记录所有行的变更日志MySQL中有六种日志文件，分别是：重做日志（redo log）、回滚日志（undo log）、二进制日志（binlog）、错误日志（errorlog）、慢查询日志（slow query log）、一般查询日志（general log），中继日志（relay log）重做日志（redo log）即使某个事务还没有提交，Innodb存储引擎仍然每秒会将重做日志缓存刷新到重做日志文件。回滚日志（undo log）保存了事务发生之前的数据的一个版本，可以用于回滚，同时可以提供多版本并发控制下的读（MVCC），也即非锁定读二进制日志（binlog）用于复制，在主从复制中，从库利用主库上的binlog进行重播，实现主从同步；用于数据库的基于时间点的还原；慢查询修改配置文件修改配置文件my.ini，在[mysqld]段落中加入如下参数[mysqld]log_output='FILE,TABLE'slow_query_log='ON'long_query_time=0.0011234需要重启 MySQL 才可以生效，命令为 service mysqld restart设置全局变量我在命令行中执行如下2句打开慢查询日志，设置超时时间为0.001s，并且将日志记录到文件以及mysql.slow_log表中set global slow_query_log = on;set global log_output = 'FILE,TABLE';set global long_query_time = 0.001;123想要永久生效得到配置文件中配置，否则数据库重启后，这些配置失效分析慢查询日志因为mysql慢查询日志相当于是一个流水账，并没有汇总统计的功能，所以我们需要用一些工具来分析一下mysqldumpslowmysql内置了mysqldumpslow这个工具来帮我们分析慢查询日志count不同的用法对于 count(主键 id) 来说，InnoDB 引擎会遍历整张表，把每一行的 id 值都取出来，返回给 server 层。server 层拿到 id 后，判断是不可能为空的，就按行累加。对于 count(1) 来说，InnoDB 引擎遍历整张表，但不取值。server 层对于返回的每一行，放一个数字“1”进去，判断是不可能为空的，按行累加。单看这两个用法的差别的话，你能对比出来，count(1) 执行得要比 count(主键 id) 快。因为从引擎返回 id 会涉及到解析数据行，以及拷贝字段值的操作。对于 count(字段) 来说：如果这个“字段”是定义为 not null 的话，一行行地从记录里面读出这个字段，判断不能为 null，按行累加；如果这个“字段”定义允许为 null，那么执行的时候，判断到有可能是 null，还要把值取出来再判断一下，不是 null 才累加。也就是前面的第一条原则，server 层要什么字段，InnoDB 就返回什么字段。但是 count(*) 是例外，并不会把全部字段取出来，而是专门做了优化，不取值。count(*) 肯定不是 null，按行累加。看到这里，你一定会说，优化器就不能自己判断一下吗，主键 id 肯定非空啊，为什么不能按照 count(*) 来处理，多么简单的优化啊。当然，MySQL 专门针对这个语句进行优化，也不是不可以。但是这种需要专门优化的情况太多了，而且 MySQL 已经优化过 count(*) 了，你直接使用这种用法就可以了。所以结论是：按照效率排序的话，count(字段)<count(主键 id)<count(1)≈count(*)，所以我建议你，尽量使用 count(*)mysql规范Java规范009jvmJVM规范中唯一没有规定OutOfMemoryError情况的区域 程序计数器内存结构新版本、重要知识点程序计数器是唯一一个不会出现 OutOfMemoryError 的内存区域，它的生命周期随着线程的创建而创建，随着线程的结束而死亡为什么要将永久代 (PermGen) 的实现从方法区替换为元空间 (MetaSpace) 呢?简洁回答：因为永久代的空间有限，在大量使用字符串的场景下会导致 OutOfMemoryError 错误。理解：因为永久代有一个 JVM 本身设置固定大小上限，无法进行调整，而元空间使用的是直接内存，受本机可用内存的限制，并且永远不会得到 java.lang.OutOfMemoryError。你可以使用 -XX：MaxMetaspaceSize 标志设置最大元空间大小，默认值为unlimited，这意味着它只受系统内存的限制。-XX：MetaspaceSize 设置元空间的初始大小，如果未指定此标志，则 Metaspace 将根据运行时的应用程序需求动态地重新调整大小垃圾收集器Serial收集器串行垃圾回收器在线程执行回收操作时 其他的用户线程全部停止ParNew收集器配合这个cms收集多路并行执行Parallel Scavenge收集器与ParNew一样是多线程收集器。其它收集器目标是尽可能缩短垃圾收集时用户线程的停顿时间，而它的目标是达到一个可控制的吞吐量。这里的吞吐量指CPU 用于运行用户程序的时间占总时间的比值。Serial Old收集器作为 CMS 收集器的后备预案，在并发收集发生 Concurrent Mode Failure 时使用。Parallel Old收集器是Parallel Scavenge 收集器的老年代版本。在注重吞吐量以及CPU 资源敏感的场合，都可以优先考虑 Parallel Scavenge 加 Parallel Old 收集器。 CMS收集器标记正常的对象CMS（Concurrent Mark Sweep），Mark Sweep 指的是标记 - 清除算法。主要分为以下四个流程：●初始标记：仅仅只是标记一下 GC Roots 能直接关联到的对象，速度很快，需要停顿（单线程串行，Stop the world）。●并发标记：进行GC Roots Tracing 的过程，它在整个回收过程中耗时最长，不需要停顿（单线程串行）。●重新标记：为了修正并发标记期间因用户程序继续运作而导致一些对象的标记产生变动，然后需要更新这些标记，需要停顿（多线程串行）。●并发清除：不需要停顿（单线程并发）。在整个过程中耗时最长的并发标记和并发清除过程中，收集器线程都可以与用户线程一起工作，不需要进行停顿。G1收集器的筛选回收最好是停顿的并且是并发回收。具有以下缺点：●吞吐量低：低停顿时间是以牺牲吞吐量为代价的，导致CPU 利用率不够高。●无法处理浮动垃圾[1]，可能出现 Concurrent Mode Failure。浮动垃圾是指并发清除阶段由于用户线程继续运行而产生的垃圾，这部分垃圾只能到下一次 GC 时才能进行回收。由于浮动垃圾的存在，因此需要预留出一部分内存，意味着 CMS 不能像其它收集器那样等待老年代快满的时候再回收。如果预留的内存不够存放浮动垃圾，就会出现 Concurrent Mode Failure，这时虚拟机将临时启用 Serial Old 来替代 CMS。●标记 - 清除算法导致的空间碎片，往往出现老年代空间剩余，但无法找到足够大连续空间来分配新对象，不得不提前触发一次 Full GC。总结：停顿->不停顿->停顿->不停顿。不并发->并发->不并发->并发。只有重新标记阶段是多线程。G1收集器原理：G1 把堆划分成多个大小相等的独立区域（Region），新生代和老年代不再物理隔离，使得每个小区域可以单独进行垃圾回收。通过记录以往每个区域垃圾回收时间以及回收所获得的空间，将其存储在一个优先列表，每次根据允许的收集时间，优先回收价值最大的区域。另外每个区域都有一个Remembered Set，用来记录该区域对象的引用对象所在的区域。通过使用Remembered Set，在做可达性分析的时候就可以避免全堆扫描。如果不计算维护 Remembered Set 的操作，G1 收集器的运作大致可划分为以下几个步骤：●初始标记与CMS收集器一样●并发标记与CMS收集器一样●最终标记：和CMS收集器的重新标记差不多，最终标记的区别在于虚拟机将在并发标记时标记变化的对象记录在线程的 Remembered Set Logs 里面，然后把 Remembered Set Logs的数据合并到 Remembered Set 中。这阶段需要停顿线程（stop the world），但是可多线程执行最终标记。●筛选回收：首先对各个区域中的回收价值和成本进行排序，根据用户所期望的 GC 停顿时间来制定回收计划。此阶段其实也可以做到与用户程序一起并发执行，但是因为只回收一部分区域，时间是用户可控制的，而且停顿用户线程将大幅度提高收集效率。具备如下特点：●空间整合（不出现内存碎片）：整体来看是基于“标记 - 整理”算法实现的收集器，从局部（两个区域之间）上来看是基于“复制”算法实现的，这意味着运行期间不会产生内存空间碎片。●可预测的停顿：能让用户明确指定在一定时间内，消耗在 GC 上的时间最多不得超过多少秒。010操作系统011 计算机网cookie和session坑禁用Cookie就不能得到Session，因为Session是用Session ID来确定当前对话所对应的服务器Session，而Session ID是通过Cookie来传递的，禁用Cookie相当于失去了Session ID，也就得不到Session了。SSL/TLS协议运行机制的概述TLS握手阶段的详细过程协议内容（1） 客户端向服务器端索要并验证公钥。（2） 双方协商生成"对话密钥"。（3） 双方采用"对话密钥"进行加密通信。一、首先，客户端（通常是浏览器）先向服务器发出加密通信的请求，这被叫做ClientHello请求。在这一步，客户端主要向服务器提供以下信息。（1） 支持的协议版本，比如TLS 1.0版。（2） 一个客户端生成的随机数，稍后用于生成"对话密钥"。（3） 支持的加密方法，比如RSA公钥加密。（4） 支持的压缩方法。这里需要注意的是，客户端发送的信息之中不包括服务器的域名。也就是说，理论上服务器只能包含一个网站，否则会分不清应该向客户端提供哪一个网站的数字证书。这就是为什么通常一台服务器只能有一张数字证书的原因。二、服务器收到客户端请求后，向客户端发出回应，这叫做SeverHello。服务器的回应包含以下内容。（1） 确认使用的加密通信协议版本，比如TLS 1.0版本。如果浏览器与服务器支持的版本不一致，服务器关闭加密通信。（2） 一个服务器生成的随机数，稍后用于生成"对话密钥"。（3） 确认使用的加密方法，比如RSA公钥加密。（4） 服务器证书。除了上面这些信息，如果服务器需要确认客户端的身份，就会再包含一项请求，要求客户端提供"客户端证书"。比如，金融机构往往只允许认证客户连入自己的网络，就会向正式客户提供USB密钥，里面就包含了一张客户端证书三、客户端回应客户端收到服务器回应以后，首先验证服务器证书。如果证书不是可信机构颁布、或者证书中的域名与实际域名不一致、或者证书已经过期，就会向访问者显示一个警告，由其选择是否还要继续通信。如果证书没有问题，客户端就会从证书中取出服务器的公钥。然后，向服务器发送下面三项信息。（1） 一个随机数。该随机数用服务器公钥加密，防止被窃听。（2） 编码改变通知，表示随后的信息都将用双方商定的加密方法和密钥发送。（3） 客户端握手结束通知，表示客户端的握手阶段已经结束。这一项同时也是前面发送的所有内容的hash值，用来供服务器校验。上面第一项的随机数，是整个握手阶段出现的第三个随机数，又称"pre-master key"。有了它以后，客户端和服务器就同时有了三个随机数，接着双方就用事先商定的加密方法，各自生成本次会话所用的同一把"会话密钥"。至于为什么一定要用三个随机数，来生成"会话密钥"为啥子要有三个随机数"不管是客户端还是服务器，都需要随机数，这样生成的密钥才不会每次都一样。由于SSL协议中证书是静态的，因此十分有必要引入一种随机因素来保证协商出来的密钥的随机性。对于RSA密钥交换算法来说，pre-master-key本身就是一个随机数，再加上hello消息中的随机，三个随机数通过一个密钥导出器最终导出一个对称密钥。pre master的存在在于SSL协议不信任每个主机都能产生完全随机的随机数，如果随机数不随机，那么pre master secret就有可能被猜出来，那么仅适用pre master secret作为密钥就不合适了，因此必须引入新的随机因素，那么客户端和服务器加上pre master secret三个随机数一同生成的密钥就不容易被猜出了，一个伪随机可能完全不随机，可是是三个伪随机就十分接近随机了，每增加一个自由度，随机性增加的可不是一。"此外，如果前一步，服务器要求客户端证书，客户端会在这一步发送证书及相关信息。四、服务器回应服务器收到客户端的第三个随机数pre-master key之后，计算生成本次会话所用的"会话密钥"。然后，向客户端最后发送下面信息。（1）编码改变通知，表示随后的信息都将用双方商定的加密方法和密钥发送。（2）服务器握手结束通知，表示服务器的握手阶段已经结束。这一项同时也是前面发送的所有内容的hash值，用来供客户端校验。至此，整个握手阶段全部结束。接下来，客户端与服务器进入加密通信，就完全是使用普通的HTTP协议，只不过用"会话密钥"加密内容。至此，整个握手阶段全部结束。接下来，客户端与服务器进入加密通信，就完全是使用普通的HTTP协议，只不过用"会话密钥"加密内容。httpshttps://blog.csdn.net/qq_39390545/article/details/118159145?spm=1001.2014.3001.5501tls握手https://blog.csdn.net/zk3326312/article/details/80245756?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-10.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-10.control泛洪攻击缺陷引起的SYN FloodSYN Flood 攻击SYN- Flood攻击是当前网络上最为常见的DDoS攻击，也是最为经典的拒绝服务攻击，它就是利用了TCP协议实现上的一个缺陷，通过向网络服务所在端口发送大量 的伪造源地址的攻击报文，就可能造成目标服务器中的半开连接队列被占满，从而阻止其他合法用户进行访问。这种攻击早在1996年就被发现，但至今仍然显示 出强大的生命力。很多操作系统，甚至防火墙、路由器都无法有效地防御这种攻击，而且由于它可以方便地伪造源地址，追查起来非常困难。它的数据包特征通常 是，源发送了大量的SYN包，并且缺少三次握手的最后一步握手ACK回复。原理：攻击者首先伪造地址对 服务器发起SYN请求，服务器回应(SYN+ACK)包，而真实的IP会认为，我没有发送请求，不作回应。服务 器没有收到回应，这样的话，服务器不知 道(SYN+ACK)是否发送成功，默认情况下会重试5次（tcp_syn_retries）。这样的话，对于服务器的内存，带宽都有很大的消耗。攻击者 如果处于公网，可以伪造IP的话，对于服务器就很难根据IP来判断攻击者，给防护带来很大的困难。SYN Flood 防护措施 无效连接监视释放这种方法不停的监视系统中半开连接和不活动连接，当达到一定阈值时拆除这些连接，释放系统资源。这种绝对公平的方法往往也会将正常的连接的请求也会被释放掉，”伤敌一千，自损八百“ 延缓TCB分配方法SYN Flood关键是利用了，SYN数据报文一到，系统立即分配TCB资源，从而占用了系统资源，因此有俩种技术来解决这一问题Syn Cache技术这种技术在收到SYN时不急着去分配TCB，而是先回应一个ACK报文，并在一个专用的HASH表中（Cache）中保存这种半开连接，直到收到正确的ACK报文再去分配TCBSyn Cookie技术Syn Cookie技术则完全不使用任何存储资源，它使用一种特殊的算法生成Sequence Number，这种算法考虑到了对方的IP、端口、己方IP、端口的固定信息，以及对方无法知道而己方比较固定的一些信息，如MSS、时间等，在收到对方 的ACK报文后，重新计算一遍，看其是否与对方回应报文中的（Sequence Number-1）相同，从而决定是否分配TCB资源 使用SYN Proxy防火墙原理：对试图穿越的SYN请求进行验证之后才放行012 spring013 redisRedis为什么快单线程和基于内存还因为在存储字符串类型的时候用了 free存储字符串的可用长度 再删除字符串的时候不直接删除 而是把删除的字符串长度变为可用长度 在下次用到时候String 预分配缓存击穿解决办法static Lock reenLock = new ReentrantLock();
    public List<String> getData04() throws InterruptedException {
        List<String> result = new ArrayList<String>();
        // 从缓存读取数据
        result = getDataFromCache();
        if (result.isEmpty()) {
            if (reenLock.tryLock()) {
                try {
                    System.out.println("拿到锁了,从DB获取数据库后写入缓存");
                    // 从数据库查询数据
                    result = getDataFromDB();
                    // 将查询到的数据写入缓存
                    setDataToCache(result);
                } finally {
                    reenLock.unlock();// 释放锁
                }

            } else {
                result = getDataFromCache();// 先查一下缓存
                if (result.isEmpty()) {
                    System.out.println("我没拿到锁,缓存也没数据,先小憩一下");
                    Thread.sleep(100);// 小憩一会儿
                    return getData04();// 重试
                }
            }
        }
        return result;
    }
nginx正向代理这种代理模式称为正向代理，正向代理最大的特点是客户端明确要访问的服务器地址（或网络地址）；而服务器只清楚请求来自哪个代理服务器，却不清楚来自哪个具体的客户端；正向代理模式屏蔽或者隐藏了真实客户端信息。  正向代理，代理的是客户端，代客户端发出请求，是一个位于客户端和目标服务器间的服务器，为了从目标服务器取得内容，客户端向代理发送一个请求并指定目标(内网服务器)，然后代理向目标服务器转交请求并将获得的内容返回给客户端反向代理N个客户端给服务器发送的请求，Nginx服务器接收到之后，按照一定的规则均衡分发给了后端的业务处理服务器进行处理了。此时，请求的客户端是明确的，但是请求具体由哪台服务器处理的并不明确了，Nginx扮演的就是一个反向代理角色。  客户端是无感知代理的存在的，反向代理对外都是透明的，访问者并不知道自己访问的是一个代理。因为客户端不需要任何配置就可以访问。  反向代理，它代理的是服务端，代服务端接收请求，主要用于服务器集群分布式部署的情况下，反向代理隐藏了服务器的信息正向代理中，Proxy和Client同属于一个网，隐藏了客户端信息；反向代理中，Proxy和Server同属于一个网，隐藏了服务端信息；设计模式设计原则开闭原则是总纲，它指导我们要对扩展开放，对修改关闭；单一职责原则指导我们实现类要职责单一；里氏替换原则指导我们不要破坏继承体系；依赖倒置原则指导我们要面向接口编程；接口隔离原则指导我们在设计接口的时候要精简单一；迪米特法则指导我们要降低耦合单例1，静态对象实现    private static SingtonTest1 instance = new SingtonTest1();
	//私有化这样子其它的类不能够通过访问这里的构造创建实例对象使得创建对象只能够在当前类中执行
    private SingtonTest1 (){

    }

    //定义静态程序在一开始就会创建instance实例 且由于为静态修饰只会创建一次
    /*
    * 但由于这个会在 当你不要用到这些对象时也会创建实例对象在内存中 浪费了Java内存空间
    * */
    public static SingtonTest1 getInstance() {

        return instance;
    }
    public static void main(String[] args) {

        SingtonTest1 instance = getInstance();
        SingtonTest1 ingtonTest1 = getInstance();
        System.out.println(instance);
        System.out.println(ingtonTest1);

    }结果设计模式.SingtonTest1@1b6d3586设计模式.SingtonTest1@1b6d35862，静态出现快实现public static void main(String[] args) {
        SingtonTest2 instance1 =  getInstance();
        SingtonTest2 instance2 = getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
    private static SingtonTest2 instance;
    private SingtonTest2() {

    }
    static {
        instance = new SingtonTest2();

    }
    public static SingtonTest2 getInstance(){
        return instance;
    }结果设计模式.Sington.SingtonTest2@1b6d3586设计模式.Sington.SingtonTest2@1b6d3586预先初始化和静态块初始化都会在实例被使用之前创建实例3,延迟执行new public static void main(String[] args) {
        SingtonTest3 instance = getInstance();
        SingtonTest3 instance1 = getInstance();
        System.out.println(instance);
        System.out.println(instance1);

    }
    private static SingtonTest3 instance;
    private SingtonTest3(){

    }
    public static SingtonTest3 getInstance(){
        if (instance==null){
            instance = new SingtonTest3();

        }

        return instance;
    }结果设计模式.Sington.单例.SingtonTest3@1b6d3586设计模式.Sington.单例.SingtonTest3@1b6d3586但这样自会在多线程下创建多个实例4，同步锁public class SingtonTestSync {

    static int k = 0;

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <90 ; i++) {
                System.out.println(getInstance());
            }

        },("Thread"+k)).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getInstance());
    }
    private static SingtonTestSync instance;
    private SingtonTestSync(){

    }
    public static synchronized SingtonTestSync getInstance(){

        if (instance==null){
            instance = new SingtonTestSync();
        }
        k++;
        return instance;
    }
}
结果设计模式.Sington.单例.SingtonTestSync@1acc1ca0设计模式.Sington.单例.SingtonTestSync@1acc1ca0设计模式.Sington.单例.SingtonTestSync@1acc1ca0但由于使用了syn降低了使用效率5，双重public class SingtonSyncPlu {

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
    private static SingtonSyncPlu instance;
    private SingtonSyncPlu(){

    }
    public static SingtonSyncPlu getInstance(){
        if (instance==null){
            synchronized (SingtonSyncPlu.class){
                if (instance==null){
                    instance = new SingtonSyncPlu();
                }
            }
        }
        return instance;
    }
    }

结果设计模式.Sington.单例.SingtonSyncPlu@1b6d3586设计模式.Sington.单例.SingtonSyncPlu@1b6d35866，静态内部类public class SingtonStatic {

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
    private SingtonStatic(){

    }
    private static final class SingtonStaticIn{
        private static final SingtonStatic INSTANCE = new SingtonStatic();
    }
    public static SingtonStatic getInstance(){
        return SingtonStaticIn.INSTANCE;
    }
}
结果设计模式.Sington.单例.SingtonStatic@1b6d3586设计模式.Sington.单例.SingtonStatic@1b6d3586单例类实例的私有内部静态类。当加载单例类时，SingletonHelper类不会加载到内存中，只有当有人调用getInstance方法时，才会加载这个类并创建单例类实例7，反射破坏单例public class SingtonFanshe {

    public static void main(String[] args) {
        SingtonTest1 instance = SingtonTest1.getInstance();
        SingtonTest1 instance1 = null;
        try {
            Constructor<?>[] declaredConstructors = SingtonTest1.class.getDeclaredConstructors();

            for (Constructor c: declaredConstructors) {

                //允许访问所有的构造器
                c.setAccessible(true);
                instance1 = (SingtonTest1)c.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(instance);
        System.out.println(instance1);
    }
}
结果设计模式.SingtonTest1@1b6d3586设计模式.SingtonTest1@4554617c8,枚举类class C{
  public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
public static C getInstance(){

    return Sington1.INSTANCE.getInstance();
}
}
public enum Sington1 {
    INSTANCE;
    private C instance;
    Sington1(){
        instance = new C();
    }
    public C getInstance(){
        return instance;
    }
}
结果设计模式.Sington.单例.C@1b6d3586设计模式.Sington.单例.C@1b6d3586反射不能够破坏因为 Java 确保任何枚举值在 Java 程序中仅被实例化一次。由于Java 枚举值是全局可访问的，因此单例也是如此9，序列化public class SingtonT implements Serializable {
    private static final long serialVersionUID = -7603366932017737115L;

    private SingtonT(){}

    private static class SingtonTIn {
        private static final SingtonT instance = new SingtonT();
    }

    public static SingtonT getInstance(){
        return SingtonTIn.instance;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SingtonT instanceOne = SingtonT.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingtonT instanceTwo = (SingtonT) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

    }

}
结果instanceOne hashCode=21685669instanceTwo hashCode=1452126962序列化单例类的问题在于，无论何时反序列化它，它都会创建该类的一个新实例。让我们用一个简单的程序来看看它解决protected Object readResolve(){ return getInstance(); }反序列化时，首先获取序列化的类 ： desc（ 可理解为单例类的class类，但它和JVM加载到内存中的单例class类有不同）因为如果我们的单例类在构造方法中通过实例不为空则抛出异常防止了反射破坏单例，那单例类是不允许再实例化的。而desc类却依然可以实例化。（当我们反序列化一个对象时，永远不会调用其类的构造函数，反序列化后的实例变量与序列化之前的实例变量相同，类变量与当前的类变量相同，如果反序列化时类未被加载则类变量为默认值。）判断对象是否能实例化。可以则进行实例化，至此单例类进行了第一次实例化，对象名为obj第一次实例化完成后，通过反射寻找该单例类中的readResolve()方法，没有则直接返回obj对象。（这就是直接反序列化破坏单例模式的原因）有定义readResolve()方法，desc通过invokeReadResolve(Object obj)方法调用readResolve()方法获取单例对象instance，将他赋值给rep，如果单例对象之前已经被实例化过，那么rep就会指向之前实例化的单例对象。如果我们之前没有实例化单例对象，则rep会指向null。rep与obj进行比较，由于obj是反射获取的对象，当然与rep不等，于是将rep的值instance赋值给obj，将obj返回，返回对象instance也就保证了单例。简而言之就是，当我们通过反序列化readObject()方法获取对象时会去寻找readResolve()方法，如果该方法不存在则直接返回新对象，如果该方法存在则按该方法的内容返回对象，以确保如果我们之前实例化了单例对象，就返回该对象。如果我们之前没有实例化单例对象，则会返回null。public class SingtonT implements Serializable {
    private static final long serialVersionUID = -7603366932017737115L;

    private SingtonT(){}

    private static class SingtonTIn {
        private static final SingtonT instance = new SingtonT();
    }

    public static SingtonT getInstance(){
        return SingtonTIn.instance;
    }
    protected Object readResolve() {
        return getInstance();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SingtonT instanceOne = SingtonT.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingtonT instanceTwo = (SingtonT) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

    }

}
工厂1,抽象父类定义原材料  规范//抽象父类定义全局
public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
2，产品类PCpublic class PC extends Computer{

    private String ram;
    private String hdd;
    private String cpu;
    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
Serverpublic class Server extends Computer{

    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}
3，生产工厂类客户端这边只需要工厂类传入不同的类型参数就能够创建不同的产品 //工厂类
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        //通过客户端的选择来生产不同的产品 PC和Server为Computer的产品 抽象类给咱定义设计原料 咱根据相同原料的不同配合生产不同的商品
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);

        return null;
    }
}
4，测试类public class TestFactory {

    public static void main(String[] args) {
        Computer pc1 = ComputerFactory.getComputer("PC", "3GB", "300GB", "3Ghz");
        Computer server1 = ComputerFactory.getComputer("Server", "5GB", "500GB", "5Ghz");
        System.out.println("pc1"+pc1);
        System.out.println("server1"+server1);
    }
}
5，结果pc1RAM= 3GB, HDD=300GB, CPU=3Ghzserver1RAM= 5GB, HDD=500GB, CPU=5Ghz抽象工厂1，抽象超类//抽象超类
public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}2，抽象工厂超类为工厂定义规范//工厂类的抽象类为生产的工定义规范
public interface ComputerAbstractFactory {

    public Computer createComputer();

}3，需要生产的产品类PCpublic class PC extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}Serverpublic class Server extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}4，工厂产品类PCFactory//定义生产PC需要那些零件啥之类的
public class PCFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public Computer createComputer() {
        return new PC(ram,hdd,cpu);
    }

}ServerFactory//定义生产Server需要那些零件啥之类的
public class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }

}5，消费者给工厂提供需求 作为中间人根据传入的类不同要求不同的工厂生产对用的产品//消费者给真正的工厂类提供需求
public class ComputerFactory {

    //根据传入的ComputerAbstractFactory多态判断实现的子类选择对应的工厂创建对应的产品
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}6，测试类public class TestDesignPatterns {


    public static void main(String[] args) {
        testAbstractFactory();
    }

    //这样子会不需要在扩展需要的产品 如本来只需要生产两个产品，现在又要多加十一个产品  又会在服务端程序多加十多个ifelse 耦合太高了
    //现在要扩展多个产品的时候只需要多增加产品类和产品工厂类 对原有的程序未进行修改
    private static void testAbstractFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("3 GB","500 GB","1.9 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("11 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
7，结果AbstractFactory PC Config::RAM= 3 GB, HDD=500 GB, CPU=1.9 GHzAbstractFactory Server Config::RAM= 11 GB, HDD=1 TB, CPU=2.9 GHz建造者为了解决当对象包含大量属性时工厂和抽象工厂设计模式的一些问题。当对象包含大量属性时，工厂和抽象工厂设计模式存在三个主要问题。从客户端程序传递到 Factory 类的参数太多，这很容易出错，因为大多数时候，参数的类型是相同的，并且从客户端很难维护参数的顺序。一些参数可能是可选的，但在工厂模式中，我们被迫发送所有参数，可选参数需要作为 NULL 发送。如果对象很重并且它的创建很复杂，那么所有这些复杂性都将成为令人困惑的 Factory 类的一部分生成器模式是一种创建型设计模式， 使你能够分步骤创建复杂对象。 该模式允许你使用相同的创建代码生成不同类型和形式的对象1，需要生产的产品原料public interface Matter {

    String scene();      // 场景；地板、地砖、涂料、吊顶

    String brand();      // 品牌

    String model();      // 型号

    BigDecimal price();  // 价格

    String desc();       // 描述

}
2，原料public class MarcoPoloTile implements Matter {

    public String scene() {
        return "地砖";
    }

    public String brand() {
        return "马可波罗(MARCO POLO)";
    }

    public String model() {
        return "缺省";
    }

    public BigDecimal price() {
        return new BigDecimal(140);
    }

    public String desc() {
        return "“马可波罗”品牌诞生于1996年，作为国内最早品牌化的建陶品牌，以“文化陶瓷”占领市场，享有“仿古砖至尊”的美誉。";
    }

}
public class LiBangCoat implements Matter {

    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "立邦";
    }

    public String model() {
        return "默认级别";
    }

    public BigDecimal price() {
        return new BigDecimal(650);
    }

    public String desc() {
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }

}
public class DuluxCoat  implements Matter {

    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "多乐士(Dulux)";
    }

    public String model() {
        return "第二代";
    }

    public BigDecimal price() {
        return new BigDecimal(719);
    }

    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使用多乐士油漆。";
    }

}
public class DongPengTile implements Matter {

    public String scene() {
        return "地砖";
    }

    public String brand() {
        return "东鹏瓷砖";
    }

    public String model() {
        return "10001";
    }

    public BigDecimal price() {
        return new BigDecimal(102);
    }

    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }

}
public class DerFloor implements Matter {

    public String scene() {
        return "地板";
    }

    public String brand() {
        return "德尔(Der)";
    }

    public String model() {
        return "A+";
    }

    public BigDecimal price() {
        return new BigDecimal(119);
    }

    public String desc() {
        return "DER德尔集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
    }

}
public class DecorationPackageMenu implements Builder {

    private List<Matter> list = new ArrayList<Matter>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    private DecorationPackageMenu() {
    }

    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    public Builder appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    public Builder appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    public Builder appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public Builder appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
public class LevelTwoCeiling  implements Matter {

    public String scene() {
        return "吊顶";
    }

    public String brand() {
        return "装修公司自带";
    }

    public String model() {
        return "二级顶";
    }

    public BigDecimal price() {
        return new BigDecimal(850);
    }

    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }

}
3，建造者用来定义要生产的顺序 要多少原料 选择参数数量public interface Builder {

    Builder appendCeiling(Matter matter); // 吊顶

    Builder appendCoat(Matter matter);    // 涂料

    Builder appendFloor(Matter matter);   // 地板

    Builder appendTile(Matter matter);    // 地砖

    String getDetail();                 // 明细

}
4 ，控制生成器 public class DecorationPackageMenu implements Builder {

    private List<Matter> list = new ArrayList<Matter>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    private DecorationPackageMenu() {
    }

    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    public Builder appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    public Builder appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    public Builder appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public Builder appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
5，测试类public class test_Builder {

    public static void main(String[] args) {
        Director director = new Director();
        // 豪华欧式
        System.out.println(director.levelOne(132.52D).getDetail());
        // 轻奢田园
        System.out.println(director.levelTwo(98.25D).getDetail());
        // 现代简约
        System.out.println(director.levelThree(85.43D).getDetail());
    }
}
6，结果-------------------------------------------------------
装修清单
套餐等级：豪华欧式
套餐价格：198064.39 元
房屋面积：132.52 平米
材料清单：
吊顶：装修公司自带、二级顶、平米价格：850 元。
涂料：多乐士(Dulux)、第二代、平米价格：719 元。
地板：圣象、一级、平米价格：318 元。


-------------------------------------------------------
装修清单
套餐等级：轻奢田园
套餐价格：119865.00 元
房屋面积：98.25 平米
材料清单：
吊顶：装修公司自带、二级顶、平米价格：850 元。
涂料：立邦、默认级别、平米价格：650 元。
地砖：马可波罗(MARCO POLO)、缺省、平米价格：140 元。


-------------------------------------------------------
装修清单
套餐等级：现代简约
套餐价格：91580.96 元
房屋面积：85.43 平米
材料清单：
吊顶：装修公司自带、一级顶、平米价格：300 元。
涂料：立邦、默认级别、平米价格：650 元。
地砖：东鹏瓷砖、10001、平米价格：102 元。
装饰器初看上图感觉装饰器模式有点像俄罗斯套娃、某众汽车🚕，而装饰器的核心就是再不改原有类的基础上给类新增功能。不改变原有类，可能有的小伙伴会想到继承、AOP切面，当然这些方式都可以实现，但是使用装饰器模式会是另外一种思路更为灵活，可以避免继承导致的子类过多，也可以避免AOP带来的复杂性装饰器主要解决的是直接继承下因功能的不断横向扩展导致子类膨胀的问题，而是用装饰器模式后就会比直接继承显得更加灵活同时这样也就不再需要考虑子类的维护。在装饰类中有两个重点的地方是；1)继承了处理接口、2)提供了构造函数、3)覆盖了方法preHandle。以上三个点是装饰器模式的核心处理部分，这样可以踢掉对子类继承的方式实现逻辑功能扩展。1，需要增强的接口类的被实现对象public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}2，增强接口类的实现public class SsoInterceptor implements HandlerInterceptor{

    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
3，增强接口类的执行接口public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
4，增强接口类执行实现类import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSsoDecorator extends SsoDecorator {


    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
       System.out.println("模拟单点登录方法访问拦截校验："+ userId +"    "+ method);;
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
5，测试类public class test_LoginSsoDecorator {

    public static void main(String[] args) {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));

    }
}
6，结果模拟单点登录方法访问拦截校验：huahua    queryUserInfo登录校验：1successhuahua 放行就像夏天热你穿短裤，冬天冷你穿棉裤，雨天挨浇你穿雨衣一样，你的根本本身没有被改变，而你的需求却被不同的装饰而实现。生活中往往比比皆是设计，当你可以融合这部分活灵活现的例子到代码实现中，往往会创造出更加优雅的实现方式原型原型模式主要解决的问题就是创建重复对象，而这部分对象内容本身比较复杂，生成过程可能从库或者RPC接口中获取数据的耗时较长，因此采用克隆的方式节省时间如果你有一个对象，并希望生成与其完全相同的一个复制品，你该如何实现呢？首先，你必须新建一个属于相同类的对象。然后，你必须遍历原始对象的所有成员变量，并将成员变量值复制到新对象中。不错！ 但有个小问题。 并非所有对象都能通过这种方式进行复制， 因为有些对象可能拥有私有成员变量， 它们在对象本身以外是不可见的。模版关于模版模式的核心点在于由抽象类定义抽象方法执行策略，也就是说父类规定了好一系列的执行标准，这些标准的串联成一整套业务流程模板方法模式建议将算法分解为一系列步骤，然后将这些步骤改写为方法，最后在“模板方法”中依次调用这些方法。步骤可以是抽象的，也可以有一些默认的实现。为了能够使用算法，客户端需要自行提供子类并实现所有的抽象步骤。如有必要还需重写一些步骤（但这一步中不包括模板方法自身）。让我们考虑如何在数据挖掘应用中实现上述方案。 我们可为图中的三个解析算法创建一个基类， 该类将定义调用了一系列不同文档处理步骤的模板方法。/**
 * Base class of social network.
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.userName, this.password)) {
            // Send the post data.
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}/**
 * Class of social network
 */
public class Facebook extends Network {
    public Facebook(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}/**
 * Class of social network
 */
public class Twitter extends Network {

    public Twitter(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Twitter");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Twitter");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}public class Test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
结果Input user name: zhangsanInput password: 111Input message: 111Choose social network for posting message.1 - Facebook2 - Twitter1Checking user's parametersName: zhangsanPassword: ***..........LogIn success on FacebookMessage: '111' was posted on FacebookUser: 'zhangsan' was logged out from Facebook 代理他的特征是代理类与委托类有同样的接口，代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等。代理类与委托类之间通常会存在关联关系，一个代理类的对象与一个委托类的对象关联，代理类的对象本身并不真正实现服务，而是通过调用委托类的对象的相关方法，来提供特定的服务。简单的说就是，我们在访问实际对象时，是通过代理对象来访问的，代理模式就是在访问实际对象时引入一定程度的间接性，因为这种间接性，可以附加多种用途/**
 * 创建Person接口
 */
public interface Person {
    //上交班费
    void giveBan();
}被代理类为public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveBan() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }
}
打印时间加工具类public class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
代理类/*
* 创建StuInvocationHandler类，实现InvocationHandler接口，这个类中持有一个被代理对象的实例target。
* InvocationHandler中有一个invoke方法，所有执行代理对象的方法都会被替换成执行invoke方法。在invoke方法中执行被代理对象target的相应方法。
* 在代理过程中，我们在真正执行被代理对象的方法前加入自己其他处理。这也是Spring中的AOP实现的主要原理，这里还涉及到一个很重要的关于java反射方面的基础知识。
*/
public class StuInvocationHandler<T> implements InvocationHandler {
    //invocationHandler持有的被代理对象
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" +method.getName() + "方法");
        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
测试类public class ProxyTest {
    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveBan();
    }
}
结果代理执行giveBan方法张三上交了班费330元giveBan用时1000JDK动态代理只能对实现了接口的类生成代理，而不能针对类 ，使用的是 Java反射技术实现，生成类的过程比较高效。CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法 ，使用asm字节码框架实现，相关执行的过程比较高效，生成类的过程可以利用缓存弥补，因为是继承，所以该类或方法最好不要声明成final JDK代理是不需要第三方库支持，只需要JDK环境就可以进行代理，使用条件:实现InvocationHandler + 使用Proxy.newProxyInstance产生代理对象 + 被代理的对象必须要实现接口CGLib必须依赖于CGLib的类库，但是它需要类来实现任何接口代理的是指定的类生成一个子类，覆盖其中的方法，是一种继承但是针对接口编程的环境下推荐使用JDK的代理；网关LVS的英文全称是Linux Virtual Server，即Linux虚拟服务器，主要用于多服务器的负载均衡。F5是负载均衡产品的一个品牌，除此以外还有，Radware、Array、A10、Cisco等。Nginx就比较常见，它是由C语言编写的，是一个高性能的HTTP和反向代理web服务器，同时也提供了IMAP/POP3/SMTP服务。泛型类型擦除https://blog.csdn.net/qing_gee/article/details/119239180?spm=1001.2014.3001.5501实战返回类型入参https://blog.csdn.net/qq_39390545https://github.com/fuzhengwei/CodeGuide/wikihttps://github.com/SharingSource/LogicStack-LeetCode/wikihttps://bugstack.blog.csdn.net/刷题https://blog.csdn.net/weixin_45629285/category_10556551_2.htmlhttps://leetcode-cn.com/leetbook/read/top-interview-questions/xm0u83/https://leetcode-cn.com/circle/article/48kq9d/  List<Integer> list = new ArrayList<>();        int a = matrix.length;        int b = 0;        int c = matrix[0].length;        int k = 0;        int e = matrix[0].length;        int f = 0;        int l = matrix.length;        int w = 0;        int t = matrix.length + 2;        int count  = 0;        while (count < t){switch(count%3){case 0 ://bcfor (int i = b; i < c; i++) {                        list.add(matrix[b][i]);}b++;c--;                    break; //可选                //afcase 1 ://语句for (int i = f+1; i < a ; i++) {list.add(matrix[i][a-1]);}                    a--;f++;                    break; //可选                //你可以有任意数量的case语句case 2 :for (int i = e - 2; i >= k   ; i--) {list.add(matrix[e-1][i]);}                    k++;e--;                    break;                case 3 :for (int i = l - 2; i > w ; i--) {list.add(matrix[i][w]);}                    w++;l--;                    break;                default : //可选                    //语句}count++;}return list;数组的遍历495. 提莫攻击看了题解495. 提莫攻击
  
public int findPoisonedDuration(int[] timeSeries, int duration) {
 int index = 1;
        int result = 0;
        while (index<timeSeries.length){
            if (timeSeries[index]-timeSeries[index-1]>=duration){
                result+=duration;
            }
            else {
                result+=timeSeries[index]-timeSeries[index-1];
            }
            index++;
        }
return result+duration;
    }485. 最大连续 1 的个数看了题解485. 最大连续 1 的个数

public int findMaxConsecutiveOnes(int[] nums) {
int index = 0;
        int current = 0;
        int result = 0;
        while (index<nums.length){
            if (nums[index] == 1){
                current++;
            }else {
                current = 0;
            }
            index++;
            result = result>current ? result : current;
            
        }
return result;
    }628. 三个数的最大乘积未看题解628. 三个数的最大乘积
public int maximumProduct(int[] nums) {
 int result1 = Integer.MIN_VALUE;
        int result2 = Integer.MIN_VALUE;
        int result3 = Integer.MIN_VALUE;
        int zui1 = Integer.MAX_VALUE;
        int zui2 = Integer.MAX_VALUE;
        for (int c: nums) {
            if (c>result1){
                result3 = result2;
                result2 = result1;
                result1 = c;
            }else if (c>result2){
                result3 = result2;
                result2 = c;
            }else if (c>result3){
                result3 = c;
            }

            if (c < zui1){
                zui2 = zui1;
                zui1 = c;
            }else if (c < zui2){
                zui2 = c;
            }

        }
return Math.max(result1*result2*result3,result1*zui1*zui2);
    }414. 第三大的数看了题解414. 第三大的数
  
public int thirdMax(int[] nums) {
 long result1 = Long.MIN_VALUE;
        long result2 = Long.MIN_VALUE;
        long result3 = Long.MIN_VALUE;


        for (int i = 0; i <nums.length ; i++) {
            //当编历到的数据等于三大数任意个跳过
            if (nums[i] == result1 || nums[i] == result2 || nums[i] == result3) continue;
            if (nums[i]>result1){
                result3 = result2;
                result2 = result1;
                result1 = nums[i];
            }else if (nums[i]>result2){
                result3 = result2;
                result2 = nums[i];
            }else if (nums[i]>result3){
                result3 = nums[i];
            }
        }
            return (int) (result3 == Long.MIN_VALUE ? result1 : result3);
    }统计数组中的元素697. 数组的度public class _697数组的度 {

    public static int findShortestSubArray(int[] nums) {
        //结果成功但用了两层for超过时间限制了啊
//        if (nums.length == 1){
//            return 1;
//        }
//        int currentZui = 1;
//        int result = 1;
//        int len = 1;
//        int result1 = 1;
//
////        if (nums[0] == nums[nums.length-1]){
////            index = 1;
////        }
//        for (int i = 0; i <nums.length ; i++) {
//            //开始处
//             //结尾处
//            for (int j = i+1; j <nums.length ; j++) {
//
//                if (nums[i] == nums[j]){
//
//                    currentZui++;
//                    len = j - i + 1;
//
//                }
//            }
//            if (result > currentZui){
//
//
//            }else if (currentZui > result){
//                result = currentZui;
//                result1 = len;
//            }
//            else {
//               result1 = Math.min(result1,len);
//            }
//
//            currentZui = 1;
//        }
//return result1;





        //要想要不会超时 要使用多次循环 不要用嵌套的循环 用到了这个统计数组位置出现的频次，可使用令个数组映射索引为原数组的数据 值为其大小
        int[] first = new int[50000];
        int[] last = new int[50000];
        int result = 1;
        int currentZui[] = new int[50000];
        int result1 = Integer.MAX_VALUE;
        //定义所有的数据原来的开始处位置为-1
        Arrays.fill(first, -1);

        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            currentZui[k] ++;
result = Math.max(currentZui[k],result );
            if (first[k] == -1){
                first[k] = i;
            }
            last[k] = i;
        }
        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            if (result == currentZui[k]){
                result1 = Math.min(result1,last[k] - first[k] + 1);

            }
        }
        return result1;
    }
}
26. 删除有序数组中的重复项 public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        int fast = 1;
        int slow = 1;
        while (fast < nums.length){
            if (nums[fast]!=nums[slow-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
return  nums[slow] ;27. 移除元素 public int removeElement(int[] nums, int val) {
        //左右指针覆盖 左指针往左全部都未含有val 左指针的值要被有指针的值覆盖
        int slow = 0;
       int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }else {

                fast++;
            }
        }
return slow;448. 找到所有数组中消失的数字未看题解public class _448找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[1,1]
        int[] a = new int[nums.length+1];
        Arrays.fill(a,-1);
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            a[k] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 1){
                list.add(i);
            }
        }
return list;
    }
}
41. 缺失的第一个正数看了题解public class _41缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        //超过了空间限制
//        int[] currentZui = new int[Integer.MAX_VALUE];
//        int result1 = 0;
//        for (int i = 0; i <nums.length ; i++) {
//
//            if (nums[i]>=0){
//                currentZui[nums[i]] ++;
//            }
//
//        }
//        for (int i = 0; i <currentZui.length ; i++) {
//            if (currentZui[i] == 0){
//                result1 = Math.min(result1,currentZui[i]);
//            }
//        }
//
////        Arrays.binarySearch()
//return result1;

        Arrays.sort(nums);

            for (int j = 1; j <nums.length ; j++) {
                        if (Arrays.binarySearch(nums,j)<0){
return j;
                        }
            }

return nums[nums.length-1]+1;
    }
}
442. 数组中重复的数据未看题解public class _442数组中重复的数据 {
    public static void main(String[] args) {
        int[] k = new int[]{4,3,2,7,8,2,3,1};
        findDuplicates(k);
    }
    public static List<Integer> findDuplicates(int[] nums) {
List<Integer> list = new ArrayList<>();
int[] a = new int[nums.length+1];
        Arrays.fill(a,0);
        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            a[k] ++ ;
        }
        for (int i = 0; i <a.length ; i++) {
            if (a[i]==2){
                list.add(i);
            }
        }
return list;
    }
}274. H指数未清楚public class _274H指数 {

    public int hIndex(int[] citations) {

//int[] a =  new int[citations.length+1];
//        Arrays.fill(a,0);
//        for (int i = 0; i <citations.length ; i++) {
//            int k = citations[i];
//            //被引用了多少次的论文有几篇
//            a[k] ++;
//        }
////        题目就想找出有n篇论文被引用了>=n次,求n的最大值，n篇和n次必须是相等的
//return 1;
        //超过当前论文引用次数的论文篇数
        //[1,3,1]
//        if (citations[0]==0 && citations.length == 1){
//            return 0;
//        }
//        else if (citations[0] !=0 && citations.length == 1){
//            return 1;
//        }
//        int current = 1;
//        int result1 = 0;
//        for (int i = 0; i <citations.length ; i++) {
//            for (int j = i+1; j < citations.length; j++) {
//                if (citations[j]>=citations[i]){
//                   current++;
//                }
//            }
//            if (current >= citations[i]){
//                result1 = result1> current ? result1 : current;
//            }
//            current = 1;
//        }
//

        Arrays.sort(citations);
        int result1 = 0;
        int k = citations.length - 1;
while ( k>=0 && citations[k] > result1){
result1 ++;

k--;
}
        return result1;
    }

数组的改变、移动283. 移动零未看题解public class _283移动零 {

    public void moveZeroes(int[] nums) {
        //[0,1,0,3,12] 1 0 0 3 12      1 3 0 0 12    1 3 12 0 0 [1,0]
        if (nums.length == 1){
            return ;
        }
        int index = 0;
        for (int i = 0; index <nums.length ; i++) {
            while ( index<nums.length && nums[index] == 0 ){

               index++;

           }
           if (index == nums.length){
               return;
           }
           if ( i != index){
               nums[i] = nums[index];
               nums[index] = 0;
           }

            index++;
        }
    }
}
453. 最小操作次数使数组元素相等看了题解public class _453最小操作次数使数组元素相等 {

    public int minMoves(int[] nums) {
        //首先要更新n-1个数值加一即要所有的值一样且要执行加一操作 因此最大值不要执行加一操作 
        // 为了加快加一的速度 因为都至少要把最小值加到最大值 因此直接给所有的除最大值的值加上最大值与最小值的差值
        Arrays.sort(nums);
        int result = 0;
        int step = 0;
        for (int i = nums.length-1; i > 0  ; i--) {
            //最小值一直是0位 最大值随着增加步值往前移动一个位置
            step = nums[i] - nums[0];
            nums[0] += step;
            //单次操作只会更新前一数据 而未更新之前的数据 在下次操作的时候更新只加上step值会漏掉数
            result += step;
            nums[i -1] += result;
        }
        return result;
    }
}
二维数组及滚动数组419. 甲板上的战舰未看题解public class _419甲板上的战舰 {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'X'){
                        result ++;
                        if (i-1 >= 0 &&board[i-1][j] == 'X'){
                            result--;
                        }
                        else if (j-1 >= 0 && board[i][j-1] == 'X'){
                            result--;
                        }
                    }
            }
        }
return result;
    }
}
598. 范围求和 II未看题解public class _598范围求和II {
    public int maxCount(int m, int n, int[][] ops) {
    if (ops.length == 0){
        return m*n;
}
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i <ops.length ; i++) {
            a = Math.min(a,ops[i][0]);
            b = Math.min(b,ops[i][1]);
        }
return a*b;
    }
}
661. 图片平滑器未看题解public class _661图片平滑器 {
    public static void main(String[] args) {
        int[][] b = new int[][]{{3,1,1}, {1,0,1},{1,1,1}};
        imageSmoother(b);
    }
    public static int[][] imageSmoother(int[][] img) {
            int[][] result = new int[img.length][img[0].length];
int current = 0;
int result1 = 0;
        for (int i = 0; i <img.length ; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result1 += img[i][j];
                current ++;
                //左边
              if (j - 1 >= 0 ){
                  result1 += img[i][j-1];
                  current ++;

              }
              //右边
                if (j + 1 < img[0].length){
                    result1 += img[i][j+1];
                    current ++;

                }
                //上边
                if ( i -1 >= 0 ){
                    result1 += img[i-1][j];
                    current++;
                }
                //下边
                if (i+1 < img.length){
                    result1 += img[i+1][j];
                    current++;
                }
                //左上
                if (i-1 >=0 && j-1 >= 0){
                    result1 += img[i-1][j-1];
                    current++;
                }
                //右上
                if (i-1 >=0 && j+1 < img[0].length){
                    result1 +=img[i-1][j+1];
                    current++;
                }
                //左下
                if (i+1 < img.length && j - 1>=0){
                    result1 += img[i+1][j-1];
                    current++;
                }
                //右下
                if (i+1 < img.length && j+1 < img[0].length){
                    result1 += img[i+1][j+1];
                    current++;
                }
                result[i][j] = (int) Math.floor((double) result1/current);
                result1 = 0;
                current = 0;
            }
        }
            return result;

    }
}
119. 杨辉三角 II未看题解119. 杨辉三角 II 
public List<Integer> getRow(int rowIndex) {
     List<Integer> list1;
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i <= rowIndex ; i++) {
            list1 = new ArrayList<>();
            for (int j = 0; j < i+1 ; j++) {
                if (j == 0 || j == i){
                    list1.add(1);
                }else {
                    list1.add(list3.get(j)+list3.get(j-1));
                }
            }
            list3 = list1;
        }
            return list3;
    }118杨辉三角未看题解public class _118杨辉三角 {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list3;
        for (int i = 1; i <=numRows ; i++) {
            list3 = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                if (j == 0 || j == (i-1) ){
                    list3.add(1);
                }else {


                    list3.add(list1.get(j)+list1.get(j-1));

                }
            }
            list1 = list3;

            list.add(list1);
        }
        return list;

    }
}
数组的旋转396. 旋转函数看了题解public class _396旋转函数 {

    public int maxRotateFunction(int[] nums) {
        int result1 = 0;
        int charZhi = 0;
        int current = 0;
        int b = 0;
        for (int i = 0; i <nums.length ; i++) {
            current += nums[i] * ((i)%nums.length);
        }
        b = current;
        for (int i = 0; i <nums.length ; i++) {
            result1 += nums[i];
        }
        for (int i = 1; i <nums.length ; i++) {
           //错位相减法

            charZhi = result1 - (nums.length)*nums[nums.length-i];
            current += charZhi;
            b = Math.max(b,current);
        }
return b ;
    }
}
189. 旋转数组未看题解public class _189旋转数组 {

    public void rotate(int[] nums, int k) {
int[] result = new int[k];
int index = 0;
if (nums.length <= 1){
    return;
}
        for (int i = Math.abs(nums.length - k%nums.length); i <nums.length ; i++) {
            result[index] = nums[i];
            index++;
        }
        for (int i = nums.length - 1; i >=  k%nums.length; i--) {
            nums[i] = nums[i-k%nums.length];
        }
        for (int i = 0; i <index ; i++) {
            nums[i] = result[i];
        }
    }
}
特定顺序遍历二维数组498. 对角线遍历看了题解public class _498对角线遍历 {
    public static void main(String[] args) {
        int[][] b = new int[][]{{ 1, 2, 3 } , { 4, 5, 6} , {7, 8, 9}  };
        findDiagonalOrder(b);
    }
    public static int[] findDiagonalOrder(int[][] mat) {
            int [] result = new  int[mat.length*mat[0].length];
            int index = 0;
            int count = 0;
            int t = mat.length + mat[0].length -1;
            int current = 0;

            //列
            int indexZ = 0;
            //行
            int indexA = 0;
            while (count < t){
                switch(count%2){
                    case 0 :
                        //语句
                        for (int i = indexA, j = indexZ; i >=0 && j<mat[0].length; i--,j++) {
                                  result[index] = mat[i][j];

                                  current = j;
                                  index++;
                                  indexA = i;
                                  indexZ = j;
                                }
                        if (current  == mat[0].length-1){
                            indexA++;
                        }else {
                            indexZ++;
                        }
                        break; //可选
                    case 1 :
                        for (int i = indexA,j = indexZ; i < mat.length && j >=0; i++,j--) {
                                    result[index] = mat[i][j];
                            indexA = i;
                            indexZ = j;
                                    current = i;
                                    index++;
                        }
                        if (current == mat.length - 1){
                            indexZ++;
                        }else {
                            indexA++;
                        }
                        //语句
                        break; //可选
                    //你可以有任意数量的case语句
                    default : //可选
                        //语句
                }

                count++;
            }

            return result;
    }
}
59. 螺旋矩阵 II未看题解public class _59螺旋矩阵II {

    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int t = n*2 -1;
            int count = 0;
            int a = 0;
            int b = n;
            int c = 0;
            int k = n;
            int value = 1;
            while (count < t){
                switch(count%4){
                    case 0 :
                        //语句
                        for (int i = c; i < k ; i++) {
                            result[a][i] = value;
                            value++;
                        }
                        a++;
                        break; //可选
                    case 1 :
                        for (int i = a; i < b ; i++) {
                            result[i][k-1] = value;
                            value++;
                        }
                        k--;
                        //语句
                        break; //可选
                    //你可以有任意数量的case语句
                    case 2 :
                        for (int i = k-1; i >= c ; i--) {
                            result[b-1][i] = value;
                            value++;
                        }
                        b--;
                        break;
                    case 3 :
                        for (int i = b-1; i >= a ; i--) {
                            result[i][c] = value;
                            value++;
                        }
                        c++;
                        break;
                    default : //可选
                        //语句
                }
                count++;
            }
            return result;
    }
}
54. 螺旋矩阵未看题解public class _54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int a = matrix.length;
        int b = 0;
        int c = matrix[0].length;
        int k = 0;

        int e = matrix[0].length;
        int f = 0;
        int l = matrix.length;
        int w = 0;
        int t = matrix.length + 2;
        int count  = 0;
        while (count < t){
            switch(count%3){
                case 0 :



                    //bc
                    for (int i = b; i < c; i++) {



                        list.add(matrix[b][i]);


                    }
b++;
                    c--;
                    break; //可选
                //af
                case 1 :
                    //语句
                    for (int i = f+1; i < a ; i++) {
list.add(matrix[i][a-1]);
                    }
                    a--;
                    f++;
                    break; //可选
                //你可以有任意数量的case语句
                case 2 :
                    for (int i = e - 2; i >= k   ; i--) {
list.add(matrix[e-1][i]);
                }
                    k++;
                    e--;
                    break;
                case 3 :
                    for (int i = l - 2; i > w ; i--) {
list.add(matrix[i][w]);
                    }
                    w++;
                    l--;
                    break;
                default : //可选
                    //语句
            }
count++;
        }



        return list;
    }
}
二维数组变换73. 矩阵置零未看题解public class _73矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int[][] b  =  new int[matrix[0].length*matrix.length][2];
        int index = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0){
                        b[index][0] = i;
                        b[index][1] = j;
                        index++;
                    }
            }
        }
        for (int i = 0; i < index; i++) {
            //行0
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix[b[i][0]][j] = 0;
            }



            //列
            for (int j = 0; j <matrix.length ; j++) {
                matrix[j][b[i][1]] = 0;

            }
        }
    }
}
48. 旋转图像未看题解public class _48旋转图像 {

    public static void main(String[] args) {
        int[][] b = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(b);
    }
    public static void rotate(int[][] matrix) {
        int count = matrix.length - 2;
        int b = 0;
        int c = 0;
        int current = 0;
        int index = 0;

        int you = matrix.length;
        do {

            for (int i = index,j = index;  j < you - 1 ; j++) {

                            int k = 0;
                current =    matrix[i][j];
                        while (k < 4){
                            b = current;
                            current = matrix[j][matrix.length-i-1];


                            matrix[j][matrix.length-i-1] = b;
                            //行列交换
                            c = j;
                            j = matrix.length-i-1;
                            i = c;
                            k++;
                        }

            }
            you --;
            count--;
            index++;
        }
        while (count > 0 );

    }
}
566. 重塑矩阵未看题解public class _566重塑矩阵 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
            int[][] result = new int[r][c];
            int[] current = new int[mat.length*mat[0].length];
            int index = 0;
            if (mat.length*mat[0].length != r*c){
                return  mat;
            }
            else {
             for (int i = 0; i <mat.length ; i++) {
                for (int j = 0; j <mat[0].length ; j++) {
                    current[index] = mat[i][j];
                    index++;
                }
            }
             int k = 0;
                for (int i = 0; i <r ; i++) {
                    for (int j = 0; j <c ; j++) {
                        result[i][j] = current[k];
                        k++;
                    }
                }
                return result;

            }

    }
}
前缀和数组238. 除自身以外数组的乘积未看题解public class _238除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
            int current = 1;
            int l = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == 0){
                l++;
            }else {
                current *= nums[i];

            }
        }
        int[] result = new  int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            if (l>1){
                result[i] = 0;
            }

            else if (l == 1 && nums[i] != 0){
                result[i] = 0;


            }
            else if (l==1 && nums[i] == 0){

                result[i] = current;

            }
            else {
                result[i] = current/nums[i];
            }
        }
        return result;
    }
}

字符520. 检测大写字母未看题解public class _520检测大写字母 {

    public boolean detectCapitalUse(String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))){
                index++;
            }
        }
    if (index == word.length()){
        return true;
    }else if (index == 1 && Character.isUpperCase(word.charAt(0))){
        return true;
    }else if (index == 0){
        return true;
    }
        return false;
    }
}回文串的定义125. 验证回文串未看题解public class _125验证回文串 {


    public boolean isPalindrome(String s) {
        String k = s.toLowerCase();

        int i = 0;
        int j = k.length() - 1;
     while (i<=j){
         if (!(Character.isDigit(k.charAt(i))   || k.charAt(i)>='a'&& k.charAt(i)<='z' )){
                    i++;
                    continue;
         }
         if ( !(Character.isDigit(k.charAt(j))   || k.charAt(j)>='a'&& k.charAt(j)<='z' )){
                        j--;
continue;
         }
         else if (k.charAt(i) == k.charAt(j)){
             i++;

             j--;


         }else if (k.charAt(i) != k.charAt(j)){
             return false;
         }

     }


        return true;
    }
}
公共前缀14. 最长公共前缀未看题解public class _14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        int zui = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i <strs.length ; i++) {
            zui = strs[i].length() > zui ? zui : strs[i].length();
        }
            for (int j = 0; j < zui ; j++) {
                char current = strs[0].charAt(j);

                for (int k = 1; k < strs.length; k++) {
                    if (!(strs[k].charAt(j)==current)){
                        return result;

                    }

                }
                result += current;


        }
        return result;

    }
}
单词58. 最后一个单词的长度未看题解public class _58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        String s1 = s.toLowerCase();
        int count = 0;
        for (int i = s1.length()-1; i >=0 ; i--) {
            if (s1.charAt(i) != ' '){
                count++;
            }
            else {
                if (count>0){
                    return count;
                }
            }
        }
        return count;
    }
}
434. 字符串中的单词数未看题解public class _434字符串中的单词数 {

    public int countSegments(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) != ' '){
                //最后一个的判断
                if (i == s.length()-1){
                    result++;
                }
                count ++;
            }

            else {
                if (count>0){

                    result++;
                    count = 0;
                }
            }
        }
return result;
    }
}
434. 字符串中的单词数
未看题解




字符串的反转

151. 翻转字符串里的单词
未看题解 先统计原字符串的单词个数
在创建大小为这样子的字符串数组 
调换字符串数组
吧数组的数据入Stringbuilder


557. 反转字符串中的单词 III
未看题解

541. 反转字符串 II
未看题解

344. 反转字符串
未看题解

刷题



字符的统计


桶排序
把存储的数组数据
 //对应的频次加一        for (int i = 0; i <arrayChar.length ; i++) {
            array[arrayChar[i]][1] ++;
        }
在这里用到了这种思想



先统计第一次该字符串的频率最高的字符 加入结果字符串
在把上次最高的字符删除
超时了




解法一






char[] c = s.toCharArray();
int count = 0;//用来判断是否为正数
String result = "";
    int cur = 0;//当前整数位
for (int i = 0; i <c.length ; i++) {
if (c[i] != ' '){
if(c[i] == '-'){
            count = 1  ;
}
else if (c[i] == '+'){
            count = 2;
}
else if (!(c[i] >= '0' && c[i] <='9')){
break;
}
else if (c[i] >= '0' && c[i] <='9' ){
if (count ==1 || count == 2 ){
                result += c[i] ;
cur++;
}
else {
break;
}
        }
    }
}
int integer = (int)Integer.valueOf(result);
return integer;
可以先看懂了默写一遍都可以
https://bugstack.blog.csdn.net/
https://github.com/fuzhengwei/CodeGuide/wiki
https://leetcode-cn.com/u/ac_oier/
https://github.com/SharingSource/LogicStack-LeetCode/wiki
https://tech.meituan.com/2021/02/04/2021-spring-festival-present.html
https://leetcode-cn.com/circle/article/ZeSd1q/
https://leetcode-cn.com/circle/discuss/51Ib3t/
https://blog.csdn.net/qq_39390545/article/details/108540362
https://tech.meituan.com/2019/01/25/present-by-tech-team-2019.html
https://tech.meituan.com/2020/03/26/meituan-tech-corporate-recruitment.html
https://leetcode-cn.com/circle/discuss/T8dPCY/
https://leetcode-cn.com/circle/discuss/9iLkc2/
https://leetcode-cn.com/circle/article/48kq9d/这个顺序来刷题
https://leetcode-cn.com/u/ac_oier/ 这个来筛题做 有算法来的
https://www.yuque.com/learnforlearn/mr5sg9/dowr4c#ISEqm 解题
做题时要写思想步骤
public class _451根据字符出现频率排序 {

public static void main(String[] args) {
        String b = "cccaaa";
System.out.println(frequencySort(b));
}
public static String frequencySort(String s) {

//        "cccaaa"
        //一维整数数组存储个数从大到小
//        int[] result = new int[s.length()];
//        Arrays.fill(result,-1);
        //一维字符串数组存储大到小的字

String result = "";
String[] result1 = new String[s.length()];

Arrays.fill(result1,"");
//先统计有多少个字
int k = 1;
//索引为频率 数据为char
        //存储上个存入数组的索引
int current = 0;
//右指针
int t = 0;
        for (int i = 0; i <s.length() ; i++) {
            t = i+1;

            if (s.charAt(i)+"" == result1[current]){

            }
else {
while (t < s.length()){
if (s.charAt(i) == s.charAt(t)){
                        k++;
}
                    t++;
}
for (int j = 0; j < k ; j++) {
                    result1[k] += s.charAt(i);
}
                current = k;
k = 1;
}


        }
//遍历数组会把数组的值乘以索引存入result倒序
for (int i = result1.length - 1; i >0 ; i--) {
if (!(""==(result1[i] )) ){

                result += result1[i];
}
        }
return result;

}
}

字符串的匹配匹配问题
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md

28. 实现strStr
暴力


还能用字符串匹配算法




459. 重复的子字符串
用next数组
只能够用来判断从头开始的字符串是否有与之相对应的重复

2. 两数相加
节点next = 中间的变量来传递指针来操作



栈和队列问题

225. 用队列实现栈






232. 用栈实现队列




1047. 删除字符串中的所有相邻重复项




20. 有效的括号



155. 最小栈





150. 逆波兰表达式求值


单调队列
239. 滑动窗口最大值




优先级队列
347. 前K个高频元素


KMP
28实现strStr
https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md 讲解



459. 重复的子字符串




二叉树
144. 二叉树的前序遍历




107. 二叉树的层序遍历II




199. 二叉树的右视图




637. 二叉树的层平均值




429. N叉树的层序遍历




515. 在每个树行中找最大值




116. 填充每个节点的下一个右侧节点指针




117. 填充每个节点的下一个右侧节点指针II




111. 二叉树的最小深度






226. 翻转二叉树




101. 对称二叉树










559. N叉树的最大深度









222. 完全二叉树的节点个数




110. 平衡二叉树




257. 二叉树的所有路径




404. 左叶子之和


githup解法
因为要打印出最左边的数值因此要使用后序遍历 递归更新深度 递归返回时 由于深度传入的改变了 但回到当前节点 深度还要为原来的值 因此要用回溯 把加一的深度再次减一








https://s3plus.meituan.net/v1/mss_e63d09aec75b41879dcb3069234793ac/file/2020%E7%BE%8E%E5%9B%A2%E6%8A%80%E6%9C%AF%E5%B9%B4%E8%B4%A7-%E5%90%8E%E5%8F%B0%E7%AF%87.pdf

https://github.com/youngyangyang04/leetcode-master
https://blog.csdn.net/generalfu/category_10244632.html
https://leetcode-cn.com/circle/article/ZeSd1q/
https://leetcode-cn.com/circle/discuss/51Ib3t/
https://tech.meituan.com/2021/02/04/2021-spring-festival-present.html
https://tech.meituan.com/2020/03/26/meituan-tech-corporate-recruitment.html
