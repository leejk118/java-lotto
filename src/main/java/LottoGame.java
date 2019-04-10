import domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private int lottoNum;
    private List<Integer> numbers;
    private Lotto[] userlotto;

    public void start(){
        inputMoney();
        generateLottoNumber();
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
        for (int i = 0; i < lottoNum; ++i){
            generateRandomNumber();
            userlotto[i] = new Lotto(numbers);
        }
    }
    public void generateRandomNumber(){

    }
}
