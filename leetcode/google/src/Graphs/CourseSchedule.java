package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
      public static boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                  graph.add(new ArrayList<>());
            }

            int[] indegree = new int[numCourses];

            for (int[] pre: prerequisites) {
                  int course = pre[0];
                  int prereq = pre[1];

                  graph.get(prereq).add(course);
                  indegree[course]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                  if (indegree[i] == 0) {
                        queue.offer(i);
                  }
            }

            int completed = 0;
            while (!queue.isEmpty()) {
                  int curr = queue.poll();
                  completed++;

                  for (int next: graph.get(curr)) {
                        indegree[next]--;

                        if (indegree[next] == 0) queue.offer(next);
                  }

            }

            return completed == numCourses;
      }

      public static void main(String[] args) {
            int numCourses1 = 2;
            int[][] prerequisites1 = {{1,0}};

            int numCourses2 = 2;
            int[][] prerequisites2 = {{1,0}, {0,1}};

            System.out.println(canFinish(numCourses1, prerequisites1));
            System.out.println(canFinish(numCourses2, prerequisites2));
      }
}
