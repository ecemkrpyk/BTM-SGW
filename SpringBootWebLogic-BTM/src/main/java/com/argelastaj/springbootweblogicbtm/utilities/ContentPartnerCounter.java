package com.argelastaj.springbootweblogicbtm.utilities;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContentPartnerCounter implements ContentCounter{

    HashMap<Integer, Integer[]> ContentPartnerId2Count = new HashMap<Integer, Integer[]>();
    Random random = new Random();
    Integer position = 0;
    Integer[] arr2 = {0,0,0,0};
    

    /*@Scheduled(fixedRate=1000L) Deneme amaçlı yapıldı.
    public void init(){
        incrementRequestCount(1,random.nextInt(100));
        incrementRequestCount(2,random.nextInt(100));
        incrementRequestCount(3,random.nextInt(100));
        incrementRequestCount(4,random.nextInt(100));
    }*/

    @Scheduled(initialDelay = 15000L,fixedRate=15000L)
    public void ChangePosition(){
        List<Integer> cleanList =new ArrayList<>();
        if(position==3) {
            position = 0;
        }
        else {
            position++;
        }
        ContentPartnerId2Count.forEach((k, v) -> {
            System.out.print("key: " + k + " Array: ");
            System.out.println(Arrays.toString(v));
            v[position] = 0;
            if(Arrays.stream(v).mapToInt(Integer::intValue).sum()==0)
            {
                cleanList.add(k);
            }

        });
        for(int id : cleanList){
            ContentPartnerId2Count.remove(id);
        }
    }

    @Override
    public void incrementRequestCount(Integer CpId, Integer count) {
        Integer[] arr = {0,0,0,0};
        if(ContentPartnerId2Count.get(CpId) != null){
            arr=ContentPartnerId2Count.get(CpId);
        }
        arr[position] += count;
        ContentPartnerId2Count.put(CpId,arr);

    }

    @Override
    public Integer getPreviousTimeCount(Integer CpId) {

       return Arrays.stream(ContentPartnerId2Count.get(CpId)).mapToInt(Integer::intValue).sum();


    }
}
