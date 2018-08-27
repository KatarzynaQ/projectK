package projectQ;

import java.util.ArrayList;
import java.util.List;

public class NIP {
    private String nipNumber;

    public NIP(String nipNumber) {
        this.nipNumber=nipNumber;
    }

    private List<Integer> onlyIntegersFromString(String s){
        List<Integer>integers=new ArrayList<Integer>();
        String[]allChars=s.split("");
        for (String x:allChars
             ) {
            if(isANumber(x)){
                integers.add(Integer.valueOf(x));
            }
        }
        return integers;
    }

    private boolean isANumber(String s){
        Integer number;
        number=Integer.valueOf(s);
        if(number!=null){
            return true;
        } else return false;
    }
    private String createNIPFromIntegerList(List<Integer>integers){
        String[] Nip=new String[12];
        for (int i = 0; i < 12; i++) {
            if(i==3||i==7||i==10){
                Nip[i]="-";
            }else{
                Nip[i]=String.valueOf(integers.get(i));
            }
        }
        String toReturnNip="";
        for (int i = 0; i < Nip.length; i++) {
            toReturnNip=toReturnNip+Nip[i];
            System.out.println(toReturnNip);
        }
        return toReturnNip;
    }
}
