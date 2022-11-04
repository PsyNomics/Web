import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class java_test {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\IdeaProjects\\Web\\taxi_script\\gwangju_taxi(UTF8).csv";
        String line = "";

        List<String> csv = new ArrayList<String>();
        List<List<String>> list = new ArrayList<List<String>>();

        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(path));

            //Set<String> set = new HashSet<>();
            while ((line = file.readLine()) != null) {

                String[] arr = line.split(",");
                csv = Arrays.asList(arr);
                //시도구분 및 업체명만 따로 리스트 만들기
                //set으로 중복 제거 시도
                //중복을 제거하고 기존 list에 어떤식으로 그걸 전달해서 삭제할 것인가가 문제
                //csv = Arrays.asList(arr[2-5]);
                //System.out.println(list.size());
                // --------------------------------------
                //map의 key 값에 시도구분, 업체명을 넣고 나머지 전체를 오브젝트(클래스)로 해서 value에 할당해 놓으면
                //map의 key 값은 중복되면 안되기 때문에 해당 value가 날아갈 것임

                list.add(csv);
//                System.out.println(list.size());
//                System.out.println(csv.get(3));
//                for(int i=1; i<list.size(); i++){
//                    String a = list.get(i-1).get(3);
//                    if(csv.get(3) == a){
//                        list.remove(csv);
//                    }
//                    //System.out.println(list.get(i).get(3));
//                }
            }
            for(int i = 0; i < list.size(); i++){
                for(int j = i + 1; j < list.size(); j++){
                    if ( list.get(i).get(3).equals(list.get(j).get(3))){
                        list.remove(j);
                    }
                }
            }
//            System.out.println(list.get(0).get(3));
//            System.out.println(list.get(1).get(3));
//            System.out.println(list.get(2).get(3));

            for (List<String> data : list) {
                    System.out.println(data);
                }

            Class.forName("org.mysql.jdbc.Driver"); //그냥 외울것
            String url = "jdbc:mysql://localhost:3306/java";
            String id = "root";
            String pw = "1234";

            conn = DriverManager.getConnection(url, id, pw); // Connection

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}