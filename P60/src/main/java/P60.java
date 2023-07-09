import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2차 방정식이 주어질때 교점을 출력
 * **/
public class P60 {

    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 직전의 교점 함수
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교점구하기
        // a1 b1 c1
        // a2 b2 c2
        double x = (double) (b1 * c2 - c1 * b2) / (b2 * a1 - a2 * b1);
        double y = (double) (c1 * a2 - a1 * c2) / (b2 * a1 - a2 * b1);

        if( x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long)x, (long)y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }

        return new Point(x,y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 교점 구하고
        for(int i = 0; i<line.length; i++) {
            for(int j = i+1; j<line.length; j++) {

                Point intersection = intersection(line[i][0], line[i][1], line[i][2]
                        ,line[j][0], line[j][1], line[j][2]);

                if(intersection != null) points.add(intersection);
            }
        }

        // 교점들의 최소점 최대점 구하고
        Point max = getMaximumPoint(points);
        Point min = getMinimumPoint(points);

        // 최소크기로 결과 행렬 만들고
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        char[][] arr = new char[width][height];

        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 결과 만들기
        for(Point p : points) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y -  p.y);

            arr[y][x] = '*';
        }



        String[] result = new String[arr.length];
        for(int i = 0; i<arr.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {
            {2,-1,4}, {-2,-1,4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        };

        String[] r = new P60().solution(input);

        Arrays.stream(r).toList().forEach(v -> System.out.println(v));
    }
}