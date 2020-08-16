package 常用算法.设计模式.代理模式;

import java.util.HashMap;
import java.util.Map;

// 代理
public class Proxy implements Company{

    private HR hr;

    Proxy(){
        super();
        this.hr = new HR();
    }

    @Override
    public void findWorker(String title) {
        hr.findWorker(title);
        String worker = getWorker(title);
        System.out.println("find a worker by proxy, worker name is :"+ worker);
    }


    private String getWorker(String title){
        Map<String, String> workerList = new HashMap<>();
        workerList.put("java", "张三");
        workerList.put("python", "李四");
        workerList.put("c", "王五");
        return workerList.get(title);
    }
}
