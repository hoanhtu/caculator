package hcmute.spkt.hoanhtu;

import android.util.Log;

import java.math.BigInteger;

public class Caculator {

    static String daoXau(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(s.length() - 1 - i);
        }
        return res;
    }
    private Integer max(String s1,String s2){
       return (s1.length()>s2.length()) ? s1.length() : s2.length();
    }
    public String Add(String s1,String s2){
        String s = "";

        int len1 = s1.length();
        int len2 = s2.length();
        int max = max(s1, s2);
        s1 = daoXau(s1);
        s2 = daoXau(s2);

        //thuc hien noi them so 0 vao chuoi voi muc dich lam cho 2 chuoi so bang nhau
        if (max > len1) {
            for (int i = max; i >= len1; i--) {
                s1 += "0";
            }
        }
        if (max > len2) {
            for (int i = max; i >= len2; i--) {
                s2 += "0";
            }
        }

        //thuc hien phep cong
        int soGhiNho = 0;
        for (int i = 0; i < max; i++) {
            int tong = 0;
            //charAt ky tu tai vi tri thu i trong xau
            tong = s1.charAt(i) - '0' + s2.charAt(i) - '0' + soGhiNho;
            s += tong % 10;
            soGhiNho = tong / 10;
        }
        if (soGhiNho == 1) {
            s += 1;
        }
        //thuc hien dao xau truoc khi xuat
        s = daoXau(s);
        return s;

    }
    public String Subtract(String s1,String s2){
        BigInteger num1, num2;
        num1=new BigInteger(s1);
        num2=new BigInteger(s2);
        BigInteger result=num1.subtract(num2);
        return result.toString();
    }
}
