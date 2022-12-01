public class ChineseText {
    public static void main(String[] args) {
        String str = "R U R' U' R' F R2 U' R' U' R U R' F'";
        String[] s = str.split(" ");
        for (String s1 : s) {
            System.out.print(变换规则(s1) + " ");
        }
    }

    private static String 反转(String str) {
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("2")) continue;
            if (split[i].contains("'"))
                split[i] = split[i].replace("'", "");
            else
                split[i] = split[i] + "'";
        }
        //反转
        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] = split[split.length - i - 1];
            split[split.length - i - 1] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //拼接
        for (String s : split) {
            stringBuilder.append(s).append("   ");
        }
        return stringBuilder.toString();
    }

    private static String 变换规则(String s) {
        //F
        s = s.replace("F", "前");
        //U
        s = s.replace("U", "上");
        if (s.contains("上"))
            if (s.contains("'")) {
                s = s.replace("'", "→撇");
            } else {
                s = s.concat("←撇");
            }
        s = s.replace("D", "下");
        if (s.contains("下"))
            if (s.contains("'")) {
                s = s.replace("'", "←撇");
            } else {
                s = s.concat("→撇");


            }
        s = s.replace("B", "后");
        if (s.contains("后"))
            if (s.contains("'")) {
                s = s.replace("'", "顺");
            } else {
                s = s.concat("逆");
            }
        s = s.replace("L", "左");
        if (s.contains("左"))
            if (s.contains("'")) {
                s = s.replace("'", "↑撇");
            } else {
                s = s.concat("↓撇");
            }
        s = s.replace("R", "右");
        if (s.contains("右"))
            if (s.contains("'")) {
                s = s.replace("'", "↓撇");
            } else {
                s = s.concat("↑撇");
            }
        s = s.replace("2", "2次");
        if (s.contains("2"))
            s = s.substring(0, 3);
        return s;
    }
}
