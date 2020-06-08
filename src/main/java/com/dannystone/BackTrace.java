package com.dannystone;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/6/8 10:41 AM
 */
@Data
public class BackTrace {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    private boolean valid(String segment) {

        int length = segment.length();

        if (length > 3) {
            return false;
        }

        if (length == 0) {
            return false;
        }

        if (segment.charAt(0) == '0') {
            return length == 1;
        }

        return Integer.valueOf(segment) < 255;

    }

    public void backTrace(int prevPos, int leftDots) {
        int maxPos = Math.min(prevPos + 4, n - 1);
        for (int currentPos = prevPos + 1; currentPos < maxPos; currentPos++) {
            String segment = s.substring(prevPos + 1, currentPos + 1);
            if (valid(segment)) {
                segments.add(segment);

                boolean dotsAllPlaced = leftDots - 1 == 0;
                if (dotsAllPlaced) {
                    updateOutPut(currentPos);
                } else {
                    backTrace(currentPos, leftDots - 1);
                }

                //如果段为valid 的ip 段，还需要考虑其他情况，所以得remove掉
                segments.removeLast();
            }
        }
    }

    private void updateOutPut(int currentPos) {
        String segment = s.substring(currentPos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));

            //如果段为valid 的ip 段，还需要考虑其他情况，所以得remove掉
            segments.removeLast();
        }

    }


    public static void main(String[] args) {
        BackTrace backTrace = new BackTrace();
        backTrace.setS("19216811");
        backTrace.setN("19216811".length());

        backTrace.backTrace(-1, 3);

        System.out.println(JSONObject.toJSONString(backTrace.getOutput()));

    }
}
