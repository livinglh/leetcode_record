package 笔试题.bilibili8_13;

import java.util.ArrayList;
import java.util.List;


public class Main1 {
    /**
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean Game24Points (int[] arr) {
        List<Double> nums = new ArrayList<Double>();
        for (int i = 0; i < arr.length; i++) {
            nums.add((double) arr[i]);
        }
        return is24dian(nums);
    }

    public boolean is24dian(List<Double> nums){
        if(nums.size() == 0){
            return false;
        }
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if(i != j){
                    ArrayList<Double> numsnext = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) {
                        if(k!= i && k != j){
                            numsnext.add(nums.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        if(k < 2 && j > i){
                            continue;
                        }
                        if(k == 0){
                            numsnext.add(nums.get(i) + nums.get(j));
                        }
                        if(k == 1){
                            numsnext.add(nums.get(i) * nums.get(j));
                        }
                        if(k == 2){
                            numsnext.add(nums.get(i) - nums.get(j));
                        }

                        if(k == 3){
                            if(nums.get(j) != 0){
                                numsnext.add(nums.get(i) / nums.get(j));
                            }else{
                                continue;
                            }
                        }
                        if(is24dian(numsnext)){
                            return true;
                        }
                        numsnext.remove(numsnext.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}