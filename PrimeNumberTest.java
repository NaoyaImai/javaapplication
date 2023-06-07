import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @Test
    int getPrime(int nth) {

        int cnt = 1 ;
        int i = 0;
        int target = 3;
        int results = 0;
        int p_flag = 1;

        if(nth == 1){
            results = 2;
            return results;
        }

        while(true){
            p_flag = 1;

            for(i = 2; i < target; i++) {
                //素数じゃない判定
                if(target % i == 0){
                    p_flag = 0;
                    break;
                }
            }



            //次の値
            if(p_flag == 1){
                //結果の格納
                results = target;
            }





            //n番目を取得済み
            if(cnt == nth){
                break;
            }
            if(p_flag == 1){
                cnt++;

            }

            target++;

        }

        return results;
    }

    @Test
    void testGetPrime() {
        assertEquals(7, getPrime(4));
        assertEquals(11, getPrime(5));
        assertEquals(17, getPrime(7));
    }
}