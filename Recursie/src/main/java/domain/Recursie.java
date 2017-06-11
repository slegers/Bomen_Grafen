package domain;

import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <= 0) {
            throw new IllegalArgumentException("getal should be strict positive");
        }
        if (getal <= 2) {
            return 1;
        } else {
            return fibonacci(getal - 2) + fibonacci(getal - 1);
        }
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal < 0) {
            getal = getal * -1;
        }
        String getals = getal + "";
        if (getals.length() == 1) {
            return getal;
        } else {
            return Integer.parseInt(getals.substring(0, 1)) + somVanCijfers(Integer.parseInt(getals.substring(1, getals.length())));
        }

    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s can't be null");
        } else {
            if (s.length() <= 1) {
                return s;
            } else {
                return s.substring(s.length() - 1, s.length()) + keerOm(s.substring(0, s.length() - 1));
            }
        }
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s can't be null");
        } else {
            if (s.length() <= 0) {
                return 0;
            }
            if (s.length() == 1) {
                if (s.equals("x")) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (s.substring(0, 1).equals("x")) {
                return 1 + countX(s.substring(1, s.length()));
            } else {
                return 0 + countX(s.substring(1, s.length()));
            }
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The string s can't be null");
        }
        if (s.length() <= 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.equals("hi")) {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.substring(0, 2).equals("hi")) {
            return 1 + countHi(s.substring(1, s.length()));
        } else {
            return 0 + countHi(s.substring(1, s.length()));
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s can't be null");
        }
        if (s.length() <= 0) {
            return "";
        }
        if (s.substring(0, 1).equals("x")) {
            return "y" + changeXY(s.substring(1));
        } else {
            return s.substring(0, 1) + changeXY(s.substring(1));
        }
    }

    // oefening 7

    public static String changePi(String s) {
        if(s == null){
            throw new IllegalArgumentException("s can't be null");
        }else if(s.length() < 2){
            return s;
        }else if(s.substring(0,2).equals("pi")){
            return "3.14" + changePi(s.substring(2));
        }else{
            return s.substring(0,1) + changePi(s.substring(1));
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if(getal <= 0){
            throw new IllegalArgumentException("getal can't be negative!");
        }
        if(getal % 2 != 0){
            return 0;
        }else{
            return 1 + tweelog(getal/2);
        }
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if(lijst == null){
            throw new IllegalArgumentException("The list can't be null");
        }else if(lijst.isEmpty()){
            throw new IllegalArgumentException("The list can't be empty");
        } else if(lijst.size() == 1){
            return lijst.get(0);
        }else{
            if(lijst.get(0) < lijst.get(1)){
                lijst.remove(0);
                return findMaximum(lijst);
            }else{
                lijst.remove(1);
                return findMaximum(lijst);
            }
        }
    }


    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string == null)
            throw new IllegalArgumentException();
        ArrayList<String> res = new ArrayList<String>();
        if (string.length() <= 1) { //ook de lege string telt mee!
            res.add(string);
            return res;
        }
        else {
            res.add(string.substring(0, 1));
            ArrayList<String> res2 = findSubstrings(string.substring(1));
            res.addAll(res2);
            for (String s : res2) {
                res.add(string.charAt(0) + s);
            }
            return res;
        }
    }

    //Extra oefening 1
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length){
            return (target == 0);
        }
        if (groupSum(start + 1, nums, target - nums[start])){
            return true;
        }
        if (groupSum(start + 1, nums, target)){
            return true;
        }
        return false;
    }


    public static boolean groupSum5(int start, int[] nums, int target) {
            if (start >= nums.length){
                return (target == 0);

            }
        if (nums[start] % 5 == 0) {
                if (start < nums.length - 1 && nums[start + 1] == 1){
                    return groupSum5(start + 2, nums, target - nums[start]);
                }else{
                    return groupSum5(start + 1, nums, target - nums[start]);
                }
            }
            return groupSum5(start + 1, nums, target - nums[start])
                    || groupSum5(start + 1, nums, target);

    }

    public static boolean splitOdd10(int[] nums) {
        return checker(0, nums, 0, 0);
    }

    public static boolean checker(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length){
            return sum1 % 10 == 0 && sum2 % 2 == 1 || sum1 % 2 == 1
                    && sum2 % 10 == 0;
        }else{
            return checker(start + 1, nums, sum1 + nums[start], sum2)
                    || checker(start + 1, nums, sum1, sum2 + nums[start]);
        }
    }

    public static boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target == 0;
        }
        if (nums[start] == 6){
            return groupSum6(start + 1, nums, target - nums[start]);

        }else{
        return groupSum6(start + 1, nums, target - nums[start])
                || groupSum6(start + 1, nums, target);
        }
    }
    public static boolean splitArray(int[] nums) {
        return helper(0,nums,0,0);
    }

    public static boolean helper(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return sum1 == sum2;
        return helper(start + 1, nums, sum1 + nums[start], sum2)
                || helper(start + 1, nums, sum1, sum2 + nums[start]);
    }

    /***************************************************************************
     * EXTRA
     ***************************************************************************/

    public boolean split53(int[] nums) {
        return checkerSplit53(0, nums, 0, 0);
    }

    public boolean checkerSplit53(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) return sum1 == sum2;
        if (nums[start] % 5 == 0){
            return checkerSplit53(start + 1, nums, sum1 + nums[start], sum2);
        }
        if (nums[start] % 3 == 0){
            return checkerSplit53(start + 1, nums, sum1, sum2 + nums[start]);
        }else{
            return checkerSplit53(start + 1, nums, sum1 + nums[start], sum2)
                    || checkerSplit53(start + 1, nums, sum1, sum2 + nums[start]);
        }
    }
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        int sum = nums[start];
        int count = 1;
        for (int i = start + 1; i < nums.length; i++)
            if (nums[i] == nums[start]) {
                sum += nums[i];
                count++;
            }
        return groupSumClump(start + count, nums, target - sum)
                || groupSumClump(start + count, nums, target);
    }
}
