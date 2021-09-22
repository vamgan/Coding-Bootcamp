import java.util.*;
import java.io.*;

class Solution {
    private int total_distance;
    public int calculateDistance(String input) {
        total_distance = 0;
        ArrayList<Integer> trashPresent = new ArrayList<Integer>();
        ArrayList<Integer> trashAbsent = new ArrayList<Integer>();
        if (!input.contains("0")) {
            return 0;
        }
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                trashAbsent.add(i);
            } else {
                trashPresent.add(i);
            }
        }
        for(int i = 0; i < trashAbsent.size(); i++) {
            int min = trashAbsent.get(i);
            for (int j = 0; j < trashPresent.size(); j++) {
                int dist = Math.abs(trashPresent.get(j) - trashAbsent.get(i));
                if (dist < min){
                    min = dist;
                }
            }
            this.total_distance += min;
            
        }
        return this.total_distance;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int caseId = 1; caseId <= numCases; caseId++) {
            String line = sc.next();
            sc.nextLine();
            
            System.out.println(String.format("Case #%d: %d", caseId, new Solution().calculateDistance(line)));

    }
  }
}
    
