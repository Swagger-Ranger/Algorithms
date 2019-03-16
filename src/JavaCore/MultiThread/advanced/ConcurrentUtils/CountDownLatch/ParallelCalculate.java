package JavaCore.MultiThread.advanced.ConcurrentUtils.CountDownLatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ParallelCalculate
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 10:22
 * @Description: 不使用CountDownLatch的并行计数，将文本中每行的数字并行求和然后等每一行都得出结果后再汇总求和
 * @Aha-eureka:
 *******************************************************************************/

public class ParallelCalculate {

    //数组用来保存每一行的值
    private int[] nums;

    //构造函数初始化要求和的长度
    public ParallelCalculate( int line ) {
        nums = new int[line];
    }

    /**
     * 单独计算每一行的和
     * @param line
     * @param index
     */
    public void calc( String line, int index ) {
        //将每一行的数字切分出来
        String[] nus = line.split(",");

        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }

        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 正在执行计算任务..." + line + "  结果为：" + total);
    }


    public void sum() {
        System.out.println("线程汇总开始执行...");

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        System.out.println("最终结果为：" + total);
    }

    /**
     * 文件读取工具方法
     * @return
     */
    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/JavaCore/MultiThread/advanced/ThreadCorrespondence/CountDownLatch/data"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contents;
    }


    public static void main( String[] args ) {
        List<String> contents = readFile();
        int lineCount = contents.size();

        ParallelCalculate pc = new ParallelCalculate(lineCount);

        for (int i = 0; i < lineCount; i++) {
            final int j = i;
            new Thread(() -> pc.calc(contents.get(j),j)).start();
        }

        System.out.println(Thread.activeCount());

        //这里注意，run执行默认就要两个线程即除去主线程还有一个线程，所以要>2，原因还未可知，但debug就只有一个线程
        while (Thread.activeCount() > 2) {
            //只要还有线程在计算即还在活动就一直等待线程结束
//            System.out.println(Thread.activeCount());
        }

        pc.sum();

    }
}
