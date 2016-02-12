package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneDimensionalBattleShips {
    static int a;
    static int firstMoveLying;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int moves[] = new int[m];

        for (int i = 0; i < m; i++) 
            moves[i] = Integer.parseInt(st.nextToken());

        boolean arr[] = new boolean[n];
        int i = 0;
        boolean lying = true;
        firstMoveLying = m+1;
        while(perm(arr, i++, k)){
            if (!isLying(arr,moves)){
                lying = false;
                break;
            }
            arr = new boolean[n];
        }

        if (!lying)
            System.out.println(-1);
        else
            System.out.println(firstMoveLying);
    }

    public static boolean perm(boolean[] arr, int start,int ships){
        for (int i = start-1; i >= 0; i--) 
            arr[i] = true;

        int index = start;
        while(ships > 0){
            index += a;
            if (index < arr.length) {
                arr[index] = true;
                index++;
                ships--;
            }
            else if (index == arr.length)
                ships--;
            else 
                return false;           
        }

        for (; index < arr.length; index++) 
            arr[index] = true;

        return true;
    }

    public static boolean isLying(boolean[] arr, int[] moves){
        for (int i = 1; i <= moves.length; i++) {
            int hitCell = moves[i-1]-1;
            if (!arr[hitCell]) {
                if (i < firstMoveLying)
                    firstMoveLying = i;
                return true;
            }
        }
        return false;
    }
}