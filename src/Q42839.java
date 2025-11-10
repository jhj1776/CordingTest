import java.util.HashSet;
import java.util.Iterator;

//======================================= 소수판별문제 =================================================
//1,0은 소수가 아니니까 2~판단하려는 숫자전의 비교해서 숫자를 판단해야한다.
//에라토스테네스의 체
//판단하려는 숫자의 루트 씌운 값까지만 판단하면 된다.

class Q42839 {
    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others) {
        //comb 여태까지 조합된 숫자
        //other 조합되지 않고 남은 숫자
        //Set 컬렉션 사용해서 중복제거
        if (!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));

        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    private boolean isPrime(int number) {
        //0,1 소수아님
        if(number==0||number==1)
            return false;
        //에라토스테네스의 체 적용을 위한 루트씌우기
        int lim = (int)Math.sqrt(number);

        //최대 리밋까지만 배수확인
        for(int i = 2; i<=lim; i++)
            if(number % i == 0)
                return false;
        return true;
    }

    public int solution(String numbers) {
        int count = 0;

        //1. 생성 가능한 모든 숫자 조합을 재귀함수를 통해 하나씩 만든다.
        recursive("", numbers);

        System.out.println("numberSet = " + numberSet);

        //2. 소수의 개수만 세기
        Iterator<Integer> it = numberSet.iterator();

        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number))
                count++;
        }

        //3. 소수의 개수 반환
        return count;
    }



    //디버깅용
    public static void main(String[] args) {
        Q42839 sol = new Q42839();
        System.out.println(sol.solution("110"));
    }
}


//Set Collection 중 하나 set, map, list
//String str = "HelloWorld";
//String sub = str.substring(0, 5); // "Hello"

//String sql = "SELECT * FROM users WHERE age > ?";
//PreparedStatement ps = conn.prepareStatement(sql);
//ps.setInt(1, 20);
//ResultSet rs = ps.executeQuery();
//
//while(rs.next()) {
//    System.out.println(rs.getString("name"));
//}

//iterator();

//hasNext()
//다음 요소가 있으면 true, 없으면 false

//next()
//다음 요소를 반환하고 커서 이동

//remove()
//마지막으로 반환된 요소를 컬렉션에서 제거