
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}

		System.out.println(findConvexHull(points).size());
	}

	private static ArrayList<Point> findConvexHull(ArrayList<Point> points) {
		ArrayList<Point> hull = new ArrayList<>();

		Point start = points.get(0);
		for (Point p : points) {
			if (p.y < start.y || (p.y == start.y && p.x < start.x)) {
				start = p;
			}
		}

		Point finalStart = start;
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				int order = ccw(finalStart, p1, p2);
				if (order == 0) {
					double dist1 = distance(finalStart, p1);
					double dist2 = distance(finalStart, p2);
					return Double.compare(dist1, dist2);
				}
				return -order;
			}
		});

		Stack<Point> stack = new Stack<>();
		for (Point p : points) {
			while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.peek(), p) <= 0) {
				stack.pop();
			}
			stack.push(p);
		}

		hull.addAll(stack);
		return hull;
	}

	private static int ccw(Point a, Point b, Point c) {
		long area2 = (long) (b.x - a.x) * (c.y - a.y) - (long) (b.y - a.y) * (c.x - a.x);
		if (area2 > 0)
			return 1;
		if (area2 < 0)
			return -1;
		return 0;
	}

	private static double distance(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}