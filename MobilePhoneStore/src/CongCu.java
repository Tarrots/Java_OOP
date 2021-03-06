

import java.util.Scanner;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class CongCu{
    public static Scanner inp= new Scanner(System.in);
    public static String[] CMNDkh;
    public static String[] SDTkh;
    public static String[] CMNDnv;
    public static String[] SDTnv;
    public static void newCSDLNhanVien(){
            CMNDnv=new String[0];
            SDTnv=new String[0];
    }
    public static void addnv(String cmnd,String sdt){
        CMNDnv=Arrays.copyOf(CMNDnv,CMNDnv.length+1);
        SDTnv=Arrays.copyOf(SDTnv,SDTnv.length+1);
        CMNDnv[CMNDnv.length-1]=cmnd;
        SDTnv[SDTnv.length-1]=sdt;
    }
    public static int timKiemSDTNV(String Kh){
        for(int i=0;i<SDTnv.length;i++){
            if(SDTnv[i].equals(Kh)) return i;
        }
        return -1;
    }
    public static int timKiemCMNDNV(String Kh){
        for(int i=0;i<CMNDnv.length;i++){
            if(CMNDnv[i].equals(Kh)) return i;
        }
        return -1;
    }
    public static void newCSDLKhangHang(){
            CMNDkh=new String[0];
            SDTkh=new String[0];
    }
    public static void addkh(String cmnd,String sdt){
        CMNDkh=Arrays.copyOf(CMNDkh,CMNDkh.length+1);
        SDTkh=Arrays.copyOf(SDTkh,SDTkh.length+1);
        CMNDkh[CMNDkh.length-1]=cmnd;
        SDTkh[SDTkh.length-1]=sdt;
    }
    public static int timKiemSDTKH(String Kh){
        for(int i=0;i<SDTkh.length;i++){
            if(SDTkh[i].equals(Kh)) return i;
        }
        return -1;
    }
    public static int timKiemCMNDKH(String Kh){
        for(int i=0;i<CMNDkh.length;i++){
            if(CMNDkh[i].equals(Kh)) return i;
        }
        return -1;
    }
    public static Date convertDate(String s){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(s);
        } catch (ParseException e) {
            return convertDate(CongCu.inp.nextLine());
        }
        //return null;
    }
    public static Date convertMonth(String s){
        try {
            return new SimpleDateFormat("MM/yyyy").parse(s);
        } catch (ParseException e) {
            return convertMonth(CongCu.inp.nextLine());
        }
    }
    public static String toBString(Date S){  //chuy???n ng??y sang String
        if (S == null) {
            return " ";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(S);
    }
    public static int getOption(String S){
        if(S.equals("0")) return 0;
        try{
            return Integer.parseInt(S);
        } catch(NumberFormatException e){
            System.out.println("B???n ???? nh???p sai\n"); 
            return -1;
        }
    }
    public static boolean isNum(String S){
        for(int i=0;i<S.length();i++){
            if((int)S.charAt(i)<48||(int)S.charAt(i)>57){
                return false;
            }
        }
        return true;
    }
    public static boolean checkName(String S){
        String name = S.toLowerCase();
        for(int i=0;i<name.length();i++){
            if(!(name.charAt(i)==' '||((int)name.charAt(i)>=92&& (int)name.charAt(i)<=122)))
            return false;
        }
        return true;
    }
    public static boolean checkSDT(String SDT){
        if(SDT.length()!=10){
            System.out.println("SDT c???n c?? 10 ch??? s???");
            return false;
        }
        for (int i=0;i<SDT.length();i++){
            if((int)SDT.charAt(i)<48||(int)SDT.charAt(i)>57){
                System.out.println("SDT ch??? ch???a s???");
                return false;
            }
        }
        return true;
    }
    public static boolean checkCMND(String CMND){
        if(CMND.length()!=9&&CMND.length()!=12){
            System.out.println("CMND y??u c???u ????? d??i 9 ho???c 12 m???i nh???p l???i");
            return false;
        }
        for(int i=0;i<CMND.length();i++){
            if((int)CMND.charAt(i)<48||(int)CMND.charAt(i)>57){
                System.out.println("CMND ch??? ch???a s???");
                return false;
            }
        }
        return true;
    }
    public static boolean isGT(String gT) {
        String S=gT.toUpperCase();
        if(S.equals("NAM")||S.equals("NU")||S.equals("KHAC")){
            return true;
        }
        return false;
    }
    
    public static boolean isSDT(String sdt){
        for(int i=0;i<sdt.length();i++){
            if((int)sdt.charAt(i)<48||(int)sdt.charAt(i)>57){
                System.out.println("S??? ??i???n tho???i ch??? nh???n k?? t??? s???");
                return false;
            }
        }
        return true;
    }
    public static String chuanHoaTen(String name){
        int j = 0;
        String N=name.trim();
        while (N.indexOf("  ") != -1)
            N = N.replaceAll("  ", " ");
        if(N.equals("")) return N;
        //11if()
        //N.matches("[a-z]"); kiem tra N chi ki tu a-z false;
        String temp[] = N.split(" ");
        N="";
        for (int i = 0; i < temp.length; i++) {
            N += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1).toLowerCase();
            if (i < temp.length - 1)
                N += " ";
        }
            return N;
    }
    public static boolean getYesNo(){
        System.out.println("X??c Nh???n (type YES/NO)");
        String S=CongCu.inp.nextLine();
        S=S.toUpperCase();
        if(S.equals("YES")){
            return true;
        }
        else
            if(S.equals("NO")){
                return false;
            }
            else return getYesNo();
    }
}