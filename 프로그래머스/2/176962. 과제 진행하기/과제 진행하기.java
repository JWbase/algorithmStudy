import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        class Task {
            String name;
            int startTime;
            int playtime;
            
            Task(String name, String start, String playtime) {
                this.name = name;
                this.startTime = convertToMinutes(start);
                this.playtime = Integer.parseInt(playtime);
            }
        }
        
        List<Task> taskList = new ArrayList<>();
        for (String[] plan : plans) {
            taskList.add(new Task(plan[0], plan[1], plan[2]));
        }
        
        Collections.sort(taskList, (a, b) -> a.startTime - b.startTime);
        
        Stack<Task> pausedTasks = new Stack<>();
        
        int currentTime = taskList.get(0).startTime;
        
        for (int i = 0; i < taskList.size(); i++) {
            Task currentTask = taskList.get(i);
            
            if (i < taskList.size() - 1) {
                Task nextTask = taskList.get(i + 1);
                int timeGap = nextTask.startTime - currentTime;
                
                if (currentTask.playtime <= timeGap) {
                    answer.add(currentTask.name);
                    currentTime += currentTask.playtime;
                    
                    int remainingTime = timeGap - currentTask.playtime;
                    while (remainingTime > 0 && !pausedTasks.isEmpty()) {
                        Task pausedTask = pausedTasks.pop();
                        
                        if (pausedTask.playtime <= remainingTime) {
                            answer.add(pausedTask.name);
                            remainingTime -= pausedTask.playtime;
                        } else {
                            pausedTask.playtime -= remainingTime;
                            pausedTasks.push(pausedTask);
                            remainingTime = 0;
                        }
                    }
                    currentTime = nextTask.startTime;
                }
                else {
                    currentTask.playtime -= timeGap;
                    pausedTasks.push(currentTask);
                    currentTime = nextTask.startTime;
                }
            }
            else {
                answer.add(currentTask.name);
                currentTime += currentTask.playtime;
                
                while (!pausedTasks.isEmpty()) {
                    answer.add(pausedTasks.pop().name);
                }
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}