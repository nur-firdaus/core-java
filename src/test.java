public class test {

    public static void test(String[] args) {
        System.out.println("OddOccurrencesInArray "+solution("BAABA",new int[] {2,4,1,1,2}));
    }
    public static int[] solution(String R, int[] V) {

        int initValA=0;
        int initValB=0;

        char[] recipient = R.toCharArray();

        if(recipient.length<=2){
            int[] answer = {V[0],0};
            return answer;
        }
        if(recipient[0]=='B'){
            initValB=V[0];
            initValA=V[1];
        }else{
            initValA=V[0];
            initValB=V[1];
        }

        for(int i=0;i<recipient.length;i++){
            if(recipient[i]=='B'){
                initValA=initValA+V[i];
                initValB=initValB-V[i];
            }
            else{
                initValA=initValA-V[i];
                initValB=initValB+V[i];
            }
        }

        return new int[]{initValB, initValA};
    }
}
