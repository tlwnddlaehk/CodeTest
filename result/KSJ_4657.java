import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hello {
    // csv파일을 저장할 자료구조
    private static List<List<String>> csvList = new ArrayList<List<String>>();

    // 실제 수행 메소드
    public static void main(String[] args) {
        // csv저장 (파라미터는 경로명 리눅스(맥)와 윈도우는 상이)
        saveCsv("/Users/kimsijung/dev/hello/table.csv");

        // 연봉 제일 높은사람 출력
        highComprate();

        // 평균 연봉 출력
        AverageComprate(30, 49);
    }

    /**
     * csv를 읽어 List에 저장하는 메소드
     *
     * **/
    private static void saveCsv(String path) {
        BufferedReader br = null;

        try {
            br = Files.newBufferedReader(Paths.get(path));
            //Charset.forName("UTF-8");
            String line = "";

            int count = 0;
            while ((line = br.readLine()) != null) {
                // 첫째 행은 읽지 않는다.
                if (count != 0) {
                    //CSV 1행을 저장하는 리스트
                    List<String> tmpList = new ArrayList<String>();
                    String array[] = line.split(",");
                    // 복사항 배열 준비
                    String coppyArray[] = new String[4];
                    //필요 없는 문자열 변경
                    array[3] = array[3].replace("\"$", "");
                    array[4] = array[4].replace("\"", "");
                    array[3] = array[3] + array[4];

                    System.arraycopy(array, 0, coppyArray, 0, 4);
                    //배열에서 리스트 반환
                    tmpList = Arrays.asList(coppyArray);
                    System.out.println(tmpList);

                    csvList.add(tmpList);
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 연봉 가장 높은사람
     *
     * **/
    private static String highComprate() {
        Double comPrate = 0.00;
        String name = "";

        for (List<String> list : csvList) {
            String name2 = list.get(0);
            String comPrate2 = list.get(3);

            if (comPrate < Double.parseDouble(comPrate2)) {
                comPrate = Double.parseDouble(comPrate2);
                name = name2;
            }
        }

        System.out.println(name);
        return name;
    }

    /**
     * 우리 회사 30,40대(age between 30 and 49) 직원의 평균 연봉을 출력해주세요.
     *
     * **/
    private static Double AverageComprate(int minAge, int maxAge) {
        Double sumComPrate = 0.00;
        Double averageComprate = 0.00;
        String name = "";

        int index = 0;
        for (List<String> list : csvList) {
            String name2 = list.get(0);
            String age2 = list.get(2);
            String comPrate2 = list.get(3);

            if (Integer.parseInt(age2) >= minAge && Integer.parseInt(age2) <= maxAge ) {
                sumComPrate += Double.parseDouble(comPrate2);
                index++;
            } else {
                continue;
            }
        }
        averageComprate = sumComPrate / index;

        System.out.println(averageComprate);
        return averageComprate;
    }

}

