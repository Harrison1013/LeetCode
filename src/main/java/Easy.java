import java.util.*;

public class Easy {

    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    //9. Palindrome Number
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == r || x == r / 10;
    }

    //13. Roman to Integer
    public int romanToInt(String s) {
        Map<Character, Integer> r = new HashMap<Character, Integer>();
        r.put('I', 1);
        r.put('V', 5);
        r.put('X', 10);
        r.put('L', 50);
        r.put('C', 100);
        r.put('D', 500);
        r.put('M', 1000);

        int a = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = r.get(s.charAt(i));
            if (i < n - 1 && value < r.get(s.charAt(i + 1))) {
                a -= value;
            } else {
                a += value;
            }
        }
        return a;
    }

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String r = strs[0];
        for (String s : strs) {
            r = longestCommonPrefix(r, s);
            if (r.length() == 0) {
                break;
            }
        }
        return r;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    //20. Valid Parentheses
    public boolean isValid(String s) {
        Map<Character, Character> m = new LinkedHashMap<Character, Character>();
        m.put('}', '{');
        m.put(']', '[');
        m.put(')', '(');
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> c = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (m.containsKey(ch)) {
                if (c.isEmpty() || !c.peek().equals(m.get(ch))) {
                    return false;
                }
                c.pop();
            } else {
                c.push(ch);
            }
        }
        return c.isEmpty();
    }

    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //27. Remove Element
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
