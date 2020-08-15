package 常用算法.设计模式.简单工厂模式;

public class Factory {
    public Phone createPhone(String phoneName){
        if (phoneName.equals("apple")){
            return new Apple();
        }else if(phoneName.equals("huawei")){
            return new Huawei();
        }else{
            return null;
        }
    }
}
