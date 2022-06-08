package Arrays.Searching.BinaryS;

public class Q18_AllocateMinLargestPages {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 8, 10};
        int students = 2;

        System.out.println("The minimum largest num of pages with best distribution is: " + allocatePages(arr, students));
    }

    public static int allocatePages(int[] arr, int k) {
        int start = 0, end = 0;

        // start = Max(array)
        // end = Summation(total array elements)
        for (int i : arr) {
            start = Math.max(start, i);
            end += i;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0, num_students = 0;

            for (int num : arr) {
                if ((sum + num) > mid) {
                    // If sum with next num is greater than max limit of pages (mid)
                    // Then allocate sum of nums to a new student --> Thus increasing num_studs count
                    sum = num;
                    num_students++;
                }
                else // if (sum+num) <= mid --> Include the element for that student and calculate the sum
                    sum += num;
            }

            if (num_students > k)
                // Max number of pages needs to be increased to lower the num_student count
                // So, discard the left side --> Move right
                start = mid + 1;
                // Here, mid is not included in start because if condition holds, then mid can never be an answer
            else
                // Num of students within limit --> Check for answer possibility
                // The current mid might be minimum but larger than that can't be --> so we need to discard right side
                end = mid;
                // Here, mid is included beacause it might be a possible answer and need to return it.
        }

        // Here, we didn't store the value of mid --> Because start and end eventually converges to the same value
        // start == end == mid

        return end;
    }
}
