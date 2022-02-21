package lesson8.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MyBiFunction implements BiFunction<Double, Double, List<Double>> {

    @Override
    public List<Double> apply(Double x, Double y){

        List<Double> list = new ArrayList<>();
        list.add(Math.pow(x, y));
        list.add(x * y);
        return list;
    }

    public static void main(String[] args) {

        BiFunction<Double, Double , List<Double>> f1 = new MyBiFunction();
        System.out.println(f1.apply(2.0, 3.0));

        /***
         *
         *  Another option is just write a lambda expression as follows
         *  Both are the same:
         */

        BiFunction<Double , Double , List<Double>> f2  = (x, y)->{
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };

        System.out.println(f2.apply(2.0, 3.0));

    }



}