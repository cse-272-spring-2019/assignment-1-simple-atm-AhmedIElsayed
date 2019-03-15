import java.util.*;

public class History {
    private int i = -1, j=0, k=1, flag=0, n;
    private String[] trans = new String[5];
    { Arrays.fill(trans,"no transactions");}

    public void saveTrans(String bb) {
        flag = 1;
        if (i == 4) {
            for (j = 0; j < 4; j++) {
                trans[j] = trans[j + 1];
                System.out.println("j="+j);
            }
            i = 3;
        }
        trans[++i] = bb;
        System.out.println("i="+i);
    }

    public String Previous() {
        if (flag == 1) {
            k = i;
            k++;
            flag = 0;
        }

//        if (trans[--k] == null)
//            return "no transactions";
        return trans[--k];

    }

    public String Next() {

//        if (trans[++k] == null)
//            return "no transactions";

        return trans[++k];
    }


    public int retK(){
        n=k;
        if (trans[k]=="no transactions")
        {
            n=90;
        }
        return n;

    }


}

