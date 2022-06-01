package leetCode.hashmap;

import java.util.*;

public class test {


    public static void main(String[] args) {
        //1.
        HashMap<String,String> map = new HashMap();

        map.put("1","A");
        map.put("2","B");

        for (String key : map.keySet()){
            System.out.println("key"+key);
        }
        for(String vaal : map.values()){
            System.out.println("val"+vaal);
        }
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key: "+entry.getKey()+" value:"+entry.getValue());
        }

        //2.
        Map map1 = new HashMap();

        map1.put("1","A");
        map1.put("2","B");

        Iterator<Map.Entry<String,String>> it1 = map1.entrySet().iterator();

        while(it1.hasNext()){

            Map.Entry<String,String> entry = it1.next();
            System.out.println("key: "+entry.getKey()+" value:"+entry.getValue());
        }
        System.out.println("ARRAY======================");

        List<String> list = new ArrayList<String>();

        list.add("vikas");

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("123");


    }
}
