package Day4_Arrays_IV;
import java.util.*;

public class Q5_CountNumSubArrXorK {
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int XR = 0, cnt = 0;
        for (int n : arr) {
            XR ^= n;
            cnt += map.getOrDefault(XR ^ k, 0);
            map.put(XR, map.getOrDefault(XR, 0) + 1);
        }

        return cnt;
	}
}
