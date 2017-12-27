package main.java.longrun;

//package <set your test package>;
import org.junit.*;

import java.net.MalformedURLException;

public class LongRunTest {

    public static final int ITERATIONS = 2;
    public static final int TIME = 1000 * 60 * 1;
    private Thread[] androidThreads;
    private Thread[] iOSThreads;






    @Before
    public void setUp() throws MalformedURLException {
        androidThreads = new  Thread[ITERATIONS];
        iOSThreads = new  Thread[ITERATIONS];


    }

    @Test
    public void testLongRunTest() throws MalformedURLException {
        long t0= System.currentTimeMillis();
        long t1= System.currentTimeMillis();
        long dt = t1 - t0;
        System.out.println("****************************************");
        System.out.println("Time :"+ dt);
        t1= System.currentTimeMillis();
        long time = TIME;
        while (dt<time) {
            for (int i=0;i<ITERATIONS;i++){
                androidThreads[i]=new Thread(new AndroidTest(i));
                androidThreads[i].setName("Android Test "+i);
                iOSThreads[i]=new Thread(new IOSTest(i));
                iOSThreads[i].setName("IOS Test "+i);
            }
            for (int i = 0; i < ITERATIONS; i++) {
                androidThreads[i].start();
                iOSThreads[i].start();
                System.out.println("Starting test " + i);
            }

            try {
                for (int i = 0; i < ITERATIONS; i++) {
                    androidThreads[i].join();
                    iOSThreads[i].join();
                    System.out.println("Ending test " + i);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1= System.currentTimeMillis();
            dt = t1 - t0;
            System.out.println("Time :"+ dt);
            System.out.println("****************************************");
        }
    }

    @After
    public void tearDown() {
    }
}