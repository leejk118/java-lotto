import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    static final int LOTTO_START_NUM = 1;
    static final int LOTTO_END_NUM = 45;
    static final int LOTTO_NUM = 6;

    private int lottoNum;
    private Lotto[] userlotto;

    public void start(){
        inputMoney();
        generateLottoNumber();
        printLottoNumber();
        //inputWinningNumber();
        //printWinningStatistic();
    }

    public void inputMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        lottoNum = money / 1000;
    }
    public void generateLottoNumber(){
        userlotto = new Lotto[lottoNum];
        List<Integer> numbers;
        for (int i = 0; i < lottoNum; ++i){
            numbers = generateRandomNumber();
            userlotto[i] = new Lotto(numbers);
        }
    }
    public List<Integer> generateRandomNumber(){
        int index = 0;
        int[] num = new int[LOTTO_NUM];
        while(index < LOTTO_NUM){
            num[index] = (int) (Math.random() * LOTTO_END_NUM) + LOTTO_START_NUM;
            index = checkOverlap(num, index);
        }
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUM; ++i) numbers.add(num[i]);

        return numbers;
    }
    private int checkOverlap(int[]num, int index){
        for (int i = 0; i < index - 1; ++i){
            if (num[i] == num[index]){
                index -= 2;
                break;
            }
        }
        index++;
        return index;
    }
    public void printLottoNumber(){
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");
        for (int i = 0; i < lottoNum; ++i){
            userlotto[i].printNumbers(LOTTO_NUM);
            System.out.println();
        }
    }
}
