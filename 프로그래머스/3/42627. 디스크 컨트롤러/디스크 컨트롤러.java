import java.util.*;

class Solution {
    static class Job implements Comparable<Job> {
        int id;
        int requestTime;
        int duration;
        
        Job(int id, int requestTime, int duration) {
            this.id = id;
            this.requestTime = requestTime;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Job other) {
            if (this.duration != other.duration) {
                return this.duration - other.duration;
            }
            if (this.requestTime != other.requestTime) {
                return this.requestTime - other.requestTime;
            }
            return this.id - other.id;
        }
    }
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Job[] jobArray = new Job[n];
        for (int i = 0; i < n; i++) {
            jobArray[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(jobArray, (a, b) -> a.requestTime - b.requestTime);
        
        PriorityQueue<Job> waitQueue = new PriorityQueue<>();
        int currentTime = 0;
        int jobIndex = 0;
        int totalTurnaroundTime = 0;
        int completedJobs = 0;
        
        while (completedJobs < n) {
            while (jobIndex < n && jobArray[jobIndex].requestTime <= currentTime) {
                waitQueue.offer(jobArray[jobIndex++]);
            }
            
            if (waitQueue.isEmpty()) {
                currentTime = jobArray[jobIndex].requestTime;
                continue;
            }
            
            Job currentJob = waitQueue.poll();
            totalTurnaroundTime += currentTime - currentJob.requestTime + currentJob.duration;
            currentTime += currentJob.duration;
            completedJobs++;
        }
        
        return totalTurnaroundTime / n;
    }
}