import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, B, C;
	static int[] arr;
	static long min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
	
		min = N;
		for (int i = 0; i < N; i++) {
			arr[i] -= B; // 총 감독은 무조건 필요
			
			if (arr[i] > 0) { 
				min += arr[i] / C; // 부감독 필요
				
				if (arr[i] % C != 0) { // 부감독 추가
					min++;
				}
			}
		}
		System.out.println(min);
	}

}
