import java.math.BigInteger;

public class BigLong {


    public static int[] add(int[] a,int[] b) {
        int[] c = new int[a.length];
        if (a.length == 8 && b.length == 8) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= 0 && b[i] >= 0) {
                    int value = a[i] + b[i]+c[i];
                    if ((value & Integer.MAX_VALUE+1) == Integer.MAX_VALUE+1) {
                        if (i != 7) {
                            if(a[i]>b[i]){
                                int rest= Integer.MAX_VALUE-a[i];
                                //c[i]+=b[i]-rest;

                            }else {
                                int rest= Integer.MAX_VALUE-b[i];
                                //c[i]+=a[i]-rest;
                            }
                            c[i]+=a[i]+b[i];
                            c[i]&=Integer.MAX_VALUE;
                            c[i + 1]++;
                        }
                    } else {
                        c[i]+=a[i]+b[i];
                    }

                }
            }
        }

      /*  if(a.length==8 && b.length==8){
            for(int i=0;i<a.length;i++){
                if(a[i]>=0 && b[i]>=0){
                    int rest=2147483647-a[i];
                    if(b[i]>rest){
                        c[i]=b[i]-rest;
                        if(i<a.length-1){
                            c[i+1]++;
                        }
                    }else{
                        c[i]=a[i]+b[i];
                    }


                }
            }

        }
        return c;*/
        return c;

    }

    public static int[] negate(int []a){
        int[] c=new int[a.length];

        if(a.length==8 ) {
            for (int i = 0; i < a.length; i++) {
                c[i] = ~(a[i]);
                c[i]&=Integer.MAX_VALUE;

            }

        }

        for(int i=0;i<c.length;i++){
            if(c[i] != Integer.MAX_VALUE){
                c[i]++;
                break;

            }else if(i!=7){
                c[i]=0;
                c[i+1]++;
            }
        }



   /*     for(int i=0;i<c.length;i++){
            int oneadded=c[i]+1;
            if ((oneadded & Integer.MAX_VALUE+1) == Integer.MAX_VALUE+1) {
                if (i != 7) {
                    c[i]=0;
                    c[i+1]++;
                }

            }else{
                c[i]=oneadded;
                break;
            }


        }
*/

        /*int oneadded=c[0]+1;
        if((oneadded & Integer.MAX_VALUE+1) == Integer.MAX_VALUE+1){
            int carry=c[1]++;
            c[0]=0;
            if ((carry & Integer.MAX_VALUE+1) == Integer.MAX_VALUE+1))

        }*/
       return c;


        /*int[] one= new int[]{0, 0, 0, 0, 0, 0, 0, 1};
        return add(c,one);*/





       /* int potenz = 1;
        for ( int i = 1; i <= 31; ++i) {
            potenz = potenz * 2;
        }
        if(a.length==8 ){
            for(int i=0;i<a.length;i++){
              //  c[i]=(~(a[i]))& Integer.MAX_VALUE;//carry
                
            }

        }*/





    }

    public static int[] subtract(int[] a,int[] b){
        int[] c=new int[a.length];
        boolean bigger=true;
        for(int i=0;i<a.length;i++){
            if(a[i]>=b[i]){
                bigger=true;
            }else{
                bigger=false;
                break;
            }
        }

        if(bigger){
            for(int i=0;i<a.length;i++){
                c[i]=a[i]-b[i];
            }
        }else{
            c=add(a,negate(b));
        }


//        for(int i=0;i<a.length;i++){
//            if(a[i]>=b[i]){
//                c[i]+=a[i]-b[i];
//
//            }else if(i!=7) {
//                c[i]+=a[i]-b[i]+ Integer.MAX_VALUE;
//                c[i+1]--;
//
//            }else if(i==7 && a[i]<b[i]){
//                c[i]+=-(a[i]-b[i]);
//
//            }
//        }
        return c;
    }

    public static String toString (int[] a) {
        int value = 0;
        String z = "";
       /* int bit=30;
        String lastbitstr="";
        String seclastbitstr="";
        String num="";
        int lastbit;
        int seclastbit=0;
        String[] save=new String[a.length];
        for(int i=0;i<a.length;i++) {
            if(bit==31){
                lastbit = ((a[i] & (1 << (bit - 1))) >> (bit - 1));
                lastbitstr += lastbit;
                lastbitstr += "0";
                --bit;
            }
            seclastbit = ((a[i] & (1 << (bit - 1))) >> (bit - 1));
                if (seclastbit == 1) {
                    lastbitstr = lastbitstr.substring(0, lastbitstr.length() - 2) + 1;
                }
                lastbitstr += "0";
            save[i]=lastbitstr;
            lastbitstr="";


        }*/


        int pow = 1;
        int secpow=1;
        for (int i = 0; i < 31; i++) {
            pow *= 2;
        }

        for (int i = 0; i < a.length; i++) {
            if(i==0){
                secpow=1;
            }else{

                  for (int j = i; j > 0; j--) {

                    secpow *= pow;


                //value+=a[i]*Math.pow(Math.pow(2,31),i);

            }
            }
                value += a[i] * secpow;
        }


            z = z + value;
            if ((a[7] & Integer.MAX_VALUE + 1) == Integer.MAX_VALUE + 1) {
                z = "-" + value;


            }


        return z;


    }}
