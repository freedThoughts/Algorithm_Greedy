package problemSet_1;

import java.util.*;

public class ActivitySelection {

    public static void main(String[] a){

        Scanner in = new Scanner(System.in);
        // Number of Test cases
        String s = in.nextLine();
        int testCases = Integer.valueOf(s.split(" ")[0]);
        // Answers
        List<List<Activity>> listOfListAnswers = new ArrayList<List<Activity>>(testCases);
        for(int testCase = 0; testCase < testCases; testCase ++){
            // Number of Activities
            s = in.nextLine();
            int numberOfActivities = Integer.valueOf(s.split(" ")[0]);
            // Start Array
            s = in.nextLine();
            String[] s1 = s.split(" ");
            int[] startArray = new int[numberOfActivities];
            for(int i = 0; i < numberOfActivities; i++){
                startArray[i] = Integer.valueOf(s1[i]);
            }
            // End Array
            s = in.nextLine();
            s1 = s.split(" ");
            int[] endArray = new int[numberOfActivities];
            for(int i = 0; i < numberOfActivities; i++){
                endArray[i] = Integer.valueOf(s1[i]);
            }

            List activityList = new ArrayList<Activity>(numberOfActivities);
            for(int i = 0; i < numberOfActivities; i++){
                activityList.add(new Activity(startArray[i], endArray[i]));
            }
            Collections.sort(activityList);

            List answerList = new ArrayList<Activity>(numberOfActivities);
            answerList.add(activityList.get(0));
            Integer lastEnd = ((Activity)(activityList.get(0))).getEnd();
            for(int i = 1; i< numberOfActivities; i++){
                if(lastEnd <= ((Activity)activityList.get(i)).getStart()) {
                    answerList.add(activityList.get(i));
                    lastEnd = ((Activity) activityList.get(i)).getEnd();
                }
            }

            listOfListAnswers.add(answerList);
        }

        for(List<Activity> i : listOfListAnswers){
            System.out.println(i.size());
/*            for(Activity ac : i){
                System.out.print(ac.getStart() + " " + ac.getEnd() + ", ");
            }
            System.out.println();*/
        }
    }


    private static class Activity implements Comparable<Activity>{
        private Integer start;
        private Integer end;


        public Activity(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return this.end.compareTo(o.end);
        }


        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }
    }
}
